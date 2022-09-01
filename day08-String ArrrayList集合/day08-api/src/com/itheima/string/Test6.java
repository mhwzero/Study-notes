package com.itheima.string;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        // 需求：模拟手机号码屏蔽功能
        // 1.键盘录入一个手机号码
        Scanner scanner = new Scanner(System.in);
        System.out.println("请您输入您的手机号码：");
        String phoneNo = scanner.next();

        // 2.截取手机号的前3位和后四位
        // 1318899 5665
        String prefix = phoneNo.substring(0, 3);    // 前缀
        String suffix = phoneNo.substring(7);   // 后缀

        String result = prefix + "****" + suffix;
        System.out.println("加密后的手机号码为：" + result);
    }
}
