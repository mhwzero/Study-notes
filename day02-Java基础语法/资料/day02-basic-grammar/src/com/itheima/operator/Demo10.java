package com.itheima.operator;

public class Demo10 {
    public static void main(String[] args) {
        // 目标：掌握运算符的优先级，&& 的优先级高于 ||
        System.out.println(10 > 3 || 10 > 3 && 10 < 3); // true
        System.out.println((10 > 3 || 10 > 3) && 10 < 3);   // false
    }
}
