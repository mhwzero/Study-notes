package com.itheima.arraylist;

import java.util.ArrayList;

public class Demo3 {
    public static void main(String[] args) {
        // 需求：掌握ArrayList集合的常用方法
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.add("Angelababy")); // true
        list.add("蔡徐坤");
        list.add("杨紫");
        list.add("陈小春");
        list.add("刘鑫");
        list.add("渣渣辉");

        //        public E get(int index)	返回指定索引处的元素
        String ele = list.get(2);
        System.out.println(ele);

//        public int size()	返回集合中的元素的个数
        int size = list.size();
        System.out.println(size);   // 6

        // 遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();

//        public E remove(int index)	删除指定索引处的元素，返回被删除的元素
        String removed = list.remove(3);
        System.out.println(removed);

        // 看一下集合中剩下的元素
        System.out.println(list);

        System.out.println("=============");
//        public boolean remove(Object o)	删除指定的元素，返回删除是否成功
        boolean flag = list.remove("刘鑫");
        System.out.println(flag);

        System.out.println(list);

//        public E set(int index,E element)	修改指定索引处的元素，返回被修改的元素
        list.set(3, "张家辉");
        System.out.println(list);

    }
}
