package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;

@Service
public class BoardService {
	
	//필드
	@Autowired
	private BoardDao boardDao;
	
}
