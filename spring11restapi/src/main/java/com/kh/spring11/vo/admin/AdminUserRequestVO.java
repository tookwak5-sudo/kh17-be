package com.kh.spring11.vo.admin;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name= "[관리자] 회원정보 복합검색 요청")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserRequestVO {
	private String accountId;
	private String accountNickname;
	private String accountContact;
	private String accountEmail;
	private String accountAddress;
	
	private String accountBirthBegin, accountBirthEnd;
	
	private String accountJoinBegin, accountJoinEnd;
	
	private String accountLoginBegin, accountLoginEnd;
	
	private Integer accountPointMin, accountPointMax;
	
	private Set<String> accountLevels;
	
	private String accountBlock;
	
//	private List<String> orders;
//	private String lastAccountId;
//	private Integer size;
}
