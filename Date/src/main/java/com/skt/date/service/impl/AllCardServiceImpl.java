package com.skt.date.service.impl;

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
	public List<UploadVo> selectAllCardImg(String param){
		List<UploadVo> list=allcardrepo.selectAllCardImg(param);
		return list;
		
	}
	/**
	 * 카드 추가정보 조회
	 * @param 
	 * @return
	 */
	public List<ProfileVo> selectAllCardAdd(String param){
		List<ProfileVo> list=allcardrepo.selectAllCardAdd(param);
		return list;
		
	}
}


