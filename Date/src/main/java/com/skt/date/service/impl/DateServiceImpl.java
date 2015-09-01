package com.skt.date.service.impl;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.DateRepository;
import com.skt.date.service.DateService;


@Service
public class DateServiceImpl implements DateService{

	@Inject
	private DateRepository daterepository;
	
	
	public String Sample(){
		String repp="";
		repp=daterepository.Sample();
		
		return repp;
	}


	
}
