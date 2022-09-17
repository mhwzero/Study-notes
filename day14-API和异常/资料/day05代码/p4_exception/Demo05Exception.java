package com.itheima.p4_exception;

/*
    JVM默认的异常处理机制
        1.打印异常信息
        2.停止程序的执行(全都得死)
 */
public class Demo05Exception {
    public static void main(String[] args) {
        int[] array = {100, 200, 300};
        int value = getValue(array, 5);
        System.out.println("main方法中正确获取到数组元素值: " + value);
    }

    //定义方法,获取int数组array中索引index对应的元素值
    public static int getValue(int[] array, int index) {
        int value = array[index];
        System.out.println("getValue方法中正确获取到数组元素值: " + value);
        return value;
    }
}