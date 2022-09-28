package com.itheima.p5_stream;

import java.util.*;
import java.util.stream.Stream;

/*
    获取Stream流的方式
        java.util.stream.Stream<T>流: 是Java 8新加入的最常用的流接口。
            问题: 要想使用Stream流,必须先获取到Stream<T>接口的实现类对象
        方式一: 获取Collection集合对象的Stream流对象
            java.util.Collection<T>接口: 单列集合的根接口
            默认方法:
                public default Stream<E> stream(): 获取Collection集合对象的Stream流对象
                返回值类型:
                    java.util.stream.Stream<T>: 接口,该方法内部必然返回接口的实现类对象
            也就是说: 如果能够调用Collection接口中的默认方法stream,也就可以获取到Stream流对象
                Collection接口中的默认方法stream必须由Collection接口的实现类对象调用
                Collection接口的实现类: ArrayList/LinkedList/HashSet/LinkedHashSet
        方式二: 获取数组对应的Stream流对象
            java.util.stream.Stream<T>接口
            静态方法: 由接口名称直接调用
                public static<T> Stream<T> of(T... values): 获取方法可变参数对应的Stream流对象
                返回值类型:
                    java.util.stream.Stream<T>: 接口,该方法内部必然返回接口的实现类对象
                参数列表:
                    T... values: 可变参数,可以传递参数列表,可以传递数组,还可以不传参
   //1.获取List集合对象对应的Stream流对象
   //2.获取Set集合对象对应的Stream流对象
 */
public class Demo05GetStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //1.获取List集合对象对应的Stream流对象
        Stream<String> s1 = list.stream();
        System.out.println("s1 = " + s1);

        Set<String> set = new HashSet<>();
        //2.获取Set集合对象对应的Stream流对象
        Stream<String> s2 = set.stream();
        System.out.println("s2 = " + s2);

        Map<String, String> map = new HashMap<>();

        //3.获取Map集合的键对应的Set集合
        Set<String> set2 = map.keySet();
        //获取Set集合对象对应的Stream流对象
        Stream<String> s3 = set2.stream();
        System.out.println("s3 = " + s3);

        //4.获取Map集合的值对应的Collection集合
        Collection<String> coll = map.values();
        //获取Collection集合对象对应的Stream流对象
        Stream<String> s4 = coll.stream();
        System.out.println("s4 = " + s4);

        //5.获取Map集合的键值对对应的Set集合
        Set<Map.Entry<String, String>> set3 = map.entrySet();
        //获取Set集合对象对应的Stream流对象
        Stream<Map.Entry<String, String>> s5 = set3.stream();
        System.out.println("s5 = " + s5);


        String[] array = {"张无忌", "张翠山", "张三丰", "张一元"};
        //6.把数组转换成对应的Stream流对象
        Stream<String> s6 = Stream.of(array);
        System.out.println("s6 = " + s6);

        //7.把参数列表转换成对应的Stream流对象
        Stream<String> s7 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃", "爷爷", "蛇精", "蝎子精");
        System.out.println("s7 = " + s7);

        //8.Arrays工具类的静态方法stream,把数组转换成Stream流对象
        Stream<String> s8 = Arrays.stream(array);
        System.out.println("s8 = " + s8);

    }
}
