package com.example.registrationform.service;

import com.example.registrationform.entity.Post;
import com.example.registrationform.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // Add post
    public void addPost(Post post) {
        postRepository.save(post);
    }

    // Show all posts
    public List<Post> showAllPosts() {
        return postRepository.findAll();
    }

    // Show posts by author id
    public List<Post> showAllPostsByAuthorId(Long id) {
        return postRepository.findPostsByAuthorId(id);
    }
}
