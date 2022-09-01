package com.itheima.overload;

public class Demo2 {
    public static void main(String[] args) {
        // 目标：学会方法重载的识别技巧

    }

    // 新方法
    public static void open() {}

    // 是
    public static void open(int a) {}

    // 是
    static void open(int a, int b) {}
    // 是
    public static void open(double a, int b) {}
    // 是
    public static void open(int a, double b) {}
    // 重复的方法
//    public void open(int i, double d) { }
    // 不是，新方法
    public static void OPEN(){ }
}
