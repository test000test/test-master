package com.example.registrationform.controller;

import com.example.registrationform.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;

    // Delete user
    @GetMapping("/adminPage/deleteUserById/{id}")
    public String deleteUserById(@PathVariable Long id) {
        adminService.deleteUserById(id);
        return "redirect:/adminPage";
    }
}
