package com.itheima.p7_stream_other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo10StreamCollect {
    public static void main(String[] args) {
        //创建List集合对象,并添加数据
        List<Person> list = new ArrayList<>();
        Collections.addAll(list,
                new Person("张三", 18),
                new Person("李四", 38),
                new Person("王五", 28));

        //获取List集合对象的Stream流对象
        //利用map方法,把每个Person对象的年龄增加两岁后,存储到新的Stream流对象中
        //利用collect方法把Stream流对象,转换成List集合对象
        list = list.stream()
                .map(person->{
                    person.setAge(person.getAge()+2);
                    return person;
                }).collect(Collectors.toList());
        //遍历新的List集合
        for (Person person : list) {
            System.out.println(person);
        }
    }
}