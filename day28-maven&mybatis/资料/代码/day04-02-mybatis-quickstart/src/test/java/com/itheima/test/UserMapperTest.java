package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.mapper.UserMapperImpl;
import org.junit.Test;

import java.util.Date;

public class UserMapperTest {

    @Test
    public void testSave() {
        //0. 准备一个User对象
        User user = new User();
        user.setName("黑马1");
        user.setPassword("1231");
        user.setBirthday(new Date());
        user.setEmail("1231@itcast.cn");

        //1. 得到UserMapper的对象
        UserMapper userMapper = new UserMapperImpl();
        userMapper.save(user);

    }
}
