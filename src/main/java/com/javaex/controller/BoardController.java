package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//필드
	@Autowired
	private BoardService boardService;
	
	//메소드 일반
	//리스트(리스트+검색)
	@RequestMapping(value = "/list3", method = { RequestMethod.GET, RequestMethod.POST})
	public String list3(Model model,
						@RequestParam(value="keyword", required=false, defaultValue="") String keyword) {
		System.out.println("bController > list3()");
		
		List<BoardVo> bList = boardService.getbList3(keyword);
		model.addAttribute("bList", bList);
		
		return "board/list3";
	}
	
	//리스트(리스트만)
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("bController > list()");
		
		// Service를 통해서 list(주소)을 가져온다
		List<BoardVo> bList = boardService.getbList();
		
		// ds 데이터보내기 -->request attribute에 넣는다
		model.addAttribute("bList", bList);
		
		return "board/list";
	}
	
	//리스트2?
	@RequestMapping(value = "/search", method= {RequestMethod.GET, RequestMethod.POST})
	public String search(@RequestParam("keyword") String keyword, Model model) {
		System.out.println("bController > search()");
		System.out.println(keyword);
		
		List<BoardVo> bList = boardService.getbList2(keyword);
		model.addAttribute("bList", bList);
		
		return "board/list2";
		
	}
	
	//글쓰기 폼
	@RequestMapping(value= "/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("bController > writeForm()");
		
		return "board/writeForm";
	}
	
	//글쓰기
	@RequestMapping(value= "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("bController > write()");
		
		// Service를 통해서 저장한다
		boardService.write(boardVo);

		return "redirect:/board/list";
	}
	
	//읽기
	@RequestMapping(value = "/read", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(Model model, @RequestParam("no")int no) {
		System.out.println("bC > read()");
		
		//조회수 -> 나중에
		//게시글 정보가져오기
		BoardVo boardVo = boardService.getBoard(no);
		model.addAttribute("BoardVo", boardVo);
		
		return "board/read";
		
	}
	
	
	
	
	
	
}
