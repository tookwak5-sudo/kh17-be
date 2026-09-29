package com.kh.spring12.entity.post;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //jpa가 관리하는 얘다
@Table(name = "comment")
@SequenceGenerator(
		name = "comment_seq",
		sequenceName = "comment_seq",
		initialValue = 1, allocationSize = 1
)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Comment {
	@Id @GeneratedValue(generator = "comment_seq")
	private Long commentNo;
	@Column(nullable = false) @Lob
	private String commentContent;
	@CreationTimestamp
	private LocalDateTime commentWtime;
	@UpdateTimestamp
	private LocalDateTime commentEtime;
	
	//연결
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "post_no")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Post post;
}
