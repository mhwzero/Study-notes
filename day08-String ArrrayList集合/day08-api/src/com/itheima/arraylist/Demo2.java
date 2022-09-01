package com.itheima.arraylist;

import java.util.ArrayList;

public class Demo2 {
    public static void main(String[] args) {
        // 目标：掌握ArrayList集合对泛型的支持, 为了约束集合中能存储元素的类型
        ArrayList<String> list = new ArrayList<String>();
        list.add("Angelababy");
//        list.add(8);
//        list.add(8.8);
//        list.add(false);

//        ArrayList<Integer> list1 = new ArrayList();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(100);
//        list1.add(100.0);
//        list1.add("Angelababy");

        // Object是所有类型的最终父类
        ArrayList<Object> list2 = new ArrayList<>();
        list2.add("Angelababy");
        list2.add(8);
        list2.add(8.8);
        list2.add(false);

        ArrayList<Character> list3 = new ArrayList<>();

        ArrayList<Double> list4 = new ArrayList<>();
    }
}
