package com.skt.date.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
	
	/**
	 * 프로필 기본정보 조회
	 * @param param
	 * @return
	 */
	public UserVo selectProfile(String param){
		
		UserVo list=(UserVo)profilerepository.selectProfile(param);
		return list;
	}
	/**
	 * 프로필 이미지 조회
	 * @param param
	 * @return
	 */
	public List<UploadVo> selectImg(String param){
		List<UploadVo> list=profilerepository.selectImg(param);
		return list;
	}
	/**
	 * 프로필 부가정보 조회
	 * @param param
	 * @return
	 */
	public List<ProfileVo> selectAdd(String param){

		List<ProfileVo> list=profilerepository.selectAdd(param);

		return list;
	}


	/**
	 * 프로필 사진 base64로 엔코딩
	 * @param vo
	 * @return
	 */
	public boolean UploadProfile(UploadVo param) {
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
			param.setFilestream(base64);
			
			profilerepository.UploadProfile(param);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return false;

	}
	/**
	 * 프로필 부가정보 수정
	 * @param vo
	 * @return
	 */
	public void UploadAdd(PeopleVo vo){
		profilerepository.UploadAdd(vo);
		
	}

}
