package com.itheima.p5_stream;

import java.util.stream.Stream;

/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    静态方法: 由接口名称调用
        public static <T> Stream<T> concat(Stream<T> a, Stream<T> b):
            把方法参数指定的两个Stream流对象合并成一个Stream流对象返回
 */
public class Demo09Concat {
    public static void main(String[] args) {

        //创建Stream流对象
        Stream<String> s1 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃");
        Stream<String> s2 = Stream.of("爷爷", "蛇精", "蝎子精");

        //把s1和s2合并

        //遍历输出
    }
}
