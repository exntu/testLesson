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
			<div class="col-sm-2">
				<button	ng-hide="editMode" ng-click="editMode=true; edit()"
						type="submit" 
						class="btn btn-default">프로필 수정</button>
						
				<button class="btn btn-default" type="submit" ng-show="editMode" ng-click="editMode=false">저장</button>

			</div>
			<div class="col-sm-2">
			<label for="image">프로필 사진</label>
			<img style="width:144px; height:144px;" data-ng-src="data:image/jpeg;base64,{{vo}}"/>
<!-- 				<div ng-repeat="img in vo track by img.filename"  >
					<img style="width:144px; height:144px;" data-ng-src="data:image/jpeg;base64,{{img}}"/>
				</div> -->
				
<!-- 				사진 업로드 상태바
				<span class="progress" ng-show="f.progress>=0">
					<div style="width:{{f.progress}}%">{{f.progress}}%</div>
				</span> -->
				
									
				<button ngf-select ngf-change="uploadPhoto($files)" class="btn">
				<i class="fa-picture-o"></i>
				<span>사진 올리기</span>
				</button>

				<table class="table table-striped">
					<th>이름</th>
					<th>나이</th>
					<th>이메일</th>
					<th>키</th>
					<th>몸매</th>
					<th>성별</th>
					<th>직업</th>
					<th>혈액형</th>
					<th>종교</th>
					<th>흡연</th>
					<th>술</th>
					<th>스타일</th>
					<tr ng-repeat="person in result track by $index">
				    	<td>
					    	<span ng-hide="editMode">{{ person.name }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.name"/>
				    	</td>
				    	
				    	<td>
					    	<span ng-hide="editMode">{{ person.age }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.age"/>
				    	</td>
				    	<td>
					    	<span ng-hide="editMode">{{ person.email }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.email"/>
				    	</td>
				    	<td>
					    	<span ng-hide="editMode">{{ person.height }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.height"/>
				    	</td>
				    	<td>
					    	<span ng-hide="editMode">{{ person.bodyShape }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.bodyShape"/>
				    	</td>
				    	<td>
					    	<span ng-hide="editMode">{{ person.sex }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.sex"/>
				    	</td>
				    	<td>
					    	<span ng-hide="editMode">{{ person.job }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.job"/>
					    	
				    	<td>
					    	<span ng-hide="editMode">{{ person.bloodType }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.bloodType"/>
					    	
				    	<td>
					    	<span ng-hide="editMode">{{ person.religion }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.religion"/>
					    	
				    	<td>
					    	<span ng-hide="editMode">{{ person.smoking }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.smoking"/>
					    	
				    	<td>
					    	<span ng-hide="editMode">{{ person.drink }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.drink"/>
					    	</td>
				    	<td>
					    	<span ng-hide="editMode">{{ person.style }}</span>
					    	<input type="text" ng-show="editMode" ng-model="person.style"/>
				    	</td>
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