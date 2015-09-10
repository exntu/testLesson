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
			.controller('AppController', function($scope, $http) {

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
						// data 넘어 온 값
						$scope.matchingDetailCard = data.matchingDetailCard;
					})
					// 에러
					.error(function(data, status, headers, config) {
						_loading.hide();
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
						})
						// 에러
						.error(function(data, status, headers, config) {
							_loading.hide();
						});
					}
				};
				
				$scope.clickStar = function(){
					//rating 실행
					$scope.rateFunction();
				}
			})//controller
			
			.directive( 'starRating',	function() {
					return {
						restrict : 'A',
						template : '<ul class="rating">'
									+ '	<li ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">'
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
