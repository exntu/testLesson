package com.skt.date.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.CardRepository;
import com.skt.date.service.CardService;
import com.skt.date.vo.CardVo;
import com.skt.date.vo.PeopleVo;

@Service
public class CardServiceImpl implements CardService {

	@Inject
	private CardRepository cardrepository;
	
	public List<CardVo> selectTodayCard(CardVo vo){ //오늘의 카드 조회
		List<CardVo> result=cardrepository.selectTodayCard(vo);
		
		return result;
	}
	public List<PeopleVo> selectAllCard(){ //모든카드 조회
		List<PeopleVo> result=cardrepository.selectAllCard();
		
		return result;
				
	}
	
	public List<CardVo> selectExtra(CardVo vo){ // 오늘의 추가 카드 조회
		
		List<CardVo> result=cardrepository.selectExtra(vo);
		
		return result;
				
	}
	
	public List<CardVo> selectPopular(CardVo vo){ //인기있는사람 카드 조회
		
		List<CardVo> result=cardrepository.selectPopular(vo);
		
		return result;
		
	}
}
