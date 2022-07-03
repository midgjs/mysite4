package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDao galleryDao;
	
	//리스트
	public List<GalleryVo> getlist() {
		System.out.println("GallService > getlist()");
		
		List<GalleryVo> list = galleryDao.selectList();
		
		return list;
	}	
	
	//업로드
	//파일 하드디스크 저장, 파일 정보(DB저장) 추출
	public String save(MultipartFile file) {
		System.out.println("gallService > save()");
		
		System.out.println(file.getOriginalFilename());
		
		String saveDir = "C:\\javastudy\\upload";
		
		//(1)파일 정보(DB저장) 추출
		//오리지널파일명, 저장경로+파일(랜덤)명, 파일사이즈
		
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		//저장파일명
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		
		//파일경로(디렉토리+저장파일명)
		String filePath = saveDir + "\\" + saveName;
		
		//파일사이즈
		long fileSize = file.getSize();
		
		//Vo로 묶기
		GalleryVo galleryVo = new GalleryVo(filePath, orgName, saveName, fileSize);
		System.out.println(galleryVo);
		
		//-->Dao Db저장
		galleryDao.save(galleryVo);
		
		
		
		//(2)파일저장
		try {
			byte[] fileData = file.getBytes();
			
			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
			
		}
		
		return saveName;
		
		
		
		
	}
	
	
	
}
