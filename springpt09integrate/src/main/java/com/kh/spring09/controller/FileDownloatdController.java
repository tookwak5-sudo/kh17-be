package com.kh.spring09.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.AttachDao;
import com.kh.spring09.dto.AttachDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/download")
public class FileDownloatdController {
		
	@Autowired
	private AttachDao attachDao;
	
	//레거시 다운로드 JAVA EE의 객체들을 이용하여 다운로드를 설정
	@RequestMapping("/legacy")
	public void legacy(@RequestParam int attachNo, HttpServletResponse response) throws IOException {
		//목표: 전달된 attachNo에 해당하는 정보를 불러와서 파일과 조합하여 사용자에게 전송
		
		//[1] 정보조회
		AttachDto attachDto = attachDao.selectOne(attachNo);
		if(attachDto == null) throw new TargetNotfoundException("존재하지 않는 파일");
		
		//[2] 파일조회
		File dir = new File("D:/upload"); // 파일이 모여있는 폴더
		File target = new File(dir, String.valueOf(attachNo)); // 다운로드 시킬 파일
		if(!target.isFile()) throw new TargetNotfoundException("존재하지 않는 파일");
		
		//[3] 사용자에게 알려줄 다운로드 정보(헤더) 설정 (무조건  String만 설정 가능)
		response.setHeader("Content-Encoding", "UTF-8");
		response.setHeader("Content-Type", attachDto.getAttachTypeString()); //파일유형
		response.setHeader("Content-length", String.valueOf(attachDto.getAttachSize())); // 파일크기
		
		StringBuffer sb = new StringBuffer();
		sb.append("attachment");
		sb.append(";");
		sb.append("fileName=");
		sb.append("\""); // 띄어쓰기는 해결  한글만 해결하면됨
		//sb.append(attachDto.getAttachName());
		sb.append(URLEncoder.encode(attachDto.getAttachName(), "UTF-8"));
		sb.append("\"");
		response.setHeader("Content-Disposition", sb.toString()); //이름과 행동방식(무조건 다운)
				
		//[4] 실제 파일을 불러와서 사용자에게 전송
		FileInputStream stream = new FileInputStream(target);
		byte[] buffer = new byte[1024];
		
		while(true) {
			int size = stream.read(buffer); // 읽어!
			if(size== -1) break; //EOF면 나가!
			response.getOutputStream().write(buffer, 0, size);  //내보내!
		}
		
		stream.close();
		
//		response.getOutputStream().write(파일데이터);
	}

}
