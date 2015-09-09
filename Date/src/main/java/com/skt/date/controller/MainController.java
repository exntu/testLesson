package com.skt.date.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.skt.date.common.Session;


@Controller
public class MainController extends AbstractBaseController {
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	
	private Logger logger = LoggerFactory.getLogger( MainController.class );	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Protected Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Public Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Constructor
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Getter & Setter Method ( DI Method )
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Public Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	
	/**
	 * 메인 페이지
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.MAIN}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView profileCardView(
			HttpServletRequest request,
			HttpServletResponse response ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// 이전에 가려고 했던 URL정보
		//
		//////////////////////////////////////////////////
		
		String forwardUrl = "";
		String forwardMethod = "";
		String forwardParam = "";
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap != null) {

			forwardUrl = (String) flashMap.get("_forwardUrl");
			forwardMethod = (String) flashMap.get("_forwardMethod");
			forwardParam = (String) flashMap.get("_forwardParam");
		}
		
		//////////////////////////////////////////////////
		//
		// 세션에 기본정보 삭제
		//
		//////////////////////////////////////////////////
		
		HttpSession session = request.getSession();
		session.setAttribute(Session.LOGIN_KEY, null);
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		
		// JSP포워드
		model.setViewName(Path.MAIN_JSP);
		
		// 데이터
		model.addObject("_forwardUrl", forwardUrl);
		model.addObject("_forwardMethod", forwardMethod);
		model.addObject("_forwardParam", forwardParam);
		
		return model;
	}

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Implement Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Override Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Protected Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	
}
