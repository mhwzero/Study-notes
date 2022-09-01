package com.itheima.create;

public class Demo2 {
    public static void main(String[] args) {
        // 目标：掌握数组元素的访问
        // 取值：数组名[索引值]
        // 赋值：数组名[索引值] = 数值;
        int[] ages = {18, 19, 21};
        //             0   1   1
        // 访问索引为0的元素
        int age1 = ages[0];
        System.out.println(age1);   // 18

        int age2 = ages[2];
        System.out.println(age2);   // 21

        // 修改索引位置为1的元素值为27
        ages[1] = 27;
        System.out.println(ages[1]);    // 27

        // 获取数组的长度，length属性
        int length = ages.length;
        System.out.println(length); // 3

        // 数组的最大索引：arr.length - 1
        System.out.println(ages.length - 1);    // 2

        // 数组的最大索引：arr.length - 1的前提是数组元素个数至少为1个
        double[] scores = {};
        System.out.println(scores.length - 1);  // -1

    }
}
