package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.CardVo;

public interface CardRepository {

	
	public List<CardVo> selectAllCard();
	public List<CardVo> selectTodayCard(CardVo vo);
	public List<CardVo> selectExtra(CardVo vo);
	
	public List<CardVo> selectPopular(CardVo vo);
	
}
