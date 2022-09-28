package com.itheima.p4_lambda_functional;

import java.util.function.Function;

/*
    --------------------------------重点掌握-----------------------
    java中常用的函数式接口,都被定义在java.util.function包中

        java.util.function.Function<T, R>接口: 转换型接口 功能: 把T类型的数据转换成R类型
        抽象方法:
            public abstract R apply(T t): 根据方法参数T类型的t,获取R类型的数据

            转换前: T类型
            转换后: R类型

        练习:
            给你一个String的数字,你给我转成一个int数字
            转换前: String类型   <---T
            转换后: Integer类型  <---R
 */
public class Demo07Function {
    public static void main(String[] args) {
        String sNum = "12345";
        //1.调用方法传递匿名内部类对象
        fun(sNum, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });
        //2.调用方法传递lambda表达式标准格式
        fun(sNum, (String s) -> {
            return Integer.parseInt(s);
        });
        //3.调用方法传递lambda表达式简化格式
        fun(sNum, s -> Integer.parseInt(s));
    }

    /*
        定义方法,使用函数式接口Function作为参数
     */
    public static void fun(String strNum, Function<String, Integer> function) {
        int num = function.apply(strNum);
        System.out.println(num);
    }
}
