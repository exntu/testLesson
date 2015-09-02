/**
 * Matching & remain time
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
			function($scope, $http) {

				//////////////////////////////////////////////////
				//
				// 변수 선언
				//
				//////////////////////////////////////////////////

				var isRefresh = true;

				// ////////////////////////////////////////////////
				//
				// 일반 함수 정의
				//
				// ////////////////////////////////////////////////

				/**
				 * 남은 시간 구하기
				 */
				function remain() {
					var now = (new Date());
					var remainHour = 24 - now.getHours();
					var remainMin = 59 - now.getMinutes();
					var remainSec = 59 - now.getSeconds();
					var remain = (("0" + remainHour).slice(-2)) + ":"
							+ (("0" + remainMin).slice(-2)) + ":"
							+ (("0" + remainSec).slice(-2));
					return remain;
				}// remain
				
//				/**
//				 *	그래프 새로고침 함수
//				 */
//				function refreshRemain() {
//					if( $scope.enableJVM && "JVM" == sessionStorage.getItem( 'TF_MNT_TAB' ) ) {
//						$scope.activeJVM = true;
//						$scope.loadJVM();
//					}
//					else {
//						$scope.activeJVM = false;
//						$scope.loadSystem();
//					}				
//				}	// function - refreshRemain

				////////////////////////////////////////////////
				// 초기 실행
				//////////////////////////////////////////////////			
				$scope.load();

				if (isRefresh) {
					setInterval(function() {
						refreshRemain();
					}, 5000);
				}

			});// controller
})();