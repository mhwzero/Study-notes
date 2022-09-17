package com.itmhw.test;

import java.io.InputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*
1、创建Properties集合对象
2、通过类加载器,获取资源的字节输入流
3、Properties集合对象调用load方法，以键值对的方式加载配置文件信息
4、获取类的全名称
5、获取类的Class类型的对象
6、根据Class类型的对象创建一个具体的对象出来
7、获取Properties集合对象，所有的键对应的Set集合
8、遍历Set集合
8.1、根据键获取对应的值
8.2、如果键名不是DataSourceName，则代表是属性名
8.3、根据属性名获取对应的set方法的名称
8.4、获取set方法对应的Method对象
8.5、执行set方法,给obj对象成员赋值
9、打印对象
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //1、创建Properties集合对象
        Properties props = new Properties();
        //2、通过类加载器,获取资源的字节输入流
        ClassLoader classLoader = Test.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("HMDataBaseConfig.properties");
        //3、Properties集合对象调用load方法，以键值对的方式加载配置文件信息
        props.load(is);
        //System.out.println(props);
        //4、获取类的全名称
        String dataSourceName = props.getProperty("DataSourceName");
        //5、获取类的Class类型的对象
        Class<?> clazz= Class.forName(dataSourceName);
        //执行空参构造方法对象,从而创建一个具体的对象
        Object obj = clazz.newInstance();
        //6、根据Class类型的对象创建一个具体的对象出来
        Field[] driverClass = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(driverClass,true);

        //7、获取Properties集合对象，所有的键对应的Set集合
        Set<Map.Entry<Object, Object>> set = props.entrySet();
        //8、遍历Set集合
        for (Map.Entry<Object, Object> s : set) {
            //8.1、根据键获取对应的值
            //将值与成员变量进行一个对比，将相应的值写入成员变量
            for (Field field : driverClass) {
                //8.2、如果键名不是DataSourceName，则代表是属性名
                if (s.getKey().equals(field.getName())){
                    //相同，通过field中的set方法将值写入
                    field.set(obj,s.getValue());
                }
            }
        }
        //9、打印对象
        for (Field aClass : driverClass) {
            //获取成员变量中的值
            Object o = aClass.get(obj);
            System.out.println(aClass.getName()+":::"+o);
        }
    }
}
