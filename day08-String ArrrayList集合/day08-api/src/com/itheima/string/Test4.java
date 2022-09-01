package com.itheima.string;

import java.util.Random;

public class Test4 {
    public static void main(String[] args) {
        // 需求：使用String类生成5位随机验证码
        // 1.使用String存储所有的大写字符、小写字符、数字字符
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // 2.定义一个字符串，用来存储最终的结果
        String code = "";
        Random random = new Random();
        // 3.遍历5次，每次得到一个随机字符
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(chars.length());
            char c = chars.charAt(index);
            code += c;
        }

        // 4.打印最终的结果
        System.out.println(code);
    }
}
