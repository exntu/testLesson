package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;

public interface ProfileService {
	
	public boolean UploadProfile(UploadVo vo);
	
	public void UploadAdd(PeopleVo vo);

	public UserVo selectProfile(String param);
	public List<UploadVo> selectImg(String param);
	public List<ProfileVo> selectAdd(String param);
	
}
