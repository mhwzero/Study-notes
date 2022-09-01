package com.itheima.scanner;

// 1.导包, 不用自己做

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：掌握键盘录入技术
        // 2.抄代码，得到一个扫描器对象
        Scanner scanner = new Scanner(System.in);

        // 3.提示一下用户，输入什么东西
        System.out.println("请输入您的年龄：");
        int age = scanner.nextInt();
        System.out.println("年龄是：" + age);

        System.out.println("请您输入您的姓名：");
        String name = scanner.next();
        System.out.println("欢迎：" + name);
    }
}
