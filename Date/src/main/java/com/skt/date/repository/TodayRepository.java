/**
 * Today Repository interface
 * 
 * choong
 */
package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.FromToVo;
import com.skt.date.vo.MatchingAllVo;
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
	 * history에서 7일전 email 카드 가져오기
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
	 * history 상세 정보 가져오기
	 * @param vo
	 * @return
	 */
	public List<MatchingAllVo>matchingHistoryCard( FromToVo vo );
	
	/**
	 * history Email 상세 정보 가져오기 (최근순)
	 * @param vo
	 * @return
	 */
	public List<FromToVo>matchingHistoryEmail( String email );
	
	/**
	 * 카드가 선택이 되었는지를 확인 
	 * @param vo
	 * @return
	 */
	public List<FromToVo>matchingSelectYN( FromToVo vo);
	
	/**
	 * 선택 될 경우 SelectYN Y 로 변경
	 * @param vo
	 */
	public void updateMatchingCard( FromToVo vo);
	
}
