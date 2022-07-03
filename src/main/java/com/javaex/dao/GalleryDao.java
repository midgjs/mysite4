package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//리스트
	public List<GalleryVo> selectList() {
		System.out.println("GallDao > selectlist()");
		
		List<GalleryVo> list  = sqlSession.selectList("gallery.selectList");
		System.out.println(list);
		
		return list;
	}
	
	//업로드
	public int save(GalleryVo galleryVo) {
		System.out.println("GallDao > save()");
		
		return sqlSession.insert("gallery.galleryInsert", galleryVo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
