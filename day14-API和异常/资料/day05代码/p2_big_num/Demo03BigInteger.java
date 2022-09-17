package com.itheima.p2_big_num;
/*
    BigInteger类的使用
    java.math.BigInteger类: 代表超级大的整数,不可变的任意精度的整数。
    1.构造方法:
        public BigInteger(String val):
        	作用: 把构造方法参数String类型的val,转换成BigInteger类的对象
            参数: 必须是String类型的数字,内部不能出现非数字内容

    2.常用方法:
        数学运算中最常用的就是+,-,*,/,所以对于BigInteger类提供了对应的方法
        public BigInteger add(BigInteger val):
            完成数学中的加法运算,
            返回其值为 (this(调用add方法的BigInteger对象) + val(调用add方法时传递的参数BigInteger对象)) 的 BigInteger。

        public BigInteger subtract(BigInteger val):
            完成数学中的减法运算,
            返回其值为 (this(调用add方法的BigInteger对象) - val(调用add方法时传递的参数BigInteger对象)) 的 BigInteger。

        public BigInteger multiply(BigInteger val):
            完成数学中的乘法运算,
            返回其值为 (this(调用add方法的BigInteger对象) * val(调用add方法时传递的参数BigInteger对象)) 的 BigInteger。

        public BigInteger divide(BigInteger val):
            完成数学中的除法运算,
            返回其值为 (this(调用add方法的BigInteger对象) / val(调用add方法时传递的参数BigInteger对象)) 的 BigInteger。
*/

import java.math.BigInteger;

public class Demo03BigInteger {
    public static void main(String[] args) {
        //创建BigInteger类对象
        BigInteger b1 = new BigInteger("66666666666666666666");
        System.out.println(b1);

        //报错: ""中不能有非数字符号
        //BigInteger b2 = new BigInteger("3333333333a3333333333");
        //BigInteger b2 = new BigInteger("3333333333.3333333333");
        BigInteger b2 = new BigInteger("33333333333333333333");

        //调用add方法完成加法计算
        BigInteger b3 = b1.add(b2);
        System.out.println("和 = " + b3);

        //调用subtract方法完成减法计算
        BigInteger b4 = b1.subtract(b2);
        System.out.println("差 = " + b4);

        //调用multiply方法完成乘法计算
        BigInteger b5 = b1.multiply(b2);
        System.out.println("积 = " + b5);

        //调用divide方法完成除法计算
        BigInteger b6 = b1.divide(b2);
        System.out.println("商 = " + b6);
    }
}
