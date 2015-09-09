<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html ng-app="App">
<head>
<title>업로드화면</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>
	
<script>
	//optional need to be loaded before angular-file-upload-shim(.min).js
	FileAPI = {
		//only one of jsPath or jsUrl.
		//jsPath: '/js/FileAPI.min.js/folder/', 
		jsUrl : '${_resource}/lib/angular/upload/FileAPI.min.js',

		//only one of staticPath or flashUrl.
		//staticPath: '/flash/FileAPI.flash.swf/folder/',
		flashUrl : '${_resource}/lib/angular/upload/FileAPI.flash.swf'
	}
</script>

<%-- Upload --%>
<%-- AngularJS --%>
<script src="${_resource}/lib/angular/upload/ng-file-upload-shim.js"></script>
<script src="${_resource}/lib/angular/upload/ng-file-upload.min.js"></script>

<%-- 스크립트 --%>
<script src="${_resource}/js/profile/my.js"></script>
<%-- //스크립트 --%>

</head>
<body ng-controller="AppController">
	<%-- 공통 Header --%>
	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<%-- //공통 Header --%>
	
	<div class="container">
	
		<div class="row">
			<!-- 프로필 수정 -->
			<div class="col-sm-4">
				<button	ng-hide="editMode" ng-click="editMode=true;movein()"
						type="submit" 
						class="btn btn-default">프로필 수정</button>
						
				<button class="btn btn-default" type="submit" ng-show="editMode" ng-click="editMode=false">저장</button>

			</div>
			
			<!-- 프로필 사진, 사진업로드 -->
			<div class="col-sm-4">
				<label for="image">프로필 사진</label>
				<div ng-repeat="img in result_img track by $index"  >
					<img style="width:144px; height:144px;" data-ng-src="data:image/jpeg;base64,{{img.filestream}}"/>
				</div> 
								
				<button ngf-select ngf-change="uploadPhoto($files)" class="btn">
				<span>사진 올리기</span>
				</button>
			</div>
			
			<!-- 상세정보 -->
			<div class="col-sm-4">
				<table class="table table-striped">
					<tr ng-repeat="person in result_add track by $index">
				    	<td>
					    	<span>{{ person.classify }}</span>
				    	</td>
				    	<td>
					    	<span ng-hide="editMode">{{ person.data }}</span>
				    	</td>
				    	
				    </tr>
			    </table>
			    
			    
			    <!-- 수정 입력폼 -->
			    <table>
				    <tr>
					  <td><input type="text" id="age" ng-model="age"></td>
					</tr>
					<tr>
				      <td><input type="text" id="bloodtype" ng-model="bloodtype"></td>
				    </tr>
				    <tr>
				      <td><input type="text" id="bodyshape" ng-model="bodyshape"></td>
				    </tr>
				    <tr>
				      <td><input type="text" id="drink" ng-model="drink"></td>
				    </tr>
				    <tr>
				      <td><input type="text" id="height" ng-model="height"></td>
			     	</tr>
				    <tr>
				      <td><input type="text" id="job" ng-model="job"></td>
			        </tr>
				    <tr>
				      <td><input type="text" id="religion" ng-model="religion"></td>
			     	</tr>
				    <tr>
				      <td><input type="text" id="smoking" ng-model="smoking"></td>
			      	</tr>
				    <tr>
				      <td><input type="text" id="style" ng-model="style"></td>
				    </tr>
				</table>    
			    

			</div>
			
		</div>
	</div>
	<%-- 공통 Footer --%>
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	<%-- //공통 Footer --%>

</body>
</html>