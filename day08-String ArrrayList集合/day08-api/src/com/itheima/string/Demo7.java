package com.itheima.string;

public class Demo7 {
    public static void main(String[] args) {
        // 目标：掌握字符串创建对象的两种方式
        // 第一种方式：直接用英文双引号获取一个对象
        String name = "Angelababy";

        // 第二种方式：使用构造器
//        public String()	创建一个空白字符串对象，不含有任何内容 开发中几乎不用
//        String str1 = new String();
        String str1 = "";
        System.out.println(str1);

//        public String(String original)	根据传入的字符串内容，来创建字符串对象 开发中也几乎不用
//        String str2 = new String("蔡徐坤");
        String str2 = "蔡徐坤";
        System.out.println(str2);

//        public String(char[] chs)	根据字符数组的内容，来创建字符串对象
        char[] chs = {'a', 'b', 'c'};
        String str3 = new String(chs);
        System.out.println(str3);   // abc

//        public String(byte[] chs)	根据字节数组的内容，来创建字符串对象
        byte[] bytes = {97, 98, 99, 65};
        String str4 = new String(bytes);
        System.out.println(str4);
    }
}
