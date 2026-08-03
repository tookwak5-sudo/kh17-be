package com.kh.spring11.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.configuration.StorageProperties;
import com.kh.spring11.dao.AttachDao;
import com.kh.spring11.dto.AttachDto;
import com.kh.spring11.vo.attach.AttachInfoVO;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

@Slf4j
@Service
@Profile("cloud") //spring profile이 cloud일 때 활성화되는 서비스 (application.properties의 profile에서 local이나 cloud입력을 통해 연결 변경
public class AttachServiceCloud implements AttachService {
	@Autowired
	private AttachDao attachDao;
	@Autowired
	private S3Client s3Client;
	@Autowired
	private StorageProperties storageProperties;
	
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
		
		//AWS에 저장 처리
		//[1] AWS S3 전용 클라이언트 생성(이미 만들었으니 패스)
		//[2] 업로드할 파일명과 내용을 준비
		String objectKey = "uploads/"+ attachNo; //업로드 파일명(시퀀스)
		
		//[3] 업로드 요청(PutObjectRequest)을 보낼 요청객체, 응답객체를 준비
		PutObjectRequest request = PutObjectRequest.builder()
					.bucket(storageProperties.getAwsBucket())
					.key(objectKey)
					//(주의) 세미콜론이 있어야 함
					.contentType(attach.getContentType()+"; charset=UTF-8")
				.build();
		
		PutObjectResponse response = s3Client.putObject(
				request, 
				RequestBody.fromBytes(
						//content.getBytes(StandardCharsets.UTF_8) //문자열 → byte[]
						attach.getBytes()//업로드된 파일
						)
		);
			
		log.debug("<AWS S3 업로드 완료>");
		log.debug("Object key ={}", objectKey);
		log.debug("ETag = {}", response.eTag());
		
		return attachNo;
	}


	@Transactional
	@Override
	public void delete(Integer attachNo) {
		if(attachNo == null) return;
		
		//DB정보 삭제
		attachDao.delete(attachNo);	
		
		//AWS에서 파일 삭제 요청 (통신상의 오류가 나지 않으면 실행이 된다고 믿음/ 검증x)
		//삭제 요청은 DeleteObjectReqeust, DeleteObjectResponse로 처리
		String objectKey = "uploads/"+attachNo; //지울 대상의 경로
		DeleteObjectRequest request = DeleteObjectRequest.builder()
					.bucket(storageProperties.getAwsBucket())
					.key(objectKey)
				.build();
		
		DeleteObjectResponse response = s3Client.deleteObject(request);
		
		log.debug("<AWS파일 삭제 완료>");
		log.debug("HTTP status = {}", response.sdkHttpResponse().statusCode());
	}

	@Override
	public AttachInfoVO load(int attachNo) throws IOException {
		return null;
	}

}
