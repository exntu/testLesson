<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>
<title>모든카드</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>

<%-- 스크립트 --%>
<script src="${_resource}/js/card/all.js"></script>
<%-- //스크립트 --%>

</head>
<body ng-controller="AppController">
	<%-- 공통 Header --%>
	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<%-- //공통 Header --%>
	<div class="container">
		<div class="row">
			<!-- 목록화면 -->
			<div class="col-md-4"> 
				<div class="form-group">
					<label for="allCard">모든카드</label> 
					
					
					<table class="table table-striped">
						<th>아이디</th>
						<th>이름</th>
						<th>성별</th>
						<tr class="sum_list" ng-click="getDetail(person.email)" ng-repeat="person in result track by $index" >
								<td>{{person.email}}</td>
								<td>{{person.nickname}}</td>
								<td>{{person.gender}}</td>
						</tr>	
					</table>
			
				</div>
			</div>
			<!-- 프로필 상세화면 보여지는 화면 -->
			<div class="col-md-8">
				<div class="details">
					<label for="detail">상세화면</label> 
					
					
					<table class="table table-striped">
						<tr ng-repeat="person in result_add track by $index">
							<td>						
								<div ng-repeat="img in result_img track by $index">
									<img style="width:50px; height:50px;" data-ng-src="data:image/jpeg;base64,{{img.filestream}}"/>
								</div>	
							</td>
					    	<td>{{ person.classify }}</td>
					    	<td>{{ person.data }}</td>
				    	</tr>
				    </table> 

				</div>
			</div>
		</div>
	</div>
	
	

	<%-- 공통 Footer --%>
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	<%-- //공통 Footer --%>

</body>
</html>