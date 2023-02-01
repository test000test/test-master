package com.example.registrationform.repository;

import com.example.registrationform.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByAuthorId (Long id);
}
