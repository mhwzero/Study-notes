package com.itheima.paramdemo;

public class Demo3 {
    public static void main(String[] args) {
        // 需求：定义方法，判断两个整数数组是否完全一样

        int[] arr1 = {11, 22, 33, 44, 55};
        int[] arr2 = {11, 22, 33, 44, 55};

        boolean rs1 = isEquals(arr1, arr2);
        System.out.println(rs1);    // true

//        int[] arr3 = {11, 22, 33, 44, 55};
//        int[] arr4 = null;
//
//        boolean rs2 = isEquals(arr3, arr4);
//        System.out.println(rs2);    // false


//        int[] arr3 = {11, 22, 33, 44, 55};
//        int[] arr4 = {11, 22, 33};
//
//        boolean rs2 = isEquals(arr3, arr4);
//        System.out.println(rs2);    // false

    }

    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return false;
        }

        // 判断数组长度是否相等
        if (arr1.length != arr2.length) {
            return false;
        }

        // 判断2个数组对应位置的元素值是否相同
        for (int i = 0; i < arr1.length; i++) {
            // 判断对应位置的元素是否相同
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
