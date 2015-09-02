<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>
	<title>회원가입</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>
	
	<%-- 스크립트 --%>
    <script src="${_resource}/js/user/join.js"></script>
    <%-- //스크립트 --%>
</head>
<body ng-controller="AppController">
	<div class="row">
		<div class="col-xs-6 col-xs-offset-3">
			<form name="loginForm">
				<div class="form-group">
					<label for="txtEmail">ID</label> 
					<input	ng-model="userVO.email" 
							id="txtEmail"
							type="email" 
							class="form-control" 
							placeholder="ID" 
							required="required">
				</div>
				<div class="form-group">
					<label for="txtPass">비밀번호</label> 
					<input	ng-model="userVO.pass" 
							id="txtPass"
							type="password" 
							class="form-control" 
							placeholder="PW" 
							required="required">
				</div>
				<div class="form-group">
					<label for="radioMale">남자</label> 
					<input	ng-model="userVO.gender"
							value="M"
							id="radioMale" 
							type="radio"
							name="gender"
							class="form-control" 
							required="required">
					<label for="radioFemale">여자</label> 
					<input	ng-model="userVO.gender"
							value="F"
							id="radioFemale"
							name="gender" 
							type="radio"
							class="form-control" 
							required="required">
				</div>
				<div class="form-group">
					<label for="txtNickname">닉네임</label> 
					<input	ng-model="userVO.nickname" 
							id="txtNickname"
							type="text" 
							class="form-control" 
							placeholder="Nick Name" 
							required="required">
				</div>
				<button	ng-click="join()" 
						ng-disabled="loginForm.$invalid" 
						type="submit" 
						class="btn btn-default">회원가입</button>
			</form>
		</div>
	</div>
</body>
</html>