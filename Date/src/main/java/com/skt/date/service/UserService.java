package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.UserVo;

public interface UserService {

	/**
	 * 유저를 조회한다. (로그인용)
	 * @param vo
	 * @return
	 */
	public UserVo selectLoginUser(UserVo vo);

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
	public UserVo insertUser(UserVo vo);
	
	/**
	 * 유저를 수정한다.
	 * @param vo
	 * @return
	 */
	public void updateUser(UserVo vo);
}
