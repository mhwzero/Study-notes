package com.itheima.demo;

import java.util.Scanner;

public class Demo6 {
    public static void main(String[] args) {
        // 需求：评委打分：6位评委打分，最终得分为去掉一个最高分，去掉一个最低分，最后四位评委打分的平均值为选手最终得分
        // 1.定义一个动态初始化的数组
        int[] scores = new int[6];

        // 2.让评委打分
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i + 1) + "位评委得分：");
            scores[i] = scanner.nextInt();
        }

        // 3.再遍历，找到最高分、最低分和总分
        int max = scores[0];
        int min = scores[0];
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            // 先计算总分
            int score = scores[i];
            sum += score;

            // 找最大值
            if (score > max) {
                max = score;
            }

            // 找最小值
            if (score < min) {
                min = score;
            }
        }

        // 4.计算最终得分
        double result = (sum - max - min) * 1.0 / (scores.length - 2);

        System.out.println("所有评委的打分：");
        printArray(scores);

        System.out.println("去掉一个最高分：" + max);
        System.out.println("去掉一个最低分：" + min);
        System.out.println("选手最终得分为：" + result);

    }
    //输出语句
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
        }
        System.out.println("]");
    }
}
