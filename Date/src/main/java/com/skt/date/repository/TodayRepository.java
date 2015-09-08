package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.MatchingVo;

public interface TodayRepository {
	
	/**
	 * 서버 현재 시간 가져온다.
	 * @return
	 */
	public String currentTime();
	
	/**
	 * 오늘 카드가 뽑혔는지 확인
	 * @return
	 */
	public String matchingPickToday();
	
	/**
	 * 두장의 카드를 뽑는다.
	 * @param vo
	 * @return
	 */
	public List<MatchingVo> selectTwoCard(MatchingVo vo);
	
	/**
	 * 뽑힌 두장의 카드를 뽑는다.
	 * @param vo
	 * @return
	 */
	public List<MatchingVo> selectTwoCardAlready( MatchingVo vo );
	
	/**
	 * 뽑힌 두장의 카드 넣는다.
	 * @param param
	 */
	public void insertTwoCardSelected( MatchingVo param );


}
