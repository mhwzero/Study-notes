package com.itheima.p8_inner_class;

public class Person {//外部类
    int age = 18;
    private int count = 10;//次数

    static int num2 = 100;

    public class Heart {//内部类
        //跳动
        public void jump() {
            //内部类可以使用外部类的成员(包含private修饰的)
            for (int i = 0; i < count; i++) {
                System.out.println("我的小心脏那个扑通扑通的跳啊.....");
            }
        }
    }
}
