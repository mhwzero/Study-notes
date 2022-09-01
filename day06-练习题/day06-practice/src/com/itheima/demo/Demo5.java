package com.itheima.demo;

public class Demo5 {
    public static void main(String[] args) {
        // 需求：数组元素的复制
        // 1.静态初始化一个数组，用来存储原始数组数据
        int[] arr1 = {11, 12, 13, 14, 15, 20};

        // 2.动态初始化一个数组，长度和原数组一样
        int[] arr2 = new int[arr1.length];

        // 3.调用复制数组元素的方法
        arrayCopy(arr1, arr2);

        // 4.打印两个数组
        System.out.println("复制前的数组:");
        printArray(arr1);
        System.out.println("复制后的数组:");
        printArray(arr2);
    }

//    public static int[] arrayCopy(int[] arr1, int[] arr2) {
//        for (int i = 0; i < arr1.length; i++) {
//            arr2[i] = arr1[i];
//        }
//        return arr2;
//    }

    public static void arrayCopy(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
        }
        System.out.println("]");
    }
}
