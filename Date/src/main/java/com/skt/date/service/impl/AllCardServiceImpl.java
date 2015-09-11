package com.skt.date.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.AllCardRepository;
import com.skt.date.repository.CardRepository;
import com.skt.date.service.AllCardService;
import com.skt.date.vo.PeopleVo;
import com.skt.date.vo.ProfileVo;
import com.skt.date.vo.UploadVo;
import com.skt.date.vo.UserVo;

@Service
public class AllCardServiceImpl implements AllCardService{
	@Inject
	private AllCardRepository allcardrepo;
	/**
	 * 카드 기본정보조회
	 * @param 
	 * @return
	 */
	public List<UserVo> selectAllCard(UserVo vo){
		List<UserVo> list=allcardrepo.selectAllCard(vo);
		return list;
		
	}
	/**
	 * 카드 이미지 조회
	 * @param 
	 * @return
	 */
	public List<UploadVo> selectAllCardImg(UserVo vo){
		
		List<UploadVo> list = null;
		//이메일의 개수만큼 각각의 detail을 불러온다 
		for(int num=0;num<vo.getEmail().length();num++){
		
			list=allcardrepo.selectAllCardImg(vo);
		};
		return list;
		
	}
	/**
	 * 카드 추가정보 조회
	 * @param 
	 * @return
	 */
	public List<ProfileVo> selectAllCardAdd(UserVo vo){
		
		List<ProfileVo> list = null;
		
		for(int num=0;num<vo.getEmail().length();num++){
			list=allcardrepo.selectAllCardAdd(vo);
		};
		return list;
		
	}
}


