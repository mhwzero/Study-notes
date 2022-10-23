package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/user")//可以标在方法上,也可以标注在类上;如果说标注在类上,代表所有方法上的@RequestMapping共用一段路径
@Controller //将当前对象放入Spring容器
public class UserController {

    //处理请求的方法
    @RequestMapping("/demo1") //为当前方法指定一个访问路径
    @ResponseBody// 它的作用就是将当前方法的返回值转换成json返回(如果给的结果无法转成json,就原样返回)
    public User demo1(String name, Integer age) {
        //1. 封装对象
        User user = new User(name, age);

        //2. 返回对象
        return user;
    }

    //value : 用于给当前方法指定访问路径, 支持数组的写法,代表可以给一个方法绑定多个路径
    @RequestMapping(value = {"/demo2", "/demo3"})
    @ResponseBody// 它的作用就是将当前方法的返回值转换成json返回(如果给的结果无法转成json,就原样返回)
    public String demo2() {
        System.out.println("请求到达了后台");
        return "ok";
    }

    //method : 限制当前方法可以接收的请求类型, 支持数组的写法,代表可以同时接收多种请求方式; 如果method属性省略., 代表可以接收所有类型请求
    @RequestMapping(value = "/demo4", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String demo4() {
        System.out.println("请求到达了后台");
        return "ok";
    }

}
