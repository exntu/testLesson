<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 스크립트 --%>
<script src="${_resource}/js/common/header.js"></script>
<%-- //스크립트 --%>

<div ng-controller="HeaderController">
	<%-- 메뉴 --%>
	<div class="row">
		<div class="col-xs-12">
			<ul style="list-style-type: none; margin: 0; padding: 0;">
				<li style="display: inline;"><a href="${_ctx}/card/today">* Date Site</a></li>
				<li style="display: inline;"><a href="${_ctx}/card/today">* Today Card</a></li>
				<li style="display: inline;"><a href="${_ctx}/card/all">* All of Card</a></li>
				<li style="display: inline;"><a href="${_ctx}/profile">* Profile</a></li>
			</ul>
		</div>
	</div>
	<hr/>
	
	<div class="row">
		<div class="col-xs-12">
