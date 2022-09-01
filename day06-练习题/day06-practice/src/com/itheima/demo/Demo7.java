package com.itheima.demo;

import java.util.Scanner;

public class Demo7 {
    public static void main(String[] args) {
        // 需求：数字加密
        // 1.动态初始化一个数组，长度也从键盘录入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请您录入要加密数字的位数：");
        int num = scanner.nextInt();
        
        // 2.动态初始化一个数组，长度是用户录入的位数
        int[] data = new int[num];
        
        // 3.遍历数组，让用户录入要加密的数据
        for (int i = 0; i < num; i++) {
            System.out.println("请您录入第：" + (i + 1) + "个要加密的数字：");
            data[i] = scanner.nextInt();
        }

        // 3.1.打印加密前的数字
        System.out.println("加密前的数字：");
        printArray(data);
        
        // 4.再次遍历，对数组进行加密
        for (int i = 0; i < num; i++) {
            data[i] = (data[i] + 5) % 10;
        }
        
        // 5.反转
        for (int i = 0, j = data.length - 1; i < j; i++, j--) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        // 6.打印加密后的数字
        System.out.println("加密后的数字：");
        printArray(data);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
        }
        System.out.println("]");
    }
}
