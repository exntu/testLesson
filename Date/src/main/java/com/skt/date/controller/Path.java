package com.skt.date.controller;

public class Path {

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Common
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	
	// 루트
	public static final String ROOT			= "/";
	
	// 서비스 루트
	public static final String SERVICE		= "/service";
	
	// JSON으로 리턴할때의 viewName값
	public static final String JSON			= "jsonView";
	
	// 리다이렉트 Prefix
	public static final String REDIRECT		= "redirect:";
	
	// 반환코드 KEY
	public static final String CODE			= "code";
	
	// 반환데이터 KEY
	public static final String DATA			= "data";
	
	// 반환메시지 KEY
	public static final String MESSAGE		= "message";

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| 로그인
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	public static final String LOGIN						= "/login";
	public static final String LOGIN_SERVICE				= SERVICE + "/login";
	public static final String LOGIN_JSP					= "/user/login";
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| 가입신청
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	public static final String JOIN							= "/join";
	public static final String JOIN_SERVICE					= SERVICE + "/join";
	public static final String JOIN_JSP						= "/user/join";

}
