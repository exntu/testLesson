package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;

public interface ProfileService {
	
	public boolean UploadProfile(UploadVo vo);
	
	public void UploadAdd(ProfileVo vo);

	public UserVo selectProfile(UserVo param);
	public List<UploadVo> selectImg(UserVo param);
	public List<ProfileVo> selectAdd(UserVo param);
	
}
