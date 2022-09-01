package com.itheima.demo;

public class Demo2 {
    public static void main(String[] args) {
        // 需求：统计101-200之间有多少个素数，并输出所有素数
        // 1.遍历得到101-200之间的所有数字

        // 4.定义一个变量，用来统计素数的个数
        int count = 0;
        for (int i = 101; i <= 200; i++) {
            // 2.定义一个for循环，遍历2-当前数字的一半i/2
            boolean flag = true;    // 一开始假设是素数
            for (int j = 2; j <= i / 2; j++) {
                // 3.判断当前数字j能否整除i
                if (i % j == 0) {
                    // 证明当前数字i不是素数
                    flag = false;
                    break;
                }
            }

            if (flag) {
                // 是素数
                count++;
                System.out.print(i + "\t");
            }
        }
        System.out.println();
        System.out.println("101-200之间素数的个数为：" + count);
    }
}
