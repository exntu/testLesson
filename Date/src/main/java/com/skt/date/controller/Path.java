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
	| 메인
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	public static final String MAIN							= ROOT;
	public static final String MAIN_SERVICE					= SERVICE + "/main";
	public static final String MAIN_JSP						= "/main/main";

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
	public static final String JOIN_EMAIL_SERVICE			= SERVICE + "/join/email";
	public static final String JOIN_NICKNAME_SERVICE		= SERVICE + "/join/nickname";
	public static final String JOIN_JSP						= "/user/join";
	
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| 오늘의 카드
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	public static final String TODAY_CARD					= "/card/today";
	public static final String TODAY_CARD_SERVICE	= SERVICE + "/card/today";
	public static final String TODAY_CARD_JSP			= "/card/today";
	//사람 랜덤으로 생성
	public static final String PEOPLE_SERVICE				=	SERVICE + "/card/today";
	public static final String PEOPLE_JSP					=	"/card/today";
	//카드 상세보기
	public static final String TODAY_CARD_DETAIL			=	"/card/today/detail";
	public static final String TODAY_CARD_DETAIL_SERVICE	=	SERVICE + "/card/today/detail";
	public static final String TODAY_CARD_DETAIL_JSP	=	"/card/today/detail";
	//test : rate 보내기
	public static final String TODAY_CARD_DETAIL_RATING = "/card/today/rating";
	public static final String TODAY_CARD_DETAIL_RATING_SERVICE = SERVICE + "/card/today/rating";
	
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| All of 카드
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	public static final String ALL_CARD						= "/card/all";
	public static final String ALL_CARD_SERVICE				= SERVICE + "/card/all";
	public static final String ALL_CARD_JSP					= "/card/all";
	
	public static final String ALL_CARD_PROFILE				= "/card/all/profile";
	public static final String ALL_CARD_PROFILE_SERVICE		= SERVICE + "/card/all/profile";
	public static final String ALL_CARD_PROFILE_JSP			= "/card/all/profile";
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| 프로필
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	public static final String PROFILE						= "/profile";
	public static final String PROFILE_SERVICE				= SERVICE + "/profile";
	public static final String PROFILE_JSP					= "/profile/profile";
	public static final String PROFILE_UPLOAD_SERVICE		= SERVICE +"/profile/upload";
	public static final String PROFILE_UPDATE_SERVICE		= SERVICE +"/profile/update";
	//레슨 리스트
	public static final String PROFILE_LESSON				= "/profile/list/lesson";
	public static final String PROFILE_LESSON_SERVICE		= SERVICE +"/profile/list/lesson";
	public static final String PROFILE_LESSON_JSP			= "/profile/list/lesson";
	//메세지 리스트
	public static final String PROFILE_MESSAGE				= "/profile/list/message";
	public static final String PROFILE_MESSAGE_SERVICE		= SERVICE +"/profile/list/message";
	public static final String PROFILE_MESSAGE_JSP			= "/profile/list/message";
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| 관심표현 보내기
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	public static final String SEND_MEET					= "/meet";
	public static final String SEND_MEET_SERVICE			= SERVICE + "/meet";
	public static final String SEND_MEET_SERVICE_INSERT		= SERVICE + "/meet/insert";
	public static final String SEND_MEET_JSP				= "/send/meet";
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| 대화하기
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	public static final String SEND_MESSAGE					= "/message";
	public static final String SEND_MESSAGE_SERVICE			= SERVICE + "/message";
	public static final String SEND_MESSAGE_JSP				= "/send/message";

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Stroe
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	public static final String STORE						= "/store";
	public static final String STORE_SERVICE				= SERVICE + "/store";
	public static final String STORE_JSP					= "/store/store";
}