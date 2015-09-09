/**
 * today -> detail js
 * author choong
 */

(function() {

	// ////////////////////////////////////////////////
	//
	// App & Controller 선언
	//
	// ////////////////////////////////////////////////
	
	// App & Controller
	var App = angular.module('App', [])
		//초기 실행
		.run(function(){
			
		})
		//컨트롤러
		.controller('AppController', function($scope, $http) {
			
			//값 보내기
			$scope.matchingDetail = function (){
	        	$http({
	        		// Method
	        		method : "GET",
	        		// URL
	        		url	 : _ctx + '/service/card/today/detail',
	        		params:{email : email}
	        	})

	        	//성공콜백
	        	.success(function(data, status, headers, config){
	        		console.info(data);
	        	})
	        	//에러
    			.error(function(data, status, headers, config){
    				_loading.hide();
	    		});
			};
			
			$scope.matchingDetail();
		});
})();



