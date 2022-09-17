package com.itheima.p1_math;

/*
    java.lang.Math类: 用于数学运算的工具类
    特点:
        1.成员都使用static修饰
        2.构造方法private修饰
    静态成员:
        public static final double PI: 常量,代表圆周率
        public static int abs(int a): 返回参数的绝对值
        public static double ceil(double a): 返回大于或等于参数的最小double值，等于一个整数
        public static double floor(double a): 返回小于或等于参数的最大double值，等于一个整数
        public static int round(float a): 按照四舍五入返回最接近参数的int
        public static double pow(double a, double b): 计算a的b次方

    注意:
        以上方法中必须掌握ceil方法
        后面学习分页查询
        假设每页显示条数固定的: 10条
        如果有100条数据: 10页
        如果有101条数据: 11页
        如果有99条数据: 10页

        [1][2][3]...[10]
*/
public class Demo01Math {
    public static void main(String[] args) {
        System.out.println("圆周率: " + Math.PI);
        //abs方法: 获取绝对值
        System.out.println(Math.abs(6.6));//6.6
        System.out.println(Math.abs(-6.6));//6.6
        System.out.println(Math.abs(66));//66
        System.out.println(Math.abs(0));//0
        System.out.println(Math.abs(-66));//66
        System.out.println("-----------");
        //ceil(double a): 返回大于或等于参数的最小double值，等于一个整数
        System.out.println(Math.ceil(5.2));//6.0
        System.out.println(Math.ceil(5.6));//6.0
        System.out.println(Math.ceil(5.0));//5.0
        System.out.println(Math.ceil(-5.2));//-5.0
        System.out.println(Math.ceil(-5.6));//-5.0
        System.out.println(Math.ceil(-5.0));//-5.0
        System.out.println("-----------");
        //floor(double a): 返回大于或等于参数的最小double值，等于一个整数
        System.out.println(Math.floor(5.2));//5.0
        System.out.println(Math.floor(5.6));//5.0
        System.out.println(Math.floor(5.0));//5.0
        System.out.println(Math.floor(-5.2));//-6.0
        System.out.println(Math.floor(-5.6));//-6.0
        System.out.println(Math.floor(-5.0));//-5.0
        System.out.println("-----------");
        //int round(float a): 按照四舍五入返回最接近参数的int
        System.out.println(Math.round(5.2));//5
        System.out.println(Math.round(5.6));//6
        System.out.println(Math.round(5.0));//5
        System.out.println("-----------");
        //double pow(double a, double b): 计算a的b次方
        System.out.println(Math.pow(2, 10));//1024
        //153是水仙花数字
        int sum = (int) (Math.pow(1, 3) + Math.pow(5, 3) + Math.pow(3, 3));
        System.out.println("153是水仙花数字吗? " + (sum == 153));
    }
}
