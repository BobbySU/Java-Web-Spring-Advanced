package com.example.ColaDistributionApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/register")
    public String getRegister(){
        return "register";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
}
