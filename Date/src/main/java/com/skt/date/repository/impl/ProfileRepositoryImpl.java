package com.skt.date.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.ProfileRepository;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {



	
	public void updateProfile(ProfileVo vo){ //프로필 수정
		//sqlsession.update("",vo);
	}
}
