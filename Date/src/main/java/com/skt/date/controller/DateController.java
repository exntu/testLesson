package com.skt.date.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skt.date.service.CardService;
import com.skt.date.service.DateService;
import com.skt.date.service.FriendService;
import com.skt.date.service.ProfileService;
import com.skt.date.service.QuestionService;
import com.skt.date.service.UserService;
import com.skt.date.vo.CardVo;
import com.skt.date.vo.FriendVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.QuestionVo;
import com.skt.date.vo.UserVo;

@Controller
public class DateController {

	private Logger logger = LoggerFactory.getLogger( DateController.class );	

	@Autowired
	private DateService dateservice;

	@Autowired
	private CardService cardservice;
	@Autowired
	private FriendService friendservice;
	
	@Autowired
	private ProfileService profileservice;
	
	@Autowired
	private QuestionService questionservice;
	
	@Autowired
	private UserService userservice;
	
	
	@RequestMapping(value={"/sample"}, method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		logger.debug("sample view");
		
		ModelAndView model=new ModelAndView();
		String repp=dateservice.Sample();
		model.addObject("repp",repp);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value={"/main"}, method={RequestMethod.GET,RequestMethod.POST}) //메인화면
	public ModelAndView Main(HttpServletRequest request,HttpServletResponse response){
		
		CardVo vo=new CardVo();
		vo.setSex('m'); //성별이 남자에 해당하는 값
		ModelAndView model=new ModelAndView();

		List<CardVo> repp=cardservice.selectTodayCard(vo); //오늘의 카드 조회
		
		model.addObject("repp",repp);
		model.setViewName("Main");
		return model;	
	}
	
	@RequestMapping(value={"/faq"}, method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView FAQ(HttpServletRequest request,HttpServletResponse response){
		
		QuestionVo vo=new QuestionVo();
		vo.setNum(1); //1번글에 해당하는 FAQ조회
		ModelAndView model=new ModelAndView();

		List<QuestionVo> repp=questionservice.selectFAQ(vo); //FAQ조회
		
		model.addObject("repp",repp);
		model.setViewName("FAQ");
		return model;	
		
		
	}

	@RequestMapping(value={"/allcard"}, method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView AllCard(HttpServletRequest request,HttpServletResponse response){
		CardVo vo=new CardVo();
		vo.setName("나남자");
		ModelAndView model=new ModelAndView();

		List<CardVo> repp=cardservice.selectAllCard(); //모든카드 조회
		model.addObject("repp",repp);
		model.setViewName("AllCard");
		return model;	
		
		
	}
	
	@RequestMapping(value={"/todaycard"}, method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView TodayCard(HttpServletRequest request,HttpServletResponse response){
		CardVo vo=new CardVo();
		vo.setSex('m');
		ModelAndView model=new ModelAndView();

		List<CardVo> repp=cardservice.selectTodayCard(vo); //오늘의 카드 조회
		
		model.addObject("repp",repp);
		model.setViewName("TodayCard");
		return model;
		
		
	}

	@RequestMapping(value={"/friend"}, method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView Friend(HttpServletRequest request,HttpServletResponse response){
		ModelAndView model=new ModelAndView();

		List<FriendVo> repp=friendservice.selectFriend(); //친구조회
		
		model.addObject("repp",repp);
		model.setViewName("Friend");
		return model;
		
		
	}

	@RequestMapping(value={"/profile"}, method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView Profile(HttpServletRequest request,HttpServletResponse response){
		ProfileVo vo=new ProfileVo();
		ModelAndView model=new ModelAndView();

		List<ProfileVo> repp=profileservice.selectProfile(); //프로필 조회
		
		model.addObject("repp",repp);
		model.setViewName("Profile");
		return model;
		
		
	}
	
	@RequestMapping(value={"/user"}, method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView User(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView model=new ModelAndView();

		UserVo vo=new UserVo();
		UserVo repp=userservice.Join(vo); //유저 조회
		
		model.addObject("repp",repp);
		model.setViewName("User");
		return model;
		
		
	}
	
	
}
