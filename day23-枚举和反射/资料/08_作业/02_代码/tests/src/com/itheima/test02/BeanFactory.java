package com.itheima.test02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
    5、定义BeanFactory类,该类中定义newInstance方法
        5.1、获取传递的接口名
        5.2、通过类加载器,获取资源的字节输入流
        5.3、创建Properties集合对象
        5.4、Properties集合对象调用load方法，以键值对的方式加载配置文件信息
        5.5、Properties集合对象调用getProperty方法，获取接口实现类的名称
        5.6、反射创建对象并返回
        5.7、出现异常返回null
 */
public class BeanFactory {
    //定义newInstance方法
    public static <T> T newInstance(Class<T> clazz)  {

        try {
            //5.1、获取传递的接口名
            String interfaceName = clazz.getSimpleName();//配置文件中使用接口名称作为属性名(键名)

            //5.2、通过类加载器,获取资源的字节输入流
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");

            //5.3、创建Properties集合对象
            Properties props = new Properties();

            //5.4、Properties集合对象调用load方法，以键值对的方式加载配置文件信息
            props.load(is);

            //5.5、Properties集合对象调用getProperty方法，获取接口实现类的名称
            String className = props.getProperty(interfaceName);

            //5.6、反射创建对象并返回
            Class<?> clazz2 = Class.forName(className);
            return (T)clazz2.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //5.7、出现异常返回null
        return null;
    }
}
