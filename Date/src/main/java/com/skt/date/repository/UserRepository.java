package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.UserVo;

public interface UserRepository {

	/**
	 * 유저를 조회한다.
	 * @param vo
	 * @return
	 */
	public UserVo selectUser(UserVo vo);
	
	/**
	 * 유저를 등록한다.
	 * @param vo
	 * @return
	 */
	public void insertUser(UserVo vo);
	
	/**
	 * 유저를 수정한다.
	 * @param vo
	 * @return
	 */
	public void updateUser(UserVo vo);
}
