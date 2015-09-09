package com.skt.date.repository;

import com.skt.date.vo.MatchingVo;

public interface TodayDetailRepository {
	
	/**
	 * 선택된 카드 상세정보
	 * @param email
	 * @return
	 */
	public MatchingVo matchingDetailCard(String email);
	
}