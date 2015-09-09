package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;

public interface AllCardRepository {
	public List<UserVo> selectAllCard(UserVo vo);
	public List<UploadVo> selectAllCardImg(String param);
	public List<ProfileVo> selectAllCardAdd(String param);
	
}
