package com.itheima.p3_list;

import java.util.LinkedList;

/*
    java.util.Collection<E>接口:
        单列集合的根接口里面定义的方法,所有的子接口/实现类,都有

    java.util.List<E>子接口:
        特点:
            1.有序: 保证存入和取出元素的顺序是一致的
            2.有索引: 可以通过索引的方式获取元素
            3.可重复: 可以存储相同的内容

    常用实现类LinkedList集合                -------------使用LinkedList集合--------------
        特点:
            1.底层数据结构:双向链表
            2.增删快: 元素分配不连续的,添加/删除元素,只需要找到位置,再修改对应节点保存地址的地方
            3.查询慢:
                要么从前向后查,要么从后向前查
            4.线程不同步,不安全,效率高
    LinkedList集合操作链表头和尾的方法
        public void addFirst(E e) :将指定元素插入此列表的开头。
        public void addLast(E e) :将指定元素添加到此列表的结尾。
        public E getFirst() :返回此列表的第一个元素。
        public E getLast() :返回此列表的最后一个元素。
        public E removeFirst() :移除并返回此列表的第一个元素。
        public E removeLast() :移除并返回此列表的最后一个元素。
 */
public class Demo05LinkedList {
    public static void main(String[] args) {
        //创建LinkedList集合对象linked,存储数据类型String
        LinkedList<String> linked = new LinkedList<>();
        //add方法: 末尾添加元素
        linked.add("BBB");
        linked.add("CCC");
        System.out.println(linked);//[BBB, CCC]
        System.out.println("获取但不删除头节点:" + linked.getFirst());//BBB
        System.out.println("获取但不删除尾节点:" + linked.getLast());//CCC

        //添加头节点AAA
        linked.addFirst("AAA");
        //添加尾节点DDD
        linked.addLast("DDD");
        System.out.println(linked);//[AAA, BBB, CCC, DDD]
        System.out.println("获取并删除头节点:" + linked.removeFirst());//AAA
        System.out.println("获取并删除尾节点:" + linked.removeLast());//DDD
        System.out.println(linked);//[BBB, CCC]
    }
}
