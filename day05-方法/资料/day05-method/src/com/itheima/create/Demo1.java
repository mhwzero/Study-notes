package com.itheima.create;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：理解使用方法的好处
        // 张工程师
//        int a = 10;
//        int b = 20;
//        int c = a + b;
        int c = add(10, 20);
        System.out.println(c);

        // 张工程师第二次
//        int a2 = 30;
//        int b2 = 50;
//        int c2 = a2 + b2;
        int c2 = add(30, 50);
        System.out.println(c2);

        // 李工程师
//        int a1 = 10;
//        int b1 = 20;
//        int c1 = a1 + b1;
        int c1 = add(10, 20);
        System.out.println(c1);
    }

    // 定义一个方法
    public static int add(int a, int b) {
        int c = a + b;
        return c;
    }
}
