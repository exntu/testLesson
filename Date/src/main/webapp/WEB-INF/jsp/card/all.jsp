<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>
<title>모든카드</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>

<%-- AngularJS --%>
<script src="${_resource}/lib/angular/angular.js"></script>
<%-- 스크립트 --%>
<script src="${_resource}/js/card/all.js"></script>
<%-- //스크립트 --%>

</head>
<body class="sample-body" ng-controller="AppController">
 	<%--  Header --%>
	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<%--  Header --%>


 ${repp }
 
 <div class="row">
 	<div class="col-md-4">
 		<div class="left">
 			<input type="text' ng-model="">
 			
 		</div>
 	</div>
 	<div class="col-md-8">
 		<div class="right">
 			<ul>
 				<li ng-repeat="x in repp">
 				{{x.name+','+x.age}}
 			</ul>
 		</div>
 	
 	</div>
 </div>

	
	<%--  Footer --%>
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	<%--  Footer --%>

</body>
</html>