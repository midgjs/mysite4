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
	
	//게시판 전체가져오기
	public List<BoardVo> getbList() {
		System.out.println("BoardDao > getbList()");
		
		List<BoardVo> bList  = sqlSession.selectList("board.getbList");
		System.out.println(bList);
		return bList;
	}
	
}
