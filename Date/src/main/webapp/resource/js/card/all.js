/**
 * All card
 */

(function(){
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
				//카드 기본정보 리스트 
				$scope.result=data.repp;
	
			})
			// 에러콜백
			.error(function(data, status, headers, config){
				_loading.hide();
				
			});
			
			//부가정보 리스트 호출 
			$scope.getDetail=function(email){ 
				$http({
					// Method
					method: 'POST',
					// URL
					url	: _ctx+'/service/card/all/profile',
					// key값 이메일 
					data : email
				})
				
				// 성공콜백
				.success(function(data, status, headers, config){
					_loading.hide();

					//이미지 base64값 할당 
					$scope.result_img=data.repp_img;
					
					//카드 부가정보 
					$scope.result_add=data.repp_add;
				})
				
				// 에러콜백
				.error(function(data, status, headers, config){
					_loading.hide();
				});
			};

		});
})();
