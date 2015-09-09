<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>
	<title>Lesson Master</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>
	
	<%-- 스크립트 --%>
	<script>
		// 이전에 가려고 했던 URL
		var _forwardUrl = "${_forwardUrl}<c:if test="${!empty _forwardParam}">?${_forwardParam}</c:if>";
		// 이전에 가려고 했던 URL이 없을때 기본으로 갈 페이지
		var _defaultUrl = "/card/today";
	</script>
    <script src="${_resource}/js/main/main.js"></script>
    <%-- //스크립트 --%>
</head>
<body ng-controller="AppController">
	<!-- loading bar -->
	<div id="_loading" class="page-loading-overlay" style="display:none;">
	    <div class="loader-2"></div>
	</div>
	<!-- //loading bar -->

	<div class="sa-layout-wrap">
		<!-- header -->
		<div class="sa-layout-main-header">
	    	<div class="sa-ui-header">
	            <ul class="sa-list-top-menu">
	                <li><a href="javascript:">FAQ</a></li>
	                <li><a href="javascript:">About</a></li>
	            </ul>
	            <!-- 로고 -->
	            <div class="sa-ui-logo">
	            	<span class="sa-ui-text">내가 찾는 "선생님"과 나를 원하는 "학생"을<br />
					<strong>실시간 매칭하는 온라인 어학레슨 매칭 서비스</strong> </span>
	                <img src="${_resource}/images/logo_main.png" alt="LESSON MASTER"/>
	            </div>
	            <!-- //로고 -->
	            
	            <div class="sa-ui-head-contents">
	                <ul class="sa-list-login-menu">
	                    <li><a ng-click=joinModal() href="javascript:"><em class="sa-icon-join"></em>회원가입</a></li>
	                    <li><a ng-click="loginModal()" href="javascript:"><em class="sa-icon-login"></em>로그인</a></li>
	                </ul>
	                
	                <!-- 사람수 -->
	                <div class="sa-data-num">
	                    <dl class="sa-data-total">
	                        <dt>yesterday</dt>
	                        <dd>3,240명</dd>
	                    </dl>
	                    <dl class="sa-data-total">
	                        <dt>total</dt>
	                        <dd>123,240명</dd>
	                    </dl>
	                 </div>
	                 <!-- //사람수 -->
	                 
	                 <div class="sa-data-sex">
	                 	<dl>
	                    	<dt>누굴 찾나요?</dt>
	                    	<dd>
	                            <!-- Radio Button -->
	                            <div class="sa-radio">
	                                <input ng-model="gender" type="radio" value="M" id="woman" name="checkGender" checked="checked" />
	                                <label for="woman"></label>
	                            </div>
	                            <!-- //Radio Button -->
	                            <label class="sa-label-txt" for="woman">선생님을 찾아요</label>
	                        </dd>
	                    	<dd>
	                            <!-- Radio Button -->
	                            <div class="sa-radio">
	                                <input ng-model="gender" type="radio" value="F" id="man" name="checkGender" />
	                                <label for="man"></label>
	                            </div>
	                            <!-- //Radio Button -->
	                            <label class="sa-label-txt" for="man">학생을 찾아요</label>
	                        </dd>
	                    </dl>
	                 </div>
	            </div>
	        </div>
	    </div>
		<!-- //header -->
		<!-- contents -->
	    <div class="sa-layout-main-contents">
	    	<!-- 소개 -->
	    	<div class="sa-ui-introduce">
	        	<p class="sa-title">L E S S O N&nbsp;&nbsp;&nbsp;&nbsp;M A S T E R ?</p>
	            
	            <ul class="sa-list-master">
	            	<li>
	                	<span class="sa-text">영어를 배우고 싶은데…<br />실력 있는 선생님 </span>
	
						<span class="sa-text-where">
	                    	<em class="sa-icon-where1"></em>
	                        어디 없나요?
	                    </span>
	                </li>
	            	<li>
	                	<span class="sa-text">스페인어 전공인데…<br />배우실 학생분</span>
	
						<span class="sa-text-where">
	                    	<em class="sa-icon-where2"></em>
	                        어디 없나요?
	                    </span>
	                </li>
	            </ul>
	            <div class="sa-ui-comment">
	            	Lesson Master에 등록만 하시면 내가 찾는 선생님과 학생을<br />
					<strong>Lesson Mastser가 매일매일 추천드립니다.</strong>
	            </div>
	        </div>
	    	<!-- //소개 -->
	        
	        <!-- card -->
	    	<div class="sa-ui-card">
	        	<p class="sa-title">T O D A Y 'S&nbsp;&nbsp;&nbsp;&nbsp;L E S S O N</p>
	            <span class="sa-card-det">당신이 찾는 선생님/학생을 매일매일 추천합니다!</span>
	            <ul class="sa-list-card">
	                <li ng-show="gender == 'F'">
	                    <a href="javascript:">
	                        <div class="sa-ui-profile">
	                            <img src="${_resource}/images/@sample5.jpg" alt="사진" class="sa-data-photo"/>
	                            <span class="sa-data-nickname"><strong>구교준</strong> 선생님</span>
	                            <div class="sa-data-info">
	                                <span class="sa-data">30대중반</span>
	                                <span class="sa-data">경기 성남</span>
	                                <span class="sa-data">영어</span>
	                            </div>
	                        </div>
	                    </a>
	                </li>
	                <li ng-show="gender == 'F'">
	                    <a href="javascript:">
	                        <div class="sa-ui-profile">
	                            <img src="${_resource}/images/@sample2.jpg" alt="사진" class="sa-data-photo"/>
	                            <span class="sa-data-nickname"><strong>고주희</strong> 선생님</span>
	                            <div class="sa-data-info">
	                                <span class="sa-data">40대초반</span>
	                                <span class="sa-data">경기 성남</span>
	                                <span class="sa-data">스페인어</span>
	                            </div>
	                        </div>
	                    </a>
	                </li>
	                <li ng-show="gender == 'M'">
	                    <a href="javascript:">
	                        <div class="sa-ui-profile">
	                            <img src="${_resource}/images/@sample.jpg" alt="사진" class="sa-data-photo"/>
	                            <span class="sa-data-nickname"><strong>곽충현</strong> 학생</span>
	                            <div class="sa-data-info">
	                                <span class="sa-data">20대중반</span>
	                                <span class="sa-data">경기 성남</span>
	                                <span class="sa-data">프랑스어</span>
	                            </div>
	                        </div>
	                    </a>
	                </li>
	                <li ng-show="gender == 'M'">
	                    <a href="javascript:">
	                        <div class="sa-ui-profile">
	                            <img src="${_resource}/images/@sample4.jpg" alt="사진" class="sa-data-photo"/>
	                            <span class="sa-data-nickname"><strong>이태호</strong> 학생</span>
	                            <div class="sa-data-info">
	                                <span class="sa-data">20대후반</span>
	                                <span class="sa-data">경기 안양</span>
	                                <span class="sa-data">중국어</span>
	                            </div>
	                        </div>
	                    </a>
	                </li>
	            </ul>
	        </div>
	    	<!-- //card -->
	    </div>
		<!-- //contents -->
	    
	    <!-- footer -->
	    <div class="sa-layout-main-footer">
	    	<span class="sa-copy">Copyright&copy;Date,Inc. All right reserved.</span>
	    
	    </div>
	    <!-- //footer -->
	</div>
	
	
	<!-- 로그인 popup -->
	<div class="sa-layout-popup" id="modalLogin" style="display:none;">
		<em class="sa-pop-bg"></em>
	    <div class="sa-layout-popup-in">
	        <!-- pop heade -->
	        <div class="sa-layout-pop-head">
	            <img src="${_resource}/images/pop_logo.png" alt="love maker 12" class="sa-image-logo"/>
	            <a ng-click="close()" href="javascript:" class="sa-btn-close"><img src="${_resource}/images/btn_close.png" alt="닫힘"/></a>
	        </div>
	        <!-- //pop heade -->
	        
	        <!-- pop contents -->
	        <div class="sa-layout-pop-contents">
	            <p class="sa-pop-title"><span class="sa-title">Login</span><span class="sa-pop-det">로그인하셔서 당신의 이상형을 확인하세요!</span></p>
	            <div class="sa-ui-input-form">
	                <label class="sa-label-input">E-MAIL</label>
	                <input	ng-model="loginVO.email"
	                		type="text"
	                		required="required"
                            maxLength="100" 
	                		placeholder="Email" 
	                		class="sa-input-text"/>
	            </div>
	            <div class="sa-ui-input-form">
	                <label class="sa-label-input">PASSWORD</label>
	                <input 	ng-model="loginVO.pass"
	                		ng-keyup="$event.keyCode == 13 ? login() : null;" 
	                		type="password" 
	                		required="required"
                            maxLength="30"
	                		placeholder="Password" 
	                		class="sa-input-text"/>
	            </div>
	        </div>
	        <!-- //pop contents -->
	        
	        <!-- pop footer -->
	        <div class="sa-layout-pop-footer">
	            <button ng-click="close()" class="sa-btn-footer"><span><em class="sa-icon-cancel"></em> 취소</span></button>
	            <button ng-click="login()" class="sa-btn-footer"><span><em class="sa-icon-login"></em> 로그인</span></button>
	        </div>
	        <!-- //pop footer -->
	    </div>
	</div>
	<!-- //로그인 popup -->
	
	
	
	<!-- 회원가입 popup -->
	<div class="sa-layout-popup" id="modalJoin" style="display:none;">
		<em class="sa-pop-bg"></em>
	    <div class="sa-layout-popup-in">
	        <!-- pop heade -->
	        <div class="sa-layout-pop-head">
	            <img src="${_resource}/images/pop_logo.png" alt="love maker 12" class="sa-image-logo"/>
	            <a ng-click="close()" href="javascript:" class="sa-btn-close"><img src="${_resource}/images/btn_close.png" alt="닫힘"/></a>
	        </div>
	        <!-- //pop heade -->
	        
	        <!-- pop contents -->
	        <div class="sa-layout-pop-contents">
	            <p class="sa-pop-title"><span class="sa-title">Member join </span><span class="sa-pop-det">가입하시면 내가 찾는 선생님/ 학생을 실시간 매칭해 드립니다</span><em class="sa-title-line"></em></p>
	            <div class="sa-ui-input-form">
	                <label class="sa-label-input">E-MAIL</label>
	                <div class="sa-ui-multi-form">
	                    <input ng-model="joinVO.email" type="text" placeholder="Email" class="sa-input-text"/>
	                    <button ng-click="emailCheck(joinVO.email)" class="sa-btn">중복확인</button>
	                </div>
	            </div>
	            
	            <div class="sa-ui-input-form">
	                <label class="sa-label-input">PASSWORD</label>
	                <input ng-model="joinVO.pass" type="password" placeholder="Password" class="sa-input-text"/>
	            </div>
	            
	            <!-- 구분 선택 -->
	            <div class="sa-ui-inline-form">
	            	<label class="sa-label-title">구분선택</label>
	                
	              	<div class="sa-ui-radio">
	                    <!-- Radio Button -->
	                    <div class="sa-radio">
	                        <input ng-model="joinVO.gender" type="radio" value="M" id="teacher" name="check" />
	                        <label for="teacher"></label>
	                    </div>
	                    <!-- //Radio Button -->
	                    <label for="teacher" class="sa-label-radio">선생님을 찾아요</label>
	                </div>
	                
	                <div class="sa-ui-radio">
	                    <!-- Radio Button -->
	                    <div class="sa-radio">
	                        <input ng-model="joinVO.gender" type="radio" value="F" id="student" name="check" />
	                        <label for="student"></label>
	                    </div>
	                    <!-- //Radio Button -->
	                    <label for="student" class="sa-label-radio">학생을 찾아요</label>
	                </div>
	            </div>
	            <!-- //구분 선택 -->
	            
	             <div class="sa-ui-input-form">
	                <label class="sa-label-input">닉네임</label>
	                <div class="sa-ui-multi-form">
	                    <input ng-model="joinVO.nickname" type="text" placeholder="" class="sa-input-text"/>
	                    <button ng-click="nicknameCheck(joinVO.nickname)" class="sa-btn">중복확인</button>
	                </div>
	            </div>
	            
	            <div class="sa-ui-inline-form">
	                <label class="sa-label-input">생년월일</label>
	                <div class="sa-select-box">
	                    <span ng-bind="joinVO.year.name" class="sa-data-option"></span>
	                    <em class="sa-icon-select"></em>
	                    <select ng-model="joinVO.year"
	                    		ng-options="item.name for item in year"
	                    		class="tfabric-select">
	                    </select>
	            	</div>
	            	
	                <!-- Select Box -->
	                <div class="sa-select-box">
	                    <span ng-bind="joinVO.month.name" class="sa-data-option"></span>
	                    <em class="sa-icon-select"></em>
	                    <select ng-model="joinVO.month"
	                    		ng-options="item.name for item in month"
	                    		class="tfabric-select">
	                    </select>
	                </div>
	                <!-- //Select Box -->
	            	
	            	<div class="sa-select-box">
	                    <span ng-bind="joinVO.date.name" class="sa-data-option"></span>
	                    <em class="sa-icon-select"></em>
	                    <select ng-model="joinVO.date"
	                    		ng-options="item.name for item in date"
	                    		class="tfabric-select">
	                    </select>
	                </div>
	            </div>
	         
	        </div>
	        <!-- //pop contents -->
	        
	        <!-- pop footer -->
	        <div class="sa-layout-pop-footer">
	            <button ng-click="close()" class="sa-btn-footer"><span><em class="sa-icon-cancel"></em> 취소</span></button>
	            <button ng-click="join()" class="sa-btn-footer"><span><em class="sa-icon-join"></em> 가입하기</span></button>
	        </div>
	        <!-- //pop footer -->
	    </div>
	</div>
	<!-- //회원가입 popup -->
</body>
</html>