package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	//필드
	@Autowired
	private SqlSession sqlSession;
	//생성자- 디폴트 생성자
	
	//메소드 gs
	
	//메소드 일반
	
	//회원정보 수정
	public int update(UserVo userVo) {
		System.out.println("UserDao.update()");
		
		int count = sqlSession.update("user.update", userVo);
				
		return count;
	}
	
	//회원정보 가져오기(수정폼)
	public UserVo modifyUser(int no) {
		System.out.println("UserDao.modifyUser()");
		
		UserVo userVo = sqlSession.selectOne("user.modifyUser", no);
		
		return userVo;
	}
	
	//회원정보 가져오기(로그인)
	public UserVo getUser(UserVo userVo) {
		System.out.println("UserDao.getUser()");
		
		UserVo authUser = sqlSession.selectOne("user.getUser", userVo);
		
		return authUser;
	}
	
	
	//회원정보 저장(회원가입)
	public int userInsert(UserVo userVo) {
		System.out.println("UserDao.userInsert()");
		
		int count = sqlSession.insert("user.insert", userVo);
		
		return count;
	}
	
}