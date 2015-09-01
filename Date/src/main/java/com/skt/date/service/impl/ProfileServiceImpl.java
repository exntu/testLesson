package com.skt.date.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.ProfileRepository;
import com.skt.date.service.ProfileService;
import com.skt.date.vo.ProfileVo;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Inject
	private ProfileRepository profilerepository;
	
	public List<ProfileVo> selectProfile(){ //프로필 조회
		List<ProfileVo> result=profilerepository.selectProfile();
		return result;
	}
	
	public void updateProfile(ProfileVo vo){ //프로필 수정
		profilerepository.updateProfile(vo);
	}
}
