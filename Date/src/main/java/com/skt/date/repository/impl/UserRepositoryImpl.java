package com.skt.date.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.UserRepository;
import com.skt.date.vo.UserVo;

@Repository
public class UserRepositoryImpl implements UserRepository {


	public UserVo selectUser(UserVo vo){ //기존의사용자인지 확인

		//UserVo result=(UserVO) sqlsession.selectOne("",vo);
		return null; 
	}

	public void insertUser(UserVo vo){ //신규가입
		
		//sqlsession.insert("",vo);
	}
	
	public void deleteUser(UserVo vo){ //사용자 삭제
		//sqlsession.delete("",vo);
	}
	
	public void updateUser(UserVo vo){ //회원수정
		//sqlsession.update("",vo);
		
	}
	
	
	
}
