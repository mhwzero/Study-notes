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
public class Demo05ArraySort {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {7, 6, 5, 4, 3};
        System.out.println("未排序前: " + Arrays.toString(arr));
        //-1可以省略的: 无非多排了一趟而已
        for (int i = 0; i < arr.length - 1; i++) {//外层循环: 控制排序的趟数
            //-i可以省略的: 无非每趟排序的次数多了一次
            //-1不可以省略的: 防止索引越界,因为最后一个元素后面没有内容,不需要向后面继续比较了
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环: 控制每趟交换的次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("升序排序后: " + Arrays.toString(arr));
    }
}
