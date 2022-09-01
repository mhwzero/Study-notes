package com.itheima.loop;

import java.util.Scanner;

public class DeadLoopTest9 {
    public static void main(String[] args) {
        // 需求：密码验证，直到用户输入成功
        // 1.定义一个整形变量记录正确的密码
        int sysPassword = 520;

        // 2.使用死循环，让用户不断输入密码
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入您的密码：");
            int password = scanner.nextInt();
            // 3.判断用户输入的密码是否正确
            if (password == sysPassword) {
                // 密码正确
                System.out.println("欢迎进入系统");
                break;
            } else {
                // 密码不正确
                System.out.println("您输入的密码不正确，请重新输入");
            }
        }
    }
}
