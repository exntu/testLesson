<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 스크립트 --%>
<script src="${_resource}/js/common/header.js"></script>
<%-- //스크립트 --%>

<!-- loading bar -->
<div id="_loading" class="page-loading-overlay" style="display:none;">
    <div class="loader-2"></div>
</div>
<!-- //loading bar -->
<div class="sa-layout-wrap" ng-controller="HeaderController">
	<!-- header -->
	<div class="sa-layout-header">
    	<div class="sa-ui-header">
             <!-- 로고 -->
             <h1 class="sa-h1-logo">
                <img src="${_resource}/images/logo_top.png" alt="Lesson Master" />
            </h1>
            <!-- //로고 -->
            
            <div class="sa-ui-header-menu">
                 <ul class="sa-list-top-menu">
                    <li><a href="${_ctx}/">Log out</a></li>
                    <li><a href="javascript:">FAQ</a></li>
                    <li><a href="javascript:">About</a></li>
                </ul>
            </div>
           <div class="sa-ui-header-menu">
                <ul id="_menu" class="sa-list-menu">
                    <li><a href="${_ctx}/card/today">TODAY'S CARD</a></li>
                    <li><a href="${_ctx}/card/all">All CARD</a></li>
                    <li><a href="${_ctx}/profile">My PROFILE</a></li>
                    <li><a href="${_ctx}/store">Store</a></li>
                </ul>
            </div>
        </div>
    </div>
	<!-- //header -->