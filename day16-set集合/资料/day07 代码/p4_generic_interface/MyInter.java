package com.itheima.p4_generic_interface;
/*
    定义接口时,该接口中需要处理某种类型的数据,但是什么类型,不确定,所以定义成泛型
        接口中的所有非静态方法,都可以使用该泛型
 */
public interface MyInter<T> {
    //抽象方法
    public abstract void method(T t);
}
