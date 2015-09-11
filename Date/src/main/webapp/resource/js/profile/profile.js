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
		
		.run(function(){
			
		})
		.controller('AppController', function($scope, $http, Upload) {
			//입력폼에 데이터 할당때 이용
			$scope.result_add=[];
			$scope.result=[];
			$scope.result_img=[];
	
			//입력값 리스트
			var list={};
			//////////////////////////////////////////////////
			// 데이터 로드//프로필 로드
			//////////////////////////////////////////////////
			$scope.load=function(){
				
				_loading.show();
				
				$http({
					// Method
					method: 'POST',
					// URL
					url	: _ctx+'/service/profile'
				})
				// 성공콜백
				.success(function(data, status, headers, config){
					_loading.hide();
	
					if(console) console.info( data );
					//프로필 기본정보 
					$scope.result      = data.repp;
					//프로필 이미지 
					$scope.result_img  = data.repp_img;
					//프로필 부가정보 
					$scope.result_add  = data.repp_add;
					//입력값 할당
					$scope.movein();
				})
				// 에러콜백
				.error(function(data, status, headers, config){
					_loading.hide();
	
				});
			};
			//////////////////////////////////////////////////
			// 서버로 이미지 파일 전송
			//////////////////////////////////////////////////
			$scope.uploadSub=function(file){
				Upload.upload({
					url: _ctx + '/service/profile/upload',
					method: 'POST',
					file: file,
					fileFormDataName : 'profile'
				})
				
				// 성공 콜백
				.success(function (data, status, headers, config) {

					_loading.hide();
					
					//데이터 로드 
					$scope.load();
					
					// Alert
					_alert.success("프로필 사진이 변경되었습니다.");

				})
				// 에러 콜백
				.error(function(data, status, headers, config){

					// Alert
					_alert.error("프로필 사진을 변경하는데 실패하였습니다");
				});
			};
			//////////////////////////////////////////////////
			// 사진 업로드
			//////////////////////////////////////////////////
			$scope.uploadPhoto = function (files) {
	
				_loading.show();
				
				if (files && files.length) {
					for (var i = 0; i < files.length; i++) {
						var file = files[i];
							//실제 업로드, 콜백처리 함수 
							$scope.uploadSub(file);
					}
				} 
				_loading.hide();
			};
			//////////////////////////////////////////////////
			// 수정버튼 클릭시 입력버튼으로 값을 할당
			//////////////////////////////////////////////////
			$scope.movein = function () {
				_loading.show();
				
				var list=$scope.result_add;
				//리스트값을 input에 할당
				angular.forEach(list,function(index){
					//리스트 데이터 값을 할당 
					$scope[index.classify]=index.data;
					
				});

				//기본데이터
				$scope.email=$scope.result.email;
				$scope.year=$scope.result.year;
				$scope.month=$scope.result.month;
				$scope.nickname=$scope.result.nickname;
				$scope.date=$scope.result.date;
				
				//classify.data // data
				_loading.hide();

			};
			//////////////////////////////////////////////////
			// 프로필 수정
			//////////////////////////////////////////////////
			$scope.save = function () {
				_loading.show();
				
				//classify와 data값을 서버로 넣어줄 변수
				var param={};
				//data 할당
				var data=[];
				var classify=[];
				
				//입력란으로 리스트값 넣기
				var list=$scope.result_add;
					angular.forEach(list,function(index){
						//ng-model로 리스트 데이터 값을 할당 
						classify.push(index.classify);
						data.push($scope[index.classify]);

					});
				
				//param 배열에 넣을 data 배열 생성
				data=[AGE,BLOODTYPE,BODYSHAPE,DRINK,HEIGHT,JOB
				           ,RELIGION,SMOKING,STYLE];
				
				//한 컬럼값에 배열로 들어가므로 배열로 정의된 vo를 사용 
				var param={
					classify_arr : classify,	
					data_arr     : data	
				};
				//서버로 데이터 전송
				$http({
					// Method 
					method: 'POST',
					// URL
					url	: _ctx+'/service/profile/update',
					data: param			
					
				})
				// 성공콜백
				.success(function(data, status, headers, config){
					_loading.hide();
					//데이터 로드 
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
