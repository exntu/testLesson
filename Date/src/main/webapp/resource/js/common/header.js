/**
 * Header
 */

(function(){
	
	//////////////////////////////////////////////////
	//
	// 모델정의
	//
	//////////////////////////////////////////////////
	
	//////////////////////////////////////////////////
	//
	// 엘리먼트 정의
	//
	//////////////////////////////////////////////////
	
	// 메뉴
	var _$menu = null;
	
	//////////////////////////////////////////////////
	//
	// 모듈생성
	//
	//////////////////////////////////////////////////
	
	
	// 모듈생성
	angular.module("App") // 플러그인이 필요하다면 배열에 추가
		// 초기실행
		.run(function(){
			
			// 메뉴
			_$menu = $("#_menu");
			
			// 초기 선택
			_$menu.find("a").each(function(){
				
				var $a = $(this);
				
				if( window.location.href.indexOf($a.attr("href")) != -1  ){
					
					$a.parent().addClass("sa-selected");
					return false;
				} 
			});
		})
		// 컨트롤러
		.controller("HeaderController", function($scope, $http) {
			
			// Alert 재정의
			$scope.alert = function(message){
				
				alert(message);
			};
		});
})();