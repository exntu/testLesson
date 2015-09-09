package com.skt.date.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skt.date.common.Session;
import com.skt.date.service.AllCardService;
import com.skt.date.service.CardService;
import com.skt.date.service.PeopleService;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;

@Controller
public class AllCardController extends AbstractBaseController{
	
	@Autowired
	private AllCardService allcardservice;
	
	private Logger logger = LoggerFactory.getLogger( AllCardController.class );	

	
	/**
	 * view화면
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.ALL_CARD}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView View(
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		// JSP포워드
		model.setViewName(Path.ALL_CARD_JSP);

		return model;
	}
	
	
	/**
	 * 데이터 로드, 디테일 화면 param2로 사진, 추가정보 조회
	 * @param param2
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.ALL_CARD_SERVICE}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView allCardView(
			HttpServletRequest request,
			HttpServletResponse response, @RequestBody String param2) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		
		//현재 사용자 id조회
		UserVo param = this.getLoginInfo(request);

		
		//유저 데이터 조회
		List<UserVo> repp=allcardservice.selectAllCard(param);
		//이미지 데이터 조회
		List<UploadVo> repp_img=allcardservice.selectAllCardImg(param2);
		//추가 정보 조회
		List<ProfileVo> repp_add=allcardservice.selectAllCardAdd(param2);
		
		model.addObject("repp",repp);
		model.addObject("repp_img",repp_img);
		model.addObject("repp_add",repp_add);
		
		// JSP포워드
		model.setViewName(Path.JSON);
		
		
		return model;
	}
}
