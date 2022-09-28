package com.itheima.p7_stream_other;

import com.itheima.pojo.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    对流操作完成之后,如果需要将结果进行收集,例如获取对应的集合/数组等,如何操作?
    Stream流提供collect方法,其参数需要一个java.util.stream.Collector<T,A,R>接口对象来指定收集到哪种集合中.

    Stream流对象中的内容收集到集合中,Stream接口(已经获取到实现类对象)提供抽象方法:
        <R, A> R collect(Collector<? super T, A, R> collector);
        参数:
            java.util.stream.Collector collector: 接口
            需要传递接口实现类对象,但是发现自己做实现类几乎不可能,非常麻烦,方法非常多
            幸运的是,java.util.stream.Collectors工具类提供一些方法,获取Collector<T,A,R>接口实现类对象
            public static <T> Collector<T, ?, List<T>> toList(): 转换为List集合
            public static <T> Collector<T, ?, Set<T>> toSet(): 转换为Set集合

    Stream流对象中的内容收集到数组中:
        Stream流对象中的内容收集到数组中,Stream接口(已经获取到实现类对象)提供抽象方法:
        Object[] toArray()
            要求:
                使用Stream流,List集合对象中的每个Person对象的年龄增加两岁,
                放入新的List集合中
 */
public class Demo09StreamCollect {
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

        //遍历新的List集合
    }
}