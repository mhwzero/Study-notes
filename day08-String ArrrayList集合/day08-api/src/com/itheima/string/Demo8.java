package com.itheima.string;

public class Demo8 {
    public static void main(String[] args) {
        // 目标：掌握不同方式创建字符串对象的比较
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);   // true

        char[] chs = {'a', 'b', 'c'};
        String str3 = new String(chs);
        String str4 = new String(chs);
        System.out.println(str3 == str4);   // false
    }
}
