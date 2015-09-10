package com.skt.date.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.SendRepository;
import com.skt.date.vo.MeetVo;

@Repository
public class SendRepositoryImpl implements SendRepository {
	
	// MyBatis 객체
	@Autowired
	private SqlSession sqlSession;
	
	public void insertMessage(MeetVo param) {
		sqlSession.insert( "com.skt.date.sql.send.insertMessage", param );		
	}

}
