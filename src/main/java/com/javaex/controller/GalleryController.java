package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	//리스트
	@RequestMapping(value = "/list", method= {RequestMethod.GET, RequestMethod.POST} )
	public String list(Model model) {
		System.out.println("gallController > list()");
		
		List<GalleryVo> list = galleryService.getlist();
		
		model.addAttribute("list", list);
		
		return "gallery/list";
	}
	
	//이미지 업로드
	@RequestMapping(value="/upload", method = {RequestMethod.GET, RequestMethod.POST})
	public String upload(@RequestParam("file") MultipartFile file, Model model) {
		System.out.println("GallCont > upload()");
		System.out.println(file.getOriginalFilename());
		
		String saveName = galleryService.save(file);
		
		model.addAttribute("saveName", saveName);
		
		return "redirect:/list";
		
		
		
		
	}
	
	
}
