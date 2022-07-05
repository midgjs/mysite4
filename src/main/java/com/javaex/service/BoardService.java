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
	//리스트4
	public List<BoardVo> getbList4(int crtPage) {
		System.out.println("bService > getbList4()");
		
		//////////////////////////////////////
		// 리스트 가져오기
		//////////////////////////////////////
		
		//페이지당 글갯수
		int listCnt = 10;
		System.out.println(crtPage);
		
		//현재페이지
		crtPage = (crtPage > 0) ? crtPage : (crtPage=1);
		
		//시작글번호
		int startRnum = (crtPage-1)*listCnt + 1;
		
		//끝글번호
		int endRnum = (startRnum + listCnt) - 1;
		
		List<BoardVo> bList = boardDao.selectList4(startRnum, endRnum);
		
		return bList;
	}
	
	
	
	
	
	
	
	
	
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
		
		return boardDao.write(boardVo);
		
		
		
		
		
		
		
		/*
		for(int i=1; i<=127; i++){
			
			boardVo.setTitle(i+"번째 게시글(제목)입니다.");
			boardVo.setContent(i+"번째 게시글(내용)입니다.");
			boardDao.write(boardVo);
			
		}
		
		
		return 1;
		*/
	}
	
	//게시글 읽기
	public BoardVo getBoard(int no) {
		System.out.println("bservice > getboard()");
		
		BoardVo boardVo = boardDao.getBoard(no);
		
		return boardVo;
	}
	
	
	
}
