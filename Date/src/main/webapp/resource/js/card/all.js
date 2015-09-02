(function() {
	var App	= angular.module( "App", [] )
		// 초기실행
		.run(function(){})
		// 컨트롤러
		.controller("AppController", function( $scope, $http ) {
			$http({
				// Method
				method: 'GET',
				// URL
				url	: ctx+'/allcard'
			})
			
			.run(function(){
				
			})
			// 성공콜백
			.success(function(data, status, headers, config){
				//url 값
				var url=[];
				//result에 id : url값 넣기
				var result={};
				$scope.result=data;
				

			})
			// 에러콜백
			.error(function(data, status, headers, config){
			});
		});
})()