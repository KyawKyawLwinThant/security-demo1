package com.example.mvcsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("tagline"
                ,"Hello Spring Security");
        return "user/home";
    }
    @GetMapping("/admin/delete")
    public String deletePost(Model model){
        model.addAttribute("message","Your are Admin and Delete Page");
        return "admin/delete";
    }
    @GetMapping("/user/posts")
    public String showAllPost(Model model){
        model.addAttribute("message","Show All Posts");
        return "user/posts";
    }
}
