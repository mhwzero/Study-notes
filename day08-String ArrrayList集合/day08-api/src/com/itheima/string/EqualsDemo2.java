package com.itheima.string;

import java.util.Scanner;

public class EqualsDemo2 {
    public static void main(String[] args) {
        // 目标：掌握String字符串比较的方法
        // 模拟登录时用户名的比较
        String sysUsername = "itheima";

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的用户名：");
        String username = scanner.next();

//        if (sysUsername == username) {
//            System.out.println("恭喜您，用户名正确");
//        } else {
//            System.out.println("您输入的用户名有误，请重新输入");
//        }

        if (username.equals(sysUsername)) {
            System.out.println("恭喜您，用户名正确");
        } else {
            System.out.println("您输入的用户名有误，请重新输入");
        }

        // equalsIgnoreCase(),忽略大小写比较字符串内容，可以用在验证码比较中
        String code1 = "adsFsRWs";
        String code2 = "ADsfsrwS";

        System.out.println(code1.equals(code2));    // false
        System.out.println(code1.equalsIgnoreCase(code2));  // true
    }
}
