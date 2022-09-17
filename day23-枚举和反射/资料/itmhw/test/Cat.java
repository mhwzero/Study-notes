package com.itmhw.test;

//4、定义JumpAble接口实现类Cat,重写抽象方法jump
public class Cat implements JumpAble {
    @Override
    public void jump() {
        System.out.println("猫儿在跳...");
    }
}