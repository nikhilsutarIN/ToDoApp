package com.github.nikhilsutarIN.todoapp.controller;


import com.github.nikhilsutarIN.todoapp.entity.User;
import com.github.nikhilsutarIN.todoapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String addUser(@ModelAttribute User user, HttpSession session) {
        User savedUser = userService.addUser(user);

        if(!ObjectUtils.isEmpty(savedUser)){
            session.setAttribute("message", "Account created successfully!");
        } else {
            session.setAttribute("error", "Account creation failed!");
        }

        return "redirect:/signin";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

}
