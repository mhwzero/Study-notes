package com.itheima.typeconversion;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：掌握自动类型转换的知识
        // 自动类型转换：小范围的变量，可以自动转换成大范围类型的变量
        int a = 10;
        double b = a;

        char c = 'a';
        int d = c;
        System.out.println(c);  // a
        System.out.println(d);  // 97

        byte e = 12;
        int f = e;
        System.out.println(f);  // 12

        double g = 3.14;
//        int h = g;    // double的范围比int大，不能完成自动类型转换

    }
}
