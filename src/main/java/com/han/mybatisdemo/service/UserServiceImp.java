package com.han.mybatisdemo.service;

import com.han.mybatisdemo.mapper.UserMapper;
import com.han.mybatisdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }
}
