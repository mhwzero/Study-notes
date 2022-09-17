package com.itheima.p4_quanxian;

public class Zi04 extends Fu04 {

    //子类自己的方法
    public void show() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        //错误: 同一个包的子类中,private权限不能使用
        //System.out.println(d);
    }

    //子类重写父类的方法

    @Override
    public void method() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        //错误: 同一个包的子类中,private权限不能使用
        //System.out.println(d);
    }
}
