package com.example.web_login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web_login.entity.User;
import com.example.web_login.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/home2")
    public String about() {
        return "home2";
    }

	

}
