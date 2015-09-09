/**
 * Profile
 */

(function(){

	var vo={};
	var result={};
	var ProfileVo={};

	//프로필 추가정보
	var result_add={};

	var App=angular.module('App', [ 'ngFileUpload' ])
		.run(
		)
		.controller('AppController', function($scope, $http, Upload) {
	
			//입력폼에 데이터 할당때 이용
			$scope.result_add=result_add;
	
			//////////////////////////////////////////////////
			// 데이터 로드//프로필 로드
			//////////////////////////////////////////////////
			$scope.load=function(){
	
				$http({
					// Method
					method: 'POST',
					// URL
					url	: _ctx+'/service/profile',
				})
				// 성공콜백
				.success(function(data, status, headers, config){
					_loading.hide();
	
					if(console) console.info( data );
	
					$scope.result      = data.repp;
					$scope.result_img  = data.repp_img;
					$scope.result_add  = data.repp_add;
	
				})
				// 에러콜백
				.error(function(data, status, headers, config){
					_loading.hide();
	
				});
			};	// $scope.load
	
			//////////////////////////////////////////////////
			//  프로필 입력칸에 데이터 할당
			//////////////////////////////////////////////////
	
			$scope.editItem = function(index){
				$scope.editing = $scope.result.indexOf(index);
			}
	
	
			//////////////////////////////////////////////////
			// 사진 업로드
			//////////////////////////////////////////////////
			$scope.uploadPhoto = function (files) {
	
				_loading.show();
	
				if (files && files.length) {
					for (var i = 0; i < files.length; i++) {
						var file = files[i];
	
						file.upload=Upload.upload({
							url: _ctx + '/service/profile/upload',
							method: 'POST',
							file: file,
							fileFormDataName : 'profile'
						})
	
						// 성공 콜백
						.success(function (data, status, headers, config) {
	
							_loading.hide();
	
							$scope.result_img=data.profile;
							//이미지정보 주입
							// Alert
							_alert.success("프로필 사진이 변경되었습니다.");
	
						})
						// 에러 콜백
						.error(function(data, status, headers, config){
	
							// Alert
							_alert.error("프로필 사진을 변경하는데 실패하였습니다");
						});
	
					}
				} 
			};
			//////////////////////////////////////////////////
			// 수정버튼 클릭시 입력버튼으로 값을 할당
			//////////////////////////////////////////////////
			$scope.movein = function () {
				_loading.show();
				
				var list=$scope.result_add
				//리스트값을 input에 할당
				angular.forEach(list,function(index){
					$scope[index.classify]=index.value;
					//$scope[]=value.classify;
				}){
					
				}
	
/*				angular.forEach(
					$scope.result_add.data,
					function(obj){
						this.push({
							'age'      :obj.data,
							'bloodtype':obj.data,
							'bodyshape':obj.data,
							'drink'    :obj.data,
							'height'   :obj.data,
							'job'      :obj.data,
							'religion' :obj.data,
							'smoking'  :obj.data,
							'style'    :obj.data
						});	
					}
				);*/
			}
			//////////////////////////////////////////////////
			// 프로필 수정
			//////////////////////////////////////////////////
			$scope.edit = function () {
				_loading.show();
	
				$scope.person={};
	
				var param={
					classify: $scope.person.classify,
					data    : $scope.person.data
				};
	
				$http({
					// Method 
					method: 'POST',
					// URL
					url	: _ctx+'/service/profile/upload',
					data: param
				})
				// 성공콜백
				.success(function(data, status, headers, config){
					_loading.hide();
	
					$scope.load();
	
				})
				// 에러콜백
				.error(function(data, status, headers, config){
					_loading.hide();
	
				});

			};
	
			$scope.load();
		});
})();
