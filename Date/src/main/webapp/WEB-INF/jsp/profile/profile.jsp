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
<body class="sample-body" ng-controller="AppController">
<%-- 	<span class="sk-user-photo">
		<img id="imgProfile" src="${_ctx}/service/my/profile" style="width:144px; height:144px;" alt="user photo">
	</span> --%>
	<button ngf-select ngf-change="uploadPhoto($files)" class="btn btn-block btn-secondary btn-icon btn-icon-standalone sk-primary">
		<i class="fa-picture-o"></i>
		<span>사진 올리기</span>
	</button>
	<!-- 
 	<div class="container" >
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="example">
					<form role="form" name="uploadForm">
						<div class="form-group">
							<label>파일</label> <input type="file"
								ng-file-select="onFileSelect2($files)">
						</div>
						<button type="button"  ng-click="send()">button</button>
					</form>
					<br>
					<div>{{ successMsg }}</div>

				</div>
			</div>
		</div>
	</div>  -->


</body>
</html>