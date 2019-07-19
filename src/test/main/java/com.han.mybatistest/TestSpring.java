package com.han.mybatistest;

import com.han.mybatisdemo.mapper.UserMapper;
import com.han.mybatisdemo.service.MoneyService;
import com.han.mybatisdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
//这里只需要加载spring配置
@ContextConfiguration({"classpath:spring.xml"})
//@Rollback(value = false)
@Transactional
public class TestSpring {

    @Autowired
    UserService userMapper;

    @Autowired
    MoneyService moneyService;

    @Test
    public void tetLaunchSpring(){
      userMapper.getUser(123);
    }

    @Test
    public void tetTrasaction(){
        moneyService.transfer(122);
    }

}
