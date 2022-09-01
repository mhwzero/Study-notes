package com.itheima.demo;

public class Test2 {
    public static void main(String[] args) {
        // 需求：定义一个方法，在方法中输出指定的数字是奇数还是偶数
        // 2.调用方法
        judge(22);
        judge(35);
    }

    // 1.定义方法
    // judge：判断
    public static void judge(int a) {
        if (a % 2 == 1) {
            System.out.println(a + "是奇数");
        } else {
            System.out.println(a + "是偶数");
        }
    }
}
