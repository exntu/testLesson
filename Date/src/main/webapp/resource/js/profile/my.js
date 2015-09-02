(function(){
	var App=angular.module('App', [ 'ngFileUpload' ])
		.run(function(){
		})
		.controller(
			'AppController', function($scope, $http, Upload) {

				
				//////////////////////////////////////////////////
				// 사진 업로드
				//////////////////////////////////////////////////
				$scope.uploadPhoto = function (files) {
					
			        if (files && files.length) {
			            for (var i = 0; i < files.length; i++) {
			                var file = files[i];
			                
			                Upload.upload({
			                    url: _ctx + '/profile',
			                    method: 'POST',
			                    file: file,
			                    fileFormDataName : 'profile'
			                })
			                // 성공 콜백
			                .success(function (data, status, headers, config) {
			                	
			                    if( data.code == "SUCCESS" ){
			                    	
			                    	// 프로필 이미지 변경 함수 호출
			                    	//$scope.getPhoto();
			                    	
			                    	 // Alert
			                    	alert("프로필 사진이 변경되었습니다.");
			                    }
			                    else if(data.code=="FAIL"){
			                    	// Alert
			                    	alert("프로필 사진을 변경하는데 실패하였습니다.");
			                    }
			                })
			                // 에러 콜백
			                .error(function(data, status, headers, config){
			    				
			    				// Alert
			    				alert("에러.");
				    		});
			            }
			        }
			    };
	/*    			
				$scope.onFileSelect2 = function($files) {
					$scope.selectedFile = $files[0];
				};

				$scope.send = function() {
					if ($scope.selectedFile !== undefined) {
						$scope.upload = $upload.upload({
							url : _ctx+'/profile',
							method : 'POST',
							file : $scope.selectedFile,
							fileFormDataName : 'Profile',
						}).success(function(data, status, headers, config) {
							if(data.code=="success"){
								alert("프로필 사진이 변경되었습니다.");
							}else{
								alert("프로필 사진을 변경하는데 실패하였습니다.");
						  
							}
						})
						  .error(function(data, status, headers, config){
		    				
		    				// Alert
							  	alert("에러.");
			    		});
					}
				};*/
			    
			    
			});
	
})();
