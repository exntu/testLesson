<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>
	<!-- 별에대한 CSS -->
	<style type="text/css">
		.rating{
		  color: #a9a9a9;
		  margin: 0;
		  padding: 0;
		}
		ul.rating {
		  display: inline-block;
		  
		}
		.rating li {
		  list-style-type: none;
		  display: inline-block;
		  padding: 1px;
		  text-align: center;
		  font-weight: bold;
		  cursor: pointer;
		}
		.rating .filled {
		  color: #21568b;
		}
	</style>


	<title>오늘의 카드</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>

	<script>
		var email = '${email}';
	</script>
		
	<%-- 스크립트 --%>
    <script src="${_resource}/js/card/today/detail.js"></script>
    <%-- //스크립트 --%>
    
</head>
<body ng-controller="AppController">
	<%-- 공통 Header --%>
	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<%-- //공통 Header --%>

	<div class="row">
		<div class="col-xs-12">
		


 <div ng-init="rating = star.rating + 1"></div>

<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>



		
		</div>
	</div>
	<%-- 공통 Footer --%>
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	<%-- //공통 Footer --%>
</body>
</html>