package com.skt.date.service;

import java.util.List;

import com.skt.date.vo.QuestionVo;

public interface QuestionService {
	public List<QuestionVo> selectFAQ(QuestionVo vo);
	
	public void updateFAQ(QuestionVo vo);

	public void insertFAQ(QuestionVo vo);
	
	public void deleteFAQ(QuestionVo vo);

}
