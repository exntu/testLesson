package com.skt.date.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;

public interface ProfileService {

	public void updateProfile(ProfileVo vo);
	
	public boolean UploadProfile(UploadVo vo);
	
	public String upload(MultipartFile uploadfile);
}
