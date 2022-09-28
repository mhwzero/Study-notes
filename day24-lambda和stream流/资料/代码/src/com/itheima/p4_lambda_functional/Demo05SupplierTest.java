package com.itheima.p4_lambda_functional;

import java.util.function.Supplier;

/*
    Supplier接口的get方法练习求int数组最大值
 */
public class Demo05SupplierTest {
    public static void main(String[] args) {
        int[] array = {50, 60, 70, 80, 90, 100};
        //1.调用方法传递匿名内部类对象
        fun(new Supplier<Integer>() {
            @Override
            public Integer get() {
                //给计算int数组之和的方案
                int sum = 0;
                for (int i = 0; i < array.length; i++) {
                    sum += array[i];
                }
                return sum;
            }
        });
        //2.调用方法传递lambda表达式标准格式
        fun(() -> {
            //给计算int数组之平均值的方案
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            return sum / array.length;
        });
        //3.调用方法传递lambda表达式简化格式  --没有
    }

    /*
        定义方法,使用函数式接口Supplier作为参数
     */
    public static void fun(Supplier<Integer> supplier) {
        //调用抽象方法get,获取int数字value
        //至于value的内容是什么以及如何获取,这里说不清楚
        int result = supplier.get();
        System.out.println(result);
    }
}
