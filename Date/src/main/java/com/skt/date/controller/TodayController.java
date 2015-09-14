/**
 * Today Controller
 * 
 * choong
 */

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
import com.skt.date.vo.MatchingAllVo;
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
		
		//서버시간 보내기
		String currentTime = todayService.currentTime();
		
		//로그인 정보 가져오기
		UserVo userInfo = this.getLoginInfo(request);
		//로그인 사람 정보 MatchingVO에 맞게 설정
		MatchingVo matchingVo = new MatchingVo();
		matchingVo.setEmail(userInfo.getEmail());
		matchingVo.setGender(userInfo.getGender());
		matchingVo.setNickname(userInfo.getNickname());
		
		//매칭 카드 확인, 없으면 insert 2장 카드
		List<FromToVo> matchingPickToday = todayService.matchingPickToday( matchingVo );
		
		//매칭 2장의 카드에 대해서도 조회 <1번, 2번>
		List<FromToVo>selectFirstCardAlready = todayService.selectTwoCardAlready(matchingPickToday.get(0).getTo());
		List<FromToVo>selectSecondCardAlready = todayService.selectTwoCardAlready(matchingPickToday.get(1).getTo());
		
		Boolean firstCardShade = "Y".equals(selectFirstCardAlready.get(0).getSelectYN());
		Boolean secondCardShade = "Y".equals(selectSecondCardAlready.get(0).getSelectYN());
		
		//7일간의 History 카드 (최근 순서)
		List<FromToVo> matchingHistory = todayService.matchingHistoryEmail( userInfo.getEmail() );
		
		//1번
		FromToVo temp = new FromToVo();
		
		List<MatchingAllVo>matchingHistoryEmailFirst = new ArrayList<MatchingAllVo>();
		temp.setFrom( userInfo.getEmail() );
		temp.setTo( matchingHistory.get(0).getTo() );
		matchingHistoryEmailFirst.addAll( todayService.matchingHistoryCard( temp ) );
		
		List<MatchingAllVo>matchingHistoryEmailSecond= new ArrayList<MatchingAllVo>();
		temp.setFrom( userInfo.getEmail() );
		temp.setTo( matchingHistory.get(1).getTo() );
		matchingHistoryEmailSecond.addAll( todayService.matchingHistoryCard( temp ) );
		
		List<MatchingAllVo>matchingHistoryEmailThird= new ArrayList<MatchingAllVo>();
		temp.setFrom( userInfo.getEmail() );
		temp.setTo( matchingHistory.get(2).getTo() );
		matchingHistoryEmailThird.addAll( todayService.matchingHistoryCard( temp ) );
		
		List<MatchingAllVo>matchingHistoryEmailForth= new ArrayList<MatchingAllVo>();
		temp.setFrom( userInfo.getEmail() );
		temp.setTo( matchingHistory.get(3).getTo() );
		matchingHistoryEmailForth.addAll( todayService.matchingHistoryCard( temp ) );
		
		
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		ModelAndView model = new ModelAndView();
		
		//JSON
		model.setViewName(Path.JSON);
		//서버 시간 보내기
		model.addObject("currentTime", currentTime);
		//2장의 카드 조회 <1번, 2번>
		model.addObject("selectFirstCardAlready", selectFirstCardAlready );
		model.addObject("selectSecondCardAlready", selectSecondCardAlready );
		//카드 shade
		model.addObject( "firstCardShade",firstCardShade );
		model.addObject( "secondCardShade",secondCardShade );
		//카드 history 상세정보
		model.addObject( "matchingHistoryEmailFirst", matchingHistoryEmailFirst );
		model.addObject( "matchingHistoryEmailSecond", matchingHistoryEmailSecond );
		model.addObject( "matchingHistoryEmailThird", matchingHistoryEmailThird );
		model.addObject( "matchingHistoryEmailForth", matchingHistoryEmailForth );
		
		
		
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
		List<MatchingAllVo> matchingDetailCard = todayDetailService.matchingDetailCard(email);
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
		feelingVo.setTo(feelingVo.getTo());

		if( todayRatingService.matchingRate(feelingVo) == null ){
			todayRatingService.insertMatchingRate(feelingVo);
		}else{
			todayRatingService.updateMatchingRate(feelingVo);
		}
		
		
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
	 * matching vote한거 설정
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.TODAY_CARD_VOTING_SERVICE}, method={RequestMethod.POST} )
	public ModelAndView todayCardViewVoting(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody FromToVo fromToVo ) throws Exception {
		
		//로그인 가져오기
		UserVo userVo = this.getLoginInfo(request);
		
		//matching에 값 넣기
		fromToVo.setFrom( userVo.getEmail() );
		fromToVo.setTo( fromToVo.getTo() );
		
		//Select에 대해 정보 가져오기
		List<FromToVo>selectYN= todayService.matchingSelectYN( fromToVo );
		
		//update selectYN "Y"
		for( int num=0; num<selectYN.size(); num++ ){
			if( selectYN.get(num).getSelectYN().equals("N")){
				//select Y 로 update
				fromToVo.setSelectYN("Y");
				todayService.updateMatchingCard(fromToVo);
			}
		}
		
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
