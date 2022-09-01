package com.itheima.param;

public class Demo2 {
    public static void main(String[] args) {
        // 目标：掌握引用数据类型的参数传递机制
        int[] arr = new int[]{11, 22, 33};
        System.out.println("调用方法前的地址值：" + arr);
        change(arr);
        System.out.println("调用方法后的地址值：" + arr);
        System.out.println("main方法中：" + arr[1]);    // 100
    }

    public static void change(int[] arr) {
        System.out.println("方法中：" + arr[1]);    // 22
        arr[1] = 100;
        System.out.println("方法中：" + arr[1]);    // 100
    }
}
