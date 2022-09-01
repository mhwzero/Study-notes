package com.itheima.p3_interface;
//接口可以多继承: 子接口会自动拥有父接口中的所有抽象方法
public interface MyInter03D extends MyInter03A, MyInter03B, MyInter03C{
    /*
        抽象方法a,b,c已经在其它接口MyInter03A,MyInter03B,MyInter03C中定义好了,
        此处不需要单独定义了,只需要继承其它接口即可
     */
    /*void a();
    void b();
    void c();*/
    void d();
}
