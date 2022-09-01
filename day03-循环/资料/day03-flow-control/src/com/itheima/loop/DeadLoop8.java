package com.itheima.loop;

public class DeadLoop8 {
    public static void main(String[] args) {
        // 目标：掌握死循环的写法
        // 第一种写法：for
//        for (;;) {
//            System.out.println("HelloWorld");
//        }

        // 第二种写法：while
        // 经典写法
//        while (true) {
//            System.out.println("HelloWorld2");
//        }

        // 第三种写法：do-while
        do {
            System.out.println("HelloWorld3");
        } while (true);
    }
}
