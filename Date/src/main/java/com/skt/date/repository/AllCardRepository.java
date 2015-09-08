package com.skt.date.repository;

import java.util.List;

import com.skt.date.vo.PeopleVo;

public interface AllCardRepository {
	public List<PeopleVo> selectAllCard();
}
