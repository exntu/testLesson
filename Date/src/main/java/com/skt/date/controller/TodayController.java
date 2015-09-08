package com.skt.date.controller;

import java.sql.Date;
import java.util.ArrayList;
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

import com.skt.date.service.TodayService;
import com.skt.date.vo.MatchingVo;
import com.skt.date.vo.UserVo;


@Controller
public class TodayController extends AbstractBaseController {
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	@Autowired
	private TodayService todayService;

	private Logger logger = LoggerFactory.getLogger( TodayController.class );	

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
	 * 오늘의 카드(메인) 페이지
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.TODAY_CARD}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView todayCardView(
			HttpServletRequest request,
			HttpServletResponse response ) throws Exception {
		
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		
//		//JSON
//		model.addObject("currentTime", currentTime);
		// JSP포워드
		model.setViewName(Path.TODAY_CARD_JSP);
		
		return model;
	}
	
	/**
	 * 카드 상세 페이지
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.TODAY_CARD_DETAIL}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView todayCardViewDetail(
			HttpServletRequest request,
			HttpServletResponse response ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		
		// JSP포워드
		model.setViewName(Path.TODAY_CARD_DETAIL_JSP);
		
		return model;
	}
	
	/**
	 * 사람 가져오기
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.TODAY_CARD_DETAIL_SERVICE}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView todayCardViewDetailService(
			HttpServletRequest request,
			HttpServletResponse response ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		//JSON
		model.setViewName(Path.JSON);
		
		return model;
	}
	
	/**
	 * 랜덤 카드 선택
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.TODAY_CARD_SERVICE}, method={RequestMethod.GET} )
	public ModelAndView todayCardViewSelect(
			HttpServletRequest request,
			HttpServletResponse response ) throws Exception {
		
		String currentTime = todayService.currentTime();

		//로그인 정보 가져오기
		UserVo userInfo = this.getLoginInfo(request);
		
		//matchingVo 셋팅
		MatchingVo matchingVo = new MatchingVo();
		matchingVo.setEmail(userInfo.getEmail());
		matchingVo.setGender(userInfo.getGender());
		matchingVo.setNickname(userInfo.getNickname());
		
		//이메일로 정보 추출
		List<MatchingVo> matchingCard = todayService.selectTwoCard(matchingVo);
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		ModelAndView model = new ModelAndView();
		
		//JSON
		model.setViewName(Path.JSON);
		model.addObject("matchingTwoCard", matchingCard);
		model.addObject("currentTime", currentTime);
		
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
