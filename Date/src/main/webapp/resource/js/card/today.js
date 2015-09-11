/**
 * today js
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
				})
				// 성공콜백
				.success(
						function(data, status, headers, config) {
							
					  		//////////////////////////////////////////////////
				    		// data 넘어오는 값
				    		//////////////////////////////////////////////////
							//선택된 카드가 있는지
							var cardSelected= data.cardSelected;
							//서버 시간
							var currentTime = data.currentTime;
							//7장의 히스토리 카드 정보
							var matchingHistory = data.matchingHistory;
							//2장의 랜덤 뽑힌 카드 정보
							var selectFirstCard = data.selectFirstCardAlready;
							var selectSecondCard = data.selectSecondCardAlready;
//							var selectCardAlready = data.selectCardAlready;
							
					  		//////////////////////////////////////////////////
				    		// 남은 시간 구하기
				    		//////////////////////////////////////////////////
							var serverCurrentTime = new Date( currentTime);
							var now = new Date ( serverCurrentTime );
							//날짜 넘기기 (month, day)
							$scope.todayMonth = now.getMonth()+1;
							$scope.todayDay = now.getDate();
							
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
								//첫번째 카드
								for( var num=0; num<selectFirstCard.length; num++ ){
									$scope.firstCard = selectFirstCard[num];
									if( selectFirstCard[num].classify=="LAN" ){
										$scope.firstLan = selectFirstCard[num].data; 
									}else if( selectFirstCard[num].classify=="AGE" ){
										var ageFirst = selectFirstCard[num].data;
										$scope.firstAge = ageFirst>50 ? "50대 이상" : ( ageFirst>40 ? "40대" : ( ageFirst>30 ? "30대" : ( ageFirst>20 ? "20대" : "20대 이하" )));
									}else if( selectFirstCard[num].classify=="SUB"){
										$scope.firstAddress = selectFirstCard[num].data;
									}else if( selectFirstCard[num].classify=="SUB_LOCAL" ){
										$scope.firstAddressLocal = selectFirstCard[num].data;
									}else{
//										$scope.firstNotDefine = "NONE";
									}
								}
								//두번째 카드
								for( var num=0; num<selectSecondCard.length; num++ ){
									$scope.secondCard = selectSecondCard[num];
									if( selectSecondCard[num].classify=="LAN" ){
										$scope.secondLan = selectSecondCard[num].data;
									}else if( selectSecondCard[num].classify=="AGE" ){
										var ageSecond = selectSecondCard[num].data;
										$scope.secondAge = ageSecond>50 ? "50대 이상" : ( ageSecond>40 ? "40대" : ( ageSecond>30 ? "30대" : ( ageSecond>20 ? "20대" : "20대 이하" )));
									}else if( selectSecondCard[num].classify=="SUB"){
										$scope.secondAddress = selectSecondCard[num].data;
									}else if( selectSecondCard[num].classify=="SUB_LOCAL" ){
										$scope.secondAddressLocal = selectSecondCard[num].data;
									}else{
										$scope.firstNotDefine = "NONE";
									}
								}
								
								//////////////////////////////////////////////////
								// 카드 shade 처리
								//////////////////////////////////////////////////
								$scope.selectShadeLeft = function(){
									for(var num=0; num<matchingHistory.length; num++){
										var str =  matchingHistory[num].selectYN;
										var selectedCardShade = str.toUpperCase();
										if( selectedCardShade == "Y" ){
											if( matchingHistory[num].to == selectFirstCard[0].email ){
												return true;
											}
										}
									}
								}
								$scope.selectShadeRight = function(){
									for(var num=0; num<matchingHistory.length; num++){
										var str =  matchingHistory[num].selectYN;
										var selectedCardShade = str.toUpperCase();
										if( selectedCardShade == "Y" ){
											if( matchingHistory[num].to == selectSecondCard[0].email ){
												return true;
											}
										}
									}
								}
								
								//////////////////////////////////////////////////
								// 화면 shade처리
								//////////////////////////////////////////////////
								$scope.pageShade = function(){
									if( cardSelected ){
										return true;
									}else{
										return false;
									}
								}

							//////////////////////////////////////////////////
							// matchingHistory 일주일 보여주기
							//////////////////////////////////////////////////
							for(var i=0; i<matchingHistory.length; i++){
								//첫번째 카드
								var firstHistory= matchingHistory[0];
								$scope.firstHistory = firstHistory.to;
								//두번째 카드
								var secondHistory = matchingHistory[1];
								$scope.secondHistory= secondHistory.to;
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
				  			$scope.detailClick= function( email ){
				  				window.location.href = path + '/detail?email='+email;
				  			}
						})
				// 에러콜백
				.error(function(data, status, headers, config) {
				});
			});
})()