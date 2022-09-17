package com.itheima.p3_list;

import java.util.LinkedList;

/*
    java.util.LinkedList集合中可以用来模拟栈结构特点的方法
        public void push(E e) :将元素推入此列表所表示的堆栈。
            底层原理: addFirst

        public E pop() :从此列表所表示的堆栈处弹出一个元素。
            底层原理: removeFirst

 */
public class Demo06LinkedList {
    public static void main(String[] args) {
        //创建LinkedList集合对象linked,存储数据类型String
        LinkedList<String> linked = new LinkedList<>();
        //添加数据
        //add方法: 在末尾添加
        //push方法: 内部使用addFirst方法
        linked.push("1");
        System.out.println(linked);//[1]
        linked.push("2");
        System.out.println(linked);//[2, 1]
        linked.push("3");
        System.out.println(linked);//[3, 2, 1]
        linked.push("4");
        System.out.println(linked);//[4, 3, 2, 1]  右侧看成栈底,左侧看成栈顶

        //pop方法: 内部使用removeFirst方法
        System.out.println(linked.pop());//4
        System.out.println(linked);//[3, 2, 1]

        System.out.println(linked.pop());//3
        System.out.println(linked);//[2, 1]

        System.out.println(linked.pop());//2
        System.out.println(linked);//[1]

        System.out.println(linked.pop());//1
        System.out.println(linked);//[]
    }
}
