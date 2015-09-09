/**
 * Main
 */

(function(){
	
	//////////////////////////////////////////////////
	//
	// 모델정의
	//
	//////////////////////////////////////////////////
	
	
	//////////////////////////////////////////////////
	//
	// 엘리먼트 정의
	//
	//////////////////////////////////////////////////
	
	// 로그인 모달
	var _$modalLogin 	= null;
	
	// 회원가입 모달
	var _$modalJoin 	= null;
	
	//////////////////////////////////////////////////
	//
	// App & Controller 선언
	//
	//////////////////////////////////////////////////
	
	
	// App & Controller
	var App	= angular.module("App", ['ngTouch'])
		// 초기실행
		.run(function(){
			
			// 로그인 모달
			_$modalLogin 	= $("#modalLogin");
			
			// 회원가입 모달
			_$modalJoin 	= $("#modalJoin");
		})
		// 컨트롤러
		.controller("AppController", function($scope, $http) {
			
			//////////////////////////////////////////////////
			//
			// 공통
			//
			//////////////////////////////////////////////////
			
			// 누굴찾나요?
			$scope.gender = "M";
			
			// 팝업 닫음
			$scope.close = function(){
				
				_$modalLogin.hide();
				_$modalJoin.hide();
			};
			
			//////////////////////////////////////////////////
			//
			// 로그인 관련
			//
			//////////////////////////////////////////////////
			
			// 로그인 정보
			$scope.loginVO = {
				// ID (이메일)
				email : "adventurez@exntu.com",
				// 비밀번호
				pass : "test1234"
			};
			
			// 로그인 모달 띄움
			$scope.loginModal = function(){
				
				// 입력값 초기화
				$scope.loginVO.email = "adventurez@exntu.com";
				$scope.loginVO.pass 	= "test1234";
				
				// 모달 띄움
				_$modalLogin.show();
			};
			
			// 로그인
			$scope.login = function(){
				
	        	//////////////////////////////////////////////////
	        	// Validation
	        	//////////////////////////////////////////////////
				
				if( $scope.loginVO.email == "" ){
					
					alert("이메일을 입력해주세요.");
					return false;
				}
				
				if( $scope.loginVO.pass == "" ){
					
					alert("비밀번호를 입력해주세요.");
					return false;
				}
				
	    		//////////////////////////////////////////////////
	    		// 로그인 Ajax
	    		//////////////////////////////////////////////////
	        	
	        	_loading.show();
	        	
	        	$http({
	        		// Method
	        		method : "POST",
	        		// URL
	        		url	 : _ctx + "/service/login",
	        		// 파라미터
	        		data : {
	        			email : $scope.loginVO.email.toLowerCase(),
	    				pass : $scope.loginVO.pass
	        		}
	        	})
	        	// 성공콜백
	        	.success(function(data, status, headers, config){
	        		
    				// 로그인 성공시
    				if( data.code == "SUCCESS" ){

    					// 페이지 이동
    					if( _forwardUrl != "" ){
    						window.location.href = _ctx + _forwardUrl;
    					}
    					else{
    						window.location.href = _ctx + _defaultUrl;
    					}
    				}
    				// ID/PW 틀림
    				else if( data.code == "INVALID" ){
    					
    					_loading.hide();
    					
    					// Alert
        				alert("ID/PW를 확인해주세요.");
    				}
    				// 로그인 서비스 실패
    				else{
    					
    					_loading.hide();
    					
    					// Alert
        				alert("로그인에 실패하였습니다.");
    				}
    			})
    			// 에러콜백
    			.error(function(data, status, headers, config){
    				
    				_loading.hide();
    				
    				// Alert
    				alert("로그인에 실패하였습니다.");
	    		});
			};
			
			
			//////////////////////////////////////////////////
			//
			// 회원가입 관련
			//
			//////////////////////////////////////////////////
			
			// 회원가입 정보
			$scope.joinVO = {
				// ID (이메일)
				email 		: "",
				// 비밀번호
				pass 		: "",
				// 선생/학생 여부
				gender 		: "M",
				// 닉네임
				nickname 	: "",
				// 년
				year		: {},
				// 월
				month		: {},
				// 일
				date		: {}
			};
			
			// 년
			$scope.year		= [{
				name	: "년",
				value	: ""
			}];
			for( var num = 2010 ; num >= 1950 ; num-- ){
				
				$scope.year.push({
					name	: num,
					value	: num
				});
			}
			
			// 월
			$scope.month	= [{
				name	: "월",
				value	: ""
			}];
			for( var num = 1 ; num <= 12 ; num++ ){
				
				$scope.month.push({
					name	: num,
					value	: num
				});
			}
			
			// 일
			$scope.date		= [{
				name	: "일",
				value	: ""
			}];
			for( var num = 1 ; num <= 31 ; num++ ){
				
				$scope.date.push({
					name	: num,
					value	: num
				});
			}
			
			// 회원가입 모달 띄움
			$scope.joinModal = function(){
				
				// 입력값 초기화
				$scope.joinVO.email 	= "";
				$scope.joinVO.pass 		= "";
				$scope.joinVO.gender 	= "M";
				$scope.joinVO.nickname 	= "";
				$scope.joinVO.year		= $scope.year[0];
				$scope.joinVO.month		= $scope.month[0];
				$scope.joinVO.date		= $scope.date[0];
				
				// 모달 띄움
				_$modalJoin.show();
			};
			
			// 이메일 중복체크
			$scope.emailCheck = function(email){
				
				if( email == "" ){
					
					alert("이메일을 입력해주세요.");
					return false;
				}
				
	        	_loading.show();
	        	
	        	$http({
	        		// Method
	        		method : "POST",
	        		// URL
	        		url	 : _ctx + "/service/join/email",
	        		// 파라미터
	        		data : {
	        			email : email
	        		}
	        	})
	        	// 성공콜백
	        	.success(function(data, status, headers, config){
	        		
	        		_loading.hide();
	        		
    				// 중복 없을시
    				if( data.code == "SUCCESS" ){

    					alert("사용 가능한 이메일입니다.");
    				}
    				// 중복
    				else{
    					
    					// Alert
        				alert("이미 사용중인 이메일입니다.");
    				}
    			})
    			// 에러콜백
    			.error(function(data, status, headers, config){
    				
    				_loading.hide();
    				
    				// Alert
    				alert("중복체크에 실패하였습니다.");
	    		});
			};
			
			// 닉네임 중복체크
			$scope.nicknameCheck = function(nickname){
				
				if( nickname == "" ){
					
					alert("닉네임을 입력해주세요.");
					return false;
				}
				
	        	_loading.show();
	        	
	        	$http({
	        		// Method
	        		method : "POST",
	        		// URL
	        		url	 : _ctx + "/service/join/nickname",
	        		// 파라미터
	        		data : {
	        			nickname : nickname
	        		}
	        	})
	        	// 성공콜백
	        	.success(function(data, status, headers, config){
	        		
	        		_loading.hide();
	        		
    				// 중복 없을시
    				if( data.code == "SUCCESS" ){

    					alert("사용 가능한 닉네임입니다.");
    				}
    				// 중복
    				else{
    					
    					// Alert
        				alert("이미 사용중인 닉네임입니다.");
    				}
    			})
    			// 에러콜백
    			.error(function(data, status, headers, config){
    				
    				_loading.hide();
    				
    				// Alert
    				alert("중복체크에 실패하였습니다.");
	    		});
			};
			
			// 회원가입
			$scope.join = function(){
				
	        	//////////////////////////////////////////////////
	        	// Validation
	        	//////////////////////////////////////////////////
				
				if( $scope.joinVO.email == "" ){
					
					alert("이메일을 입력해주세요.");
					return false;
				}
				
				if( $scope.joinVO.pass == "" ){
					
					alert("비밀번호를 입력해주세요.");
					return false;
				}
				
				if( $scope.joinVO.nickname == "" ){
					
					alert("닉네임을 입력해주세요.");
					return false;
				}
				
				if( $scope.joinVO.year.value == "" || $scope.joinVO.month.value == "" || $scope.joinVO.date.value == "" ){
					
					alert("생년월일을 선택해주세요.");
					return false;
				}
				
	    		//////////////////////////////////////////////////
	    		// 회원가입 Ajax
	    		//////////////////////////////////////////////////
	        	
	        	_loading.show();
	        	
	        	$http({
	        		// Method
	        		method : "POST",
	        		// URL
	        		url	 : _ctx + "/service/join",
	        		// 파라미터
	        		data : {
	        			email 		: $scope.joinVO.email.toLowerCase(),
	    				pass 		: $scope.joinVO.pass,
	    				gender		: $scope.joinVO.gender,
	    				nickname	: $scope.joinVO.nickname,
	    				year		: $scope.joinVO.year.value,
	    				month		: $scope.joinVO.month.value,
	    				date		: $scope.joinVO.date.value
	        		}
	        	})
	        	// 성공콜백
	        	.success(function(data, status, headers, config){
	        		
	        		_loading.hide();
	        		
    				// 회원가입 성공시
    				if( data.code == "SUCCESS" ){

    					// 이동
    					_location.submit(
    						_ctx +"/card/today", 
    						_location.GET, 
    						{}
    					);
    				}
    				// 이미 가입됨
    				else if( data.code == "ALREADY" ){
    					
    					// Alert
        				alert("이미 사용중인 이메일입니다.");
    				}
    				// 이미 닉네임이 존재
    				else if( data.code == "ALREADY2" ){
    					
    					// Alert
        				alert("이미 사용중인 닉네임입니다.");
    				}
    				// 로그인 서비스 실패
    				else{
    					
    					// Alert
        				alert("회원가입에 실패하였습니다.");
    				}
    			})
    			// 에러콜백
    			.error(function(data, status, headers, config){
    				
    				_loading.hide();
    				
    				// Alert
    				alert("회원가입에 실패하였습니다.");
	    		});
			};
		});
})();