package com.skt.date.repository.impl;

import java.util.ArrayList;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.CardRepository;
import com.skt.date.vo.CardVo;
import com.skt.date.vo.MatchingVo;
import com.skt.date.vo.PeopleVo;
@Repository
public class CardRepositoryImpl implements CardRepository {
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

//	// MyBatis 객체
//	@Autowired
//	private SqlSession sqlSession;


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

	public List<CardVo> selectTodayCard(CardVo vo){ //오늘의 카드 조회
		List<CardVo> result=new ArrayList<CardVo>();
	
		CardVo vo1 =new CardVo();
		
		vo1.setName("고길동");
		vo1.setJob("요리사");
		vo1.setAge("35");
		vo1.setSex('m');
		
		CardVo vo2=new CardVo();
		vo2.setName("김박사");
		vo2.setJob("박사");
		vo2.setAge("68");
		vo2.setSex('m');
		
		result.add(vo1);
		result.add(vo2);
		
		return result;
	}

	public List<CardVo> selectExtra(CardVo vo){ // 오늘의 추가 카드 조회
		List<CardVo> result=new ArrayList<CardVo>();
		return result;
	}
	
	public List<CardVo> selectPopular(CardVo vo){ //인기있는사람 카드 조회
		List<CardVo> result=new ArrayList<CardVo>();
		return result;
	}
	
	public List<PeopleVo> selectAllCard() { //모든카드(랜덤) 조회
		
		PeopleRepositoryImpl pe=new PeopleRepositoryImpl();
		
		
		List<PeopleVo> result=pe.createPeople(1);

		return result;
	}
//	/**
//	 * 두장의 카드 뽑기
//	 */
//	public List<MatchingVo> selectTwoCard(MatchingVo vo) {
//
////		MatchingVo result = (MatchingVo) sqlSession.selectOne("com.skt.date.sql.matching.matchingUser",vo);
//		List<MatchingVo> result = (List<MatchingVo>) sqlSession.selectList("com.skt.date.sql.matching.matchingUser", vo);
//		return result; 
//	}

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
