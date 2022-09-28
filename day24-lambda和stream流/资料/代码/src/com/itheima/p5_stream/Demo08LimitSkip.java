package com.itheima.p5_stream;

import java.util.stream.Stream;

/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public abstract Stream<T> limit(long n):
            获取Stream流对象中的前n个元素,返回一个新的Stream流对象

        public abstract Stream<T> skip(long n):
            跳过Stream流对象中的前n个元素,返回一个新的Stream流对象

            共同的参数:
                long n: 表示数字


    练习:
        步骤一: 只要前7个
        步骤二: 跳过前4个
        步骤三: 遍历输出
 */
public class Demo08LimitSkip {
    public static void main(String[] args) {
        //创建Stream流对象
        Stream<String> s = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃", "爷爷", "蛇精", "蝎子精");

        //步骤一: 只要前7个
        //Stream<String> s2 = s.limit(7);

        //步骤二: 跳过前4个
        //Stream<String> s3 = s2.skip(4);

        //遍历输出
        //s3.forEach(name-> System.out.println(name));

        //链式编程
        s.limit(7).skip(4).forEach(name-> System.out.println(name));
    }
}
