package com.kh.spring11.service;



import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.dao.AttachDao;
import com.kh.spring11.dto.AttachDto;

@Service
@Profile("local")//spring profile이 local일 때 활성화되는 서비스
public class AttachServiceLocal implements AttachService {
	@Autowired
	AttachDao attachDao;
	
	//파일 업로드는 [물리적 저장] → [정보(메타데이터) 저장]
	@Override
	public int save(MultipartFile attach) throws IllegalStateException, IOException {
		int attachNo = attachDao.sequence(); //번호 생성
		attachDao.insert(AttachDto.builder()
					.attachNo(attachNo)
					.attachName(attach.getOriginalFilename())
					.attachType(attach.getContentType())
					.attachSize(attach.getSize())
				.build());//DB저장
		
		//물리적 파일 저장 위치
		File dir = new File("D:/upload");
		dir.mkdir();
		File target = new File(dir, String.valueOf(attachNo));
		attach.transferTo(target); //물리저장
		
		return attachNo;
	}

	@Override
	public void delete(int attach) {
		
	}
	
}
