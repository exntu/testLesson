package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.UploadVo;

public interface ProfileService {
	
	boolean uploadProfile(UploadVo param);

	List<PeopleVo> selectProfile(PeopleVo vo);

	public List<PeopleVo> selectAllCard();
}
