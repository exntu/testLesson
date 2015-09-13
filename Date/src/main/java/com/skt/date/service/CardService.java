package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.CardVo;
import com.skt.date.vo.PeopleVo;

public interface CardService {

	public List<CardVo> selectTodayCard(CardVo vo);
	
	public List<PeopleVo> selectAllCard();
	
	public List<CardVo> selectExtra(CardVo vo);
	
	public List<CardVo> selectPopular(CardVo vo);

//	/**
//	 * 유저를 조회한다.
//	 * @param vo
//	 * @return
//	 */
//	public List<MatchingVo> selectTwoCard(MatchingVo vo);

}
