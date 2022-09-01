package com.itheima.memory;

public class Demo2 {
    public static void main(String[] args) {
        // 目标：掌握两个变量指向同一个数组的内存图
        int[] arr1 = {11, 22, 33};
        int[] arr2 = arr1;

        System.out.println(arr1);
        System.out.println(arr2);

        arr2[1] =99;
        System.out.println(arr1[1]);    // 99
        System.out.println(arr2[1]);    // 99
    }
}
