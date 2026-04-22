package com.kh.spring09.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.AttachDao;
import com.kh.spring09.dto.AttachDto;


//서비스 : 하나의 단위작업을 구현하기 위한 도구
@Service
public class AttachService {
	@Autowired
	private AttachDao attachDao;
	
	//서비스는 메소드의 정해진 형태가 없다
	public void save(MultipartFile attach) throws Exception, IOException {
		//파일 업로드는 2단계로 진행된다 (DB와 실물파일 처리)
				int attachNo = attachDao.sequence(); // 파일번호 생성
				AttachDto attachDto = new AttachDto(); // DB에 저장하기 위한 객체 생성
				attachDto.setAttachNo(attachNo); //번호 설정
				attachDto.setAttachName(attach.getOriginalFilename()); //업로드된 파일명 설정
				attachDto.setAttachType(attach.getContentType());//파일 유형 설정
				attachDto.setAttachSize(attach.getSize());// 파일 크기 설정
				attachDao.insert(attachDto);
				
				//업로드된 파일을 저장하는 코드
				File dir = new File("D:/upload");
				dir.mkdirs(); //디렉토리 생성명령
				//File target = new File(dir, attach.getOriginalFilename()); // 올린이름으로 올려서 같은 이름으로 올리면 덮어씌워짐
				File target = new File(dir, String.valueOf(attachNo));//시퀀스 번호로 실제 저장
				attach.transferTo(target);
	}
}
