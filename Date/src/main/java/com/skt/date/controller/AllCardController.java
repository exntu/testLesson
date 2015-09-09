package com.skt.date.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skt.date.common.Session;
import com.skt.date.service.AllCardService;
import com.skt.date.service.CardService;
import com.skt.date.service.PeopleService;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.UserVo;

@Controller
public class AllCardController {
	
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
	 * All of 카드 페이지, ajax사용
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.ALL_CARD_SERVICE}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView allCardView(
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
		List<UserVo> repp=allcardservice.selectAllCard(param);
		model.addObject("repp",repp);
		
		// JSP포워드
		model.setViewName(Path.JSON);
		
		
		return model;
	}
}
