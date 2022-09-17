package com.itheima.p5_var_params;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    java.util.Collections工具类静态方法:
        public static <T> boolean addAll(Collection<T> coll, T... elements) :
            把调用方法时,可变参数列表中的实际数据elements,添加到集合对象coll中
            参数:
                Collection<T> coll: 接口,传递实现类ArrayList/HashSet/LinkedHashSet对象
                T... elements: 可变参数,可以传递数组/参数列表/不传参数
*/
public class Demo06Collections {
    public static void main(String[] args) {
        //参加List集合对象colors,存储数据类型String,用来存储所有的花色
        List<String> colors = new ArrayList<>();

        //把参数列表字符串"♥", "♠", "♣", "♦",添加到方法参数集合对象colors中
        //第二个参数: 传递的是参数列表的形式
        Collections.addAll(colors, "♥", "♠", "♣", "♦");

        System.out.println(colors);//[♥, ♠, ♣, ♦]


        //参加List集合对象nums,存储数据类型String,用来存储所有的数字
        List<String> nums = new ArrayList<>();

        //定义String数组
        String[] array = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        //把参数字符串数组array中的每个元素,添加到方法参数集合对象nums中
        Collections.addAll(nums, array);
        System.out.println(nums);


        List<String> nums2 = new ArrayList<>();

        Collections.addAll(nums2, "3-4-5-6-7-8-9-10-J-Q-K-A-2".split("-"));
        System.out.println(nums2);
    }
}
