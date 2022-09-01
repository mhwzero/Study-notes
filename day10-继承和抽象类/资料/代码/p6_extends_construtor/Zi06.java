package com.itheima.p6_extends_construtor;

public class Zi06 extends Fu06 {
    //子类的空参构造方法
    public Zi06() {
        super();//调用父类的空参构造,不写也有
        //错误: super调用父类构造,只能写一次
        //super();//调用父类的空参构造,不写也有
        System.out.println("子空参...");
        //错误: super调用父类构造,只能写在第一行
        //super();//调用父类的空参构造,不写也有
    }

    //子类的满参构造方法
    public Zi06(int num) {
        //如果没有自己写super,默认使用super()调用父类空参
        //可以自己写super(...): 调用父类的有参构造方法
        super(num);
        System.out.println("子满参...");
    }
}
