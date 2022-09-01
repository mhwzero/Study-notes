package com.itheima.returndemo;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：掌握return关键字单独使用
        divide(10, 0);
    }

    // divide:除
    public static void divide(int a, int b) {
        if (b == 0) {
            System.out.println("除数不能是0");
            return;
        }
        int c = a / b;  // ArithmeticException: / by zero
        System.out.println("结果是：" + c);
    }
}
