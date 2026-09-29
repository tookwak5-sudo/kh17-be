package com.kh.spring12.post;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.entity.post.Comment;
import com.kh.spring12.entity.post.Post;
import com.kh.spring12.error.TargetNotfoundException;
import com.kh.spring12.repo.CommentRepository;
import com.kh.spring12.repo.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CommentInsertTest02 {
	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	@Test
	public void test() {
		
		long postNo = 1L;
		
		Post post = postRepository.findById(postNo).orElseThrow(()->new TargetNotfoundException());
		
		Comment result = commentRepository.save(
			Comment.builder()
				.commentContent("댓글 테스트입니다!")
				.post(post)
			.build()
		);
		
		System.out.println(result);
	}
}
