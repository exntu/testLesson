package com.skt.date.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import com.skt.date.common.Session;
import com.skt.date.vo.CommonVo;
import com.skt.date.vo.UserVo;

/*
 * 클래스 이름 : AbstractBaseController
 * 
 * 클래스 설명 : 컨트롤러 추상클래스
 * 
 * 작성자 정보 : adventurez
 *
 * 버전 정보 : v1
 *
 * 수정 이력  : 2015. 07. 9
 *
 */
public class AbstractBaseController {
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

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

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Implement Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Override Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Protected Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	
	/**
	 * 로그인 유저정보를 가져온다.
	 * @param request
	 * @return
	 */
	protected UserVo getLoginInfo(HttpServletRequest request) throws Exception {
		
		// 세션에서 유저정보를 가져온다.
		HttpSession session = request.getSession();
		UserVo loginInfo = (UserVo) session.getAttribute(Session.LOGIN_KEY);
		
		// 로그인정보가 없다면
		if( loginInfo == null ){
			// 에러발생
			throw new Exception();
		}
		
		// 반환정보
		UserVo userVO = new UserVo();
		
		// Date 타입은 카피가 안되서 세팅해준다.
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
		
		// 그냥 던져주면 변경이 가능하기 때문에 Deep Copy로 전달한다.
		BeanUtils.copyProperties(userVO, loginInfo);
		
		return userVO;
	}
	
	/**
	 * 파라미터(CommonVO를 상속받은 VO)에 로그인정보 주입
	 * @param request
	 * @param param
	 * @throws Exception
	 */
	protected void setLoginInfo(HttpServletRequest request, CommonVo param) throws Exception {
		
		// 로그인정보를 가져옴
		UserVo loginInfo = this.getLoginInfo(request);
		
		// 로그인정보 주입
		param.setCreatedUserId(loginInfo.getCreatedUserId());
		param.setUpdatedUserId(loginInfo.getUpdatedUserId());
	}
	
	/**
	 * 파라미터(CommonVO를 상속받은 List<VO>)에 로그인정보 주입
	 * @param request
	 * @param param
	 * @throws Exception
	 */
	protected void setLoginInfo(HttpServletRequest request, List<?> param) throws Exception {
		
		// 로그인정보를 가져옴
		UserVo loginInfo = this.getLoginInfo(request);
		
		// 루프를 돌며
		for( int num = 0 ; num < param.size() ; num++ ){
			
			CommonVo commonVO = (CommonVo) param.get(num);
			
			// 로그인정보 주입
			commonVO.setCreatedUserId(loginInfo.getCreatedUserId());
			commonVO.setUpdatedUserId(loginInfo.getUpdatedUserId());
		}
	}

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
}
