package com.skt.date.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.ProfileRepository;
import com.skt.date.vo.FriendVo;
import com.skt.date.vo.PeopleVo;
@Repository
public class ProfileRepositoryImpl implements ProfileRepository {
	@Autowired
	SqlSession sqlSession;
	
	public List<PeopleVo> selectProfile(PeopleVo vo){
		List<PeopleVo> list=sqlSession.selectList("com.skt.date.sql.profile.selectProfile");
		return list;
	}
	
	public List<PeopleVo> selectAllCard() { //모든카드(랜덤) 조회
		
		PeopleRepositoryImpl pe=new PeopleRepositoryImpl();
		
		
		List<PeopleVo> result=pe.createPeople(1);

		return result;
	}
}
