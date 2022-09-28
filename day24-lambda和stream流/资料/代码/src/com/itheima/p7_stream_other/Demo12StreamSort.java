package com.itheima.p7_stream_other;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo12StreamSort {
    public static void main(String[] args) {
        //创建List集合对象,并添加数据
        List<Person> list = new ArrayList<>();
        Collections.addAll(list,
                new Person("张三", 18),
                new Person("李四", 38),
                new Person("王五", 28));

        //借助Stream流对象,对List集合中的Person对象按照age从小到大排序
        //获取List集合对象的Stream流对象

        //使用Stream流对象调用sorted方法,指定排序规则,传递匿名内部类对象

        //调用sorted方法,传递的是lambda表达式的简化格式

        list = list.stream().sorted((p1, p2) -> p2.getAge() - p1.getAge()).collect(Collectors.toList());
        for (Person person : list) {
            System.out.println(person);
        }
    }
}