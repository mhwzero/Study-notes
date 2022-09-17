package com.itheima.p9_niming_class;
//定义具体的实现类
public class Bird implements FlyAble {
    //覆盖重写抽象方法
    @Override
    public void fly() {
        System.out.println("鸟儿在高空自由的飞翔....");
    }
}
