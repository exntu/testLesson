package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.FromToVo;
import com.skt.date.vo.MatchingVo;

public interface TodayService {
	
	/**
	 * 서버 현재 시간 가져온다.
	 * @return
	 */
	public String currentTime();
	
	/**
	 * 오늘 뽑혔는지 확인
	 * @return
	 */
	public List<MatchingVo> matchingPickToday();
	
	/**
	 * 유저를 조회한다.
	 * @param vo
	 * @return
	 */
	public List<MatchingVo> selectTwoCard(MatchingVo vo);
	
	/**
	 * 뽑힌 두장의 카드를 뽑는다.
	 * @param vo
	 * @return
	 */
	public List<MatchingVo> selectTwoCardAlready();
	
	/**
	 * 뽑힌 두장의 카드 넣는다.
	 * @param fromtoVo
	 */
	public void insertTwoCardSelected( FromToVo fromtoVo );
	
	/**
	 * history에서 두장카드 가져오기
	 * @return
	 */
	public List<FromToVo>matchingHistory();
	

}
