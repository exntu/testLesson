package com.skt.date.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.UserRepository;
import com.skt.date.service.UserService;
import com.skt.date.vo.UserVo;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserRepository userrepository;

	public UserVo Join(UserVo vo){ //가입신청처리
		UserVo result=userrepository.selectUser(vo); //이미 가입한 사용자인지 확인
		
		if(result!=null){ //이미 가입한 사용자인 경우
			
			
		}else{ //신규 가입인경우
			userrepository.insertUser(vo);
		}
		return result;
	}
	
	
}
