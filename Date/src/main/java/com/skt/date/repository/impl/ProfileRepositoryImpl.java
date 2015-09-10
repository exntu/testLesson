package com.skt.date.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.ProfileRepository;

import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;
@Repository
public class ProfileRepositoryImpl implements ProfileRepository {
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 프로필 기본정보 조회
	 */
	public UserVo selectProfile(UserVo param){
		UserVo list=(UserVo)sqlSession.selectOne("com.skt.date.sql.profile.selectProfile",param);
		return list;
	}
	/**
	 * 프로필 이미지 조회
	 */
	public List<UploadVo> selectImg(UserVo param){
		List<UploadVo> list=sqlSession.selectList("com.skt.date.sql.profile.selectImg",param);
		return list;
	}
	/**
	 * 프로필 부가정보 조회
	 */
	public List<ProfileVo> selectAdd(UserVo param){
		List<ProfileVo> list=sqlSession.selectList("com.skt.date.sql.profile.selectAdd",param);
		return list;
	}

	/**
	 * 프로필 사진 수정
	 */
	public void UploadProfile(UploadVo vo){
		sqlSession.update("com.skt.date.sql.profile.UploadProfile",vo);

	}
	/**
	 * 프로필 부가정보 수정
	 */
	public void UploadAdd(ProfileVo vo){
		sqlSession.update("com.skt.date.sql.profile.UploadAdd",vo);
		
	}
}
