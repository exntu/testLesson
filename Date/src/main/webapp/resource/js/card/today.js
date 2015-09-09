/**
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
					method : 'GET',
					// URL
					url : _ctx + '/service/card/today'
					// 데이터
//					params: {email:"test@test.com"}
				})
				// 성공콜백
				.success(
						function(data, status, headers, config) {
							
							if(console)console.info(data);//~~~
							
							//data 넘어온 값 설정
							var currentTime = data.currentTime;
							var twoCard = data.result;
							var matchingHistory = data.matchingHistory;
							
					  		//////////////////////////////////////////////////
				    		// 남은 시간 구하기
				    		//////////////////////////////////////////////////
							var serverCurrentTime = new Date( currentTime);
							var now = new Date ( serverCurrentTime );
							function remain() {
								now.setSeconds(now.getSeconds()+1);
								var remainHour = 23 - now.getHours();
								var remainMin = 59 - now.getMinutes();
								var remainSec = 59 - now.getSeconds();
								var remain = (("0" + remainHour).slice(-2))
										+ ":" + (("0" + remainMin).slice(-2))
										+ ":" + (("0" + remainSec).slice(-2));
								return remain;
							}// remain
							
					  		//////////////////////////////////////////////////
				    		// 사람 2명 카드
				    		//////////////////////////////////////////////////

							//1번 카드 2번 카드
							for(var i=0; i<twoCard.length; i++ ){
								//첫번째 카드
								var firstCard = twoCard[0];
								$scope.firstEmail = firstCard.email;
								$scope.firstGender = firstCard.gender;
								$scope.firstNickname = firstCard.nickname;
								//두번째 카드
								var secondCard = twoCard[1];
								$scope.secondEmail = secondCard.email;
								$scope.secondGender = secondCard.gender;
								$scope.secondNickname = secondCard.nickname;
							}
							
							//////////////////////////////////////////////////
							// matchingHistory 2장카드 보여주
							//////////////////////////////////////////////////
							for(var i=0; i<matchingHistory.length; i++){
								//첫번째 카드
								var firstHistory= matchingHistory[0];
								$scope.firstHistory = firstHistory;
								//두번째 카드
								var secondHistory = matchingHistory[1];
								$scope.secondHistory= secondHistory;
							}
							
							
					  		//////////////////////////////////////////////////
				    		// 페이지 refresh
				    		//////////////////////////////////////////////////
				  			$interval (function () {
								$scope.displayTime = remain();
							}, 1000 );
							
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