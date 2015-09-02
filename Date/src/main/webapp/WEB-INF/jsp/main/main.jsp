<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>
	<title>메인</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>
	
	<%-- 스크립트 --%>
    <script src="${_resource}/js/main/main.js"></script>
    <%-- //스크립트 --%>
</head>
<body ng-controller="AppController">
	<div class="row">
		<div class="col-xs-6 col-xs-offset-3">
			<ul>
				<li>
					<a href="${_ctx}/join">Sign up</a>
				</li>
				<li>
					<a href="${_ctx}/login">Login</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>