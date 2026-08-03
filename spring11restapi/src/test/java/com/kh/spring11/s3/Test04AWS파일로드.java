package com.kh.spring11.s3;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.configuration.StorageProperties;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

@Slf4j
@SpringBootTest
public class Test04AWS파일로드 {
	@Autowired
	private StorageProperties storageProperties;
	@Autowired
	private S3Client s3Client;
	
	@Test
	public void test() throws IOException {
		//AWS에서 파일 불러오기(관리나 제어 가능)
		//1. 실제로 파일을 다운로드 받아서 불러오는 것 (실제 다운받아서 전달 네트워크 2번 발생) - 경우에 따라서(파일을 압축하거나 검증해야할 때)
		//2. 파일에 접근할 수 있는 임시 URL을 발급 받는 것 (Presigned URL 임시 url발급 추가 절차, 만료시간이 정해져있는 URL을 발급 받는 형태로 구현 가능 SpringBoot에서는 실제로 주고받지는 않음) - 권장
		//3. 파일에 접근할 수 있는 영구적인 URL을 발급 받는 것 - 절대 쓰면 안됨
		
		//1번 코드
		String objectKey = "uploads/test/dummy.txt"; //Test02에서 올려놓은 파일
		
		GetObjectRequest request = GetObjectRequest.builder()
				.bucket(storageProperties.getAwsBucket())
				.key(objectKey)
				.build();
		
		
		//s3Client.getObject(request); //이렇게만 하면 메모리로 받는 것(ResponseInputStream)
		
		//byte로 추출 (in-memory 방식)
		ResponseInputStream<GetObjectResponse> stream = s3Client.getObject(request);
		GetObjectResponse response = stream.response();
		
		log.debug("Content-Type = {}", response.contentType());
		log.debug("Content-Length = {}", response.contentLength());
		log.debug("ETag = {}", response.eTag());
		
		byte[] data = stream.readAllBytes();
		//문자열로 복원(파일마다 다름)
		String str = new String(data, "UTF-8");
		log.debug("str = {}", str);
		
		stream.close();
	}
}
