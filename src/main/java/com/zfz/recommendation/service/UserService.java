package com.zfz.recommendation.service;

import com.zfz.recommendation.bean.User;
import com.zfz.recommendation.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserMapper userMappper;

    public void addUser(User user){
        userMappper.addUser(user);
    }
    public boolean selectUserByUsernameAndPassword(User user){
        List<User> users = userMappper.selectUserByUsernameAndPassword(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        return users != null && users.size() == 1;
    }
    public boolean selectUserByUsername(String username){
        List<User> users = userMappper.selectUserByUsername(username);
        return users != null && users.size() == 1;
    }

}
