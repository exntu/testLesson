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
	var App = angular.module("App", [])
	// 초기실행
	.run(function() {
	})
	// 컨트롤러
	.controller(
			"AppController",
			function($scope, $http, $interval, $location) {
				$http({
					// Method
					method : 'PUT',
					// URL
					url : _ctx + '/service/card/today/detail'
				})
				// 성공콜백
				.success(
						function(data, status, headers, config) {
							
					  		//////////////////////////////////////////////////
				    		// 페이지 넘어온 값 가져오기
				    		//////////////////////////////////////////////////
							var path = $location.absUrl();
							//email 값 가져오기
							var email = path.split("?")[1];
							
							
							
						})
				// 에러콜백
				.error(function(data, status, headers, config) {
				});
			});
})()