package com.skt.date.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.skt.date.controller.Path;
import com.skt.date.vo.UserVo;

public class DateInterceptor extends HandlerInterceptorAdapter {
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Protected Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Public Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	
	Logger logger = LoggerFactory.getLogger(DateInterceptor.class);

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Constructor
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Getter & Setter Method ( DI Method )
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Public Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Implement Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	
	/**
	 * Request Mapping 전 호출
	 * => 상속 클래스에서 재정의 할 것
	 */
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// 세션에 로그인 정보가 있는지 체크
		//
		//////////////////////////////////////////////////
		
		HttpSession session = request.getSession();
		UserVo userVO = (UserVo) session.getAttribute(Session.LOGIN_KEY);
		
		// 로그인이 되어있지 않다면
		// => 차후에는 SSO에서 로그인정보 추출코드를 넣어야함
		if( userVO == null ){
			
			// 원래 가려고했던 URL 담음
			addRedirectAttr(request.getServletPath(), request, response);
			
			// 로그인 페이지로 리다이렉트
			response.sendRedirect(request.getContextPath() + Path.MAIN);
			
			// 중단!
			return false;
		}
		
		
		// 통과!
		return true;
	}
	
	/**
	 * Request Mapping 후 호출
	 * => 상속 클래스에서 재정의 할 것
	 */
	@Override
	public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// 로그인정보를 담는다.
		//
		//////////////////////////////////////////////////
		
		// 로그인정보를 가져온다.
		HttpSession session = request.getSession();
		UserVo userVO = (UserVo) session.getAttribute(Session.LOGIN_KEY);
		
		// 로그인정보를 모델에 담는다.
		modelAndView.addObject("_loginInfo", userVO);
		
	}
	
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Override Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Protected Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	
	
	/**
	 * 로그인 리다이렉트용
	 * 리다이렉트시에는 POST로 넘길수가 없기 때문에 플래시(소멸성)방식의 어트리뷰트를 생성한다.
	 * @param request
	 * @param response
	 */
	private void addRedirectAttr(String uri, HttpServletRequest request, HttpServletResponse response){
		
		// create a flashmap
		FlashMap flashMap = new FlashMap();

		// store the message
		flashMap.put("_forwardUrl", uri);
		flashMap.put("_forwardMethod", request.getMethod());
		flashMap.put("_forwardParam", request.getQueryString());

		// create a flashmapMapManger with `request`
		FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);

		// save the flash map data in session with falshMapManager
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
	}
	
}
