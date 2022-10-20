package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    //查询方法
    @Select("select * from user where username = #{username} and password = #{password}")
    User findUser(@Param("username") String username, @Param("password") String password);
}
