package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.FriendVo;

public interface FriendService {
	public List<FriendVo> selectFriend();
	
	public void insertFriend(FriendVo vo);
	
	public void deleteFriend(FriendVo vo);

}
