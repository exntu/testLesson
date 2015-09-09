package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;


public interface ProfileRepository {
	
	
	public UserVo selectProfile(String param);
	public List<UploadVo> selectImg(String param);
	public List<ProfileVo> selectAdd(String param);
	
	
	//프로필 사진수정
	public void UploadProfile(UploadVo vo);
	
	//프로필 부가정보 수정
	public void UploadAdd(PeopleVo vo);
	
	
}
