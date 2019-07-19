package com.han.mybatisdemo.mapper;

import com.han.mybatisdemo.pojo.Oder;
import com.han.mybatisdemo.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface UserMapper {
    public User getUser(int id);
    public List<User> getUserlike(String name);
    public int saveUser(User user);
    public int saveUserReturnId(User user);
    public int updateUser(User user);
    public int deleteUser(int id);

}
