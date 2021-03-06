\<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>
	<title>오늘의 카드</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>
	
	<%-- 스크립트 --%>
    <script src="${_resource}/js/card/today.js"></script>
    <%-- //스크립트 --%>
    
</head>
<body ng-controller="AppController">
	<%-- 공통 Header --%>
	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<%-- //공통 Header --%>
	
	<!-- contents -->
    <div class="sa-layout-contents">
    	<!-- today -->
    	<div class="sa-ui-today">
        	<p class="sa-data-date"><strong>{{ todayMonth }}</strong>월 <span class="sa-data-daily"><strong>{{ todayDay}}</strong>일</span></p>
            <span class="sa-text-title">T O D A Y ’S&nbsp;&nbsp;&nbsp;&nbsp;L E S S O N</span>
        </div>
    	<!-- //today -->
        
                <!-- 선택 -->
        <!-- 
        	마감 class="sa-ui-today-close" 추가
        -->
        <div class="sa-ui-today-contents sa-ui-today-close">
<!--         	마감 -->
        	<div	ng-show="pageShade()" class="sa-ui-close-wrap2">
            	<em class="sa-icon-close-clock"></em>
                <p class="sa-text-time"><span>{{ todayMonth }}월 {{ todayDay }}일의 Today’s Lesson 마감시간이 지났습니다.</span></p>
                <span class="sa-text-ment">{{ todayMonth }}월 {{ todayDay + 1 }}일 PM 12:00에 또 다른 2인의 선생님이 소개됩니다.</span>
            </div>
<!--         	//마감 -->
        	<p class="sa-ui-text">오늘 <span class="sa-data-time">{{ displayTime }}</span>분까지 두 분의 선생님 중 마음에 드는 선생님을 선택하세요</p>
            <div class="sa-ui-card-wrap">
                <ul class="sa-list-card">
                	<!-- 프로필 -->
                    <li>
                        <!-- 
                            마감 class="sa-ui-profile-close" 추가 
                        -->
                        <a	ng-class="{'sa-ui-profile-close': selectShadeLeft() }" 
                        	ng-click="clickSelect( firstCard.to )">
                            <div class="sa-ui-profile">
                                <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
                                <span class="sa-data-nickname"><strong>{{ firstLan }}</strong> 선생님 </span>
                                <div class="sa-data-info">
                                    <span class="sa-data">{{ firstAge }}</span>
                                    <span class="sa-data">{{ firstAddressLocal }} {{ firstAddress }}</span>
                                    <span class="sa-data">{{ firstLan }}</span>
                                </div>
                                <div class="sa-data-info">
                                    <span class="sa-data sa-data-import">{{ firstAge }}</span>
                                    <span class="sa-data">{{ firstAddressLocal }} {{ firstAddress }}</span>
                                    <span class="sa-data sa-data-import">{{ firstLan }}</span>
                                </div>
                            	<!-- 마감 -->
                            	<div class="sa-ui-close-wrap">
                                	<em class="sa-icon-close"></em>
                                </div>
                            	<!-- //마감 -->
                            </div>
                        </a>
                    </li>
                	<!-- //프로필 -->
                    
                	<!-- 프로필 -->
                    <li>
                        <!-- 
                            마감 class="sa-ui-profile-close" 추가 
                        -->
                        <a	ng-class="{'sa-ui-profile-close' : selectShadeRight() }" 
                        	ng-click="clickSelect( secondCard.to )">
                            <div class="sa-ui-profile">
                                <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
                                <span class="sa-data-nickname"><strong>{{ secondLan }}</strong> 선생님</span>
                                <div class="sa-data-info">
                                    <span class="sa-data">{{ secondAge }}</span>
                                    <span class="sa-data">{{ secondAddressLocal }} {{ secondAddress }}</span>
                                    <span class="sa-data">{{ secondLan }}</span>
                                </div>
                                <div class="sa-data-info">
                                    <span class="sa-data sa-data-import">{{ secondAge }}</span>
                                    <span class="sa-data">{{ secondAddressLocal }} {{ secondAddress }}</span>
                                    <span class="sa-data sa-data-import">{{ secondLan }}</span>
                                </div>
                            	<!-- 마감 -->
                            	<div class="sa-ui-close-wrap">
                                	<em class="sa-icon-close"></em>
                                </div>
                            	<!-- //마감 -->
                            </div>
                        </a>
                    </li>
                	<!-- //프로필 -->
                </ul>
             </div>
             
             <!-- 마감시간 -->
             <div class="sa-ui-close-time">
             	<dl>
                	<dt>선택마감시간</dt>
                    <dd><span class="sa-data-time">{{ displayTime }}</span> <span class="sa-text">시간 전</span></dd>
                </dl>
             </div>
             <!-- //마감시간 -->
        </div>
        <!-- 선택 -->

        <!-- history card -->
        <div class="sa-ui-list-wrap">
        	<div class="sa-ui-title">H i s t o r y</div>
            <p class="sa-ui-text">현재일로부터 7일전까지의 소개받은 선생님들을 확인하실 수 있습니다</p>
            <ul class="sa-list-history">
            	<!-- history -->
            	<li>
                	<div class="sa-ui-history-wrap">
                        <p class="sa-data-date"><strong>{{ firstMonth }}</strong> 월 <span class="sa-data-daily"><strong>{{ firstDay}}</strong> 일</span></p>
                        <ul class="sa-list-profile-card">
                        	<!-- 프로필 -->
                            <li>
                                <!-- 
                                    마감 class="sa-ui-profile-close" 추가 
                                -->
                            	<a ng-click="clickHistorySelect( firstHistory.email )" ng-class="{ 'sa-ui-profile-close': firstHistoryShade() }">
                                    <div class="sa-ui-profile-card">
                                        <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
                                        <span class="sa-data-nickname"><strong>{{ firstHistoryLan }}</strong> {{ firstHistoryJob }}</span>
                                        <div class="sa-data-info">
                                            <span class="sa-data">{{ firstHistoryAge }}</span>
                                            <span class="sa-data">{{ firstHistoryAddress }} {{ firstHistoryAddressLocal}}</span>
                                            <span class="sa-data">{{ firstHistoryLan }}</span>
                                        </div>
                                        <!-- 마감 -->
                                        <div class="sa-ui-close-wrap">
                                            <em class="sa-icon-close"></em>
                                        </div>
                                        <!-- //마감 -->
                                    </div>
                                </a>
                            </li>
                            <!-- //프로필 -->
                            
                          	<!-- 프로필 -->
                            <li>
                            	<a ng-click="clickHistorySelect( secondHistory.email )" ng-class="{ 'sa-ui-profile-close': secondHistoryShade() }">
                                    <div class="sa-ui-profile-card">
                                        <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
                                        <span class="sa-data-nickname"><strong>{{ secondHistoryLan }}</strong> {{ secondHistoryJob }} </span>
                                        <div class="sa-data-info">
                                            <span class="sa-data">{{ secondHistoryAge }}</span>
                                            <span class="sa-data">{{ secondHistoryAddress }}{{ secondHistoryAddressLocal }}</span>
                                            <span class="sa-data">{{ secondHistoryLan }}</span>
                                        </div>
                                        <!-- 마감 -->
                                        <div class="sa-ui-close-wrap">
                                            <em class="sa-icon-close"></em>
                                        </div>
                                        <!-- //마감 -->
                                    </div>
                                </a>
                            </li>
                            <!-- //프로필 -->
                        </ul>
                     </div>
                </li>
            	<!-- //history -->
                
                <!-- history -->
            	<li>
                	<div class="sa-ui-history-wrap">
                        <p class="sa-data-date"><strong>{{ thirdMonth }}</strong>월 <span class="sa-data-daily"><strong>{{ thirdDay }}</strong>일</span></p>
                        <ul class="sa-list-profile-card">
                        	<!-- 프로필 -->
                            <li>
                                <!-- 
                                    마감 class="sa-ui-profile-close" 추가 
                                -->
                            	<a ng-click="clickHistorySelect( first.History )" ng-class="{ 'sa-ui-profile-close': thirdHistoryShade() }">
                                    <div class="sa-ui-profile-card">
                                        <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
                                        <span class="sa-data-nickname"><strong>{{ thirdHistoryLan }}</strong> {{ thirdHistoryJob }} </span>
                                        <div class="sa-data-info">
                                            <span class="sa-data">{{ thirdHistoryAge }}</span>
                                            <span class="sa-data">{{ thirdHistoryAddress }}{{ thirdHistoryAddressLocal }}</span>
                                            <span class="sa-data">{{ thirdHistoryLan }}</span>
                                        </div>
                                        <!-- 마감 -->
                                        <div class="sa-ui-close-wrap">
                                            <em class="sa-icon-close"></em>
                                        </div>
                                        <!-- //마감 -->
                                    </div>
                                </a>
                            </li>
                            <!-- //프로필 -->
                            
                          	<!-- 프로필 -->
                            <li>
                            	<a ng-click="clickHistorySelect( second.History )" ng-class="{ 'sa-ui-profile-close': forthHistoryShade() }">
                                    <div class="sa-ui-profile-card">
                                        <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
                                        <span class="sa-data-nickname"><strong>{{ forthHistoryLan }}</strong> {{ forthHistoryJob }}</span>
                                        <div class="sa-data-info">
                                            <span class="sa-data">{{ forthHistoryAge }}</span>
                                            <span class="sa-data">{{ forthHistoryAddress }} {{ forthHistoryAddressLocal }}</span>
                                            <span class="sa-data">{{ forthHistoryLan }}</span>
                                        </div>
                                        <!-- 마감 -->
                                        <div class="sa-ui-close-wrap">
                                            <em class="sa-icon-close"></em>
                                        </div>
                                        <!-- //마감 -->
                                    </div>
                                </a>
                            </li>
                            <!-- //프로필 -->
                        </ul>
                     </div>
                </li>
            	<!-- //history -->
                
            </ul>
        </div>
        <!-- //history card -->
    </div>
	<!-- //contents -->
	<%-- 공통 Footer --%>
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	<%-- //공통 Footer --%>
</body>
</html>