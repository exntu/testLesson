package com.skt.date.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.UserRepository;
import com.skt.date.service.UserService;
import com.skt.date.vo.UserVo;

@Service
public class UserServiceImpl implements UserService{

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	
	@Inject
	private UserRepository userRepository;

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Protected Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Public Variables
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Constructor
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Getter & Setter Method ( DI Method )
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Public Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Implement Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	
	/**
	 * 유저를 조회한다. (로그인용)
	 * @param vo
	 * @return
	 */
	public UserVo selectLoginUser(UserVo vo){
		
		UserVo result = userRepository.selectLoginUser(vo);
		
		return result;
	}

	/**
	 * 유저를 조회한다.
	 * @param vo
	 * @return
	 */
	public UserVo selectUser(UserVo vo){
		
		UserVo result = userRepository.selectUser(vo);
		
		return result;
	}
	
	/**
	 * 유저를 등록한다.
	 * @param vo
	 * @return
	 */
	public void insertUser(UserVo vo){
		
		// 가입
		userRepository.insertUser(vo);
	}
	
	/**
	 * 유저를 수정한다.
	 * @param vo
	 * @return
	 */
	public void updateUser(UserVo vo){
		
		// 수정
		userRepository.updateUser(vo);
	}
	
	/**
	 * 닉네임에 해당하는 유저를 조회한다.
	 */
	public UserVo selectUserByNickname(UserVo vo){
		
		UserVo result = userRepository.selectUserByNickname(vo);
		
		return result;
	}

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Override Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/	

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Protected Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	| Private Method
	|-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	
	
}
