package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.MatchingAllVo;

public interface TodayDetailService {
	
	/**
	 * 선택된 카드 상세정보
	 * @param email
	 * @return
	 */
	public List<MatchingAllVo> matchingDetailCard(String email);


}
