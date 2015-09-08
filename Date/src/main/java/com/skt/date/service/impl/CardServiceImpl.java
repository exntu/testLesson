package com.skt.date.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.CardRepository;
import com.skt.date.repository.impl.PeopleRepositoryImpl;
import com.skt.date.service.CardService;
import com.skt.date.vo.CardVo;
import com.skt.date.vo.PeopleVo;

@Service
public class CardServiceImpl implements CardService {
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	
	@Inject
	private CardRepository cardrepository;

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
	
	public List<CardVo> selectTodayCard(CardVo vo){ //오늘의 카드 조회
		List<CardVo> result=cardrepository.selectTodayCard(vo);
		
		return result;
	}
	public List<PeopleVo> selectAllCard(){ //모든카드 조회
		
		PeopleRepositoryImpl pe=new PeopleRepositoryImpl();
		
		
		List<PeopleVo> result=pe.createPeople(4);

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
	

//	/**
//	 * 유저를 조회한다.
//	 * @param vo
//	 * @return
//	 */
//	public List<MatchingVo> selectTwoCard(MatchingVo vo){
//		
//		List<MatchingVo> result = cardrepository.selectTwoCard(vo);
//		
//		return result;
//	}

	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Override Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Protected Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

}
