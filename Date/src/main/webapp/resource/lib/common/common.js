/**
 * 공통 기능 정리
 */

//////////////////////////////////////////////////
//
// 자바스크립트 기본 클래스 확장
//
//////////////////////////////////////////////////

// 배열에 Insert 함수추가
Array.prototype.insert = function (index, item) {
  this.splice(index, 0, item);
};

//////////////////////////////////////////////////
//
// Alert
//
//////////////////////////////////////////////////

// 전역객체
var _alert = {};

//기본옵션
_alert.defaultOption = {
	"closeButton": true,
	"debug": false,
	"positionClass": "toast-top-right",
	"onclick": null,
	"showDuration": "300",
	"hideDuration": "1000",
	"timeOut": "5000",
	"extendedTimeOut": "1000",
	"showEasing": "swing",
	"hideEasing": "linear",
	"showMethod": "fadeIn",
	"hideMethod": "fadeOut"
};

// Information
_alert.info = function(content, title, option){
	
	// 타이틀
	title = title ? title : "Information";
	
	// 옵션값이 있을 경우에는 기본 옵션을 확장 
	option = option ? $.extend(this.defaultOption, option) : this.defaultOption;
	
	// 호출
	toastr.info(content, title, option);
};

// Success
_alert.success = function(content, title, option){
	
	// 타이틀
	title = title ? title : "Success";
	
	// 옵션값이 있을 경우에는 기본 옵션을 확장 
	option = option ? $.extend(this.defaultOption, option) : this.defaultOption;
	
	// 호출
	toastr.success(content, title, option);
};

// Warning
_alert.warning = function(content, title, option){
	
	// 타이틀
	title = title ? title : "Warning";
	
	// 옵션값이 있을 경우에는 기본 옵션을 확장 
	option = option ? $.extend(this.defaultOption, option) : this.defaultOption;
	
	// 호출
	toastr.warning(content, title, option);
};

// Error
_alert.error = function(content, title, option){
	
	// 타이틀
	title = title ? title : "Error";
	
	// 옵션값이 있을 경우에는 기본 옵션을 확장 
	option = option ? $.extend(this.defaultOption, option) : this.defaultOption;
	
	// 호출
	toastr.error(content, title, option);
};


//////////////////////////////////////////////////
//
// Loading
//
//////////////////////////////////////////////////

//전역객체
var _loading = {};

//Show
_loading.show = function(){
	
	if( !_loading.$element ){
		_loading.$element = $("#_loading");
		_loading.$element.css("opacity", 0.6);
	}
	
	this.$element.show();
};

//Hide
_loading.hide = function(){
	
	if( !_loading.$element ){
		_loading.$element = $("#_loading");
	}
	
	this.$element.hide();
};


//////////////////////////////////////////////////
//
// Document Ready에서 처리할 컴포넌트들
//
//////////////////////////////////////////////////

$(document).ready(function(){
	
	//////////////////////////////////////////////////
	//
	// Select Box
	//
	//////////////////////////////////////////////////
	
	$(".tfabric-select").each(function(){
		
		// Select
		var $select	= $(this);
		
		// 초기에 해당 Select의 Selected값을 넣어준다.
		// 만약 없다면 첫번째 Option의 값을 넣어준다.
		
		// 초기 선택값을 처리하지 않겠다는 클래스가 없다면
		if( $select.hasClass("tfabric-not-select") == false ){
			
			// 선택 Option
			var $option = $select.find("option[value='" + $select.val() + "']");
			
			// 선택값이 존재한다면
			if( $option.length > 0 ){
				
				// Span에 선택값 넣어주기
				$select.siblings("span").text( $option.text() );
			}
			// 선택값이 없다면
			else{
				
				// 옵션들
				var $options = $select.children();
				
				// 1개 이상의 옵션이 존재한다면
				if( $options.length > 0 ){
					
					// 첫번째 옵션
					$option = $select.children()[0];
					
					// Span에 선택값 넣어주기
					$select.siblings("span").text( $option.text() );
				}
			}
		}
		
		// Event
		$select.on("change", function(event){
			
			// 선택값
			var text = $select.find("option[value='" + $select.val() + "']").text();
			
			// Span에 선택값 넣어주기
			$select.siblings("span").text( text );
		});
	});
});

//////////////////////////////////////////////////
//
// Location 관련 유틸
//
//////////////////////////////////////////////////

//전역객체
var _location = {
	GET		: "GET",
	POST	: "POST",
	PUT		: "PUT",
	DELETE	: "DELETE"
};

//////////////////////////////////////////////////
// 
// Form을통해 POST,UPDATE,DELETE등의 방식으로 URL이동 및 파라미터 전달
//
// url			: 이동할 URL
// method		: POST, UPDATE, DELETE등
// parameter	: { key : value }로 구성된 파라미터 오브젝트 
//
//////////////////////////////////////////////////
_location.submit = function(url,method,parameter){
	
	_loading.show();
	
	// GET 방식일 경우
	if( method.toUpperCase() == "GET"){
		
		// 폼생성
		var href = url;
		
		var isFirst = true;
		
		// 파라미터 루프
		for( var key in parameter ){
			
			if( parameter.hasOwnProperty(key) ){
				
				// 파라미터 생성
				if( isFirst ){
					href += "?";
					isFirst = false;
				}
				else{
					href += "&";
				}
				
				href += key + "=" + parameter[key];
			}
		}
		
		// 이동!
		window.location.href = href;
	}
	// GET방식이 아닐경우
	else{
		
		// 폼생성
		var $form	= 	$("<form>")
						.attr("action",url)
						.attr("method",method);
		
		// 파라미터 루프
		for( var key in parameter ){
			
			if( parameter.hasOwnProperty(key) ){
				
				// 파라미터 생성
				$form.append( $("<input>").attr("type","hidden").attr("name",key).val(parameter[key]) );
			}
		}
		
		// 이동!
		$form.submit();
	}
}


//////////////////////////////////////////////////
//
// String 관련 유틸
//
//////////////////////////////////////////////////

_string = {};

//////////////////////////////////////////////////
//
// 파라미터 자리수 만큼의 난수를 생성한다. 
//
// length		: 자리수
//
//////////////////////////////////////////////////

_string.random = function(length){
	
	var str = "";
	
	var randomStr = 
			"a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z"
			+ ",A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z"
			+ ",1,2,3,4,5,6,7,8,9,0";		
	
	var chars = randomStr.split(",");
	var randomIndex = 0;
	
	for (var i=0 ; i<length ; i++)
	{
		// 랜덤 인덱스를 구하고
		randomIndex = Math.floor(Math.random() * chars.length);
		
		// 인덱스에 해당하는 문자를 추가한다.
		str += chars[randomIndex];
	}
	
	return str;
};
