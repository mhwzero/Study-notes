package com.itheima.p8_abstract;
/*
    抽象:
    1.概念:
        说不清楚的,不够具体的,功能子类要有,但是具体如何实现,父类不管,子类自己决定
        举例:
            所有的动物都应该具备吃的能力,但是具体的怎么吃,吃什么,无法在父类中做统一规定,
            但是吃的能力子类必须具备,具体如何实现,父类不管,子类自己实现/决定
    2.抽象类中抽象方法存在的意义:强制要求子类必须具备的能力
    3.抽象类的定义格式:
        public abstract class 类名 {
            ...
        }
    4.抽象方法的定义格式:
        修饰符 abstract 返回值类型 方法名称(参数列表...);
        注意:
            (1)和以前定义方法一样,但是去掉{},添加abstract关键字
            (2)返回值类型和参数列表根据需求确定
            (3)含有抽象方法的类,必须定义为抽象类,但是抽象类中不一定含有抽象方法
    5.抽象类的使用
        (1)不能直接创建抽象类的对象
        (2)定义子类,继承抽象父类
        (3)子类中覆盖重写抽象父类中的所有抽象方法
                    去掉abstract关键字,添加{}
                    快捷键: ctrl + i
        (4)创建子类对象
        (5)子类对象调用方法
*/
public class Demo08Abstract {
    public static void main(String[] args) {
        //错误: 不能直接创建抽象类的对象
        //Animal a = new Animal();

        //创建子类Dog类的对象: 空参构造方法
        Dog dog = new Dog();

        //调用set方法给成员变量赋值
        dog.setName("土豆");
        dog.setWeight(60);

        //调用成员方法
        dog.show();
        dog.eat();
        dog.sleep();
        dog.kanHome();
        System.out.println("---------------");

        //创建子类Cat类的对象: 满参构造方法
        Cat cat = new Cat("咖啡", 10);

        //调用成员方法
        cat.show();
        cat.eat();
        cat.sleep();
        cat.catchMouse();
    }
}
