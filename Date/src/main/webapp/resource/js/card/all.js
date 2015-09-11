/**
 * All card
 */

(function(){
	var App= angular.module("App", []) // 플러그인이 필요하다면 배열에 추가
		// 초기실행
		//리스트 갯수 넣는 변수
		.run(function(){
		})
		// 컨트롤러
		.controller("AppController", function( $scope, $http,$q ) {
			var result_all=[];
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
				$scope.result_img=data.repp_img;
				$scope.result_add=data.repp_add;
				
				//전체에 이미지와 디테일 이미지 배열로 넣기 
				result_all.push($scope.result_add);
				result_all.push($scope.result_img);

/*				
				for(num=0;num<$scope.result.length;num++){
					
					$scope.getDetail($scope.result[num].email,1);
				};*/
			})
			// 에러콜백
			.error(function(data, status, headers, config){
				_loading.hide();
				
			});
			
			//부가정보 리스트 호출 
			$scope.getDetail=function(email,index){ 
				var url="";
				//all of card 페이지
				if(index==1){
					url=_ctx+'/service/card/all'
				//카드 detail화면 
				}else if(index==2){
					url=_ctx+'/service/card/all/profile'
				}
				$http({
					// Method
					method: 'POST',
					// URL
					url	: url,
					// key값 이메일 
					data : email
				})
				
				// 성공콜백
				.success(function(data, status, headers, config){
					_loading.hide();
					

					//디테일 정보와 이름을 합쳐서 ng-repeat으로 돌린다 
					//카드 부가정보 
					$scope.result_add=data.repp_add;
					//이미지 base64값 할당 
					$scope.result_img=data.repp_img;
					
					$scope.add=[];
					$scope.add=function(){
						result_all.push($scope.result_add);
						result_all.push($scope.result_img);
					};
					
					$scope.param={
							repeat1 :$scope.add[0],
							repeat2 :$scope.add[1]
						};
					//result_img.push()
				})
				
				// 에러콜백
				.error(function(data, status, headers, config){
					_loading.hide();
				});
			};

		});
})();
