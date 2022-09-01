package com.itheima.p5_override_notice;

public class Zi05 extends Fu05{
    //正确: 父子类方法权限一致
    @Override
    public void a() {

    }

    //正确: 子类方法权限 大于 父类
    @Override
    public void b() {
        super.b();
    }

    //正确: 父子类方法返回值类型相同
    @Override
    public Object c() {
        return new Object();
    }

    //正确: 子类重写后的方法返回值类型 是 父类方法返回值类型的子类
    @Override
    public String d() {
        return "hello";
    }

    //错误: 子类方法返回值类型 不能是 父类方法返回值类型的父类
    /*@Override
    public Object e() {
        return new Object();
    }*/

    //错误: 父类方法f是私有的,无法继承,不存在重写
    //属于子类自己的方法,和父类无关
    //@Override
    public void f() {

    }
}
