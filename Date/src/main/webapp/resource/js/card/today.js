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
							//서버 시간
							var currentTime = data.currentTime;
							//7장의 히스토리 카드 정보
							var matchingHistory = data.matchingHistory;
							//2장의 랜덤 뽑힌 카드 정보
							var selectFirstCard = data.selectFirstCardAlready;
							var selectSecondCard = data.selectSecondCardAlready;
//							var selectCardAlready = data.selectCardAlready;
							//card shade
							var leftShadeCard = data.firstCardShade;
							var rightShadeCard = data.secondCardShade;
							
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
										$scope.firstNotDefine = "NONE";
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
								// 카드 shade 처리 (메인카드) 
								//////////////////////////////////////////////////
								$scope.selectShadeLeft = function(){
									return leftShadeCard;
								}
								$scope.selectShadeRight = function(){
									return rightShadeCard;
								}
								
								//////////////////////////////////////////////////
								// 화면 shade처리
								//////////////////////////////////////////////////
								$scope.pageShade = function(){
									if( 0 < now.getHours() && now.getHours() < 2 ){
										return true;
									}else{
										return false;
									}
								}

							//////////////////////////////////////////////////
							// matchingHistory 일주일 보여주기
							//////////////////////////////////////////////////
							var firstHistory = data.matchingHistoryEmailFirst;
							var secondHistory = data.matchingHistoryEmailSecond;
							var thirdHistory = data.matchingHistoryEmailThird;
							var forthHistory = data.matchingHistoryEmailForth;
							
							//1번
							for( var num=0; num<firstHistory.length; num++ ){
								$scope.firstHistory = firstHistory[num];
								if( firstHistory[num].classify=="LAN" ){
									$scope.firstHistoryLan = firstHistory[num].data; 
								}else if( firstHistory[num].classify=="AGE" ){
									var ageFirst = firstHistory[num].data;
									$scope.firstHistoryAge = ageFirst>50 ? "50대 이상" : ( ageFirst>40 ? "40대" : ( ageFirst>30 ? "30대" : ( ageFirst>20 ? "20대" : "20대 이하" )));
								}else if( firstHistory[num].classify=="SUB"){
									$scope.firstHistoryAddress = firstHistory[num].data;
								}else if( firstHistory[num].classify=="SUB_LOCAL" ){
									$scope.firstHistoryAddressLocal = firstHistory[num].data;
								}else if( firstHistory[num].gender =="M" ){
									$scope.firstHistoryJob = "선생님";
								}else if( firstHistory[num].gender =="F" ){
									$scope.firstHistoryJob = "학생";
								}else{
									$scope.firstHistoryNotDefine = "NONE";
								}
							}
							var firstHistoryDate = new Date( firstHistory[0].createDT );
							$scope.firstMonth = firstHistoryDate.getMonth()+1;
							$scope.firstDay = firstHistoryDate.getDate();
							
							$scope.firstHistoryShade = function(){
								if( firstHistory.selectYN == "Y"){
									return true;
								}else{
									return false; 
								}
							}
							
							//2번
							for( var num=0; num<secondHistory.length; num++ ){
								$scope.secondHistory = secondHistory[num];
								if( secondHistory[num].classify=="LAN" ){
									$scope.secondHistoryLan = secondHistory[num].data; 
								}else if( secondHistory[num].classify=="AGE" ){
									var agesecond = secondHistory[num].data;
									$scope.secondHistoryAge = agesecond>50 ? "50대 이상" : ( agesecond>40 ? "40대" : ( agesecond>30 ? "30대" : ( agesecond>20 ? "20대" : "20대 이하" )));
								}else if( secondHistory[num].classify=="SUB"){
									$scope.secondHistoryAddress = secondHistory[num].data;
								}else if( secondHistory[num].classify=="SUB_LOCAL" ){
									$scope.secondHistoryAddressLocal = secondHistory[num].data;
								}else{
									$scope.secondHistoryNotDefine = "NONE";
								}
							}
							var secondHistoryDate = new Date( secondHistory[0].createDT );
							$scope.secondMonth = secondHistoryDate.getMonth()+1;
							$scope.secondDay = secondHistoryDate.getDate();
							
							$scope.secondHistoryShade = function(){
								if( secondHistory.selectYN == "Y"){
									return true;
								}else{
									return false; 
								}
							}
							
							//3번
							for( var num=0; num<thirdHistory.length; num++ ){
								$scope.thirdHistory = thirdHistory[num];
								if( thirdHistory[num].classify=="LAN" ){
									$scope.thirdHistoryLan = thirdHistory[num].data; 
								}else if( thirdHistory[num].classify=="AGE" ){
									var agethird = thirdHistory[num].data;
									$scope.thirdHistoryAge = agethird>50 ? "50대 이상" : ( agethird>40 ? "40대" : ( agethird>30 ? "30대" : ( agethird>20 ? "20대" : "20대 이하" )));
								}else if( thirdHistory[num].classify=="SUB"){
									$scope.thirdHistoryAddress = thirdHistory[num].data;
								}else if( thirdHistory[num].classify=="SUB_LOCAL" ){
									$scope.thirdHistoryAddressLocal = thirdHistory[num].data;
								}else{
									$scope.thirdHistoryNotDefine = "NONE";
								}
							}
							var thirdHistoryDate = new Date( thirdHistory[0].createDT );
							$scope.thirdMonth = thirdHistoryDate.getMonth()+1;
							$scope.thirdDay = thirdHistoryDate.getDate();
							
							$scope.thirdHistoryShade = function(){
								if( thirdHistory.selectYN == "Y"){
									return true;
								}else{
									return false; 
								}
							}
							
							//4번
							for( var num=0; num<forthHistory.length; num++ ){
								$scope.forthHistory = forthHistory[num];
								if( forthHistory[num].classify=="LAN" ){
									$scope.forthHistoryLan = forthHistory[num].data; 
								}else if( forthHistory[num].classify=="AGE" ){
									var ageforth = forthHistory[num].data;
									$scope.forthHistoryAge = ageforth>50 ? "50대 이상" : ( ageforth>40 ? "40대" : ( ageforth>30 ? "30대" : ( ageforth>20 ? "20대" : "20대 이하" )));
								}else if( forthHistory[num].classify=="SUB"){
									$scope.forthHistoryAddress = forthHistory[num].data;
								}else if( forthHistory[num].classify=="SUB_LOCAL" ){
									$scope.forthHistoryAddressLocal = forthHistory[num].data;
								}else{
									$scope.forthHistoryNotDefine = "NONE";
								}
							}
							var forthHistoryDate = new Date( forthHistory[0].createDT );
							$scope.forthMonth = forthHistoryDate.getMonth()+1;
							$scope.forthDay = forthHistoryDate.getDate();
							
							$scope.forthHistoryShade = function(){
								if( forthHistory.selectYN == "Y"){
									return true;
								}else{
									return false; 
								}
							}
							
						
							
					  		//////////////////////////////////////////////////
				    		// 페이지 refresh
				    		//////////////////////////////////////////////////
				  			$interval (function () {
								$scope.displayTime = remain();
							}, 1000 );
				  			
				  	  		//////////////////////////////////////////////////
				    		// 카드 선택
				    		//////////////////////////////////////////////////
				  			$scope.clickSelect= function( email ){
				  				window.confirm("okay?");
				  			}
				  			$scope.clickHistorySelect= function( email ){
				  				window.confirm("money money?");
				  			}
				  			
						})
				// 에러콜백
				.error(function(data, status, headers, config) {
				});
			});
})()