package com.zfz.recommendation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping("/detail")
    public String detail(){
        return "detail";
    }
    @RequestMapping("/search")
    public String search(){
        return "search";
    }
}
