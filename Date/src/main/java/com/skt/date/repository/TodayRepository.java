/**
 * Today Repository interface
 * 
 * choong
 */
package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.FromToVo;
import com.skt.date.vo.MatchingVo;
import com.skt.date.vo.ProfileVo;

public interface TodayRepository {
	
	/**
	 * 서버 현재 시간 가져온다.
	 * @return
	 */
	public String currentTime();
	
	/**
	 * 오늘 2장 카드가 뽑혔는지 확인
	 * @return
	 */
	public List<FromToVo> matchingPickToday();
	
	/**
	 * 두장의 카드를 뽑는다.
	 * @param vo
	 * @return
	 */
	public List<MatchingVo> selectTwoCard(MatchingVo vo);
	
	/**
	 * 뽑힌 두장의 카드 넣는다.
	 * @param vo
	 */
	public void insertTwoCardSelected( FromToVo vo );

	/**
	 * history에서 7일전 카드 가져오기
	 * @param email
	 * @return
	 */
	public List<FromToVo>matchingHistory( String email );
	
	/**
	 * 뽑힌 두장의 카드를 뽑는다.
	 * @param email
	 * @return
	 */
	public List<ProfileVo> selectTwoCardAlready( String email );
	

}
