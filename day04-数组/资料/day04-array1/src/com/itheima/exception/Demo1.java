package com.itheima.exception;

public class Demo1 {
    public static void main(String[] args) {
        // 1.ArrayIndexOutOfBoundsException，数组索引越界异常
        int[] ages = {11, 22, 33};
        System.out.println(ages[0]);
        System.out.println(ages[1]);
        System.out.println(ages[2]);
//        System.out.println(ages[3]);    // java.lang.ArrayIndexOutOfBoundsException

        // 2.NullPointerException，空指针异常，如果数组名没有指向任何具体的数组，而是null，那么访问数组长度属性或者数组索引位置的元素，都会出现这个异常
        ages = null;
        System.out.println(ages);   // null
//        System.out.println(ages.length);    // java.lang.NullPointerException
        System.out.println(ages[0]);    // java.lang.NullPointerException


    }
}
