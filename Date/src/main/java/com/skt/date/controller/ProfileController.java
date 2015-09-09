package com.skt.date.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skt.date.common.Session;
import com.skt.date.service.ProfileService;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;


@Controller
public class ProfileController extends AbstractBaseController {
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	@Autowired
	private ProfileService profileservice;
	
	private Logger logger = LoggerFactory.getLogger( ProfileController.class );	

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
	 * 프로필 화면
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.PROFILE}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView profile(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute UploadVo vo ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////

		ModelAndView model = new ModelAndView();
		
		//JSP포워드
		model.setViewName(Path.PROFILE_JSP);
		
		return model;
	}
	
	/**
	 * 프로필 업로드 처리화면
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.PROFILE_SERVICE}, method={RequestMethod.POST} )
	public ModelAndView profileUpload(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		ModelAndView model = new ModelAndView();


		UserVo user=(UserVo)request.getSession().getAttribute(Session.LOGIN_KEY);
		String param=user.getEmail();
		
		UserVo repp=profileservice.selectProfile(param);
		List<UploadVo> repp_img=profileservice.selectImg(param);
		List<ProfileVo> repp_add=profileservice.selectAdd(param);
		
		model.addObject("repp",repp);
		model.addObject("repp_img",repp_img);
		model.addObject("repp_add",repp_add);
		
		model.addObject(Path.CODE, "SUCCESS" );
		model.setViewName(Path.JSON);
		
		return model;
	}
	
	/**
	 * 프로필 수정 서비스 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.PROFILE_UPDATE_SERVICE}, method={RequestMethod.POST} )
	public ModelAndView profileUpdate(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam ProfileVo vo) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		ModelAndView model = new ModelAndView();


	
		model.addObject(Path.CODE, "SUCCESS" );
		model.setViewName(Path.JSON);
		
		return model;
	}
	/**
	 * 프로필 업로드 처리화면
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.PROFILE_UPLOAD_SERVICE}, method={RequestMethod.POST} )
	public ModelAndView profileUpload(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("profile") UploadVo vo) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		ModelAndView model = new ModelAndView();

		profileservice.uploadProfile(vo);
		model.addObject("profile",vo.getFilestream());
		model.addObject(Path.CODE, "SUCCESS" );
		model.setViewName(Path.JSON);
		
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
