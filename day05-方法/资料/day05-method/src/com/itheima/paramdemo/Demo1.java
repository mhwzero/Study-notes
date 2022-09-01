package com.itheima.paramdemo;

public class Demo1 {
    public static void main(String[] args) {
        // 需求；定义一个方法，用来打印任意整形数组的内容
        // [11, 22, 33, 44, 55]
        // 定义一个数组，调用方法
        int[] ages = {11, 22, 33, 44, 55};
        printArray(ages);

        int[] arr1 = {};
        printArray(arr1);

        int[] arr2 = null;
        printArray(arr2);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
    //            if (i != arr.length - 1) {
    //                System.out.print(arr[i] + ", ");
    //            } else {
    //                System.out.print(arr[i]);
    //            }
                System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
