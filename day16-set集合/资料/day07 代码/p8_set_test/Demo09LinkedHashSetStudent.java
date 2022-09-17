package com.itheima.p8_set_test;

import java.util.LinkedHashSet;

/*
    LinkedHashSet集合存储自定义对象

    步骤:
        1.创建标准的Student类
        2.创建LinkedHashSet集合对象,泛型: Student
        3.向建LinkedHashSet集合对象存储多个Student对象
        4.遍历输出

    LinkedHashSet集合存储元素的过程
        1.计算哈希值,使用哈希值%数组长度,计算在数组中存储的索引
        2.判断该索引下是否有元素
        3.没有元素: 直接存储
        4.如果有元素:
            调用equals方法
            true: 不存储
            false: 存储

    LinkedHashSet集合保证元素唯一: 依赖hashCode方法和equals方法
    要求:
        LinkedHashSet集合存储对象所属的类要覆盖重写hashCode方法和equals方法

    特点:
        有序,无索引,不可重复
 */
public class Demo09LinkedHashSetStudent {
    public static void main(String[] args) {
        //2.创建HashSet集合对象,泛型: Student
        LinkedHashSet<Student> set = new LinkedHashSet<>();

        //3.向建HashSet集合对象存储多个Student对象
        set.add(new Student("zs",18));
        set.add(new Student("zs",18));
        set.add(new Student("ls",38));
        set.add(new Student("ls",38));
        set.add(new Student("ww",28));
        set.add(new Student("ww",28));
        //4.遍历输出
        System.out.println(set);
    }
}