package com.itmhw.test;

import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    public static <T> T newInstance(Class<T> clazz) throws Exception{
        //1、创建Properties集合对象
        Properties props = new Properties();
        //2、通过类加载器获取资源的字节输入流
        InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        //提交文件
        props.load(is);
        //集合对象调用getProperty方法，获取接口实现类的名称
        String name = clazz.getSimpleName();
        String className = props.getProperty(name);
        //反射创建对象并返回
        try {
            return (T)Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        //异常返回null
        return null;
    }
}
