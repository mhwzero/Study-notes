package com.itheima.p2_extends_var;
/*
	继承中的成员变量访问特点
        1.不重名的成员变量
            (1)子类自己有: 优先使用子类自己的
            (2)子类没有: 找父类
            (3)注意: 子类可以找父类,但是父类不能找子类
        2.重名的成员变量
    		(1)方法内部,直接写变量名
                从方法内部开始向上找
                方法内部有: 直接使用
                方法内部没有: 向上找,本类的成员位置
                本类的成员位置有: 直接使用
                本类的成员位置没有: 向上找,父类的成员位置
            (2)方法内部,直接写this.变量名
                从本类的成员位置开始向上找
                本类的成员位置有: 直接使用
                本类的成员位置没有: 向上找,父类的成员位置
            (3)方法内部,直接写super.变量名
                从父类成员位置开始向上找
                父类的成员位置有: 直接使用
                父类的成员位置没有: 继续向上找
            (4)总结:就近原则
*/
public class Demo02ExtendsVar {
    public static void main(String[] args) {
        //创建子类对象
        Zi02 zi02 = new Zi02();

        //调用成员方法
        zi02.show();

        //输出成员变量
        System.out.println(zi02.numZi);//子类自己的: 10
        System.out.println(zi02.numFu);//父类自己的: 100

        //调用成员方法
        System.out.println("------------");
        zi02.method();
        System.out.println("------------");
    }
}
