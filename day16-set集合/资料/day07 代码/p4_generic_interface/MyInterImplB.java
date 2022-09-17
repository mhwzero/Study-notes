package com.itheima.p4_generic_interface;
/*
    2.定义实现类时,也不确定接口上的泛型
            该实现类必须定义为泛型类
            而且实现类上的泛型和接口上的泛型要保持一致
            创建实现类对象时,确定具体的类型
 */
public class MyInterImplB<T> implements MyInter<T> {
    @Override
    public void method(T t) {
        System.out.println(t);
    }
}
