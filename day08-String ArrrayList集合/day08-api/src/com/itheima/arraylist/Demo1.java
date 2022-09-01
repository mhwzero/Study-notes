package com.itheima.arraylist;

import java.util.ArrayList;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：学会ArrayList的基本使用
        // 1.获取一个ArrayList对象
        ArrayList list = new ArrayList();

        // 2.向ArrayList中添加元素，默认添加到集合的最后
        list.add("Angelababy");
        list.add(8);
        list.add(8.8);
        list.add(false);

        // 在指定索引位置处添加元素
        list.add(2, "Angelababy");

        System.out.println(list);
    }
}
