package com.example.registrationform.controller;

import com.example.registrationform.entity.User;
import com.example.registrationform.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;

    // Login form
    @PostMapping("/")
    public String loginForm(@RequestParam String username) {
        userService.loadUserByUsername(username);
        return "redirect:/";
    }

    // Registration form
    @PostMapping("/registrationForm")
    public String registrationForm(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registrationPage";
        }
        if (!userService.registrationUser(user)) {
            model.addAttribute("usernameError", "Уже есть такой пользователь");
            return "registrationPage";
        }
        userService.registrationUser(user);
        return "redirect:/";
    }
}
