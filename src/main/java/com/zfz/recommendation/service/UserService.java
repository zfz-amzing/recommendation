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
    public List<User> selectUserById(Integer userId){
        List<User> users = userMappper.selectUserById(userId);
        return users;
    }
    public boolean selectUserByUsernamePassword(User user){

    }
}
