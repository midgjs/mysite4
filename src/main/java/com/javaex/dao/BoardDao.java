package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//메소드 일반
	
	//게시판 전체가져오기(리스트만)
	public List<BoardVo> selectList() {
		System.out.println("BoardDao > getbList()");
		
		List<BoardVo> bList  = sqlSession.selectList("board.selectList");
		System.out.println(bList);
		
		return bList;
	}
	
	//게시판 + 검색
	public List<BoardVo> selectList3(String keyword) {
		System.out.println("BoardDao > selectList3()");
		
		List<BoardVo> bList = sqlSession.selectList("board.selectList3", keyword);
		
		return bList;
	}
	
	//게시판2?
	public List<BoardVo> selectList2(String keyword) {
		System.out.println("bDao > selectList2()");
		System.out.println(keyword);
		
		List<BoardVo> bList = sqlSession.selectList("board.selectList2", keyword);
		System.out.println(bList);
		return bList;
		
	}
	
	//글쓰기
	public int write(BoardVo boardVo) {
		System.out.println("BoardDao>write()");
		
		int count = sqlSession.insert("board.insertBoard", boardVo);
		
		return count;
	}
	
	//게시판 읽기
	public BoardVo getBoard(int no) {
		System.out.println("bDao>getboard()");
		
		BoardVo boardVo = sqlSession.selectOne("board.getBoard", no);
		System.out.println(boardVo);
		
		return boardVo;
	}
	
}
