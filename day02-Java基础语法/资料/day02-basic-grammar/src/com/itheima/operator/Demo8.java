package com.itheima.operator;

public class Demo8 {
    public static void main(String[] args) {
        // 目标：掌握逻辑运算符的基本使用
        // 1.逻辑与 &
        // 模拟，需求：手机尺寸必须在8英寸以上，同时机身内存在512G或以上
        double size = 8.5;
        int storage = 256;
        System.out.println(size > 8 & storage >= 512);  // false

        System.out.println("======");
        // 2.逻辑或 |
        // 模拟，需求：手机尺寸在8英寸以上，或机身内存在512G或以上
        System.out.println(size > 8 | storage >= 512);  // true

        System.out.println("======");
        // 3.逻辑非
        System.out.println(!true);  // false
        System.out.println(!false); // true
        System.out.println(!(size > 8 & storage >= 512));   // true

        System.out.println("======");
        // 4.逻辑异或 ^ , 相异为真
        System.out.println(true ^ true);    // false
        System.out.println(true ^ false);   // true
        System.out.println(false ^ true);   // true
        System.out.println(false ^ false);  // false

        System.out.println("======");
        // 5.短路与 &&，特点是左边是false，右边就不执行了

        int a = 10;
        int b = 20;
        System.out.println(a > 20 && ++b == 40); // false
        System.out.println(b);  // 20

        System.out.println(a > 20 & ++b > 10);  // false
        System.out.println(b);  // 21

        System.out.println("======");
        // 短路或 ||  ，特点是左边是true，右边就不执行了
        int x = 10;
        int y = 20;
        System.out.println(x > 5 || --y < 10);  // true
        System.out.println(y);  // 20

        System.out.println(x > 5 | --y < 10);  // true
        System.out.println(y);  // 19

        System.out.println("======");
//        System.out.println(1/0); // 报错
//        System.out.println(true | (1 / 0 == 1));   // 报错
        System.out.println(true || (1 / 0 == 1));   // true

        System.out.println(false && (1 / 0 == 1));  // false
        System.out.println(false & (1 / 0 == 1));   // 报错
    }
}
