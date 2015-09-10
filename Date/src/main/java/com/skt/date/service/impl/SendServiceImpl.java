package com.skt.date.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skt.date.repository.SendRepository;
import com.skt.date.service.SendService;
import com.skt.date.vo.MeetVo;

@Service
public class SendServiceImpl implements SendService {
	
	@Autowired
	private SendRepository sendRepo;
	
	public void insertMessage(MeetVo param) {
		// TODO Auto-generated method stub
		sendRepo.insertMessage( param );
	}
}
