package com.itheima.string;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：掌握String类一个非常重要的特性：不可变性
        String str = "传智";
        str += "教育";
        str += "中心";
        System.out.println(str);    // 传智教育中心
    }
}
