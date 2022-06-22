package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	//필드
	@Autowired
	private BoardDao boardDao;
	
	//메소드 일반
	
	//리스트
	public List<BoardVo> getbList() {
		System.out.println("bService > getbList()");
		
		List<BoardVo> bList = boardDao.getbList();
		
		return bList;
		
	}
	
	//게시글 등록
	public int write(BoardVo boardVo) {
		System.out.println("bService>b.write()");
		
		int count = boardDao.write(boardVo);
		
		return count;
	}
	
	//게시글 읽기
	public BoardVo getBoard(int no) {
		System.out.println("bservice > getboard()");
		
		BoardVo boardVo = boardDao.getBoard(no);
		
		return boardVo;
	}
}
