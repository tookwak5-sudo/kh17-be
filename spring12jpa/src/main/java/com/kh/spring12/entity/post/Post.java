package com.kh.spring12.entity.post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //jpa가 관리하는 얘다
@Table(name = "post")
@SequenceGenerator(
		name = "post_seq",
		sequenceName = "post_seq",
		initialValue = 1, allocationSize = 1
)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Post {
	@Id @GeneratedValue(generator = "post_seq")
	private Long postNo;
	@Column(nullable = false) @Lob
	@ToString.Exclude
	private String postContent;
	@Column(nullable = false)
	private String postTitle;
	@Column
	private Long postReadcount;
	@CreationTimestamp
	private LocalDateTime postWtime;
	@UpdateTimestamp
	private LocalDateTime postEtime;
	
	//연결
	@OneToMany( 
			mappedBy = "post",
			cascade = {CascadeType.REMOVE},
			fetch = FetchType.EAGER, //즉시 조회
			orphanRemoval = true
	)
	@EqualsAndHashCode.Exclude
	@Builder.Default
	private List<Comment> comments = new ArrayList<>();
}
