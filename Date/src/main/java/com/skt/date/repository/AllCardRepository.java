package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.UserVo;

public interface AllCardRepository {
	public List<UserVo> selectAllCard(String param);
}
