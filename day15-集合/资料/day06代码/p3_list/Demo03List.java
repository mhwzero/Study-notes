package com.itheima.p3_list;

import java.util.ArrayList;
import java.util.List;

/*
    java.util.Collection<E>接口: 单列集合的根接口
	    里面定义的方法,所有的子接口/实现类,都有
    java.util.List<E>子接口:
        特点:
            1.有序: 保证存入和取出元素的顺序是一致的
            2.有索引: 可以通过索引的方式获取元素
            3.可重复: 可以存储相同的元素

    List子接口,除了用于父接口的方法外,额外添加与索引相关的方法
        public void add(int index,E element) 在列表的指定位置上插入元素。
        public E get(int index) 返回列表中指定位置的元素。
        public E set(int index,E element) 用指定元素替换列表中指定位置的元素，并返回替换前的元素。
        public E remove(int index) 移除列表中指定位置的元素，并返回被移除之前的元素。

    对于集合,最常用的操作:
        增删改查: C(增: Create)R(查:Read)U(改: Update)D(删: Delete)
 */
public class Demo03List {
    public static void main(String[] args) {
        //多态的方式创建List集合对象list,存储数据类型String
        List<String> list = new ArrayList<>();
        //add方法: 在末尾添加元素
        list.add("AAA");
        list.add("CCC");
        list.add("DDD");
        System.out.println(list);//[AAA, CCC, DDD]  AAA --> 0  CCC --> 1    DDD --> 2
        //在CCC前面添加BBB
        //add(int index,E element) 在列表的指定位置上插入元素。
        list.add(1, "BBB");
        System.out.println(list);//[AAA, BBB, CCC, DDD] AAA --> 0  BBB --> 1    CCC --> 2  DDD --> 3

        System.out.println("索引0元素值: " + list.get(0));
        System.out.println("索引1元素值: " + list.get(1));
        System.out.println("索引2元素值: " + list.get(2));
        System.out.println("索引3元素值: " + list.get(3));

        System.out.println("索引为3的哪个元素被删除了呢? " + list.remove(3));//DDD
        System.out.println("删除CCC是否成功? " + list.remove("CCC"));//true
        System.out.println("删除元素后集合内容: " + list);//[AAA, BBB] AAA --> 0  BBB --> 1

        //把AAA改成 A
        System.out.println("索引为0的哪个元素被修改了? " + list.set(0, "A"));//AAA
        //把BBB改成 B
        System.out.println("索引为1的哪个元素被修改了? " + list.set(1, "B"));//BBB
        System.out.println("修改元素后集合内容: " + list);//[A, B]
    }
}
