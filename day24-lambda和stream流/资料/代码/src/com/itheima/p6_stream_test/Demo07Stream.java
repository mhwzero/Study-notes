package com.itheima.p6_stream_test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
    需求:
        1. 首先筛选所有姓张的人；
        2. 然后筛选名字有三个字的人；
        3. 最后进行对结果进行打印输出。

    通过Stream流 + lambda表达式标准格式
    简化格式: 自己写
 */
public class Demo07Stream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        //获取List集合对象对应的Stream流对象
        Stream<String> s = list.stream();

        //1. 首先筛选所有姓张的人；
        Stream<String> s2 = s.filter((String name) -> {
            return name.startsWith("张");//姓张的人
        });
        //2. 然后筛选名字有三个字的人；
        Stream<String> s3 = s2.filter((String name) -> {
            return name.length() == 3;//名字有三个字的人
        });

        //3. 最后进行对结果进行打印输出。
        s3.forEach((String name) -> {
            System.out.println(name);
        });
    }
}