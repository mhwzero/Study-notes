package com.itheima.p5_stream;

import java.util.stream.Stream;

/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public abstract long count(): 获取Stream流对象中的元素的个数

        注意:
            此方法没有参数,调用时不需要传递参数,根不能再写lambda表达式了

 */
public class Demo07Count {
    public static void main(String[] args) {
        //创建Stream流对象
        Stream<String> s = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃", "爷爷", "蛇精", "蝎子精");

        //获取Stream流对象中的元素的个数


    }
}
