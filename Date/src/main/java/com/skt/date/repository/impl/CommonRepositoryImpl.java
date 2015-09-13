package com.skt.date.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skt.date.repository.CommonRepository;
import com.skt.date.vo.CommonVo;
@Repository
public class CommonRepositoryImpl implements CommonRepository{

		public CommonVo getCurrentTime(){ //현재시간 가져오기
			
			//CommonVo result=(CommonVo)sqlsession.selectOne("");
			return null;
		}
}
