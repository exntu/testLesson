package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.MatchingAllVo;

public interface TodayDetailRepository {
	
	/**
	 * 선택된 카드 상세정보
	 * @param email
	 * @return
	 */
	public List<MatchingAllVo> matchingDetailCard(String email);
	
	
}