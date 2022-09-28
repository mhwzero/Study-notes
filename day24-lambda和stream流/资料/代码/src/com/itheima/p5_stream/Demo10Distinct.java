package com.itheima.p5_stream;

import java.util.stream.Stream;

/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public Stream<T> distinct():
            把调用方法的Stream流对象中元素去重(重复的多个只显示一个),依赖Stream中元素所属类的equals和hashCode方法
 */
public class Demo10Distinct {
    public static void main(String[] args) {

        //创建Stream流对象
        Stream<String> s1 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃","爷爷", "蛇精", "蝎子精",
                                      "大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃","爷爷", "蛇精", "蝎子精");

        Stream<String> s2 = s1.distinct();

        //遍历输出
        s2.forEach(name-> System.out.println(name));
    }
}
