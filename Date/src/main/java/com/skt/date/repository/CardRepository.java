package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.CardVo;
import com.skt.date.vo.MatchingVo;
import com.skt.date.vo.PeopleVo;

public interface CardRepository {

	
	public List<PeopleVo> selectAllCard();
	
	public List<CardVo> selectTodayCard(CardVo vo);
	public List<CardVo> selectExtra(CardVo vo);
	
	public List<CardVo> selectPopular(CardVo vo);
	
//	/**
//	 * 두장의 카드를 뽑는다.
//	 * @param vo
//	 * @return
//	 */
//	public List<MatchingVo> selectTwoCard(MatchingVo vo);

}
