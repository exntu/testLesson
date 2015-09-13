/**
 * TodayService interface
 * 
 * choonghyun
 */
package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.FromToVo;
import com.skt.date.vo.MatchingAllVo;
import com.skt.date.vo.MatchingVo;
import com.skt.date.vo.ProfileVo;

public interface TodayService {
	
	/**
	 * 서버 현재 시간 가져온다. 
	 * @return
	 */
	public String currentTime();
	
	/**
	 * 오늘 2장 카드 있는지 확인 없으면 insert 2장의 카드 
	 * @return
	 */
	public List<FromToVo> matchingPickToday( MatchingVo matchingVo );
	
	/**
	 * 2장의 카드를 뽑는다. 
	 * @param vo
	 * @return
	 */
	public List<MatchingVo> selectTwoCard(MatchingVo vo);
	
	/**
	 * 뽑힌 두장의 카드 넣는다. 
	 * @param fromtoVo
	 */
	public void insertTwoCardSelected( FromToVo fromtoVo );
	
	/**
	 * history에서 7일전  카드 가져오기 
	 * @param email
	 * @return
	 */
	public List<MatchingAllVo> matchingHistory( String email );
	
	
	/**
	 * 뽑힌 두장의 카드를 뽑는다.
	 * @param email
	 * @return
	 */
	public List<FromToVo> selectTwoCardAlready( String email );
	
	/**
	 * history 카드 상세 정보
	 * @param email
	 * @return
	 */
	public List<MatchingAllVo>matchingHistoryCard( FromToVo vo );
	
	/**
	 * history Email 7일 최근 순서
	 * @param vo
	 * @return
	 */
	public List<FromToVo>matchingHistoryEmail( String email );
	

}
