package com.itheima.test01;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    第一题:
        面向对象学习多态的好处可以提高代码的扩展性,
        但是如果直接new子类对象赋值给父类的引用,
        后期更换子类,必须要修改源代码,太麻烦。
        写一个"框架"，不能改变该类的任何代码的前提下，
        可以帮我们创建任意类的子类对象，并且执行其中任意方法。

    实现步骤:
        1、定义抽象父类Animal，该类中定义抽象方法eat
        2、定义子类Dog，继承抽象父类Animal，重写抽象方法eat
        3、定义config.properties配置文件,指定类名和方法名
        4、编写测试类
            4.1、创建Properties集合对象
            4.2、获取类加载器
            4.3、通过类加载器,获取配置文件的字节输入流对象
            4.4、Properties集合对象调用load方法，以键值对的方式加载配置文件信息
            4.5、获取类的全名称
            4.6、获取要执行的方法名称
            4.7、根据类的全名称获取类的Class类型的对象
            4.8、根据Class类型的对象获取要执行的方法对应的Method对象
            4.9、Class类型的对象创建一个具体的对象出来
            4.10、Method对象调用invoke方法,执行具体的功能

 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        /*Animal a = new Cat();
        a.eat();*/

        //4.1、创建Properties集合对象
        Properties props = new Properties();

        //4.2、获取类加载器
        ClassLoader classLoader = Test01.class.getClassLoader();

        //4.3、通过类加载器,获取配置文件的字节输入流对象
        InputStream is = classLoader.getResourceAsStream("config.properties");

        //4.4、Properties集合对象调用load方法，以键值对的方式加载配置文件信息
        props.load(is);

        //4.5、获取类的全名称
        String className = props.getProperty("className");

        //4.6、获取要执行的方法名称
        String methodName = props.getProperty("methodName");

        //4.7、根据类的全名称获取类的Class类型的对象
        Class clazz = Class.forName(className);

        //4.8、根据Class类型的对象获取要执行的方法对应的Method对象
        Method method = clazz.getMethod(methodName);

        //4.9、Class类型的对象创建一个具体的对象出来
        Object obj = clazz.newInstance();

        //4.10、Method对象调用invoke方法,执行具体的功能
        method.invoke(obj);
    }
}
