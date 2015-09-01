package com.skt.date.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.FriendRepository;
import com.skt.date.service.FriendService;
import com.skt.date.vo.FriendVo;

@Service
public class FriendServiceImpl implements FriendService {

	@Inject
	private FriendRepository friendrepository;
	
	public List<FriendVo> selectFriend(){ //친구리스트 조회
		
		List<FriendVo> result=friendrepository.selectFriend();
		return result;
	}

	public void insertFriend(FriendVo vo){ //친구리스트 생성
		friendrepository.insertFriend(vo);
	}
	
	public void deleteFriend(FriendVo vo){ //친구리스트 삭제
		friendrepository.deleteFriend(vo);
	}

}
