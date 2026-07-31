package com.kh.spring11.service;



import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.configuration.StorageProperties;
import com.kh.spring11.dao.AttachDao;
import com.kh.spring11.dto.AttachDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.attach.AttachInfoVO;

@Service
@Profile("local")//spring profile이 local일 때 활성화되는 서비스
public class AttachServiceLocal implements AttachService {
	@Autowired
	private AttachDao attachDao;
	@Autowired
	private StorageProperties storageProperties;
	
	//파일 업로드는 [정보(메타데이터) 저장] → [물리적 저장]
	@Transactional
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
//		File dir = new File("D:/upload");
		File dir = storageProperties.getLocalRoot();
		dir.mkdir();
		File target = new File(dir, String.valueOf(attachNo));
		attach.transferTo(target); //물리저장
		
		return attachNo;
	}

	//Taransaction작업은 DB변경 작업으로 이 경우에는 조회만 하기 때문에 rollback할 데이터가 없기 때문에 한 Transaction내에서 작업을 진행할 필요가 없다
	@Override
	public AttachInfoVO load(int attachNo) throws IOException {
		
//		[1] 정보 조회
		AttachDto attachDto = attachDao.selectOne(attachNo);
		if(attachDto == null) throw new TargetNotfoundException();
		
		//[2] 실물 파일 조회
		File dir = storageProperties.getLocalRoot();
		if(dir.exists() == false) throw new TargetNotfoundException();
		
		File target = new File(dir, String.valueOf(attachDto.getAttachNo()));
		if(target.exists() == false) throw new TargetNotfoundException();
		
		//[3] 실제 파일 데이터를 불러와서 Resource 형태로 포장
		byte[] data = FileCopyUtils.copyToByteArray(target);
		Resource resource = new ByteArrayResource(data);
		
		//[4] 조회 결과를 포장해서 반환
		return AttachInfoVO.builder()
					.attachDto(attachDto)
					.resource(resource)
				.build();
	}
	
	@Transactional
	@Override
	public void delete(Integer attachNo) {
		if(attachNo == null) return;
		
		//DB정보 삭제
		attachDao.delete(attachNo);	
		
		//실물파일 삭제
		//- 저장 위치를 참조하는 객체를 생성
		File dir = storageProperties.getLocalRoot();
		if(dir.exists()) { //디렉터리가 있다면
			File target = new File(dir, String.valueOf(attachNo));
			if(target.exists()) { //파일이 있다면
				target.delete(); //지워!
			}
		}
	}

	
}
