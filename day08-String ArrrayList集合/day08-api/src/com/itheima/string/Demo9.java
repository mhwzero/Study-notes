package com.itheima.string;

public class Demo9 {
    public static void main(String[] args) {
        // 目标：几道字符串相关的笔试题
        String s1 = new String("abc");
        String s2 = "abc";
        System.out.println(s1 == s2);   // false

        System.out.println("===========");
        String s3 = "abc";
        String s4 = "ab";
        String s5 = s4 + "c";
        System.out.println(s3 == s5);   // false
    }
}
