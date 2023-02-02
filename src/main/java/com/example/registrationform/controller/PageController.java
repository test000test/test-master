package com.example.registrationform.controller;

import com.example.registrationform.entity.User;
import com.example.registrationform.service.AdminService;
import com.example.registrationform.service.PostService;
import com.example.registrationform.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
@Slf4j
public class PageController {
    private final AdminService adminService;
    private final UserService userService;
    private final PostService postService;

    // Index page
    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("users", user);
        model.addAttribute("posts", postService.showAllPosts());
        return "index";
    }

    // Registration page
    @GetMapping("/registrationPage")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registrationPage";
    }

    // Admin page
    @GetMapping("/adminPage")
    public String adminPage(Model model) {
        model.addAttribute("allUsers", adminService.showAllUsers());
        return "adminPage";
    }

    // User page
    @GetMapping("/userPage/{id}")
    public String userPage(@PathVariable Long id,
                           @AuthenticationPrincipal User user,
                           Model model) {
        userService.getUserId(id);
        model.addAttribute("user", user);
        model.addAttribute("posts", postService.showAllPostsByAuthorId(id));
        return "userPage";
    }
}
