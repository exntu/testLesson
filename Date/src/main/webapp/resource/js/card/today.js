/**
 * Today
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
					method : 'GET',
					// URL
					url : _ctx + '/service/card/today'
					// 데이터
//					params: {email:"test@test.com"}
				})
				// 성공콜백
				.success(
						function(data, status, headers, config) {
							
							if(console)console.info(data); //~~~~~s
							
					  		//////////////////////////////////////////////////
				    		// 남은 시간 구하기
				    		//////////////////////////////////////////////////
							function remain() {
								var now = (new Date());
								var remainHour = 24 - now.getHours();
								var remainMin = 59 - now.getMinutes();
								var remainSec = 59 - now.getSeconds();
								var remain = (("0" + remainHour).slice(-2))
										+ ":" + (("0" + remainMin).slice(-2))
										+ ":" + (("0" + remainSec).slice(-2));
								return remain;
							}// remain
							
					  		//////////////////////////////////////////////////
				    		// 사람랜덤 구하기
				    		//////////////////////////////////////////////////
//				  			$scope.person1 = (data[0].name);
//							$scope.person2 = (data[1].name);
//							$scope.person3 = (data[2].name);
//							$scope.person4 = (data[3].name);
							
					  		//////////////////////////////////////////////////
				    		// 페이지 refresh
				    		//////////////////////////////////////////////////
				  			$interval (function () {
								$scope.test = remain();
							}, 1 );
							
				  	  		//////////////////////////////////////////////////
				    		// detail 페이지 이동
				    		//////////////////////////////////////////////////
							var path = $location.absUrl();
							$scope.todayDetail = function () {
								window.location.href = path + '/detail';
							} 
						})
				// 에러콜백
				.error(function(data, status, headers, config) {
				});
			});
})()