package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.FriendVo;

public interface FriendRepository {

	public List<FriendVo> selectFriend();
	
	public void insertFriend(FriendVo vo);
	
	public void deleteFriend(FriendVo vo);


}
