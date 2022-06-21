package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//방명록 전체가져오기
	public List<GuestbookVo> getgList() {
		System.out.println("GuestbookDao > getgList()");
		
		List<GuestbookVo> gList  = sqlSession.selectList("guestbook.getgList");
		System.out.println(gList);
		return gList;
	}
	
	//방명록 추가
	public int gInsert(GuestbookVo gVo) {
		System.out.println("gDao > gInsert()");
		
		int count = sqlSession.insert("guestbook.gInsert", gVo);
		
		return count;
	}
	
	//방명록 삭제
	public int gDelete(GuestbookVo gVo) {
		System.out.println("gDao > gDelete()");
		
		int count = sqlSession.delete("guestbook.gDelete", gVo);
		
		return count;
	}
}
