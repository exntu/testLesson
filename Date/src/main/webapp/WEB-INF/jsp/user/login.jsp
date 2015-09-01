<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>
	<title>로그인</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>
	
	<%-- 스크립트 --%>
	<script>
		// 이전에 가려고 했던 URL
		var _forwardUrl = "${_forwardUrl}<c:if test="${!empty _forwardParam}">?${_forwardParam}</c:if>";
		// 이전에 가려고 했던 URL이 없을때 기본으로 갈 페이지
		var _defaultUrl = "/main";
	</script>
    <script src="${_resource}/js/user/login.js"></script>
    <%-- //스크립트 --%>
</head>
<body ng-controller="AppController">
	<div class="row">
		<div class="col-xs-6 col-xs-offset-3">
			<form>
				<div class="form-group">
					<label for="txtId">ID</label> 
					<input id="txtId" type="text" class="form-control" placeholder="ID">
				</div>
				<div class="form-group">
					<label for="txtPassword">비밀번호</label> 
					<input id="txtPassword" type="password" class="form-control" placeholder="PW">
				</div>
				<button type="submit" class="btn btn-default">로그인</button>
			</form>
		</div>
	</div>
</body>
</html>