package com.itheima.memory;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：掌握方法在内存中的执行流程
        study();
    }

    public static void study() {
        eat();
        System.out.println("学习ing...");
        sleep();
    }

    public static void eat() {
        System.out.println("吃饭ing...");
    }

    public static void sleep() {
        System.out.println("睡觉ing...");
    }
}
