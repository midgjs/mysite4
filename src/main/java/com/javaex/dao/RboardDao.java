package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.RboardVo;

@Repository
public class RboardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//리스트
	public List<RboardVo> selectList() {
		System.out.println("rbdao > getlist()");
		
		List<RboardVo> list  = sqlSession.selectList("rboard.selectList");
		System.out.println(list);
		
		return list;
	}
}
