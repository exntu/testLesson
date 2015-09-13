/**
 * TodayServiceImpl
 * 
 * choong
 */
package com.skt.date.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.TodayRepository;
import com.skt.date.service.TodayService;
import com.skt.date.vo.FromToVo;
import com.skt.date.vo.MatchingAllVo;
import com.skt.date.vo.MatchingVo;
import com.skt.date.vo.ProfileVo;

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
	 * 오늘 2장 카드 있는지 확인, 없으면 insert 2장의 카드
	 * @return
	 */
	public List<FromToVo> matchingPickToday( MatchingVo matchingVo ){
		List<FromToVo> result = todayRepository.matchingPickToday();
		//2장의 카드가 없을 경우 2장의 카드 조회
		if( result == null || result.isEmpty() || result.get(0).getTo() == null || result.size()==0 ){
			//2장의 랜덤 카드 조회
			List<MatchingVo>selectTwoCard = selectTwoCard( matchingVo );
			//2장의 랜덤카드 insert하기
			FromToVo fromtoVo = new FromToVo();
			for(int num=0; num<selectTwoCard.size(); num++ ){
				fromtoVo.setFrom(matchingVo.getEmail());
				fromtoVo.setTo(selectTwoCard.get(num).getEmail());
				fromtoVo.setSelectYN("N");
				insertTwoCardSelected( fromtoVo );
			}
		}else{
			return result;
		}
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
	 * @param vo
	 * @return
	 */
	public List<MatchingVo> selectTwoCard(MatchingVo vo){
		List<MatchingVo> result = todayRepository.selectTwoCard(vo);
		return result;
	}

	/**
	 * 7일간의 history를 email로 가져온다.
	 * @param email
	 * @return
	 */
	public List<MatchingAllVo> matchingHistory( String email ){
		List<MatchingAllVo> result = todayRepository.matchingHistory( email );
		return result;
	}
	
	/**
	 *	뿁혔던 두장의 카드 뽑기 
	 * @param email
	 * @return
	 */
	public List<FromToVo> selectTwoCardAlready( String email ) {
		List<FromToVo> result = todayRepository.selectTwoCardAlready( email );
		return result;
	}
	
	/**
	 * History카드 상세 정보 가져오기
	 * @param email
	 * @return
	 */
	public List<MatchingAllVo>matchingHistoryCard( FromToVo vo ){
		List<MatchingAllVo>result = todayRepository.matchingHistoryCard( vo );
		return result;
	}
	
	public List<FromToVo>matchingHistoryEmail( String email ){
		List<FromToVo>result = todayRepository.matchingHistoryEmail( email );
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
