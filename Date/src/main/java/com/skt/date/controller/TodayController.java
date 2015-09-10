package com.skt.date.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skt.date.service.TodayDetailService;
import com.skt.date.service.TodayRatingService;
import com.skt.date.service.TodayService;
import com.skt.date.vo.FeelingVo;
import com.skt.date.vo.FromToVo;
import com.skt.date.vo.MatchingVo;
import com.skt.date.vo.UserVo;


@Controller
public class TodayController extends AbstractBaseController {
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	//today 페이지 서비스
	@Autowired
	private TodayService todayService;
	//detail 페이지 서비스
	@Autowired
	private TodayDetailService todayDetailService;
	//별점 주기
	@Autowired
	private TodayRatingService todayRatingService;

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
		
		// JSP포워드
		model.setViewName(Path.TODAY_CARD_JSP);
		
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
		
		//결과값
		List<MatchingVo> result;	
		//오늘 카드 확인
		if( todayService.matchingPickToday().isEmpty() ){
			//이메일로 정보 추출
			List<MatchingVo> matchingCard = todayService.selectTwoCard(matchingVo);
			//insert
			FromToVo fromtoVo = new FromToVo();
			for(int i=0; i<matchingCard.size(); i++){
				fromtoVo.setFrom(userInfo.getEmail());
				fromtoVo.setTo(matchingCard.get(i).getEmail());
				todayService.insertTwoCardSelected(fromtoVo);
			}
			result = matchingCard;
		} else {
			result = todayService.selectTwoCardAlready();
		}
		
		//History 카드 보여주기
		List<FromToVo> matchingHistory = todayService.matchingHistory();
		matchingHistory.get(0).getTo();
		matchingHistory.get(1).getTo();
		
		
		System.out.println(matchingHistory);
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		ModelAndView model = new ModelAndView();
		
		//JSON
		model.setViewName(Path.JSON);
		model.addObject("result", result );
		model.addObject("currentTime", currentTime);
		model.addObject("matchingHistory", matchingHistory);
		
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
			HttpServletResponse response,
			@RequestParam String email ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		
		// JSP포워드
		model.setViewName(Path.TODAY_CARD_DETAIL_JSP);
		//JSON
		model.addObject("email", email);
		return model;
	}
	
	/**
	 * 사람 가져오기
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.TODAY_CARD_DETAIL_SERVICE}, method={RequestMethod.GET} )
	public ModelAndView todayCardViewDetailSelect(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam String email ) throws Exception {

		
		//get으로 email값 가져와서 사용
		MatchingVo matchingDetailCard = todayDetailService.matchingDetailCard(email);
		//feeling에 넣기
		FeelingVo feelingVo = new FeelingVo();
		//로그인 가져오기
		UserVo userInfo = this.getLoginInfo(request);
		feelingVo.setFrom(userInfo.getEmail());
		feelingVo.setTo(email);
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		//JSON
		model.setViewName(Path.JSON);
		//OBJECT
		model.addObject( "matchingDetailCard", matchingDetailCard );
		model.addObject( "feelingVo", feelingVo );
		model.addObject( "test", "test" );
		return model;
	}
	
	/**
	 * rate 설정
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.TODAY_CARD_DETAIL_RATING_SERVICE}, method={RequestMethod.POST} )
	public ModelAndView todayCardViewDetailSelectRate(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody FeelingVo feelingVo ) throws Exception {
		
		//로그인 가져오기
		UserVo userVo = this.getLoginInfo(request);
		
		//feeling에 값 넣기
		feelingVo.setFrom(userVo.getEmail());

		if( todayRatingService.matchingRate(feelingVo) == null ){
			todayRatingService.insertMatchingRate(feelingVo);
		}
			
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		//JSON
		model.setViewName(Path.JSON);
		//OBJECT
		model.addObject( "test", "test" );
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
