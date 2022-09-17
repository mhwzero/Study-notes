package com.itheima.p4_suanfa;

/*
    二分查找
        前提:
            1.数组必须要保证是有序的
            2.数组元素不能重复

        原理:
            取数组中间的元素和被查找的元素进行比较，如果被查找元素大于数组中间元素，
            就舍去数组元素左的一半，对另一半继续进行查找。
*/
public class Demo06BinarySearch {
    public static void main(String[] args) {
        int[] array = {5, 13, 19, 21, 37, 56, 64, 75, 80, 88, 92};

        System.out.println(getIndex(array,5));//0
        System.out.println(getIndex(array,56));//5
        System.out.println(getIndex(array,92));//10
        System.out.println(getIndex(array,100));//-1
    }

    /*
        定义方法在int数组中获取一个元素第一次出现的索引值,如果没有返回-1
        三要素:
            1.方法名称: getIndex
            2.参数列表:
                int[] array: 要查找元素的int数组
                int value: 要在数组中查找的元素
            3.返回值类型: int
    */
    public static int getIndex(int[] array, int value) {
        //定义两个int变量start和end,保存最小/最大索引值
        int start = 0, end = array.length - 1;
        //使用二分查找思想获取元素索引,到底多少次可以找到,不确定,使用while循环
        //二分查找的条件: start <= end
        while (start <= end) {
            //计算中间索引值
            int midIndex = (start + end) / 2;
            //计算中间索引对应的元素值
            int midValue = array[midIndex];
            //判断如果中间索引对应的元素值 等于 value 说明找到了
            if (midValue == value) {
                //返回索引值
                return midIndex;
            } else if (midValue < value) {
                //中间索引对应的元素值 小于 value 说明value应该在中间值的右侧,需要修改start的值
                start = midIndex + 1;
            } else {
                //中间索引对应的元素值 大于 value 说明value应该在中间值的左侧,需要修改end的值
                end = midIndex - 1;
            }
        }
        //代码执行到这里,说明没找到
        return -1;
    }
}
