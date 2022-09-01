package com.itheima.bit;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：理解二进制、八进制、十六进制数据在程序中的书写格式
        // 二进制: 以0B或者0b开头
        int a = 0B01100001;
        System.out.println(a);  // 97

        // 八进制：以0开头
        int b = 0141;
        System.out.println(b);  // 97

        // 十六进制：以0X或者0x开头
        int c = 0X61;
        int d = 0x61;
        System.out.println(c);  // 97
        System.out.println(d);  // 97
    }
}
