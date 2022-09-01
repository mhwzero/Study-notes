package com.itheima.p2_extends_var;

public class Zi02 extends Fu02 {
    int numZi = 10;
    int num = 20;

    //子类成员方法
    public void show() {
        System.out.println(numZi);//子类自己的: 10
        System.out.println(numFu);//父类自己的: 100
    }

    //子类成员方法
    public void method() {
        int num = 2;
        //输出2
        System.out.println(num);
        //输出20
        System.out.println(this.num);
        //输出200
        System.out.println(super.num);
    }
}
