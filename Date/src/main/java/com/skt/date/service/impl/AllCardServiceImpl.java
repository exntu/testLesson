package com.skt.date.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.AllCardRepository;
import com.skt.date.repository.CardRepository;
import com.skt.date.service.AllCardService;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.UserVo;

@Service
public class AllCardServiceImpl implements AllCardService{
	@Inject
	private AllCardRepository allcardrepo;
	
	public List<UserVo> selectAllCard(String param){
		List<UserVo> list=allcardrepo.selectAllCard(param);
		return list;
		
	}
}
