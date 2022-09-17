package com.itmhw.test;

public class Test1 {
    public static void main(String[] args) throws Exception {
        FlyAble flyAble = BeanFactory.newInstance(FlyAble.class);
        flyAble.fly();
        JumpAble jumpAble = BeanFactory.newInstance(JumpAble.class);
        jumpAble.jump();

    }
}
