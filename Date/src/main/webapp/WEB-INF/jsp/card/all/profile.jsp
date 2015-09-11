<!DOCTYPE html>
<html ng-app="App" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>TODAYS LESSON</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>

	<%-- 스크립트 --%>
	<script src="${_resource}/js/card/all/profile.js"></script>
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
        	<a href="#" class="sa-btn-back">목록으로</a>
        	<span class="sa-data-name">영문학도</span>' S&nbsp;&nbsp;&nbsp;&nbsp;P R O F I L E
        </div>
    	<!-- //title -->
        
        <!-- 프로필 내용 -->
    	<div class="sa-wrap-top">
        	<img src="${_resource}/images/img-@sample15.png" alt="이미지" />
            <div class="sa-box-profile">
            	<div class="sa-ui-jobwrap">
            		<span>영문학도</span>
                    <span class="sa-ui-job">학생</span>
                </div>
                <ul class="sa-list-introduce">
                	<li class="sa-ui-strong">30대 중반</li>
                    <li>경기 성남</li>
                    <li>영어</li>
                </ul>
                <!--
                	 이미지 닫힘 class="sa-list-close" 추가            
                -->
                <ul class="sa-list-photo">
                	<li>
                    	<a href="#">
                        	<img src="${_resource}/images/img_photo1.png" alt="images1" />
                            <!-- 닫힘 -->
                            <div class="sa-ui-image-close">
                                <em class="sa-icon-close"></em>
                            </div>
                            <!-- 닫힘 -->
                        </a>
                    </li>
                    <li class="sa-list-close">
                        <a href="#">
                        	<img src="${_resource}/images/img_photo2.png" alt="images1" />
                            <!-- 닫힘 -->
                            <div class="sa-ui-image-close">
                                <em class="sa-icon-close"></em>
                            </div>
                            <!-- 닫힘 -->
                        </a>
                    </li>
                    <li class="sa-list-close">
                    	<a href="#">
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
                	<a class="sa-bg-chat" href="#"><p>Chatting</p></a>
                   	<a class="sa-bg-message" href="#"><p>메시지 보내기</p></a>
                </div>
            </div>
        </div>
        
        <!-- 평가점수 -->
        <div class="sa-wrap-middle">
        	<p>평가점수</p>
            <span><em style="width:30%;"></em></span>
            <button type="button">평가하기</button>
        </div>
        <!-- //평가점수 -->
        
        <!-- 프로필 리스트 -->
        <div class="sa-wrap-bottom">
        	<div class="sa-list-profile">
            	<span><strong>영문학도</strong>'S Profile</span>
                <ul>
                	<li>
                    	<span class="sa-ui-title">과목</span>
                        <span>영어(영어회화,독해)</span>
                    </li>
                    <li>
                    	<span class="sa-ui-title">지역</span>
                        <span>경기 성남</span>
                    </li>
                    <li>
                    	<span class="sa-ui-title">나이</span>
                        <span>20대 중반</span>
                    </li>
                </ul>
            </div>
            <div class="sa-list-lesson">
            	<span><strong>영문학도</strong>'S lesson infomation</span>
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
                            <span>20대 선생님</span>
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
