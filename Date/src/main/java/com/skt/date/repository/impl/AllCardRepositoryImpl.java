package com.skt.date.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.AllCardRepository;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;
@Repository
public class AllCardRepositoryImpl implements AllCardRepository{
	// MyBatis 객체
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 모든카드를 조회 
	 * @param 
	 * @return
	 */
	public List<UserVo> selectAllCard(String param){
		List<UserVo> list=sqlSession.selectList("com.skt.date.sql.allcard.selectAllCard",param);
		return list;
	}
	

}
