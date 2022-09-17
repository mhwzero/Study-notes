package com.itheima.p1_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    java.util.Collections类: 操作集合的工具类
    特点:
        1.构造方法private修饰
        2.所有成员static修饰

    常用方法:
        public static void shuffle(List<?> list): 打乱List集合中元素的顺序
        public static <T> void sort(List<T> list): 将集合中元素按照默认规则排序。
            参数:
                List list: 接口,传递实现类ArrayList/LinkedList对象
            注意:
                对于数字而言,默认排序规则,按照数字从小到大的顺序排列
                对于字符串而言,默认排序规则,按照第一个不相同的字母的ASCII码值从小到大的顺序排列
 */
public class Demo01Collections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //add: 添加元素
        for (int i = 1; i <= 15; i++) {
            list.add(i * 100);
        }
        System.out.println("集合原内容: " + list);

        //shuffle方法: 打乱List集合中元素的顺序
        Collections.shuffle(list);


        System.out.println("集合乱序后内容: " + list);

        //sort方法: 完成排序
        Collections.sort(list);

        System.out.println("集合升序排序后内容: " + list);
    }

    public static void sort(List<Integer> list) {

    }
}
