package com.itheima.p3_interface;
/*
    java中继承的特点:
        1.类之间的继承: 只能单继承,可以多层继承
        2.接口之间的继承: 可以多继承
        3.类和接口之间:
            一个类可以继承一个父类,同时实现多个接口

    子接口会拥有父接口中的所有抽象方法
 */
public class Demo03InterfaceExtends {
    public static void main(String[] args) {
        MyInter03DImpl myInter03D = new MyInter03DImpl();
        //调用方法
        myInter03D.a();
        myInter03D.b();
        myInter03D.c();
        myInter03D.d();
    }
}
