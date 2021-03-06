/**
 * Today repositoryImpl
 * 
 * choonghyun
 */

package com.skt.date.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.TodayRepository;
import com.skt.date.vo.FromToVo;
import com.skt.date.vo.MatchingAllVo;
import com.skt.date.vo.MatchingVo;
import com.skt.date.vo.ProfileVo;
@Repository
public class TodayRepositoryImpl implements TodayRepository {
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	// MyBatis 객체
	@Autowired
	private SqlSession sqlSession;


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

	/**
	 * 서버 현재 시간 가져오기 
	 * @return
	 */
	public String currentTime(){
		String result = (String) sqlSession.selectOne("com.skt.date.sql.matching.matchingTimer");
		return result;
	}
	
	/**
	 * 오늘 카드 2장이 뽑혔는지 확인 
	 * @return
	 */
	public List<FromToVo> matchingPickToday() {
		List<FromToVo> result = (List<FromToVo>) sqlSession.selectList("com.skt.date.sql.matching.matchingPickToday");
		return result;
	}
	
	/**
	 * 두장의 카드 뽑기 
	 *@param vo
	 *@return
	 */
	public List<MatchingVo> selectTwoCard( MatchingVo vo ) {
		List<MatchingVo> result = sqlSession.selectList("com.skt.date.sql.matching.selectTwoCard", vo);
		return result; 
	}
	
	/**
	 * 두장의 뽑힌 카드 넣기 
	 * @param
	 */
	public void insertTwoCardSelected( FromToVo vo ) {
		sqlSession.insert( "com.skt.date.sql.matching.insertMatchedCard", vo );
	}
	
	/**
	 * history에서 7일전 email 카드 가져오기 
	 * @param email
	 * @return
	 */
	public List<MatchingAllVo> matchingHistory( String email ){
		List<MatchingAllVo> result = sqlSession.selectList( "com.skt.date.sql.matching.matchingHistory", email );
		return result;
	}
	
	/**
	 * 뿁혔던 두장의 카드 뽑기
	 * @param email
	 * @return
	 */
	public List<FromToVo> selectTwoCardAlready( String email ) {
		List<FromToVo> result = sqlSession.selectList( "com.skt.date.sql.matching.matchingUserAlready", email );
		return result; 
	}
	
	/**
	 * History 카드 상세정보 조회
	 * @param vo
	 * @return
	 */
	public List<MatchingAllVo>matchingHistoryCard( FromToVo vo ){
		List<MatchingAllVo>result = sqlSession.selectList("com.skt.date.sql.matching.matchingHistoryCard", vo);
		return result;
	}
	
	/**
	 * history 카드 email 7일 상세 정보 최근순
	 * @param email
	 * @return
	 */
	public List<FromToVo>matchingHistoryEmail( String email ){
		List<FromToVo>result = sqlSession.selectList("com.skt.date.sql.matching.matchingHistoryEmail", email );
		return result;
	}
	
	/**
	 * 카드가 선택이 되었는지를 확인
	 * @param vo
	 * @return
	 */
	public List<FromToVo>matchingSelectYN( FromToVo vo){
		List<FromToVo>result = sqlSession.selectList( "com.skt.date.sql.matching.matchingSelectYN", vo );
		return result;
	}
	
	/**
	 * 선택 될 경우 SelectYN Y 로 변경
	 * @param vo
	 */
	public void updateMatchingCard( FromToVo vo ){
		sqlSession.update( "com.skt.date.sql.matching.updateMatchingCard", vo );
	}
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Public Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Implement Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

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
