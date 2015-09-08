/**
 * Profile
 */

(function(){
	
	var vo={};
	var result={};
	var ProfileVo={};
	var $profile=null; //프로필 이미지

	
	var App=angular.module('App', [ 'ngFileUpload' ])
		.run(function(){
			//프로필 이미지정보
			$profile=$("#imgprofile");
		})
		.controller(
			'AppController', function($scope, $http, Upload) {
				//$scope.profileVo=profileVo;
				//////////////////////////////////////////////////
				// 데이터 로드//프로필 로드
				//////////////////////////////////////////////////
				$http({
					// Method
					method: 'POST',
					// URL
					url	: _ctx+'/service/profile'
				})
				// 성공콜백
				.success(function(data, status, headers, config){
					_loading.hide();
					//if(console) console.info( data );
					
					//프로필을  profileVo에 저장
					
					
					//$scope.profileVo=data.repp;
					
					$scope.result=data.repp;
		
				})
				// 에러콜백
				.error(function(data, status, headers, config){
					_loading.hide();
					
				});
				

				//////////////////////////////////////////////////
				//  프로필 입력칸에 데이터 할당
				//////////////////////////////////////////////////
				
				$scope.editItem=function(index){
					$scope.editing=$scope.result.indexOf(index);
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
			                    url: _ctx + '/service/profile',
			                    method: 'POST',
			                    file: file,
			                    fileFormDataName : 'profile'
			                })
               
			                // 성공 콜백
			                .success(function (data, status, headers, config) {
			               
			                	_loading.hide();
			                	
			                	
			                	$scope.vo=data.profile;
			                	//이미지정보 주입
			                    	 // Alert
			                    	_alert.success("프로필 사진이 변경되었습니다.");
			                    	
			                })
			                // 에러 콜백
			                .error(function(data, status, headers, config){
			    				
			    				// Alert
			    				_alert.error("프로필 사진을 변경하는데 실패하였습니다");
				    		});
			                // 파일 업로드 상태바
			                file.upload.progress(function (evt){
			                	file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
			                	
			                });
			            }
			        } 
			    };
			    

			})
})();
