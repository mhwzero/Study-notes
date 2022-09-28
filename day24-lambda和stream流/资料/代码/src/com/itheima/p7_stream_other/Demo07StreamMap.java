package com.itheima.p7_stream_other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public abstract <R> Stream<R> map(Function<T, R> mapper)
            按照方法参数mapper指定的方式把Stream流对象中的T类型的元素转换成R类型,返回新的Stream流
            参数:
                Function<T, R> mapper: 转换型接口

        java.util.function.Function<T, R>接口: 转换型接口
        功能: 把T类型的数据转换成R类型
        抽象方法:
            public abstract R apply(T t): 根据方法参数T类型的t,获取R类型的数据
            转换前: T类型
            转换后: R类型
   	map: 映射
        如果需要将流中的元素映射到另一个流中,可以使用map方法.方法签名
        public abstract <R> Stream<R> map(Function<T, R> mapper);
        该方法需要一个Function函数式接口参数,可以将当前流中的T类型数据转换为另一种R类型的流.
 */
public class Demo07StreamMap {
    public static void main(String[] args) {
        // {new Person("张三", 18), new Person("李四", 38), new Person("王五", 28)};
        //创建List集合对象strList,存储数据类型String
        List<String> strList = new ArrayList<>();
        //添加多个字符串,每个字符串代表一个Person对象的信息
        Collections.addAll(strList,"张三:18","李四:38","王五:28");

        //获取List集合对象strList对应的Stream流对象
        Stream<String> s1 = strList.stream();

        //把Stream流对象中的每个String,转换成Person对象
        /*Stream<Person> s2 = s1.map(new Function<String, Person>() {
            @Override
            public Person apply(String s) {
                String[] array = s.split(":");
                return new Person(array[0], Integer.parseInt(array[1]));
            }
        });*/
        Stream<Person> s2 = s1.map((String s) -> {
                String[] array = s.split(":");
                return new Person(array[0], Integer.parseInt(array[1]));
            });
        //遍历存储Person对象的Stream流对象
        /*s2.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });*/
        s2.forEach((Person person) -> {
                System.out.println(person);
            });
    }
}