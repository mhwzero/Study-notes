package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;


@RequestMapping("/user")//可以标在方法上,也可以标注在类上;如果说标注在类上,代表所有方法上的@RequestMapping共用一段路径
//@Controller //将当前对象放入Spring容器
//@ResponseBody//
@RestController // 一个相当于@Controller  @ResponseBody
public class UserController {

    //处理请求的方法
    @RequestMapping("/demo1") //为当前方法指定一个访问路径
    //@ResponseBody// 它的作用就是将当前方法的返回值转换成json返回(如果给的结果无法转成json,就原样返回)
    public User demo1(String name, Integer age) {
        //1. 封装对象
        User user = new User(name, age, null);

        //2. 返回对象
        return user;
    }

    //value : 用于给当前方法指定访问路径, 支持数组的写法,代表可以给一个方法绑定多个路径
    @RequestMapping(value = {"/demo2", "/demo3"})
    //@ResponseBody// 它的作用就是将当前方法的返回值转换成json返回(如果给的结果无法转成json,就原样返回)
    public String demo2() {
        System.out.println("请求到达了后台");
        return "ok";
    }

    //method : 限制当前方法可以接收的请求类型, 支持数组的写法,代表可以同时接收多种请求方式; 如果method属性省略., 代表可以接收所有类型请求
    @RequestMapping(value = "/demo4", method = {RequestMethod.GET, RequestMethod.POST})
    //@ResponseBody
    public String demo4() {
        System.out.println("请求到达了后台");
        return "ok";
    }

    //接收参数--简单类型
    //需要保证前端传递的参数名称跟方法的形参名称一致
    //在SpringMvc框架的底层,对于一些简单的类型参数,存在类型转换机制
    @RequestMapping("/demo5")
    //@ResponseBody
    public String demo5(String name, Integer age) {
        System.out.println(name + ":" + age);
        return "ok";
    }

    //接收参数--对象类型
    //需要保证前端传递的参数名称跟实体类的属性名称一致
    @RequestMapping("/demo6")
    //@ResponseBody
    public String demo6(User user) {
        System.out.println(user);
        return "ok";
    }

    //接收参数--数组类型
    //需要保证前端传递的参数名称跟方法中的数组形参名称一致
    //如果前台提交的参数中存在键一样的情况[names=张三&names=李四],后台接收时:
    //如果使用字符串接收,会得到一个使用分割的字符串   demo7(String names)--->张三,李四
    //如果使用数组接收,会得到一个数组 demo7(String[] names)   ---->[张三, 李四]
    @RequestMapping("/demo7")
    //@ResponseBody
    public String demo7(String[] names) {
        System.out.println(Arrays.toString(names));
        return "ok";
    }

    //接收参数--日期类型
    //注解: 在参数前面添加@DateTimeFormat(pattern = "转换规则")
    @RequestMapping("/demo8")
    // @ResponseBody
    public String demo8(@DateTimeFormat(pattern = "yyyy-MM-dd") Date myDate) {
        System.out.println(myDate);
        return "ok";
    }

    //接收参数--日期类型
    //配置:1 自定义一个类型转换器类,完成转换方法  2. 转换器的类交给Springmvc
    @RequestMapping("/demo9")
    //@ResponseBody
    public String demo9(Date myDate) {
        System.out.println(myDate);
        return "ok";
    }


    //在方法形参中直接接收MultipartFile类型的文件
    //细节1: 接收参数类型必须是MultipartFile
    //细节2: 参数的名称必须跟前端表单中文件上传框name一致
    @RequestMapping("/demo10")
    //@ResponseBody
    public String demo10(MultipartFile picture) throws IOException {
        System.out.println(picture);
        //接收到文件之后, 保存到目录下
        //1. 设置文件名(唯一)
        //UUID.randomUUID().toString()  生成唯一字符串
        String fileName = UUID.randomUUID().toString() + picture.getOriginalFilename();

        //2. 设置新文件
        File file = new File("D:/upload/" + fileName);

        //3. 上传
        picture.transferTo(file);

        return "ok";
    }

/*    //接收List
    //需要将集合参数包装到一个实体中才可以
    @RequestMapping("/demo11")
    @ResponseBody
    public String demo11(User user) {
        for (String s : user.getHobby()) {
            System.out.println(s);
        }
        return "ok";
    }*/


    //@RequestParam
    //场景1: 标注在形参之前, 用于指定当前参数要接收前端哪个变量的值
    //场景2: 标注在形参之前, 用于给当前参数设置默认值
    //场景3: 用于接收一个List集合
    @RequestMapping("/demo12")
    //@ResponseBody
    public String demo12(@RequestParam("usERName") String username,
                         @RequestParam(defaultValue = "123456") String password) {

        System.out.println("username=" + username + ",password=" + password);
        return "ok";
    }

    //接收List
    @RequestMapping("/demo11")
    //@ResponseBody
    public String demo11(@RequestParam("hobby") List<String> hobby) {
        for (String s : hobby) {
            System.out.println(s);
        }
        return "ok";
    }

    //只有前端是通过在请求地址后面用?拼接上来的参数,后台接收方式都是一致的
    @RequestMapping("/demo13")
    //@ResponseBody
    public String demo13(String name, Integer age) {
        System.out.println(name + ":" + age);
        return "ok";
    }


    //@RequestBody 放在参数之前,而且要求这个参数必须是对象类型或者是一个Map集合
    //作用就是将请求体中json数据转换成指定的Java对象
    @RequestMapping("/demo14")
    //@ResponseBody
    public String demo14(@RequestBody User user) {
        System.out.println(user);
        return "ok";
    }

//    @RequestMapping("/demo14")
//    @ResponseBody
//    public String demo14(@RequestBody Map<String,Object> map) {
//        System.out.println(map);
//        return "ok";
//    }


    @RequestMapping("/demo15")
    public void demo15(Integer type) {
        if (type == 1) {
            String a = null;
            a.length();
        } else if (type == 2) {
            int i = 1 / 0;
        } else {
            String[] arr = new String[2];
            arr[10] = "haha";
        }
    }


    @RequestMapping("/demo16")
    public String demo16() {
        System.out.println("请求到达了controller");
        return "OK";
    }

}



















