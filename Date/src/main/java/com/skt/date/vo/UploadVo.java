package com.skt.date.vo;

import org.springframework.web.multipart.MultipartFile;

public class UploadVo extends CommonVo {

	private MultipartFile Profile;
	private String ProfilePath;
	public MultipartFile getProfile() {
		return Profile;
	}
	public void setProfile(MultipartFile profile) {
		Profile = profile;
	}
	public String getProfilePath() {
		return ProfilePath;
	}
	public void setProfilePath(String profilePath) {
		ProfilePath = profilePath;
	}

	
	
}
