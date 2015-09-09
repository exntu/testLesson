package com.skt.date.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.skt.date.common.Session;
import com.skt.date.service.UserService;
import com.skt.date.vo.UserVo;

@Controller
public class UserController extends AbstractBaseController{
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	
	private Logger logger = LoggerFactory.getLogger( UserController.class );	
	
	@Inject
	private UserService userService;

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
	 * 로그인 페이지
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.LOGIN}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView loginView(
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
		model.setViewName(Path.LOGIN_JSP);
		
		// 데이터
		model.addObject("_forwardUrl", forwardUrl);
		model.addObject("_forwardMethod", forwardMethod);
		model.addObject("_forwardParam", forwardParam);
		
		return model;
	}
	
	
	/**
	 * 로그인 처리 서비스
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.LOGIN_SERVICE}, method={RequestMethod.POST} )
	public ModelAndView loginService(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody UserVo param ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// 반환 세팅
		//
		//////////////////////////////////////////////////
		
		// 반환값
		String result = "FAIL";
		
		//////////////////////////////////////////////////
		//
		// ID/PW 조회
		//
		//////////////////////////////////////////////////
		
		// 사용자정보 조회
		UserVo userVO = userService.selectLoginUser(param);
		
		// ID/PW에 해당하는 유저가 있을경우
		if( userVO != null ){
			
			// 로그인정보 세션에 담음
			HttpSession session = request.getSession();
			session.setAttribute(Session.LOGIN_KEY, userVO);
			
			// 로그인 성공
			result = "SUCCESS";
		}
		// ID/PW에 해당하는 유저가 없을경우
		else{
			
			// ID/PW 오류코드
			result = "INVALID";
		}
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model	= new ModelAndView();
		
		// JSON
		model.setViewName(Path.JSON);
		
		// 반환코드
		model.addObject(Path.CODE, result);
		
		// 반환메시지
		model.addObject(Path.MESSAGE, "");
		
		return model;
	}
	
	
	/**
	 * 회원가입 페이지
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.JOIN}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView joinView(
			HttpServletRequest request,
			HttpServletResponse response ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		
		// JSP포워드
		model.setViewName(Path.JOIN_JSP);
		
		return model;
	}
	
	
	/**
	 * 회언가입 처리 서비스
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.JOIN_SERVICE}, method={RequestMethod.POST} )
	public ModelAndView joinService(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody UserVo param ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// 반환 세팅
		//
		//////////////////////////////////////////////////
		
		// 반환값
		String result = "FAIL";
		
		//////////////////////////////////////////////////
		//
		// ID/PW 조회
		//
		//////////////////////////////////////////////////
		
		// (Email) 사용자정보 조회
		UserVo userVO = userService.selectUser(param);
		
		// (Nickname) 사용자정보 조회
		UserVo userVO2 = userService.selectUserByNickname(param);
		
		// ID에 해당하는 유저가 있을경우
		if( userVO != null ){
			
			// 이미 가입된 유저임
			result = "ALREADY";
		}
		else if( userVO2 != null ){
			
			// 이미 존재하는 닉네임임
			result = "ALREADY2";
		}
		// ID/PW에 해당하는 유저가 없을경우
		else{
			
			// 작성자저보 담음
			param.setCreatedUserId(param.getEmail());
			param.setUpdatedUserId(param.getEmail());
			
			// 회원가입
			userService.insertUser(param);
			
			// 사용자정보 재조회
			userVO = userService.selectUser(param);
			
			// 로그인정보 세션에 담음
			HttpSession session = request.getSession();
			session.setAttribute(Session.LOGIN_KEY, userVO);
			
			// 가입 성공
			result = "SUCCESS";
		}
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model	= new ModelAndView();
		
		// JSON
		model.setViewName(Path.JSON);
		
		// 반환코드
		model.addObject(Path.CODE, result);
		
		// 반환메시지
		model.addObject(Path.MESSAGE, "");
		
		return model;
	}
	
	
	/**
	 * 회언가입 이메일 중복체크 서비스
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.JOIN_EMAIL_SERVICE}, method={RequestMethod.POST} )
	public ModelAndView joinEmailCheckService(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody UserVo param ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// 반환 세팅
		//
		//////////////////////////////////////////////////
		
		// 반환값
		String result = "SUCCESS";
		
		//////////////////////////////////////////////////
		//
		// 중복 조회
		//
		//////////////////////////////////////////////////
		
		// (Email) 사용자정보 조회
		UserVo userVO = userService.selectUser(param);
		
		// ID에 해당하는 유저가 있을경우
		if( userVO != null ){
			
			// 이미 가입된 유저임
			result = "ALREADY";
		}
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model	= new ModelAndView();
		
		// JSON
		model.setViewName(Path.JSON);
		
		// 반환코드
		model.addObject(Path.CODE, result);
		
		// 반환메시지
		model.addObject(Path.MESSAGE, "");
		
		return model;
	}
	
	
	/**
	 * 회언가입 닉네임 중복체크 서비스
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.JOIN_NICKNAME_SERVICE}, method={RequestMethod.POST} )
	public ModelAndView joinNicknameCheckService(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody UserVo param ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// 반환 세팅
		//
		//////////////////////////////////////////////////
		
		// 반환값
		String result = "SUCCESS";
		
		//////////////////////////////////////////////////
		//
		// 중복 조회
		//
		//////////////////////////////////////////////////
		
		// (Nickname) 사용자정보 조회
		UserVo userVO = userService.selectUserByNickname(param);
		
		 if( userVO != null ){
			
			// 이미 존재하는 닉네임임
			result = "ALREADY2";
		}
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model	= new ModelAndView();
		
		// JSON
		model.setViewName(Path.JSON);
		
		// 반환코드
		model.addObject(Path.CODE, result);
		
		// 반환메시지
		model.addObject(Path.MESSAGE, "");
		
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
