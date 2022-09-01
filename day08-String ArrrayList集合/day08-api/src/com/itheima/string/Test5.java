package com.itheima.string;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        // 需求：模拟用户登录功能，最多登录3次
        // 1.记录正确的用户名和密码
        String sysUsername = "angelababy";
        String sysPassword = "123456";

        Scanner scanner = new Scanner(System.in);
        // 2.使用for循环，循环3次
        for (int i = 0; i < 3; i++) {
            System.out.println("请您输入用户名：");
            String username = scanner.next();
            System.out.println("请您输入密码：");
            String password = scanner.next();
            // 判断用户输入的用户名和密码是否都正确
            if (username.equals(sysUsername) && password.equals(sysPassword)) {
                System.out.println("恭喜您，登录成功");
                break;
            } else {
                System.out.println("您输入的用户名或密码不正确，您还有" + (2 - i) + "次机会");
            }
        }
    }
}
