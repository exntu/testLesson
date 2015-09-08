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
	
	public UserVo selectProfile(String param){
		UserVo list=(UserVo)sqlSession.selectOne("com.skt.date.sql.profile.selectProfile",param);
		return list;
	}

	public List<UploadVo> selectImg(String param){
		List<UploadVo> list=sqlSession.selectList("com.skt.date.sql.profile.selectImg",param);
		return list;
	}
	public List<ProfileVo> selectAdd(String param){
		List<ProfileVo> list=sqlSession.selectList("com.skt.date.sql.profile.selectAdd",param);
		return list;
	}

	public List<PeopleVo> selectAllCard() { //모든카드(랜덤) 조회
		
		PeopleRepositoryImpl pe=new PeopleRepositoryImpl();
		
		
		List<PeopleVo> result=pe.createPeople(1);

		return result;
	}
}
