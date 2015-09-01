package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.CardVo;

public interface CardService {

	public List<CardVo> selectTodayCard(CardVo vo);
	
	public List<CardVo> selectAllCard();
	
	public List<CardVo> selectExtra(CardVo vo);
	
	public List<CardVo> selectPopular(CardVo vo);

	
}
