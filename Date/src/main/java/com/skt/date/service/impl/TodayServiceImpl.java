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
//		// 오늘 만든 카드가 있는지 조회
////		if( StringUtils.isEmpty(matchingPickToday()) == false ){
//		if( matchingPickToday().isEmpty() || matchingPickToday().get(0).getEmail() == null){
//			
//			// 없다면 카드 두장 조회
//			List<MatchingVo> result = todayRepository.selectTwoCard(vo);
//			
//			// 조회한 카드 두장을 insert
//			for( int i=0; i<result.size(); i++){
//				MatchingVo param = new MatchingVo();
//				param.setEmail(vo.getEmail());
//				param.setOtherEmail(result.get(i).getEmail());
//				insertTwoCardSelected(param);
//			}
//			
//			return result;
//		}else{
//			//이미 뽑힌 두장의 카드
//			return todayRepository.matchingPickToday();
//		}
//	}

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
