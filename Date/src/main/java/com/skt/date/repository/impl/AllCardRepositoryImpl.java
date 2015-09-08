package com.skt.date.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.vo.PeopleVo;
@Repository
public class AllCardRepositoryImpl {
	// MyBatis 객체
	@Autowired
	private SqlSession sqlSession;
	

}
