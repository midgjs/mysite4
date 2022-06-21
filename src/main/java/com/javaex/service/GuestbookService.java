package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	//필드
	@Autowired
	private GuestbookDao guestbookDao;
	
	//메소드 일반
	
	//addList
	public List<GuestbookVo> getgList(){
		System.out.println("PhoneService>getPersonList()");
		
		List<GuestbookVo> gList = guestbookDao.getgList();
		
		return gList;
	}
	
	//방명록 등록
	public int gInsert(GuestbookVo gVo) {
		System.out.println("gService > gInsert()");
		
		int count = guestbookDao.gInsert(gVo);
		
		return count;
	}
	
	
	
	
	
	
	
	
}
