/**
 * Login
 */

(function(){
	
	//////////////////////////////////////////////////
	//
	// 모델정의
	//
	//////////////////////////////////////////////////
	
	// 유저정보
	var userVO = {
		// ID (이메일)
		email : "adventurez@exntu.com",
		// 비밀번호
		pass : "test1234"
	};
	
	
	//////////////////////////////////////////////////
	//
	// 엘리먼트 정의
	//
	//////////////////////////////////////////////////
	
	// 아이디 입력창
	var _$txtId = null;
	
	// 비밀번호 입력창
	var _$txtPassword = null;
	
	//////////////////////////////////////////////////
	//
	// App & Controller 선언
	//
	//////////////////////////////////////////////////
	
	
	// App & Controller
	var App	= angular.module("App", [])
		// 초기실행
		.run(function(){
			
			// 아이디 입력창
			_$txtId = $("#txtId");
			
			// 비밀번호 입력창
			_$txtPassword = $("#txtPassword");
		})
		// 컨트롤러
		.controller("AppController", function($scope, $http) {
			
	        // 유저 로그인정보
	        $scope.userVO = userVO;
	        
	        // 로그인
	        $scope.login = function(){
	        	
	        	//////////////////////////////////////////////////
	        	// Validation
	        	//////////////////////////////////////////////////
	        	
	        	// ID 체크
	        	if( !$scope.userVO.email  || $scope.userVO.email == "" ){
	        		
	        		// Alert
	        		_alert.warning("ID를 입력해주세요.");
	        		return false;
	        	}
	        	
	        	// PW 체크
	        	if( !$scope.userVO.pass  || $scope.userVO.pass == "" ){
	        		
	        		// Alert
	        		_alert.warning("비밀번호를 입력해주세요.");
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
	        			email : $scope.userVO.email.toLowerCase(),
	    				pass : $scope.userVO.pass
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
        				_alert.error("ID/PW를 확인해주세요.");
    				}
    				// 로그인 서비스 실패
    				else{
    					
    					_loading.hide();
    					
    					// Alert
        				_alert.error("로그인에 실패하였습니다.");
    				}
    			})
    			// 에러콜백
    			.error(function(data, status, headers, config){
    				
    				_loading.hide();
    				
    				// Alert
    				_alert.error("로그인에 실패하였습니다.");
	    		});
	        };
		});
})();