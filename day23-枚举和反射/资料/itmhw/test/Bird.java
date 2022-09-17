package com.itmhw.test;

//2、定义FlyAble接口实现类Bird,重写抽象方法fly
public class Bird  implements FlyAble{
    @Override
    public void fly() {
        System.out.println("鸟儿在飞....");
    }
}