package com.itheima.loop;

public class ForTest3 {
    public static void main(String[] args) {
        // 需求：计算1-10之间的所有奇数和
        // 3.在循环外定义一个累加变量sum，用来统计最终的结果
        int sum = 0;

        // 1.使用for循环，产生1-10之间的所有数字
        for (int i = 1; i <= 10; i++) {
            // 2.判断当前数字是否是奇数
            if (i % 2 == 1) {
                sum += i;
            }
        }

        // 4.打印最终结果
        System.out.println("1-10之间所有奇数的和是：" + sum);

        System.out.println("=================");

        // 方式二：
        // 3.在循环外定义一个累加变量sum，用来统计最终的结果
        int sum1 = 0;

        // 1.使用for循环，产生1-10之间的所有数字
        for (int i = 1; i <= 10; i+=2) {
            sum1 += i;
        }
        // 4.打印最终结果
        System.out.println("1-10之间所有奇数的和是：" + sum1);

    }
}
