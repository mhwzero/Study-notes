package com.itheima.p2_generic_class;
//定义泛型类
/*
    定义类时,该类中需要处理某种类型的数据,但是什么类型,不确定,所以定义成泛型

    注意:
        泛型类中可以把泛型当成某种具体的类型提前使用
 */
public class MyClass02<T> {
    //定义成员变量
    private T t;

    //toString方法
    @Override
    public String toString() {
        return "MyClass02{" +
                "t=" + t +
                '}';
    }

    //空参/满参构造方法
    public MyClass02() {
    }

    public MyClass02(T t) {
        this.t = t;
    }

    //提供get/set
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
