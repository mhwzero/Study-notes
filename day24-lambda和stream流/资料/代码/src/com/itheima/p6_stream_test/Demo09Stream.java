package com.itheima.p6_stream_test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
    Stream流综合练习
    要求:
        1. 第一个队伍只要名字为3个字的成员姓名；
        2. 第一个队伍筛选之后只要前3个人；
        3. 第二个队伍只要姓张的成员姓名；
        4. 第二个队伍筛选之后不要前2个人；
        5. 将两个队伍合并为一个队伍；
        6. 打印整个队伍的姓名信息。

    按照Stream流 + 匿名内部类对象
 */
public class Demo09Stream {
    public static void main(String[] args) {
        List<String> o = new ArrayList<>();
        o.add("迪丽热巴");
        o.add("宋远桥");
        o.add("苏星河");
        o.add("老子");
        o.add("庄子");
        o.add("孙子");
        o.add("洪七公");

        //获取第一个队伍的Stream流对象
        Stream<String> os1 = o.stream();
        //1. 第一个队伍只要名字为3个字的成员姓名；
        Stream<String> os2 = os1.filter(new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return name.length() == 3;
            }
        });
        //2. 第一个队伍筛选之后只要前3个人；
        Stream<String> os3 = os2.limit(3);

        List<String> t = new ArrayList<>();
        t.add("古力娜扎");
        t.add("张无忌");
        t.add("张三丰");
        t.add("赵丽颖");
        t.add("张二狗");
        t.add("张天爱");
        t.add("张三");

        //获取第二个队伍的Stream流对象
        Stream<String> ts1 = t.stream();
        //3. 第二个队伍只要姓张的成员姓名
        Stream<String> ts2 = ts1.filter(new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return name.startsWith("张");
            }
        });
        //4. 第二个队伍筛选之后不要前2个人
        Stream<String> ts3 = ts2.skip(2);

        //5. 将两个队伍合并为一个队伍；
        Stream<String> ots3 = Stream.concat(os3, ts3);
        //6. 打印整个队伍的姓名信息
        ots3.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });

    }
}