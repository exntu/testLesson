package com.skt.date.controller;

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

import com.skt.date.service.SendService;
import com.skt.date.vo.MeetVo;


@Controller
public class SendController extends AbstractBaseController {
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	@Autowired
	private SendService sendService;
	
	private Logger logger = LoggerFactory.getLogger( SendController.class );	

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
	 * 관심표현 보내기 페이지
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping( value={Path.SEND_MEET}, method={RequestMethod.GET,RequestMethod.POST} )
	public ModelAndView toMeetPage(
			HttpServletRequest request,
			HttpServletResponse response ) throws Exception {
		
		//////////////////////////////////////////////////
		//
		// ModelAndView 반환
		//
		//////////////////////////////////////////////////
		
		ModelAndView model = new ModelAndView();
		
		// JSP포워드
		model.setViewName(Path.SEND_MEET_JSP);
		
		return model;
	}
	
	@RequestMapping( value={Path.SEND_MEET_SERVICE_INSERT}, method={RequestMethod.POST} )
	public ModelAndView insertMeetMsg(
			HttpServletRequest request,
			HttpServletResponse response, 
			@RequestBody MeetVo param) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		// 뷰 이름 설정
		mav.setViewName(Path.JSON);
		
		try {
			// 입력 기능 실행 
			sendService.insertMessage( param );
			
			// 정상 실행 시 코드 설정
			mav.addObject( Path.CODE, "SUCCESS" );
			mav.addObject( Path.MESSAGE, "" );		
		}
		catch( Exception ex ) {
			logger.error( ex.getMessage() );
			// 에러 상황 시 코드 설정
			mav.addObject( Path.CODE, "ERROR" );
			mav.addObject( Path.MESSAGE, ex.getMessage() );		
		}	
		
		return mav;
		
	}	// Method - insertMeetMsg

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
