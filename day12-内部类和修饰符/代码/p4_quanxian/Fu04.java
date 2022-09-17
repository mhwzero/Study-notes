package com.itheima.p4_quanxian;

public class Fu04 {
    //分别使用四种权限修饰符定义变量
    public int a = 1;
    protected int b = 2;
    int c = 3;
    private int d = 4;

    //定义方法
    //同一个类中: 四种权限都可以使用
    public void method() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
