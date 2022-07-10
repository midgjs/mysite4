package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.RboardDao;
import com.javaex.vo.RboardVo;

@Service
public class RboardService {

	//필드
	@Autowired
	private RboardDao rboardDao;
	
	//리스트
	public List<RboardVo> getlist() {
		System.out.println("rbservice > getlist()");
		
		List<RboardVo> list = rboardDao.selectList();
		
		return list;
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
}
