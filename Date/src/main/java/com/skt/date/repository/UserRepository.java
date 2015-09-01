package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.UserVo;

public interface UserRepository {

	public UserVo selectUser(UserVo vo);
	
	public void insertUser(UserVo vo);
	
	public void deleteUser(UserVo vo);
	
	public void updateUser(UserVo vo);
}
