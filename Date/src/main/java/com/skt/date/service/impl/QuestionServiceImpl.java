package com.skt.date.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.skt.date.repository.QuestionRepository;
import com.skt.date.service.QuestionService;
import com.skt.date.vo.QuestionVo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Inject
	private QuestionRepository questionrepository;
	
	public List<QuestionVo> selectFAQ(QuestionVo vo){ //FAQ 조회
		
		List<QuestionVo> result=questionrepository.selectFAQ(vo);
		
		return result;
	}
	public void updateFAQ(QuestionVo vo){ //FAQ 수정
		
		questionrepository.updateFAQ(vo);
	}

	public void insertFAQ(QuestionVo vo){ //FAQ 입력
		questionrepository.insertFAQ(vo);
	}
	
	public void deleteFAQ(QuestionVo vo){ //FAQ 삭제
		questionrepository.deleteFAQ(vo);
	}

}
