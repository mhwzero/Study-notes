package com.itheima.p4_suanfa;

import java.util.Arrays;

/*
    冒泡排序
    1.原理:
        每次都是从第一个元素开始向后两两进行比较,
        只要后面的元素小于前面的元素,就交换这两个元素(从小到大)

    2.总结:
        1.有5个数需要排4趟,有n个数需要n-1趟
        2.每趟排序的次数都比前面一趟少1次

    3.规律:
            第一趟				第二趟			第三趟			第四趟
            [0] VS [1]		[0] VS [1]		[0] VS [1]	[0] VS [1]
            [1] VS [2]      [1] VS [2]      [1] VS [2]
            [2] VS [3]      [2] VS [3]
            [3] VS [4]
*/
public class Demo04ArraySort {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {7, 6, 5, 4, 3};
        System.out.println("未排序前: " + Arrays.toString(arr));
        for (int j = 0; j < arr.length - 1 - 0; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一趟排序后: " + Arrays.toString(arr));

        for (int j = 0; j < arr.length - 1 - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二趟排序后: " + Arrays.toString(arr));

        for (int j = 0; j < arr.length - 1 - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三趟排序后: " + Arrays.toString(arr));


        for (int j = 0; j < arr.length - 1 - 3; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序后: " + Arrays.toString(arr));
    }
}
