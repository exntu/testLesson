package com.skt.date.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.QuestionRepository;
import com.skt.date.vo.QuestionVo;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository{

	public List<QuestionVo> selectFAQ(QuestionVo vo){ //FAQ조회
		
		List<QuestionVo> result=new ArrayList<QuestionVo>();
		
		QuestionVo vo1 =new QuestionVo();
		
		vo1.setNum(1);
		vo1.setTitle("질문");
		
		QuestionVo vo2 =new QuestionVo();
		
		vo2.setNum(2);
		vo2.setTitle("질문2");
		
		
		result.add(vo1);
		result.add(vo2);
		return result;
	}
	
	public void updateFAQ(QuestionVo vo){ //FAQ수정
		//sqlsession.update("",vo);
	}
	public void insertFAQ(QuestionVo vo){ //FAQ입력
		//sqlsession.insert("",vo);
	}
	public void deleteFAQ(QuestionVo vo){ //FAQ삭제
		//sqlsession.delete("",vo);
	}

}
