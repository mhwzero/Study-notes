package com.itheima.p5_stream;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

//Map集合的forEach方法
public class Demo05MapForeach {
    public static void main(String[] args) {
        //创建Map集合对象,并添加键值对
        Map<String, String> map = new HashMap<>();
        map.put("邓超", "孙俪");
        map.put("李晨", "范冰冰");
        map.put("刘德华", "柳岩");

        //Map集合有forEach方法
        //双列集合调用forEach方法,传递匿名内部类对象
        System.out.println("--------");
        //双列集合调用forEach方法,传递lambda表达式标准格式
        System.out.println("--------");
        //双列集合调用forEach方法,传递lambda表达式简化格式
    }
}