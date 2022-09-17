package com.itheima.p3_generic_method;

public class MyClass03<T> {
    //非静态方法
    //注意: 不是泛型方法,是一个普通的方法,只不过使用了类上定义的泛型
    public void method(T t){
        System.out.println(t);
    }

    //非静态方法
    //注意: 是泛型方法,泛型E属于show方法本身
    public <E> void show(E e) {
        System.out.println(e);
    }

    /*
        静态方法: 不能使用类上定义的泛型
            静态方法直接有类名调用,此时没有对象,
            而类上的泛型,必须在创建对象时确定,
            既然没有对象,类上的泛型没有确定
     */
    /*public static void fun(T t) {

    }*/

    //静态方法
    public static <K> void print(K k) {
        System.out.println(k);
    }
}
