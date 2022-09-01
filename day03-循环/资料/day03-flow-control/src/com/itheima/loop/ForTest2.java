package com.itheima.loop;

import java.util.Scanner;

public class ForTest2 {
    public static void main(String[] args) {
        // 需求：使用for循环，计算1-5之间的数据和
        // 2.在for循环外定义一个sum，用于累加得到的每一个数字
        int sum = 0;

        // 1.使用for循环，得到1-5之间的所有数字
        // sum: 1   3   6   10  15
        // i:   1   2   3   4   5   6

        for (int i = 1; i <= 5; i++) {
            // 3.每得到一个数字，就加到累加变量中
            sum += i;
        }

        System.out.println("1-5之间所有数字的和是：" + sum);
    }
}
