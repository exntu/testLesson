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

	<!-- contents -->
    <div class="sa-layout-contents">
    	<!-- title -->
    	<div class="sa-ui-top-title">
        	<a href="javascript:history.back()" class="sa-btn-back">목록으로</a>
        	<span class="sa-data-name"> {{ detailCard.nickname }}</span>' S&nbsp;&nbsp;&nbsp;&nbsp;P R O F I L E
        </div>
    	<!-- //title -->
        
        <!-- 프로필 내용 -->
    	<div class="sa-wrap-top">
	        <img src="${_resource}/images/img-@sample15.png" alt="이미지" />
            <div class="sa-box-profile">
            	<div class="sa-ui-jobwrap">
            		<span>{{ detailCard.nickname }}</span>
                    <span class="sa-ui-job">{{ detailJob }}</span>
                </div>
                <ul class="sa-list-introduce">
                	<li class="sa-ui-strong">{{ detailAge }}</li>
                    <li>경기 성남</li>
                    <li>영어</li>
                </ul>
                <!--
                	 이미지 닫힘 class="sa-list-close" 추가            
                -->
                <ul class="sa-list-photo">
                	<li>
                    	<a href="#" ng-click = "clickCoin()">
                        	<img src="${_resource}/images/img_photo1.png" alt="images1" />
                            <!-- 닫힘 -->
                            <div class="sa-ui-image-close">
                                <em class="sa-icon-close"></em>
                            </div>
                            <!-- 닫힘 -->
                        </a>
                    </li>
                    <li class="sa-list-close">
                        <a href="#" ng-click = "clickCoin()">
                        	<img src="${_resource}/images/img_photo2.png" alt="images1" />
                            <!-- 닫힘 -->
                            <div class="sa-ui-image-close">
                                <em class="sa-icon-close"></em>
                            </div>
                            <!-- 닫힘 -->
                        </a>
                    </li>
                    <li class="sa-list-close">
                    	<a href="#" ng-click = "clickCoin()">
                            <img src="${_resource}/images/img_photo3.png" alt="images1" />
                            <!-- 닫힘 -->
                            <div class="sa-ui-image-close">
                                <em class="sa-icon-close"></em>
                            </div>
                            <!-- 닫힘 -->
                        
                        </a>
                    </li>
                </ul>
                <!-- 평가 -->
                <div class="sa-bg-star">
                    <p>평가</p>
                    <span class="sa-img-star"><span></span></span>
                </div>
                <!-- //평가 -->
                <div class="sa-list-chat">
                	<a class="sa-bg-chat" ng-click = "clickChatting()" href="#"><p>Chatting</p></a>
                   	<a class="sa-bg-message" ng-click = "clickMessage()" href="#"><p>메시지 보내기</p></a>
                </div>
            </div>
        </div>
        
        <!-- 평가점수 -->
        <div class="sa-wrap-middle">
        	<p>평가점수</p>
           	<span>
    	       	<div ng-init="rating = star.rating + 1"></div>
				<div class="star-rating" star-rating rating-value="rating" data-max="5" on-rating-selected="rateFunction(rating)"></div>
			</span>
            <button type="button" ng-click="clickbtn()">평가하기</button>
        </div>
        <!-- //평가점수 -->
        
        <!-- 프로필 리스트 -->
        <div class="sa-wrap-bottom">
        	<div class="sa-list-profile">
            	<span><strong>{{ detailCard.nickname }}</strong>'S Profile</span>
                <ul>
                	<li>
                    	<span class="sa-ui-title">과목</span>
                        <span>{{ detailLan }}</span>
                    </li>
                    <li>
                    	<span class="sa-ui-title">지역</span>
                        <span>{{ detailAddress }}{{ detailAddressLocal }}</span>
                    </li>
                    <li>
                    	<span class="sa-ui-title">나이</span>
                        <span>{{ detailAge }}</span>
                    </li>
                </ul>
            </div>
            <div class="sa-list-lesson">
            	<span><strong>{{ detailCard.nickname }}</strong>'S lesson infomation</span>
                <ul>
                	<li>
                    	<span class="sa-ui-title">레슨희망일</span>
                        <span>주2회(월,금)</span>
                    </li>
                    <li>
                    	<span class="sa-ui-title">레슨가능시간</span>
                        <span>오전(10:000~12:00)</span>
                    </li>
                    <li>
                    	<span class="sa-ui-title">레슨요청 키워드</span>
                        <span>
                            <span>회화위주</span>
                            <span>{{ detailAge }} {{ detailJob }}</span>
                            <span>유학경험</span>
                        </span>
                    </li>
                </ul>
            </div>
        </div>   
        <!-- //프로필 리스트 -->
    </div>
	<!-- //contents -->
	<%-- 공통 Footer --%>
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	<%-- //공통 Footer --%>
</body>
</html>