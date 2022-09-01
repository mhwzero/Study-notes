package com.itheima.operator;

public class Demo6 {
    public static void main(String[] args) {
        // 目标：掌握赋值运算符的使用
        // 1.基本赋值运算符，就是=
        int a = 10;

        // 2.扩展赋值运算符 += -= *= /= %=
        int x = 10;
        int y = 20;
        x += y;     // 相当于 x = x + y
        System.out.println(x);  // 30
        System.out.println(y);  // 20

        // 两个byte相加
        byte b1 = 10;
        byte b2 = 20;
//        b1 = b1 + b2;

        byte rs1 = (byte) (b1 + b2);    // 强转

        // 扩展赋值运算符中蕴含了一个强制类型转换
        b1 += b2;   // 原因是这条语句等价于 b1 = (byte) (b1 + b2)
        System.out.println(b1); // 30
    }
}
