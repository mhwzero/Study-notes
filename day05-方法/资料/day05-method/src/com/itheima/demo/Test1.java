package com.itheima.demo;

public class Test1 {
    public static void main(String[] args) {
        // 需求：定义一个方法，在方法中计算1-n的和并返回
        // 调用方法
        int sum = sum(10);
        System.out.println(sum);

        int result = sum(100);
        System.out.println(result);

        System.out.println(sum(20));

    }

    public static int sum(int n) {
        // 在循环外定义一个累加变量
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
