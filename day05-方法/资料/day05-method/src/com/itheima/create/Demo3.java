package com.itheima.create;

public class Demo3 {
    public static void main(String[] args) {
        // 目标：掌握方法定义的其他形式
        // 定义一个没有返回值，也没有形参的方法
        print();
    }

    public static void print() {
        System.out.println("HelloWorld");
        System.out.println("HelloWorld");
        System.out.println("HelloWorld");
        // 如果方法返回值类型声明为void，那么方法中一定不能使用return返回具体的数据
//        return 2;
    }
}
