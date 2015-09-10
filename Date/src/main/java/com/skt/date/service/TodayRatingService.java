package com.skt.date.service;

import com.skt.date.vo.FeelingVo;

public interface TodayRatingService {

	/**
	 * 별점 조회
	 * @param vo
	 * @return
	 */
	public FeelingVo matchingRate( FeelingVo vo );
	
	/**
	 * Matching에서 상대를 별 rating을 값 넣는다
	 * @param vo
	 */
	public void insertMatchingRate( FeelingVo vo );

}
