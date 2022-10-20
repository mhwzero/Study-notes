package com.itheima.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java2Json {

    //对象转换为json
    @Test
    public void test1() throws JsonProcessingException {
        //1. 准备一个对象
        User user = new User("1", "张三", "男", 18, "北京", "123", "123@qq.com");

        //2. 对象转json
        String json = new ObjectMapper().writeValueAsString(user);
        System.out.println(json);
    }

    //集合转换为json
    @Test
    public void test2() throws JsonProcessingException {
        //1. 准备一个对象对象
        List<User> userList = new ArrayList<User>();
        userList.add(new User("1", "张三", "男", 18, "北京", "123", "123@qq.com"));
        userList.add(new User("2", "李四", "男", 18, "北京", "123", "123@qq.com"));

        //2. 对象转json
        String json = new ObjectMapper().writeValueAsString(userList);
        System.out.println(json);
    }


    //map转换为json
    @Test
    public void test3() throws JsonProcessingException {
        //1. 准备一个对象对象
        Map<String, String> map = new HashMap<String, String>();
        map.put("name","张三");
        map.put("sex","男");

        //2. 对象转json
        String json = new ObjectMapper().writeValueAsString(map);
        System.out.println(json);
    }
}
