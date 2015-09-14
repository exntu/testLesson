/**
 * today -> detail js author choong
 */

(function() {

	// ////////////////////////////////////////////////
	//
	// App & Controller 선언
	//
	// ////////////////////////////////////////////////

	// App & Controller
	var App = angular
			.module('App', [])
			// 초기 실행
			.run(function() {

			})
			// 컨트롤러
			.controller('AppController', function($scope, $http, $location) {
				
				_loading.show();
				
				// 값 보내기
				$scope.matchingDetail = function() {
					$http({
						// Method
						method : "GET",
						// URL
						url : _ctx + '/service/card/today/detail',
						params : {
							email : email
						}
					})
					// 성공콜백
					.success(function(data, status, headers, config) {
				  		//////////////////////////////////////////////////
			    		// data 넘어오는 값
			    		//////////////////////////////////////////////////
						var matchingDetailCard = data.matchingDetailCard;
						
						for( var num=0; num<matchingDetailCard .length; num++ ){
							$scope.detailCard = matchingDetailCard [num];
							if( matchingDetailCard [num].classify=="LAN" ){
								$scope.detailLan = matchingDetailCard [num].data; 
							}else if( matchingDetailCard [num].classify=="AGE" ){
								var ageDetail = matchingDetailCard [num].data;
								$scope.detailAge = ageDetail>50 ? "50대 이상" : ( ageDetail>40 ? "40대" : ( ageDetail>30 ? "30대" : ( ageDetail>20 ? "20대" : "20대 이하" )));
							}else if( matchingDetailCard [num].classify=="SUB"){
								$scope.detailAddress = matchingDetailCard [num].data;
							}else if( matchingDetailCard [num].classify=="SUB_LOCAL" ){
								$scope.detailAddressLocal = matchingDetailCard [num].data;
							}else if( matchingDetailCard[num].gender =="M" ){
								$scope.detailJob = "선생님";
							}else if( matchingDetailCard[num].gender =="F" ){
								$scope.detailJob = "학생";
							}else{
								$scope.detailNotDefine = "NONE";
							}
						}
						
						_loading.hide();
						
					})
					// 에러
					.error(function(data, status, headers, config) {
						_loading.hide();
						alert("실패!");
					});
				};
				// detail카드 실행
				$scope.matchingDetail();
				
				// 별
				$scope.rating = 5;
				
				$scope.rateFunction = function(rating) {
					if(rating && 0 < rating){
						// 값 보내기
						$http({
							// Method
							method : "POST",
							// URL
							url : _ctx + '/service/card/today/rating',
							data : {
								to : email,
								value : rating
							}
						})
						// 성공콜백
						.success(function(data, status, headers, config) {
							_loading.hide();
						})
						// 에러
						.error(function(data, status, headers, config) {
							_loading.hide();
							alter("별 점 주기 실패");
						});
					}
				};
				
		  		//////////////////////////////////////////////////
	    		// click function
	    		//////////////////////////////////////////////////
				$scope.clickCoin = function(){
					var confirm = window.confirm("결제 하겠습니까?");
					if( confirm == true){
						location.href= url + '/tdate/#'
					}
				}
				
				var url = $location.url();
				$scope.clickChatting = function(){
					location.href= url + '/tdate/message'
				}
				$scope.clickMessage = function(){
					location.href= url + '/tdate/message'
				}
				
			})//controller
			
			.directive( 'starRating',	function() {
					return {
						restrict : 'A',
						template : '<ul class="rating">'
									+ '	<li ng-repeat="star in stars" ng-class="star" ng-click="rateBtn($index)">'
									+ '\u2605' + '</li>' + '</ul>',
						scope : {
							ratingValue : '=',
							max : '=',
							onRatingSelected : '&'
						},
						link : function(scope, elem, attrs) {
							var updateStars = function() {
								scope.stars = [];
							for (var i = 0; i < scope.max; i++) {
								scope.stars.push({
									filled : i < scope.ratingValue
								});
							}
						};
						scope.rateBtn = function(index){
							scope.toggle(index);
						};
						scope.toggle = function(index) {
							scope.ratingValue = index + 1;
							scope.onRatingSelected({
								rating : index + 1
							});
						};
						scope.$watch('ratingValue', function( oldVal,	newVal ) {
							if (newVal) {
								updateStars();
							}
						});
					}
				};
		});
})();
