<!DOCTYPE html>
<html ng-app="App" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>upload</title>

	<%-- 공통 Variable & CSS & JS --%>
	<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
	<%-- //공통 Variable & CSS & JS --%>
	
<script>
	//optional need to be loaded before angular-file-upload-shim(.min).js
	FileAPI = {
		//only one of jsPath or jsUrl.
		//jsPath: '/js/FileAPI.min.js/folder/', 
		jsUrl : '${_resource}/lib/angular/upload/FileAPI.min.js',

		//only one of staticPath or flashUrl.
		//staticPath: '/flash/FileAPI.flash.swf/folder/',
		flashUrl : '${_resource}/lib/angular/upload/FileAPI.flash.swf'
	}
</script>

<%-- Upload --%>
<%-- AngularJS --%>
<script src="${_resource}/lib/angular/upload/ng-file-upload-shim.js"></script>
<script src="${_resource}/lib/angular/upload/ng-file-upload.min.js"></script>

<%-- 스크립트 --%>
<script src="${_resource}/js/profile/profile.js"></script>
<%-- //스크립트 --%>

</head>
<body ng-controller="AppController">
	<%-- 공통 Header --%>
	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<%-- //공통 Header --%>
	
	
	<!-- contents -->
    <div class="sa-layout-contents">
    	<!-- tab -->
        <!-- 
        	선택 class="sa-selected" 추가 
        -->
    	<div class="sa-ui-tab">
        	<ul class="sa-list-tab">
            	<li class="sa-selected"><a href="#">M Y&nbsp;&nbsp;&nbsp;&nbsp;P R O F I L E</a></li>
            	<li class="sa-list-second"><a href="#">L E S S O N <span class="sa-text">목록</span><em class="sa-data-lesson">2</em></a></li>
            	<li><a href="#"><span class="sa-text">메세지목록</span><em class="sa-data-message">2</em></a></li>
            </ul>
        </div>
    	<!-- //tab -->
        
        <!-- 프로필 내용 -->
    	<div class="sa-wrap-top">
        	<img src="${_resource}/images/img-@sample15.png" alt="이미지" />
            <div class="sa-box-profile">
            	<div class="sa-ui-jobwrap">
            		<span>{{nickname}}</span>
                    <span class="sa-ui-job">선생님</span>
                </div>
                <ul class="sa-list-introduce">
                	<li class="sa-ui-strong">{{AGE}} </li>
                    <li>{{SUB}}&nbsp{{SUB_LOCAL}}  </li>
                    <li>{{LAN}} </li>
                </ul>
                <ul class="sa-list-photo">
                	<li ng-repeat="img in result_img track by $index">
                    	<a href="#">
                        	<img data-ng-src="data:image/jpeg;base64,{{img.filestream}}" alt="images1" />
                        </a>
                    </li>
                    <li>
                        <a href="#">
                        	<!--upload-->
                        	<span class="sa-ui-upload" ngf-select ngf-change="uploadPhoto($files)"><em></em></span>
                        	<!--upload-->
                        </a>
                    </li>
                    <li>
                    	<a href="#">
                        	<!--upload-->
                            <span class="sa-ui-upload" ngf-select ngf-change="uploadPhoto($files)"><em></em></span>
                        	<!--upload-->
                        </a>
                    </li>
                </ul>
                <!-- 평가 -->
                <div class="sa-bg-star">
                    <p>평가</p>
                    <span class="sa-img-star"><span></span></span>
                </div>
                <!-- //평가 -->
            </div>
        </div>
        <!--// 프로필 내용 -->
        
        <!-- 프로필 수정 -->
        <div class="sa-ui-modify">
        	<div class="sa-ui-table-title">
            	My profile
            </div>
        	<table class="sa-table-form">
            	<colgroup>
                	<col width="134px" />
                	<col width="*" />
                </colgroup>
                <tbody>
                	<tr>
                        <th><span class="sa-th-title">회원종류</span></th>
                        <td><span class="sa-data-text">선생님</span></td>
                    </tr>
                	<tr>
                        <th><span class="sa-th-title">E-MAIL</span></th>
                        <td><span class="sa-data-text">{{email}}</span></td>
                    </tr>
                	<tr>
                        <th><span class="sa-th-title">생년월일</span></th>
                        <td>
                        	<div class="sa-ui-inline-form">
                                <input type="text" class="sa-input-text2" / ng-model="year">
                                <span class="sa-text">년</span>
                                
                                <!-- Select Box -->
                                <div class="sa-select-box sa-select-type">
                                    <span class="sa-data-option">{{month}}</span>
                                    <em class="sa-icon-select"></em>
                                    <select>
                                        <option></option>
                                    </select>
                                </div>
                                <!-- //Select Box -->
                                
                                <input type="text" class="sa-input-text2" ng-model="date" />
                                <span class="sa-text">일</span>
                                <button class="sa-btn" ng-click="save()">수정</button>
                            </div>
                        </td>
                    </tr>
                	<tr>
                        <th><span class="sa-th-title">지역</span></th>
                        <td>
                        	<div class="sa-ui-inline-form">
                                <!-- Select Box -->
                                <div class="sa-select-box sa-select-type">
                                    <span class="sa-data-option">{{SUB}}</span>
                                    <em class="sa-icon-select"></em>
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <!-- //Select Box -->
                                <!-- Select Box -->
                                <div class="sa-select-box sa-select-type">
                                    <span class="sa-data-option">{{SUB_LOCAL}}</span>
                                    <em class="sa-icon-select"></em>
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <!-- //Select Box -->
                                <button class="sa-btn">수정</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="sa-th-title">과목</span></th>
                        <td>
                        	<div class="sa-ui-inline-form">
                                <!-- Select Box -->
                                <div class="sa-select-box sa-select-type sa-w146">
                                    <span class="sa-data-option">{{LAN}}</span>
                                    <em class="sa-icon-select"></em>
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <!-- //Select Box -->
                                <button class="sa-btn">수정</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="sa-th-title">보유한 코인</span></th>
                        <td><span class="sa-data-store"> 32</span></td>
                    </tr>
                    <tr>
                        <th><span class="sa-th-title">과목상세</span></th>
                        <td>
                        	<div class="sa-ui-checkbox-wrap">
                            	<ul class="sa-list-check">
                                	<li><label><input type="checkbox" checked="checked"/>회화</label></li>
                                	<li><label><input type="checkbox" checked="checked"/>독해</label></li>
                                	<li><label><input type="checkbox" />문법</label></li>
                                	<li><label><input type="checkbox" />단어</label></li>
                                	<li><label><input type="checkbox" />단어</label></li>
                                </ul>
                                <button class="sa-btn">수정</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="sa-th-title">경력</span></th>
                        <td>
                        	<div class="sa-ui-inline-form">
                                <!-- Select Box -->
                                <div class="sa-select-box sa-select-type sa-w146">
                                    <span class="sa-data-option">3년 이상</span>
                                    <em class="sa-icon-select"></em>
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <!-- //Select Box -->
                                <button class="sa-btn">수정</button>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="sa-th-title">학력</span></th>
                        <td>
                        	<div class="sa-ui-inline-form">
                                <!-- Select Box -->
                                <div class="sa-select-box sa-select-type sa-w146">
                                    <span class="sa-data-option">4년제 졸업</span>
                                    <em class="sa-icon-select"></em>
                                    <select>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>
                                </div>
                                <!-- //Select Box -->
                                <button class="sa-btn">수정</button>
                            </div>
                        </td>
                    </tr>
                </thead>
            </table>
        </div>
        <!-- //프로필 수정 -->
        
         <!-- My lesson 정보 수정 -->
        <div class="sa-ui-modify">
        	<div class="sa-ui-table-title">
            	My lesson <span class="sa-text">정보</span>
                <button class="sa-btn">수정</button>
            </div>
        	<table class="sa-table-form">
            	<colgroup>
                	<col width="134px" />
                	<col width="*" />
                </colgroup>
                <tbody>
                	<tr>
                        <th><span class="sa-th-title">레슨가능일</span></th>
                        <td>
                        	<div class="sa-ui-day">
                                <div class="sa-ui-inline-form">
                                    <!-- Select Box -->
                                    <div class="sa-select-box sa-select-type sa-w95">
                                        <span class="sa-data-option">주 1회</span>
                                        <em class="sa-icon-select"></em>
                                        <select>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </select>
                                    </div>
                                    <!-- //Select Box -->
                                </div>
                                <div class="sa-ui-checkbox-wrap">
                                    <ul class="sa-list-check">
                                        <li><label><input type="checkbox" checked="checked"/>월</label></li>
                                        <li><label><input type="checkbox" />화</label></li>
                                        <li><label><input type="checkbox" checked="checked"/>수</label></li>
                                        <li><label><input type="checkbox" />목</label></li>
                                    </ul>
                                    <ul class="sa-list-check">
                                        <li><label><input type="checkbox" checked="checked" />금</label></li>
                                        <li><label><input type="checkbox" />토</label></li>
                                        <li><label><input type="checkbox" />일</label></li>
                                    </ul>
                                    
                                </div>
                             </div>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="sa-th-title">레슨시간</span></th>
                        <td>
                        	<div class="sa-ui-time-form">
                                <div class="sa-ui-checkbox-wrap">
                                    <ul class="sa-list-check">
                                        <li><label><input type="checkbox" checked="checked"/>오전</label></li>
                                        <li><label><input type="checkbox" />오후</label></li>
                                    </ul>
                                </div>
                                <div class="sa-ui-inline-form">
                                     <!-- Select Box -->
                                    <div class="sa-select-box sa-select-type">
                                        <span class="sa-data-option">9:00</span>
                                        <em class="sa-icon-select"></em>
                                        <select>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </select>
                                    </div>
                                    <!-- //Select Box -->
                                    <span class="sa-text">부터</span>
                                    
                                    <!-- Select Box -->
                                    <div class="sa-select-box sa-select-type">
                                        <span class="sa-data-option">9:00</span>
                                        <em class="sa-icon-select"></em>
                                        <select>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </select>
                                    </div>
                                    <!-- //Select Box -->
                                    <span class="sa-text">까지</span>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="sa-th-title">생년월일</span></th>
                        <td>
                        	<div class="sa-ui-input-wrap">
                                <input type="text" placeholder="컬럼비아 대학원  재학" class="sa-input-text2 sa-w176" />
                                <input type="text" placeholder="컬럼비아 대학원  재학" class="sa-input-text2 sa-w176" />
                                <input type="text" placeholder="컬럼비아 대학원  재학" class="sa-input-text2 sa-w176" />
                                <input type="text" placeholder="컬럼비아 대학원  재학" class="sa-input-text2 sa-w176" />
                            </div>
                        </td>
                    </tr>
                </thead>
            </table>
        </div>
        <!-- //My lesson 정보 수정 -->
       
    </div>
	<!-- //contents -->
	
	<%-- 공통 Footer --%>
	<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
	<%-- //공통 Footer --%>

</body>
</html>