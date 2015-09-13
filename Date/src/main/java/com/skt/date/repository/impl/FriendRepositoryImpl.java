package com.skt.date.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.FriendRepository;
import com.skt.date.vo.FriendVo;

@Repository
public class FriendRepositoryImpl implements FriendRepository {


	
	public List<FriendVo> selectFriend(){ //친구 리스트 조회
		List<FriendVo> result=new ArrayList<FriendVo>();
		FriendVo vo1 =new FriendVo();
		
		vo1.setName("김상진");
		vo1.setDate("20150813");
		
		result.add(vo1);

		return result;
	}

	public void deleteFriend(FriendVo vo){ //친구 리스트 삭제
		//sqlsession.delete("",vo);
	}
	
	public void insertFriend(FriendVo vo){ //친구 리스트 생성
		//sqlsession.insert("",vo);
	}
}
