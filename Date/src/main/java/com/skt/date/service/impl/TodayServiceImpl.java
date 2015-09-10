package com.skt.date.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.TodayRepository;
import com.skt.date.service.TodayService;
import com.skt.date.vo.FromToVo;
import com.skt.date.vo.MatchingVo;

@Service
public class TodayServiceImpl implements TodayService {
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	
	@Inject
	private TodayRepository todayRepository;

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
	
	/**
	 * 서버 현재 시간 가져오기
	 * @return
	 */
	public String currentTime(){
		String result = todayRepository.currentTime();
		return result;
	}
	
	/**
	 * 오늘 뽑은 카드있는지 확인
	 * @return
	 */
	public List<MatchingVo> matchingPickToday(){
		List<MatchingVo> result = todayRepository.matchingPickToday();
		return result;
	}
	
	/**
	 * 뽑힌 두장의 카드를 넣는다.
	 * @param vo
	 */
	public void insertTwoCardSelected(FromToVo vo) {
		todayRepository.insertTwoCardSelected(vo);
	}
	
	/**
	 * 1.	유저를 조회한다.
	 * 2.	오늘카드 있는지
	 * 3.	오늘의 카드가 없다면 insert카드 
	 * 
	 * @param vo
	 * @return
	 */
	public List<MatchingVo> selectTwoCard(MatchingVo vo){
		List<MatchingVo> result = todayRepository.selectTwoCard(vo);
		return result;
	}

	/**
	 * 
	 *	뿁혔던 두장의 카드 뽑기 
	 * @param vo
	 * @return
	 */
	public List<MatchingVo> selectTwoCardAlready() {
		List<MatchingVo> result = todayRepository.selectTwoCardAlready();
		return result;
	}
	
	
	public List<FromToVo>matchingHistory(){
		List<FromToVo> result = todayRepository.matchingHistory();
		return result;
	}
	
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
