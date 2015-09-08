package com.skt.date.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.skt.date.repository.TodayRepository;
import com.skt.date.service.TodayService;
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
	public String matchingPickToday(){
		String result = todayRepository.matchingPickToday();
		return result;
	}
	
	/**
	 * 유저를 조회한다.
	 * @param vo
	 * @return
	 */
	public List<MatchingVo> selectTwoCard(MatchingVo vo){
		
		// 오늘 만든 카드가 있는지 조회
		System.out.println(matchingPickToday());
//		if( StringUtils.isEmpty(matchingPickToday()) == true ){
		if( StringUtils.isEmpty(matchingPickToday()) == false ){
			
			// 없다면 카드 두장 조회
			List<MatchingVo> result = todayRepository.selectTwoCard(vo);
			
			// 조회한 카드 두장을 insert
			for( int i = 0; i<result.size(); i++ ){
				MatchingVo param = new MatchingVo();
				param.setEmail(vo.getEmail());
				param.setOtherEmail(result.get(i).getOtherEmail());
				insertTwoCardSelected(param);
				System.out.println(param);
			}
			return result;
		}else{
			//이미 뽑힌 두장의 카드
			List<MatchingVo> result = todayRepository.selectTwoCardAlready(vo);
			return result;
		}
	}
	
	/**
	 * 뽑힌 두장의 카드를 넣는다.
	 * @param vo
	 */
	public void insertTwoCardSelected(MatchingVo vo) {
		todayRepository.insertTwoCardSelected(vo);
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
