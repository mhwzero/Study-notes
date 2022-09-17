package com.itheima.test03;

import com.itheima.test02.BeanFactory;

import java.io.IOException;

/*
    第三题:
        题目2通过读取配置文件，创建父类或接口的子类或实现类对象。
        但是每次都写同样的代码,导致可读性差,代码臃肿。
        为提高代码的维护和扩展性，以后做项目时，经常使用接口类型接收实现类对象，
        如果每次都像题目2中的代码，同样导致代码重复臃肿。

    本题目要求:
        定义工具类BeanFactory,内部定义静态方法newInstance读取.properties配置文件,
        获取接口名和对应的实现类名,通过反射创建实现类对象,方法参数传递接口的Class对象。

    实现步骤:
        1、定义FlyAble接口,该接口中定义抽象方法fly
        2、定义FlyAble接口实现类Bird,重写抽象方法fly
        3、定义JumpAble接口,该接口中定义抽象方法jump
        4、定义JumpAble接口实现类Cat,重写抽象方法jump
        5、定义BeanFactory类,该类中定义newInstance方法
            5.1、获取传递的接口名
            5.2、通过类加载器,获取资源的字节输入流
            5.3、创建Properties集合对象
            5.4、Properties集合对象调用load方法，以键值对的方式加载配置文件信息
            5.5、Properties集合对象调用getProperty方法，获取接口实现类的名称
            5.6、反射创建对象并返回
            5.7、出现异常返回null
        6、定义测试类

 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        /*FlyAble flyAble = new Bird();
        flyAble.fly();
        JumpAble jumpAble = new Cat();
        jumpAble.jump();*/

        //6、定义测试类
        FlyAble flyAble = BeanFactory.newInstance(FlyAble.class);
        flyAble.fly();

        JumpAble jumpAble = BeanFactory.newInstance(JumpAble.class);

        jumpAble.jump();

        EatAble eatAble = BeanFactory.newInstance(EatAble.class);
        eatAble.eat();
    }
}