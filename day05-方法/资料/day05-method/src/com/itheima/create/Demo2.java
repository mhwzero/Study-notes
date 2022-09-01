package com.itheima.create;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("开始");
        int c = add(10, 20);
        System.out.println(c);
        System.out.println("结束");
    }

    // 方法必须调用才可以执行
    public static int add(int a, int b) {
        int c = a + b;
        return c;
    }
}
