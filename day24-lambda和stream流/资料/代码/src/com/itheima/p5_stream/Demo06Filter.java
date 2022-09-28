package com.itheima.p5_stream;

import java.util.stream.Stream;

/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public abstract Stream<T> filter(Predicate<T> p):
            按照方法参数p指定的条件对Stream流对象中的元素进行过滤,返回一个新的Stream流对象
            参数:
                Predicate<T> p: 判断型型接口,传递匿名内部类对象,lambda表达式

        java.util.function.Predicate<T>接口: 
        	判断型接口 功能: 根据T类型的数据获取boolean类型的结果
        抽象方法:
            public abstract boolean test(T t): 根据方法参数T类型的数据t,返回一个boolean类型的结果

    练习:
        步骤一: 过滤出所有带娃的
        步骤二: 遍历输出结果
 */
public class Demo06Filter {
    public static void main(String[] args) {
        //创建Stream流对象
        Stream<String> s = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃", "爷爷", "蛇精", "蝎子精");

        //1.匿名内部类的方式
        /*Stream<String> s2 = s.filter(new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return name.contains("娃");
            }
        });*/

        //2.使用lambda表达式的标准格式
        /*Stream<String> s2 = s.filter((String name) -> {
                return name.contains("娃");
            });*/

        //3.使用lambda表达式的简化格式
        Stream<String> s2 = s.filter(name -> name.contains("娃"));
        //遍历输出
        s2.forEach(name-> System.out.println(name));
    }
}