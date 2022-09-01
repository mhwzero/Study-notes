package com.itheima.loop;

public class ForDemo1 {
    public static void main(String[] args) {
        // 目标：掌握for循环的基本使用，理解其执行流程
        // 打印3行HelloWorld
        for (int i = 0; i < 3; i++) {
            System.out.println("HelloWorld");
        }
        System.out.println("=======");
        for (int i = 0; i < 5; i++) {
            System.out.println("HelloWorld");
        }

        System.out.println("=======");
        for (int i = 1; i < 5; i++) {
            System.out.println("HelloWorld");
        }

        System.out.println("=======");
        for (int i = 1; i <= 5; i++) {
            System.out.println("HelloWorld" + i);
        }
    }
}
