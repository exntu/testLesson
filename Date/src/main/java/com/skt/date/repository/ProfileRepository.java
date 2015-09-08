package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.QuestionVo;

public interface ProfileRepository {
	public List<PeopleVo> selectProfile(PeopleVo vo);
	
	public List<PeopleVo> selectAllCard();
	
}
