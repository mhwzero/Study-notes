package com.itheima.paramdemo;

public class Demo2 {
    public static void main(String[] args) {
        // 需求：从数组中查询指定元素的索引
        int[] ages = {11, 22, 33, 44, 55};
        int index = getIndex(ages, 33);
        System.out.println(index);
    }

    // 1.定义方法，接收一个数组类型的参数和一个整数类型的参数
    public static int getIndex(int[] arr, int data) {
        // 2.遍历数组
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;  // 查无此元素
    }
}
