package com.zfz.recommendation.controller;

import com.zfz.recommendation.bean.ResponseMessage;
import com.zfz.recommendation.bean.User;
import com.zfz.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//(produces = "application/json; charset=utf-8")
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseMessage login(@RequestParam String username,
                                 @RequestParam String password){
        System.out.println("接收到请求 username:"+username + "密码"+ password);
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        boolean b = userService.selectUserByUsernameAndPassword(user);
        System.out.println(b);
        return b ? ResponseMessage.success() : ResponseMessage.error();

    }
    @PostMapping("/register")
    @ResponseBody
    public ResponseMessage register(@RequestParam String username,
                                    @RequestParam String password){
        System.out.println("收到注册请求: " + username +"  密码： "+ password );
        boolean b = userService.selectUserByUsername(username);
        if (b){
            System.out.println("用户名已存在");
            return ResponseMessage.error();
        }else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            if(username != null){
                userService.addUser(user);
                System.out.println("注册成功");
            }
            return ResponseMessage.success();
        }

    }
}
