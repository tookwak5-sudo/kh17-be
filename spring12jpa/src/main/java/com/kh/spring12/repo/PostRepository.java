package com.kh.spring12.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.spring12.entity.post.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
