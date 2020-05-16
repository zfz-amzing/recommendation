package com.zfz.recommendation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/")
    public String index(){
        return "showBooks";
    }
    @RequestMapping("/userRegister")
    public String register(){
        return "register";
    }
}
