package com.skt.date.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.AllCardRepository;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;
@Repository
public class AllCardRepositoryImpl implements AllCardRepository{
	// MyBatis 객체
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 기본 카드정보 조회
	 * @param 
	 * @return
	 */
	public List<UserVo> selectAllCard(UserVo vo){
		List<UserVo> list=sqlSession.selectList("com.skt.date.sql.allcard.selectAllCard",vo);
		return list;
	}
	/**
	 * 카드 이미지 조회
	 * @param 
	 * @return
	 */
	public List<UploadVo> selectAllCardImg(UserVo vo){
		List<UploadVo> list=sqlSession.selectList("com.skt.date.sql.allcard.selectAllCardImg",vo);
		return list;
	}
	/**
	 * 카드 부가정보 조회
	 * @param 
	 * @return
	 */
	public List<ProfileVo> selectAllCardAdd(UserVo vo){
		List<ProfileVo> list=sqlSession.selectList("com.skt.date.sql.allcard.selectAllCardAdd",vo);
		return list;
	}
	


}
