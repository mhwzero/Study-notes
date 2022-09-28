package com.itheima.p7_stream_other;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Demo11StreamSort {
    public static void main(String[] args) {
        //创建List集合对象,并添加数据
        List<Person> list = new ArrayList<>();
        Collections.addAll(list,
                new Person("张三", 18),
                new Person("李四", 38),
                new Person("王五", 28));

        //借助Stream流对象,对List集合中的Person对象按照age从小到大排序
        //获取List集合对象的Stream流对象
        Stream<Person> s1 = list.stream();

        //使用Stream流对象调用sorted方法,指定排序规则,传递匿名内部类对象
        /*Stream<Person> s2 = s1.sorted(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/
        //调用sorted方法,传递的是lambda表达式的简化格式
        Stream<Person> s2 = s1.sorted((p1, p2) -> p1.getAge() - p2.getAge());
        //遍历
        s2.forEach(person -> System.out.println(person));
    }
}