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
	
	//리스트(리스트만)
	public List<BoardVo> getbList() {
		System.out.println("bService > getbList()");
		
		List<BoardVo> bList = boardDao.selectList();
		
		return bList;
		
	}
	
	//리스트2?
	public List<BoardVo> getbList2(String keyword) {
		System.out.println("bService > getbList2()");
		System.out.println(keyword);
		
		List<BoardVo> bList = boardDao.selectList2(keyword);
		
		return bList;
	}
	
	//리스트(리스트+검색)
	public List<BoardVo> getbList3(String keyword) {
		System.out.println("bService > getbList3()");
		
		List<BoardVo> bList = boardDao.selectList3(keyword);
		
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
