package com.skt.date.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
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

@Service
public class ProfileServiceImpl implements ProfileService {

	@Inject
	private ProfileRepository profilerepository;
	

	public void updateProfile(ProfileVo vo){ //프로필 수정
		profilerepository.updateProfile(vo);
	}
	
	
	
	public boolean UploadProfile(UploadVo param){
		if(param.getProfile()==null){
			return false;
		}
		// 업로드
				
				String filePath = upload(param.getProfile()); 
				
				/*
				Base64 decoder=new Base64();
				byte[] imgBytes=decoder.decode(value); //value가 문자값
				
				
				*/
				
				if( "".equals(filePath) == false ){
					
					// 파일경로 삽입
					param.setProfilePath(filePath);
					
					
					return true;
				}
				// 업로드 실패
				else{
					
					return false;
				}
	}
	
	public  String upload(MultipartFile uploadfile){
		String result = "";
		
		try{
			// 파일의 오리지널 네임
			String originalFilename = uploadfile.getOriginalFilename();
			
/*			// 유효한 확장자 체크
			if( isValidExtension(originalFilename, extension) ){
				*/
				
				// 파일명
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSS");
				String fileName = format.format(date);
				
				// 파일의 확장자
				String fileExtension = "";
				
				if( originalFilename != null && !"".equals( originalFilename )) {
					if( originalFilename.lastIndexOf( "." ) != -1){
						fileExtension = originalFilename.toLowerCase().substring( originalFilename.lastIndexOf( "." ) + 1, originalFilename.length() );
					}
				}
				
				// 최종 파일명
				
				
				// 파일생성
				
				
				// 업로드
				//ploadfile.transferTo(file);
				
				// 업로드 성공
				//result = path + fileName + "." + fileExtension;
			
		}
		catch(Exception e){
			
			
		}
		
		return result;
	}
	
}
