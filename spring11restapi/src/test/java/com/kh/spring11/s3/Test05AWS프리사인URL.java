package com.kh.spring11.s3;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.configuration.StorageProperties;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

@Slf4j
@SpringBootTest
public class Test05AWS프리사인URL {
	@Autowired
	private S3Client s3Client;
	@Autowired
	private StorageProperties storageProperties;
	
	@Test
	public void test() {
		//AWS에서 파일 불러오기(관리나 제어 가능)
		//1. 실제로 파일을 다운로드 받아서 불러오는 것 (실제 다운받아서 전달 네트워크 2번 발생) - 경우에 따라서(파일을 압축하거나 검증해야할 때)
		//2. 파일에 접근할 수 있는 임시 URL을 발급 받는 것 (Presigned URL 임시 url발급 추가 절차, 만료시간이 정해져있는 URL을 발급 받는 형태로 구현 가능 SpringBoot에서는 실제로 주고받지는 않음) - 권장
		//3. 파일에 접근할 수 있는 영구적인 URL을 발급 받는 것 - 절대 쓰면 안됨
		
		//2번 코드
		String objectKey = "uploads/test/dummy.txt";
		
		GetObjectRequest request = GetObjectRequest.builder()
					.bucket(storageProperties.getAwsBucket())
					.key(objectKey)
					.responseContentDisposition(
						"attachment; filename=s3-dummy.txt"
					)
				.build();
		
		//Presigner 생성 - S3Client를 사용하지 않음 다른 처리방식 사용
		S3Presigner s3Presigner = S3Presigner.builder()
						.region(Region.of(storageProperties.getAwsRegion()))
					.build();
		
		//Request를 Presigner로 한번 더 포장해서 전송
		GetObjectPresignRequest presignRequest = 
				GetObjectPresignRequest.builder()
					.signatureDuration(Duration.ofMinutes(10)) // 보통 10분~15분 권장
					.getObjectRequest(request)
				.build();
		
		//이 코드로 우리가 얻어내고 싶은건 S3가 발급한 임시 다운로드 주소
		String url = s3Presigner.presignGetObject(presignRequest)
					.url().toString();
		
		log.debug("<임시 URL 발급 완료>");
		log.debug("URL = {}", url);
		
	}
}
