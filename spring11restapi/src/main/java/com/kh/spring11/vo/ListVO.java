package com.kh.spring11.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ListVO {
	private List list;//데이터 목록 //List<>아무것도 표기하지않으면 성능이 느려짐 but React에서 할거기 때문에 큰 문제 x 여기선 담아주기만 할 뿐
	private boolean last;//마지막인지
}
