package com.itheima.p5_duotai;
/*
	多态中的向上转型
        多态的本质(父类引用指向子类对象): 就是向上转型
        类似于 基本类型的自动类型转换
        取值范围小的数据或者变量可以直接赋值给取值范围大的变量
        int a = 100;//int: 占4个字节
        double d = a;//double: 占8个字节
        不需要进行特殊的处理

    多态中的向下转型
        类似于 基本类型的强制类型转换
        取值范围大的数据或者变量不可以直接赋值给取值范围小的变量
        double d2 = 100;//double: 占8个字节
        int c = (int)d2;//int: 占4个字节
        强制类型转换:
            转后类型 对象名称 = (转后类型)转前的对象或者变量名称;
	注意:多态的向下转型(强制类型转换)存在安全隐患
        如果转换前的类型和转换后的类型不一致,就会报出类型转换异常(ClassCastException)
        如何解决这个问题呢?
*/
public class Demo09ZhuanXing {
    public static void main(String[] args) {
        //多态的方式创建对象: 叫向上转型(把子类对象当成父类类型使用,把小类型当成大类型使用)
        Animal a = new Cat();
        //Animal a = new Dog();

        //多态的方式调用方法
        a.eat();
        a.sleep();

        //多态的缺陷: 不能直接调用子类的特有方法
        //a.kanHome();
        //a.catchMouse();

        //把引用变量a中保存的内存地址值复制一份强制类型转换成Dog类型,复制给左侧的Dog变量
        Dog dog = (Dog) a;
        dog.kanHome();

        //Cat cat = (Cat) a;
        //cat.catchMouse();
    }
}
