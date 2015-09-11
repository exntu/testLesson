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
	 * history에서 7일전 카드 가져오기 
	 * @param email
	 * @return
	 */
	public List<FromToVo> matchingHistory( String email ){
		List<FromToVo>result = sqlSession.selectList( "com.skt.date.sql.matching.matchingHistory", email );
		return result;
	}
	
	/**
	 * 뿁혔던 두장의 카드 뽑기
	 * @param email
	 * @return
	 */
	public List<ProfileVo> selectTwoCardAlready( String email ) {
		List<ProfileVo> result = sqlSession.selectList( "com.skt.date.sql.matching.matchingUserAlready", email );
		return result; 
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
