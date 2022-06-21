package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value="/guestbook")
public class GuestbookController {
	
	//필드
	@Autowired
	GuestbookService guestbookService;
	
	//메소드 일반
	
	//addList
	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("Gbc > addList()");
		
		// Service를 통해서 personList(주소)을 가져온다
		List<GuestbookVo> gList = guestbookService.getgList();
		
		// ds 데이터보내기 -->request attribute에 넣는다
		model.addAttribute("gList", gList);
		
		return "guestbook/addList";
	}
	
	//add (@ModelAttribute 사용)
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVo gVo) {
		System.out.println("gController > add()");

		// Service를 통해서 저장한다
		int count = guestbookService.gInsert(gVo);

		// 리다이렉트
		return "redirect:/addlist";
	}
	

	
	
	
	
	
}
