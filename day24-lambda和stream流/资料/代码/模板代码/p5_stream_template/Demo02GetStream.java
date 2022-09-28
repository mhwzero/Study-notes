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
public class Demo02GetStream {
    public static void main(String[] args) {
        //1.获取List集合对象对应的Stream流对象

        //2.获取Set集合对象对应的Stream流对象

        //Map集合,内部没有直接定义stream方法获取Stream流对象
        //必须转换为单列集合Collection,然后获取Stream流对象

        //3.获取Map集合键对应的Set集合对象对应的Stream流对象

        //4.获取Map集合值对应的Collection集合对象对应的Stream流对象

        //5.获取Map集合键值对对应的Set集合对象对应的Stream流对象

        System.out.println("---------------------");

        String[] arr = {"张无忌", "张翠山", "张三丰", "张一元"};

        //6.获取数组对应的Stream流对象

        //7.获取参数列表对应的Stream流对象

        //8.java.util.Arrays工具类的静态方法stream,也可以把数组转换成Stream流对象

    }
}
