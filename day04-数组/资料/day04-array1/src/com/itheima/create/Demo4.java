package com.itheima.create;

public class Demo4 {
    public static void main(String[] args) {
        // 目标：掌握数组的动态初始化写法
        // 语法：
        // 数据类型[] 数组名 = new 数据类型[长度];

        int[] ages = new int[3];
        ages[0] = 18;
        System.out.println(ages[0]);    // 18
        System.out.println(ages[1]);    // 0
    }
}
