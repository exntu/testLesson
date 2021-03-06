<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>
	<title>오늘의 카드</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>
	
	<%-- 스크립트 --%>
    <script src="${_resource}/js/send/meet.js"></script>
    <%-- //스크립트 --%>
</head>
<body ng-controller="AppController">
	<%-- 공통 Header --%>
	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<%-- //공통 Header --%>

	<div class="row">
		<div class="col-xs-12">
			<textarea id="txtMessage" rows="10" cols="10" ng-model="txtMessage" ></textarea>
			<input type="button" id="btnSend" value="Send" ng-click="send()" />
		</div>
	</div>
	
	<%-- 공통 Footer --%>
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	<%-- //공통 Footer --%>
</body>
</html>