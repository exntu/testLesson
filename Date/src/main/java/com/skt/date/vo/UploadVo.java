package com.skt.date.vo;

import org.springframework.web.multipart.MultipartFile;

/** PeopleVo의 additional 정보를  upload로 상속(join쿼리를 list로 받기위해서) */
public class UploadVo extends PeopleVo {

	
	private MultipartFile profile;

	private String filename; //파일이름
	private String fileexarr; //파일확장자
	private String filestream; //base64로 저장된 바이트
	
	public String getFilestream() {
		return filestream;
	}

	public void setFilestream(String filestream) {
		this.filestream = filestream;
	}



	public String getFilename() {
		return filename;
	}

	public MultipartFile getProfile() {
		return profile;
	}

	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}

	public String getFileexarr() {
		return fileexarr;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFileexarr(String fileexarr) {
		this.fileexarr = fileexarr;
	}

	@Override
	public String toString() {
		return "UploadVo [profile=" + profile + ", filename=" + filename + ", fileexarr=" + fileexarr + ", filestream="
				+ filestream + "]";
	}




 


	
}
