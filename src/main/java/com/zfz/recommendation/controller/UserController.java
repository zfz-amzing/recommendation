package com.zfz.recommendation.controller;

import com.zfz.recommendation.bean.ResponseMessage;
import com.zfz.recommendation.bean.User;
import com.zfz.recommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
//(produces = "application/json; charset=utf-8")
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseMessage login(@RequestParam String username,
                                 @RequestParam String password,
                                 HttpSession session){

        User user = new User();
        String mdPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println("接收到请求 username:"+username + "密码"+ password);
        user.setPassword(mdPassword);
        user.setUsername(username);
        User user1 = userService.selectUserByUsernameAndPassword(user);
        System.out.println(user1);
        if (user1 == null)
            return ResponseMessage.error();
        else
            return ResponseMessage.success().addObject("user",user1);

    }
    @PostMapping("/register")
    @ResponseBody
    public ResponseMessage register(@RequestParam String username,
                                    @RequestParam String password){
        System.out.println("收到注册请求: " + username +"  密码： "+ password );
        boolean b = userService.selectUserByUsername(username);
        if (!b){
            System.out.println("用户名已存在");
            return ResponseMessage.error();
        }else {
            String mdPassword = DigestUtils.md5DigestAsHex(password.getBytes());
            User user = new User();
            user.setUsername(username);
            user.setPassword(mdPassword);
            if(username != null){
                userService.addUser(user);
                System.out.println("注册成功");
            }
            return ResponseMessage.success();
        }

    }
}
