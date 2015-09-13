package com.skt.date.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.UserRepository;
import com.skt.date.vo.UserVo;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	
	
	// MyBatis 객체
	@Autowired
	private SqlSession sqlSession;

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
	
	/**
	 * 사용자 조회 (로그인용)
	 */
	public UserVo selectLoginUser(UserVo vo){ 

		UserVo result = (UserVo) sqlSession.selectOne("com.skt.date.sql.user.selectLoginUser",vo);
		
		return result; 
	}
	
	/**
	 * 사용자 조회
	 */
	public UserVo selectUser(UserVo vo){ 

		UserVo result = (UserVo) sqlSession.selectOne("com.skt.date.sql.user.selectUser",vo);
		
		return result; 
	}
	
	/**
	 * 사용자 가입
	 */
	public void insertUser(UserVo vo){
		
		sqlSession.insert("com.skt.date.sql.user.insertUser",vo);
	}
	
	/**
	 * 사용자 정보수정
	 */
	public void updateUser(UserVo vo){
		
		sqlSession.insert("com.skt.date.sql.user.updateUser",vo);
	}
	
	/**
	 * 닉네임에 해당하는 유저를 조회한다.
	 */
	public UserVo selectUserByNickname(UserVo vo){ 

		UserVo result = (UserVo) sqlSession.selectOne("com.skt.date.sql.user.selectUserByNickname",vo);
		
		return result; 
	}

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
