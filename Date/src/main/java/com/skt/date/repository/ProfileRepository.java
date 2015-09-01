package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.ProfileVo;

public interface ProfileRepository {

	public List<ProfileVo> selectProfile();

	public void updateProfile(ProfileVo vo);
	
}
