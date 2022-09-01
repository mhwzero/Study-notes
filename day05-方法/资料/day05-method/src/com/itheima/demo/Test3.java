package com.itheima.demo;

public class Test3 {
    public static void main(String[] args) {
        // 需求：定义一个方法，支持返回任意整形数组的最大值
        int[] faceScores = {15, 9000, 10000, 20000, 9500, -5};
        // 6.调用方法
        int result = getArrayMax(faceScores);
        System.out.println("数组元素最大值是：" + result);
    }

    // 1.定义一个方法
    public static int getArrayMax(int[] arr) {
        // 2.先定义一个临时变量，存储临时最大值
        int max = arr[0];
        // 3.for循环，遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 4.判断当前元素是否比临时最大值大，如果大，则替换
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 5.返回最终的结果
        return max;
    }
}
