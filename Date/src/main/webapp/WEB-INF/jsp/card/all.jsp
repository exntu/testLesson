<!DOCTYPE html>
<html ng-app="App" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>TODAYS LESSON</title>

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
	
	    
	<!-- contents -->
    <div class="sa-layout-contents">
    	<div class="sa-ui-all-card">
             <ul class="sa-list-card">
                <!-- 프로필 -->
                <li>
                    <!-- 날짜 -->
                    <div class="sa-data-daily" style="">
                    	<span class="sa-data-month">9</span>
                    	<span class="sa-data-day">1</span>
                    </div>
                    <!-- //날짜 -->

                    <!-- 
                        선택하지 않을 경우 class="sa-ui-disabled" 추가 
                    -->
                    <a href="#" class="sa-ui-disabled">
                        <div class="sa-ui-profile" >
                            <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
                            <span class="sa-data-nickname"><strong>영어최강</strong> 선생님</span>
                            <div class="sa-data-info">
                                <span class="sa-data">20대중반</span>
                                <span class="sa-data">경기 성남</span>
                                <span class="sa-data">영어</span>
                            </div>
                            <div class="sa-data-info">
                                <span class="sa-data sa-data-import">20대중반</span>
                                <span class="sa-data">경기 성남</span>
                                <span class="sa-data sa-data-import">스페인어</span>
                            </div>
                            <!-- not choice -->
                            <div class="sa-ui-not-choice">
                                <em class="sa-icon-choice"></em>
                            </div>
                            <!-- not choice -->
                        </div>
                    </a>
                </li>
                <!-- //프로필 -->
                
                <!-- 프로필 -->
                <li>
                    <!-- 날짜 -->
                    <div class="sa-data-daily" style="">
                    	<span class="sa-data-month">9</span>
                    	<span class="sa-data-day">1</span>
                    </div>
                    <!-- //날짜 -->
                    
                    <!-- 
                        선택하지 않을 경우 class="sa-ui-disabled" 추가 
                    -->
                    <a href="${_ctx}/card/all/profile">
                        <div class="sa-ui-profile">
                            <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
                            <span class="sa-data-nickname"><strong>영어최강</strong> 선생님</span>
                            <div class="sa-data-info">
                                <span class="sa-data">20대중반</span>
                                <span class="sa-data">경기 성남</span>
                                <span class="sa-data">영어</span>
                            </div>
                            <div class="sa-data-info">
                                <span class="sa-data sa-data-import">20대중반</span>
                                <span class="sa-data">경기 성남</span>
                                <span class="sa-data sa-data-import">스페인어</span>
                            </div>
                            <!-- not choice -->
                            <div class="sa-ui-not-choice">
                                <em class="sa-icon-choice"></em>
                            </div>
                            <!-- not choice -->
                        </div>
                    </a>
                </li>
                <!-- //프로필 -->
                
                <!-- 프로필 -->
                <li>
                    <!-- 날짜 -->
                    <div class="sa-data-daily" style="">
                    	<span class="sa-data-month">9</span>
                    	<span class="sa-data-day">1</span>
                    </div>
                    <!-- //날짜 -->
                    
                    <!-- 
                        선택하지 않을 경우 class="sa-ui-disabled" 추가 
                    -->
                    <a href="${_ctx}/card/all/profile" >
                        <div class="sa-ui-profile">
                            <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
                            <span class="sa-data-nickname"><strong>영어최강</strong> 선생님</span>
                            <div class="sa-data-info">
                                <span class="sa-data">20대중반</span>
                                <span class="sa-data">경기 성남</span>
                                <span class="sa-data">영어</span>
                            </div>
                            <div class="sa-data-info">
                                <span class="sa-data sa-data-import">20대중반</span>
                                <span class="sa-data">경기 성남</span>
                                <span class="sa-data sa-data-import">스페인어</span>
                            </div>
                            <!-- not choice -->
                            <div class="sa-ui-not-choice">
                                <em class="sa-icon-choice"></em>
                            </div>
                            <!-- not choice -->
                        </div>
                    </a>
                </li>
                <!-- //프로필 -->
                
                <!-- 프로필 -->
                <li>
                    <!-- 날짜 -->
                    <div class="sa-data-daily" style="">
                    	<span class="sa-data-month">9</span>
                    	<span class="sa-data-day">1</span>
                    </div>
                    <!-- //날짜 -->
                    
                    <!-- 
                        선택하지 않을 경우 class="sa-ui-disabled" 추가 
                    -->
                    <a href="#" class="sa-ui-disabled">
                        <div class="sa-ui-profile">
                            <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
                            <span class="sa-data-nickname"><strong>영어최강</strong> 선생님</span>
                            <div class="sa-data-info">
                                <span class="sa-data">20대중반</span>
                                <span class="sa-data">경기 성남</span>
                                <span class="sa-data">영어</span>
                            </div>
                            <div class="sa-data-info">
                                <span class="sa-data sa-data-import">20대중반</span>
                                <span class="sa-data">경기 성남</span>
                                <span class="sa-data sa-data-import">스페인어</span>
                            </div>
                            <!-- not choice -->
                            <div class="sa-ui-not-choice">
                                <em class="sa-icon-choice"></em>
                            </div>
                            <!-- not choice -->
                        </div>
                    </a>
                </li>
                <!-- //프로필 -->
            </ul>
        </div>
    </div>
	<!-- //contents -->
    

	<%-- 공통 Footer --%>
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	<%-- //공통 Footer --%>

</body>
</html>