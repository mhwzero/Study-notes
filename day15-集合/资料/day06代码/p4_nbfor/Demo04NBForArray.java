package com.itheima.p4_nbfor;

/*
    数组定义格式:
        数据类型[] 数组名称 = new 数据类型[长度];
        int[] arr = new int[3];

    格式:
        for(数组存储元素的类型 变量名称 : 数组) {
            ...
        }

    注意:
        1.变量名称不是用来存储数组的索引值的,而是用来存储数组中的每个元素的
        2.增强for遍历数组底层使用的是普通for
        3.增强for遍历数组时,请不要对数组元素进行增删改的操作,否则出现问题,自己解决
        4.增强for遍历数组快捷键:
            数组名.for
 */
public class Demo04NBForArray {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 50};
        //普通for遍历
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("---------");
        //增强for遍历
        for(int num : array){
            System.out.println(num);
        }
        System.out.println("---------");
        //增强for遍历快捷键: 数组名.for
        for (int num : array) {
            System.out.println(num);
        }
    }
}
