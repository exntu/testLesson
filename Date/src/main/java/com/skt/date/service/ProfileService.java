package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.ProfileVo;

public interface ProfileService {
	public List<ProfileVo> selectProfile();

	public void updateProfile(ProfileVo vo);
	


}
