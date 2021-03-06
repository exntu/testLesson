//package com.skt.date.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.skt.date.service.CardService;
//import com.skt.date.service.PeopleService;
//import com.skt.date.vo.MatchingVo;
//import com.skt.date.vo.PeopleVo;
//import com.skt.date.vo.UserVo;
//
//
//@Controller
//public class CardController extends AbstractBaseController {
//	
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Private Variables
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
//	@Autowired
//	private CardService cardService;
//	@Autowired
//	private PeopleService peopleService;
//	
//	private Logger logger = LoggerFactory.getLogger( CardController.class );	
//
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Protected Variables
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Public Variables
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
//
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Constructor
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
//
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Getter & Setter Method ( DI Method )
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Public Method
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//	
//	/**
//	 * 오늘의 카드(메인) 페이지
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping( value={Path.TODAY_CARD}, method={RequestMethod.GET,RequestMethod.POST} )
//	public ModelAndView todayCardView(
//			HttpServletRequest request,
//			HttpServletResponse response ) throws Exception {
//		
//		//////////////////////////////////////////////////
//		//
//		// ModelAndView 반환
//		//
//		//////////////////////////////////////////////////
//		
//		ModelAndView model = new ModelAndView();
//		
//		// JSP포워드
//		model.setViewName(Path.TODAY_CARD_JSP);
//		
//		return model;
//	}
//	
//	
//	
//
//	/**
//	 * 사람 가져오기
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping( value={Path.PEOPLE_SERVICE}, method={RequestMethod.GET,RequestMethod.POST} )
//	public ModelAndView people(
//			HttpServletRequest request,
//			HttpServletResponse response ) throws Exception {
//		
//		//////////////////////////////////////////////////
//		//
//		// 사람 정보
//		//
//		//////////////////////////////////////////////////
//		
//		int howmanyPeople = 30;
//		List<PeopleVo> people = peopleService.createPeople(howmanyPeople);
//		
//		//////////////////////////////////////////////////
//		//
//		// ModelAndView 반환
//		//
//		//////////////////////////////////////////////////
//		
//		ModelAndView model = new ModelAndView();
//		
//		model.setViewName(Path.JSON);
//		// 데이터
//		model.addObject("people", people);
//		
//		return model;
//	}
//	
//	/**
//	 * 카드 상세 페이지
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping( value={Path.TODAY_CARD_DETAIL}, method={RequestMethod.GET,RequestMethod.POST} )
//	public ModelAndView todayCardViewDetail(
//			HttpServletRequest request,
//			HttpServletResponse response ) throws Exception {
//		
//		//////////////////////////////////////////////////
//		//
//		// ModelAndView 반환
//		//
//		//////////////////////////////////////////////////
//		
//		ModelAndView model = new ModelAndView();
//		
//		// JSP포워드
//		model.setViewName(Path.TODAY_CARD_DETAIL_JSP);
//		
//		return model;
//	}
//	
//	/**
//	 * 사람 가져오기
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping( value={Path.TODAY_CARD_DETAIL_SERVICE}, method={RequestMethod.GET,RequestMethod.POST} )
//	public ModelAndView todayCardViewDetailService(
//			HttpServletRequest request,
//			HttpServletResponse response ) throws Exception {
//		
//		//////////////////////////////////////////////////
//		//
//		// ModelAndView 반환
//		//
//		//////////////////////////////////////////////////
//		
//		ModelAndView model = new ModelAndView();
//		//JSON
//		model.setViewName(Path.JSON);
//		
//		return model;
//	}
//	
////	/**
////	 * 랜덤 카드 선택
////	 * @param request
////	 * @param response
////	 * @return
////	 * @throws Exception
////	 */
////	@RequestMapping( value={Path.TODAY_CARD_SERVICE}, method={RequestMethod.GET} )
////	public ModelAndView todayCardViewService(
////			HttpServletRequest request,
////			HttpServletResponse response ) throws Exception {
////
//////			ModelMap modelMap,
//////			@ModelAttribute MatchingVo param ) throws Exception {
////		
////		//리턴결과에 자동매핑 파라미터를 제거
//////		modelMap.remove("matchingVo");
////		
////		//로그인 정보 가져오기
////		UserVo userInfo = this.getLoginInfo(request);
////		
////		//matchingVo 셋팅
////		MatchingVo matchingVo = new MatchingVo();
////		matchingVo.setEmail(userInfo.getEmail());
////		matchingVo.setGender(userInfo.getGender());
////		matchingVo.setNickname(userInfo.getNickname());
////		
////		//이메일로 정보 추출
////		List<MatchingVo> matchingCard = cardService.selectTwoCard(matchingVo);
////
////		//list로 전체 다 받기
////		List<MatchingVo>matchingAllCard = new ArrayList<MatchingVo>();
////		matchingAllCard.addAll(matchingCard);
////		
////		//////////////////////////////////////////////////
////		//
////		// ModelAndView 반환
////		//
////		//////////////////////////////////////////////////
////		ModelAndView model = new ModelAndView();
////		
////		//JSON
////		model.setViewName(Path.JSON);
////		model.addObject("matchingAllCard", matchingAllCard);
////		
////		return model;
////	}
//	
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Implement Method
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Override Method
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
//
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Protected Method
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//
//	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//	| Private Method
//	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
//	
//}
