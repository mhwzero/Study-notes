package com.itheima.p5_duotai;
/*
    多态中成员方法的访问特点
        编译时期看左边(父类/接口),运行时期看右边(子类/实现类)
 */
public class Demo05DuoTai {
    public static void main(String[] args) {
        //多态的方式创建Animal类的对象
        Animal a = new Dog();

        //多态的方式调用方法
        /*
            在多态中把Dog对象(子类对象)当成Animal类型(父类)使用,
            此时Dog对象表现的是父类Animal的形态
            多态的方式调用eat/sleep方法
            编译时期: 检测父类Animal中是否有eat/sleep方法的定义
            发现父类中: 有eat/sleep方法的定义,编译通过
            运行时期:   运行的是Dog类中重写后的eat/sleep方法
         */
        a.eat();
        a.sleep();
        /*
            在多态中把Dog对象(子类对象)当成Animal类型(父类)使用,
            此时Dog对象表现的是父类Animal的形态
            多态的方式调用kanHome方法
            编译时期: 检测父类Animal中是否有kanHome方法的定义
            发现父类中: 没有有kanHome方法的定义,编译失败了,不能运行了
         */
        //a.kanHome();

        //多态的方式创建Animal类的对象
        Animal a2 = new Cat();

        //多态的方式调用方法
        /*
            在多态中把Cat对象(子类对象)当成Animal类型(父类)使用,
            此时Cat对象表现的是父类Animal的形态
            多态的方式调用eat/sleep方法
            编译时期: 检测父类Animal中是否有eat/sleep方法的定义
            发现父类中: 有eat/sleep方法的定义,编译通过
            运行时期:   运行的是Cat类中重写后的eat/sleep方法
         */
        a2.eat();
        a2.sleep();
        /*
            在多态中把Cat对象(子类对象)当成Animal类型(父类)使用,
            此时Cat对象表现的是父类Animal的形态
            多态的方式调用catchMouse方法
            编译时期: 检测父类Animal中是否有catchMouse方法的定义
            发现父类中: 没有有catchMouse方法的定义,编译失败了,不能运行了
         */
        //a2.catchMouse();
    }
}
