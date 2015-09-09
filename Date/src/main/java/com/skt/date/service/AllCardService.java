package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.CardVo;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;

public interface AllCardService {
	public List<UserVo> selectAllCard(UserVo vo);
	public List<UploadVo> selectAllCardImg(String param);
	public List<ProfileVo> selectAllCardAdd(String param);
	
}
