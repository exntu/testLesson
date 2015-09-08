package com.skt.date.repository.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.net.SyslogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.TodayRepository;
import com.skt.date.vo.MatchingVo;
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
	 * 오늘 카드가 뽑혔는지 확인
	 * @return
	 */
	public String matchingPickToday() {
		String result = (String) sqlSession.selectOne("com.skt.date.sql.matching.matchingPickToday");
		return result;
	}
	
	/**
	 * 두장의 카드 뽑기
	 */
	public List<MatchingVo> selectTwoCard( MatchingVo vo ) {
		List<MatchingVo> result = sqlSession.selectList("com.skt.date.sql.matching.matchingUser", vo);
		return result; 
	}
	
	/**
	 * 뿁혔던 두장의 카드 뽑기
	 */
	public List<MatchingVo> selectTwoCardAlready( MatchingVo vo ) {
		List<MatchingVo> result = sqlSession.selectList("com.skt.date.sql.matching.matchingUserAlready", vo);
		return result; 
	}
	
	/**
	 * 두장의 뽑힌 카드 넣기
	 */
	public void insertTwoCardSelected( MatchingVo matchingCard ) {
		sqlSession.insert( "com.skt.date.sql.matching.insertMatchedCard", matchingCard );
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
