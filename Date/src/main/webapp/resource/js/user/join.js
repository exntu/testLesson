/**
 * Join
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
		email : "",
		// 비밀번호
		pass : "",
		// 성별
		gender : "M",
		// 닉네임
		nickname : ""
	};
	
	//////////////////////////////////////////////////
	//
	// 엘리먼트 정의
	//
	//////////////////////////////////////////////////
	
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
			
	        // 유저 가입정보
	        $scope.userVO = userVO;
	        
	        // 회원가입
	        $scope.join = function(){
	        	
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
	        			email 		: $scope.userVO.email.toLowerCase(),
	    				pass 		: $scope.userVO.pass,
	    				gender		: $scope.userVO.gender,
	    				nickname	: $scope.userVO.nickname,
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
        				_alert.error("이미 존재하는 사용자입니다.");
    				}
    				// 로그인 서비스 실패
    				else{
    					
    					// Alert
        				_alert.error("회원가입에 실패하였습니다.");
    				}
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