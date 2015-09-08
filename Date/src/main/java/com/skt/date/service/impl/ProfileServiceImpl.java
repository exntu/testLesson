package com.skt.date.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skt.date.repository.ProfileRepository;
import com.skt.date.service.ProfileService;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Inject
	private ProfileRepository profilerepository;
	
	
	public UserVo selectProfile(String param){
		
		UserVo list=(UserVo)profilerepository.selectProfile(param);
		return list;
	}
	
	public List<UploadVo> selectImg(String param){
		List<UploadVo> list=profilerepository.selectImg(param);
		return list;
	}
	
	public List<ProfileVo> selectAdd(String param){

		List<ProfileVo> list=profilerepository.selectAdd(param);

		return list;
	}
	
	
	
	public List<PeopleVo> selectAllCard(){ //모든카드 조회
		List<PeopleVo> result=profilerepository.selectAllCard();
		
		return result;
				
	}

	public boolean uploadProfile(UploadVo param) {
		if (param.getProfile() == null) {
			return false;
		}
		// 업로드
		MultipartFile file= param.getProfile();
		
		String name=file.getOriginalFilename();
		String[] fileExarr=name.split("\\.");
		
		param.setFilename(fileExarr[fileExarr.length-1]);
		param.setFileexarr(fileExarr[0]);
		
		try {
			byte[] fileData=file.getBytes();
			String base64=new String(Base64.encodeBase64(fileData),"UTF-8");
			//param.setFilestream(base64);
			param.setFilestream(base64);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return false;

	}

}
