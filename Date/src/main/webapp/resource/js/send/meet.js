/**
 * meet
 */

(function(){

	//////////////////////////////////////////////////
	//
	// App & Controller 선언
	//
	//////////////////////////////////////////////////

	// App & Controller
	var App	= angular.module("App", [])
		// 초기실행
		.run(function(){
			
		})
		// 컨트롤러
		.controller("AppController", function($scope, $http) {

			//////////////////////////////////////////////////
			//
			// 모델정의
			//
			//////////////////////////////////////////////////
			
			// 관심표현 데이터 오브젝트
			var meetVO = {
				// 보내는 사람 ID (이메일)
				// TODO : 테스트를 위해 고정값 사용 - 후에 로그인 정보로 변환
				from 	: "gyojoon@exntu.com",
				// 받는 사람 ID (이메일)
				// TODO : 테스트를 위해 고정값 사용 - 후에 넘겨주는 정보로 변환
				to 		: "fiora@exntu.com",
				// 보내는 내용 
				message : ""
			};
			
			// $scope.txtMessage = "";
			
			//////////////////////////////////////////////////
			//
			// $scope 기능 정의
			//
			//////////////////////////////////////////////////
	        
	        // 관심표현 보내기
	        $scope.send = function(){
	        	
	    		//////////////////////////////////////////////////
	    		// 관심표현 보내기 Ajax
	    		//////////////////////////////////////////////////
	        	
	        	_loading.show();
	        	
	        	// var objData = $.extend( {}, meetVO, { message : $scope.txtMessage } );
	        	var objData = meetVO;
	        	// objData.message = $scope.txtMessage;	        	
	        	objData.message = $( '#txtMessage' ).val();	        	
	        	
	        	$http({
	        		// Method
	        		method : "POST",
	        		// URL
	        		url	 : _ctx + "/service/meet/insert",
	        		// 파라미터
	        		data : objData
	        	})
	        	// 성공콜백
	        	.success(function(data, status, headers, config){
	        		
	        		if( 'SUCCESS' === data.code ) {
	        			alert( '정상' );
	        		}
	        		else {	        			
	        			alert( '오류 ' );
	        		}
	        		
	        		_loading.hide();

    			})
    			// 에러콜백
    			.error(function(data, status, headers, config){
    				
    				_loading.hide();
    				
    				// Alert
    				_alert.error("회원가입에 실패하였습니다.");
	    		});
	        };
		});
})();