(function(){
	var App=angular.module('App', [ 'ngFileUpload' ])
		.run(function(){
		})
		.controller(
			'AppController', function($scope, $http, Upload) {

	    			
				$scope.onFileSelect2 = function($files) {
					$scope.selectedFile = $files[0];
				};

				$scope.send = function() {
					if ($scope.selectedFile !== undefined) {
						$scope.upload = $upload.upload({
							url : ctx+'/profile',
							method : 'POST',
							file : $scope.selectedFile,
							fileFormDataName : 'Profile',
						}).success(function(data, status, headers, config) {
							// 서버에서 전송시 보낸 email을 그대로 응답 데이터로 전달함.
							$scope.successMsg = data.email + "로 전송 완료";
						});
					}
				};
			});
	
});
