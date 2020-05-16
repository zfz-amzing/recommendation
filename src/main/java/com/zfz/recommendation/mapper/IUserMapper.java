package com.zfz.recommendation.mapper;

import com.zfz.recommendation.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface IUserMapper extends Serializable {

     void addUser(User user);
     List<User> selectUserByUsernameAndPassword(User user);
     List<User> selectUserByUsername(String username);
     
}
