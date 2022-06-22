package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//필드
	@Autowired
	private BoardService boardService;
	
	//메소드 일반
	//리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("bController > list()");
		
		// Service를 통해서 list(주소)을 가져온다
		List<BoardVo> bList = boardService.getbList();
		
		// ds 데이터보내기 -->request attribute에 넣는다
		model.addAttribute("bList", bList);
		
		return "board/list";
	}
	
	//글쓰기 폼
	@RequestMapping(value= "/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("bController > writeForm()");
		
		return "writeForm";
	}
	
	
}
