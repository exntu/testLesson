/**
 * All card
 */

(function(){
	var result={};
	var result_add={};
	var App= angular.module("App", []) // 플러그인이 필요하다면 배열에 추가
		// 초기실행
		.run(function(){


		})
		// 컨트롤러
		.controller("AppController", function( $scope, $http ) {
			
			//////////////////////////////////////////////////
			//
			// ajax 호출
			//
			//////////////////////////////////////////////////

			//모든카드 리스트 호출
			$http({
				// Method
				method: 'POST',
				// URL
				url	: _ctx+'/service/card/all'
			})
			// 성공콜백
			.success(function(data, status, headers, config){
				_loading.hide();
				
				console.info(data);
				$scope.result=data.repp;
				//$scope.result_img=data.repp_img;
	
			})
			// 에러콜백
			.error(function(data, status, headers, config){
				_loading.hide();
				
			});
			
			//선택된 리스트 정보 
/*			$scope.getDetail=function(index){ 
				$scope.detail=[];
				$scope.detail.push($scope.result_add[index]);
				
			};*/
			
			$scope.getDetail=function(email){ 
				$http({
					// Method
					method: 'POST',
					// URL
					url	: _ctx+'/service/card/all',
					data : email
				})
				// 성공콜백
				.success(function(data, status, headers, config){
					_loading.hide();

					$scope.result_img=data.repp_img;
					$scope.result_add=data.repp_add;
		
				})
				// 에러콜백
				.error(function(data, status, headers, config){
					_loading.hide();
					
				});
			
			};


		});
})();
