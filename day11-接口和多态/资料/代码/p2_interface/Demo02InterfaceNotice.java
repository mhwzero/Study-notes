package com.itheima.p2_interface;
/*
    接口的多实现
        在继承体系中，一个类只能继承一个父类【类的单继承： 亲爹只能有一个】。
        对于接口而言，一个类是可以实现多个接口的，这叫做接口的多实现
        【类实现接口的多实现： 干爹可以有多个】。并且，一个类能继承一个父类，同时实现多个接口。

    一个类能继承一个父类，同时实现多个接口格式:
        public class 子类名 extends 父类名 implements 接口名A,接口名B {
            覆盖重写抽象父类和接口中的所有的抽象方法
        }

    实现步骤:
        1.创建抽象父类AbstractClass,内部定义抽象方法
        2.创建接口MyInterA和MyInterB,内部定义抽象方法
        3.创建子类MyClass 继承 抽象父类AbstractClass 实现接口 MyInterA和MyInterB
        4.子类MyClass 覆盖重写抽象父类和接口中的所有的抽象方法
        5.创建子类MyClass的对象
        6.使用子类MyClass的对象调用方法

    注意:
        子类必须重写父类和接口中的所有抽象方法,只要有一个抽象方法没有被重写,
        该子类必须定义为抽象类,看MyClass02类
*/
public class Demo02InterfaceNotice {
    public static void main(String[] args) {
        //5.创建子类MyClass的对象
        MyClass mc = new MyClass();

        //6.使用子类MyClass的对象调用方法
        mc.method();
        mc.show();
        mc.fun();
    }
}
