package com.itheima.p7_set;

import java.util.HashSet;

/*
    HashSet集合存储元素的过程
        1.计算哈希值,使用哈希值%数组长度,计算在数组中存储的索引
        2.判断该索引下是否有元素
        3.没有元素: 直接存储
        4.如果有元素:
            调用equals方法
            true: 不存储
            false: 存储

    HashSet集合保证元素唯一: 依赖hashCode方法和equals方法
    要求:
        HashSet集合存储对象所属的类要覆盖重写hashCode方法和equals方法
 */
public class Demo10HashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("abc");//96354
        set.add("重地");//1179395
        set.add("通话");//1179395
        set.add("abc");//96354
        System.out.println(set);//[重地, 通话, abc]

        System.out.println("abc".hashCode());
        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());

        System.out.println(96354 % 16);//2
        System.out.println(1179395 % 16);//3
        System.out.println(Integer.toBinaryString(15));//1111
        System.out.println(Integer.toBinaryString(96354));//10111100001100010
        System.out.println(0b10111100001100010 & 0b1111);//2
    }
}