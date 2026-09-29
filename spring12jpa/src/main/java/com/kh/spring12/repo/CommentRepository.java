package com.kh.spring12.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.spring12.entity.post.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
