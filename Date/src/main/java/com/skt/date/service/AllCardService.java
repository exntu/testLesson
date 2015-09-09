package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.CardVo;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.UserVo;

public interface AllCardService {
	public List<UserVo> selectAllCard(String param);
}
