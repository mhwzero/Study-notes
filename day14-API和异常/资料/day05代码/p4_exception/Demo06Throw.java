package com.itheima.p4_exception;

/*
    Demo05Exception中异常对象是由JVM创建并自动抛出的
        如果我们想自己创建异常对象并手动抛出
        需要使用throw关键字
        throw关键字: 扔,抛的意思
        throw关键字使用格式:
            throw 异常对象;
            throw new 异常类(...);
        注意:
            1.throw必须使用在方法内部
            2.throw后面必须写异常对象,而且只能写一个
            3.throw表示把一个具体的异常对象抛出给该方法的调用者
*/
public class Demo06Throw {
    public static void main(String[] args) {
        int[] array = {100, 200, 300};
        //array = null;
        int value = getValue(array, 2);
        System.out.println("main方法中正确获取到数组元素值: " + value);
    }

    //定义方法,获取int数组array中索引index对应的元素值
    public static int getValue(int[] array, int index) {
        //判断空指针
        if (null == array) {
            throw new NullPointerException("数组是" + array+"了,无法获取数组了...");
        }
        //判断索引越界
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("数组索引" + index + "超出了范围了....");
        }
        int value = array[index];
        System.out.println("getValue方法中正确获取到数组元素值: " + value);
        return value;
    }
}