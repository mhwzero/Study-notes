package com.itheima.typeconversion;

public class Demo3 {
    public static void main(String[] args) {
        // 目标：掌握强制类型转换的知识点
        int a = 20;
//        byte b = a;

        // 强制类型转换的语法格式： 数据类型 变量2 = (数据类型) 变量1
        byte b = (byte) a;
        System.out.println(a);  // 20
        System.out.println(b);  // 20

        // 强制类型转换可能会造成数据精度的损失
        int i = 1500;
        byte j = (byte) i;
        System.out.println(j);  // -36

        // 小数类型的变量强转成整数，结果保留整数部分返回，小数部分直接丢掉
        double pi = 3.14;
        int x = (int) pi;
        System.out.println(x);  // 3
    }
}
