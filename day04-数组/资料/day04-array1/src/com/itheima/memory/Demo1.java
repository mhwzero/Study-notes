package com.itheima.memory;

public class Demo1 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(a);  // 10

        int[] arr = new int[]{11, 22, 33};

        arr[0] = 44;
        arr[1] = 55;
        arr[2] = 66;

        System.out.println(arr[0]); // 44
        System.out.println(arr[1]); // 55
        System.out.println(arr[2]); // 66
    }
}
