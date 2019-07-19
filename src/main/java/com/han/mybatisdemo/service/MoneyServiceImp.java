package com.han.mybatisdemo.service;

import com.han.mybatisdemo.mapper.UserMapper;
import com.han.mybatisdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MoneyServiceImp implements MoneyService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void transfer(int id) {
//        User user = new User();
//        user.setId(123);
//        user.setMoney(0);
//        userMapper.updateUser(user);
          int i = 1/0;
//        User user1 = new User();
//        user1.setId(555);
//        user1.setMoney(0);
//        userMapper.updateUser(user1);
    }
}
