package com.itheima.operator;

public class Demo9 {
    public static void main(String[] args) {
        // 目标：掌握三元运算符的使用
        // 基本格式：条件表达式 ? 值1 : 值2
        // 模拟小明考试
        int score = 59;
//        int score = 60;

        String result = score >= 60 ? "考试通过" : "考试不及格";
        System.out.println(result); // 考试不及格

        System.out.println("=============");
        // 需求：求三个整数的最大值
        int a = 10;
        int b = 8;
        int c = 9;

        // 1.计算前两个数的较大值
        int temp = a > b ? a : b;
        // 2.将前两个数的较大值和第三个数比较
        int rs = temp > c ? temp : c;
        System.out.println(rs);

        // 一行代码实现
        int rs2 = a > b ? a > c ? a : c : b > c ? b : c;
        System.out.println(rs2);

    }
}
