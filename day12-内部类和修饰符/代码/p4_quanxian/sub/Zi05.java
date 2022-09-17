package com.itheima.p4_quanxian.sub;

import com.itheima.p4_quanxian.Fu04;
//不同包的子类
public class Zi05 extends Fu04 {
    //子类自己的方法
    public void fun() {
        System.out.println(a);
        System.out.println(b);
        //错误: 不同包的子类中,默认和private不能使用
        //System.out.println(c);
        //System.out.println(d);
    }

    //子类重写父类的方法

    @Override
    public void method() {
        System.out.println(a);
        System.out.println(b);
        //错误: 不同包的子类中,默认和private不能使用
        //System.out.println(c);
        //System.out.println(d);
    }
}
