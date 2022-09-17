package com.itheima.p3_list;

import java.util.LinkedList;

/*
    java.util.LinkedList集合中可以用来模拟栈结构特点的方法
        public void push(E e) :将元素推入此列表所表示的堆栈。
            底层原理: addFirst

        public E pop() :从此列表所表示的堆栈处弹出一个元素。
            底层原理: removeFirst

    借助LinkedList定义一个MyStack<E>类,模拟栈数据结构
        达到的效果: 先进后出
        方法:
            public void in(E e): 添加数据,压栈
            public E out(): 获取数据,弹栈

 */
public class Demo07LinkedList {
    public static void main(String[] args) {
        //创建LinkedList集合对象linked,存储数据类型String
        LinkedList<String> linked = new LinkedList<>();
        //添加数据
        //add方法: 在末尾添加
        //push方法: 内部使用addFirst方法
        linked.push("1");
        linked.push("2");
        linked.push("3");
        linked.push("4");
        System.out.println(linked);

        //错误
        /*for (int i = 0; i < linked.size(); i++) {
            System.out.println(linked.pop());//每次执行pop,size的值减少1
        }*/
        /*int size = linked.size();
        for (int i = 0; i < size; i++) {
            System.out.println(linked.pop());//每次执行pop,size的值减少1
        }*/
        while (!linked.isEmpty()) {
            System.out.println(linked.pop());
        }
    }
}
