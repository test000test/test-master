package com.example.registrationform.controller;

import com.example.registrationform.entity.Post;
import com.example.registrationform.entity.User;
import com.example.registrationform.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    // Add post
    @PostMapping("/createPost")
    public String addPost(@AuthenticationPrincipal User user, Post post) {
        post.setAuthor(user);
        postService.addPost(post);
        return "redirect:/";
    }
}
