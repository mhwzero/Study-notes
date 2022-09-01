package com.itheima.p5_duotai;
/*
    强制类型转换(向下转型)存在安全隐患:
        如果转后类型和创建对象的具体类型不一致,报出类型转换异常 ClassCastException

    如何解决呢?
        如果变量a指向的是Dog类型,把Animal类型的变量a强制转换成Dog类型
        如果变量a指向的是Cat类型,把Animal类型的变量b强制转换成Cat类型

    如何判断变量a指向的到底是哪种类型的对象呢?
        使用instanceof关键字
        使用格式:
            boolean result = 对象名 instanceof 类名
                如果对象名称中保存的是该类的对象,返回true。
                如果对象名称中保存的不是该类的对象,返回false。
*/
public class Demo10ZhuanXing {
    public static void main(String[] args) {
        //多态的方式创建对象: 叫向上转型(把子类对象当成父类类型使用,把小类型当成大类型使用)
        //Animal a = new Cat();
        Animal a = new Dog();

        //多态的方式调用方法
        a.eat();
        a.sleep();

        //多态的缺陷: 不能直接调用子类的特有方法
        //a.kanHome();
        //a.catchMouse();
        //判断引用变量a指向的是否是Dog类的对象,如果是返回true,如果不是返回false
        if(a instanceof Dog){
            //把引用变量a中保存的内存地址值复制一份强制类型转换成Dog类型,复制给左侧的Dog变量
            Dog dog = (Dog) a;
            dog.kanHome();
        } else {
            //把引用变量a中保存的内存地址值复制一份强制类型转换成Cat类型,复制给左侧的Cat变量
            Cat cat = (Cat) a;
            cat.catchMouse();
        }
    }
}
