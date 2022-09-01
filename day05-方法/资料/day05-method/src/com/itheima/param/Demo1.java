package com.itheima.param;

// param: 参数
public class Demo1 {
    public static void main(String[] args) {
        // 目标：掌握Java中基本数据类型的参数传递机制：值传递
        int a = 10;
        change(a);
        System.out.println("main中的" + a);  // 10
    }

    public static int change(int a) {
        System.out.println(a);  // 10
        a = 20;
        System.out.println(a);  // 20
        return a;
    }


}
