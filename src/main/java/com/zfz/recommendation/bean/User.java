package com.zfz.recommendation.bean;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
