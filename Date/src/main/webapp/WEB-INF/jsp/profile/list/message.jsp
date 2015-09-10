<!DOCTYPE html>
<html ng-app="App" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>MYPROFILE_MESSAGE</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>

	<%-- 스크립트 --%>
	<script src="${_resource}/js/profile/list/message.js"></script>
	<%-- //스크립트 --%>

</head>
<body ng-controller="AppController">

	<%-- 공통 Header --%>
	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<%-- //공통 Header --%>

	<!-- contents -->
   	<div class="sa-tab2-contents">
    	<!-- tab -->
        <!-- 
        	선택 class="sa-selected" 추가 
        -->
    	<div class="sa-ui-tab">
        	<ul class="sa-list-tab">
            	<li><a href="#">M Y&nbsp;&nbsp;&nbsp;&nbsp;P R O F I L E</a></li>
            	<li class="sa-list-second"><a href="#">L E S S O N <span class="sa-text">목록</span><em class="sa-data-lesson">2</em></a></li>
            	<li class="sa-selected"><a href="#"><span class="sa-text">메세지목록</span><em class="sa-data-message">2</em></a></li>
            </ul>
        </div>
    	<!-- //tab -->
    	<ul class="sa-list-profile">
        	<li>
            	<a href="#">
                	<img class="sa-data-image" src="../images/@sample.jpg" alt="프로필사진" />
                    <div class="sa-ui-info">
                    	<span class="sa-data-name"><strong>영어최강</strong></span>
                    	<div class="sa-ui-user-det">
                            <span class="sa-data-import">30대 중반</span>
                            <span>경기 성남</span>
                            <span>영어</span>
                            <span>경력3년</span>
                            <span>뉴저지대</span>
                   		</div>
                    </div>
                    <span class="sa-ui-time">3 hour ago</span>
                    <img class="sa-btn-sendblue" src="../images/icon-send.png" alt="보내기버튼" />
                </a>
            </li>
            <li>
            	<a href="#">
                	<img class="sa-data-image" src="../images/@sample.jpg" alt="프로필사진" />
                    <div class="sa-ui-info">
                    	<span class="sa-data-name"><strong>영어최강</strong></span>
                    	<div class="sa-ui-user-det">
                            <span class="sa-data-import">30대 중반</span>
                            <span>경기 성남</span>
                            <span>영어</span>
                            <span>경력3년</span>
                            <span>뉴저지대</span>
                   		</div>
                    </div>
                    <span class="sa-ui-time">3 hour ago</span>
                    <img class="sa-btn-receive" src="../images/icon-receive.png" alt="받기버튼" />
                </a>
            </li>
            <li>
            	<a href="#">
                	<img class="sa-data-image" src="../images/@sample.jpg" alt="프로필사진" />
                    <div class="sa-ui-info">
                    	<span class="sa-data-name"><strong>영어최강</strong></span>
                    	<div class="sa-ui-user-det">
                            <span class="sa-data-import">30대 중반</span>
                            <span>경기 성남</span>
                            <span>영어</span>
                            <span>경력3년</span>
                            <span>뉴저지대</span>
                   		</div>
                    </div>
                    <span class="sa-ui-time">3 hour ago</span>
                    <img class="sa-btn-sendblue" src="../images/icon-send.png" alt="보내기버튼" />
                </a>
            </li>
            <li>
            	<a href="#">
                	<img class="sa-data-image" src="../images/@sample.jpg" alt="프로필사진" />
                    <div class="sa-ui-info">
                    	<span class="sa-data-name"><strong>영어최강</strong></span>
                    	<div class="sa-ui-user-det">
                            <span class="sa-data-import">30대 중반</span>
                            <span>경기 성남</span>
                            <span>영어</span>
                            <span>경력3년</span>
                            <span>뉴저지대</span>
                   		</div>
                    </div>
                    <span class="sa-ui-time">3 hour ago</span>
                    <img class="sa-btn-receive" src="../images/icon-receive.png" alt="받기버튼" />
                </a>
            </li>
            <li class="sa-disable-profile">
            	<a href="#">
                	<img class="sa-data-image" src="../images/@sample.jpg" alt="프로필사진" />
                    <div class="sa-ui-info">
                    	<span class="sa-data-name"><strong>영어최강</strong></span>
                    	<div class="sa-ui-user-det">
                            <span class="sa-data-import">30대 중반</span>
                            <span>경기 성남</span>
                            <span>영어</span>
                            <span>경력3년</span>
                            <span>뉴저지대</span>
                   		</div>
                    </div>
                    <span class="sa-ui-time">3 hour ago</span>
                </a>
            </li>
            <li class="sa-disable-profile">
            	<a href="#">
                	<img class="sa-data-image" src="../images/@sample.jpg" alt="프로필사진" />
                    <div class="sa-ui-info">
                    	<span class="sa-data-name"><strong>영어최강</strong></span>
                    	<div class="sa-ui-user-det">
                            <span class="sa-data-import">30대 중반</span>
                            <span>경기 성남</span>
                            <span>영어</span>
                            <span>경력3년</span>
                            <span>뉴저지대</span>
                   		</div>
                    </div>
                    <span class="sa-ui-time">3 hour ago</span>
                </a>
            </li>
        </ul>    
    </div>
	<!-- //contents -->
    
	<%-- 공통 Footer --%>
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	<%-- //공통 Footer --%>


</body>
</html>
