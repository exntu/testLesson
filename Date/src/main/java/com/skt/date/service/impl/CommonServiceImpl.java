package com.skt.date.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.CommonRepository;
import com.skt.date.service.CommonService;
import com.skt.date.vo.CommonVo;

@Service
public class CommonServiceImpl implements CommonService {

	@Inject
	private CommonRepository commonrepository;
	public CommonVo getCurrentTime(){
		
		CommonVo result=commonrepository.getCurrentTime();
		
		return result;
	}
}
