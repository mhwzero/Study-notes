package com.itheima.p2_big_num;

import java.math.BigDecimal;

/*
    BigInteger类的使用
    java.math.BigDecimal类: 代表超级大的小数,不可变的任意精度的小数。
    1.构造方法:
        public BigDecimal(String val):
        	作用: 把构造方法参数String类型的val,转换成BigDecimal类的对象
            参数: 必须是String类型的数字,内部不能出现非数字内容

    2.常用方法:
        数学运算中最常用的就是+,-,*,/,所以对于BigDecimal类提供了对应的方法
        对于+,-,*这些运算和BigInteger是一样的,就不再演示了
        但是对于 除法 运算,可能会出现 无限循环/无限不循环的结果
        然而BigDecimal是用来完成超级精确的数学运算,这样就导致
        BigDecimal不知道到底给你什么样的结果?
        解决方案:
            (1)告诉它保留多少位小数
            (2)如何保留小数

        public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode):
            按照方法参数指定的保留位数以及保留方式做除法运算
            参数:
                 int scale: 要保留几位小数
                 int roundingMode: 如何保留小数
                        BigDecimal.ROUND_UP 向上加1。
                        BigDecimal.ROUND_DOWN 直接舍去。
                        BigDecimal.ROUND_HALF_UP 四舍五入。
*/
public class Demo04BigDecimal {
    public static void main(String[] args) {
        //创建BigDecimal类的对象
        BigDecimal b1 = new BigDecimal("10.0");
        System.out.println(b1);

        //报错: ""中不能有非数字符号
        //BigDecimal b2 = new BigDecimal("666a6666.666666666");

        BigDecimal b2 = new BigDecimal("3.0");

        //divide方法: 做除法运算
        //BigDecimal b3 = b1.divide(b2);//出现无限循环结果,直接报错了

        //保留6位小数: 从第7位开始直接舍去
        BigDecimal b3 = b1.divide(b2, 6, BigDecimal.ROUND_DOWN);
        System.out.println("b3 = " + b3);//3.333333

        //保留6位小数: 从第7位开始直接进一位
        BigDecimal b4 = b1.divide(b2, 6, BigDecimal.ROUND_UP);
        System.out.println("b4 = " + b4);//3.333334

        //保留6位小数: 从第7位开始四舍五入
        BigDecimal b5 = b1.divide(b2, 6, BigDecimal.ROUND_HALF_UP);
        System.out.println("b5 = " + b5);//3.333333

    }
}
