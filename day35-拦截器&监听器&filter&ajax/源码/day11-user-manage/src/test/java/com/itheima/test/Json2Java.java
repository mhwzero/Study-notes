package com.itheima.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Json2Java {

    //对象转换为json
    @Test
    public void test1() throws JsonProcessingException {
        //1. 准备一个json串
        String json = "{\"id\":\"1\",\"name\":\"张三\",\"sex\":\"男\",\"age\":18,\"address\":\"北京\",\"qq\":\"123\",\"email\":\"123@qq.com\"}";

        //2. json转对象
        User user = new ObjectMapper().readValue(json, User.class);
        System.out.println(user);
    }


    //集合转换为json
    @Test
    public void test2() throws JsonProcessingException {
        //1. 准备一个字符串
        String json = "[{\"id\":\"1\",\"name\":\"张三\",\"sex\":\"男\",\"age\":18,\"address\":\"北京\",\"qq\":\"123\",\"email\":\"123@qq.com\"},{\"id\":\"2\",\"name\":\"李四\",\"sex\":\"男\",\"age\":18,\"address\":\"北京\",\"qq\":\"123\",\"email\":\"123@qq.com\"}]";

        //2. json转对象
        List list = new ObjectMapper().readValue(json, List.class);
        System.out.println(list);
    }


}
