package com.itheima.loop;

public class ForForDemo10 {
    public static void main(String[] args) {
        // 目标：掌握循环嵌套的写法
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("我爱你");
            }
            System.out.println("=================");
        }

        System.out.println("====================");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
