package com.itheima.operator;

public class Test2 {
    public static void main(String[] args) {
        // 需求：有一个三位数，123，在控制台分别打印个位、十位、百位
        // 1.定义一个变量记录这个三位数
        int num = 123;

        // 2.计算个位
        int ge = num % 10;
        System.out.println(ge);

        // 3.计算十位
        int shi = num / 10 % 10;
        System.out.println(shi);

        // 4.计算百位
//        int bai = num / 100 % 10;
        int bai = num / 100;
        System.out.println(bai);
    }
}
