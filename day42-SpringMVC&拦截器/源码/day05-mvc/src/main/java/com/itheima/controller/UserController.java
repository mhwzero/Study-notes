package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    //保存
    //@RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")//指定接收post请求
    public User saveUser(@RequestBody User user) {
        //1. 打印
        System.out.println(user);
        //2. 年龄+1
        user.setAge(user.getAge() + 1);
        //3. 返回user
        return user;
    }

    //查询所有
    //@RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")//指定接收get请求
    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        list.add(new User(1, "张三", 18));
        list.add(new User(2, "李四", 19));
        return list;
    }


    //@PathVariable("id") 标注在方法的参数之前, 用于获取请求路径中得值赋值给参数
    //当{}的值跟方法参数一样的时候, 注解@PathVariable的value属性可以不写
    //注意的是占位符:{}    不是#{}    ${}   ()
    //根据id查询
    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Integer myId) {
        System.out.println("id的值:" + myId);
        return new User(myId, "张三", 18);
    }


    //@GetMapping("/user/name/{name}/age/{age}")
    @GetMapping("/user/{name}/{age}")
    public User findByCondition(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age
    ) {

        return new User(1, name, age);
    }


}
