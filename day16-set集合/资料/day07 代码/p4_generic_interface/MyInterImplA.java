package com.itheima.p4_generic_interface;
/*
    1.实现类实现接口时,确定接口上泛型的具体类型的话,
            直接指定具体类型
 */
public class MyInterImplA implements MyInter<String> {
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
