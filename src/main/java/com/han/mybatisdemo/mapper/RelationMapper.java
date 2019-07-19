package com.han.mybatisdemo.mapper;

import com.han.mybatisdemo.pojo.Oder;
import com.han.mybatisdemo.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;


public interface RelationMapper {
    public List<User> getUserWithOder(Map<String,Object> datas);
    @Select(value = " select o.id,o.name,o.userid from `oder` o")
    @Results({
             @Result(property = "id",column = "id"),
             @Result(property = "name",column = "name"),
            @Result(property = "userId",column = "userid"),
             @Result(property = "user",column = "userid",javaType = User.class,one=@One(select = "com.han.mybatisdemo.mapper.UserMapper.getUser",fetchType = FetchType.LAZY) )

    })
    public List<Oder> getOderWithUser(Map<String,Object> datas);
}
