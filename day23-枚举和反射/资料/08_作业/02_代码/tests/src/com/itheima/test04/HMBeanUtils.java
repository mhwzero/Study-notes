package com.itheima.test04;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

/*
    2.定义工具类HMBeanUtils,私有构造方法
    3.在工具类HMBeanUtils中定义静态方法setProperty,作用是给指定对象的指定属性(成员变量)赋值指定的值
        3.1 获取bean对象对应的Class类型的对象
        3.2 通过Class类型的对象获取指定字段name对应的Field对象(getDeclaredField方法)
        3.3 取消java语言的访问检查
        3.4 Field对象调用set方法,完成成员变量的赋值
    4.在工具类HMBeanUtils中定义静态方法getProperty,作用是获取指定对象的指定行属性的值
        4.1 获取bean对象对应的Class类型的对象
        4.2 通过Class类型的对象获取指定字段name对应的Field对象(getDeclaredField方法)
        4.3 取消java语言的访问检查
        4.4 Field对象调用get方法,获取成员变量指定属性name对应的值(Object类型的)
        4.5 返回对应的String类型的结果
    5.在工具类HMBeanUtils中定义静态方法populate,作用是把map集合中的键值对数据存储到对象bean中，
			map中的键代表对象的属性，map中的值代表对象属性的值
        5.1 获取bean对象对应的Class类型的对象
        5.2 获取Map集合对象所有的键(属性名/成员变量名称)对应的Set集合对象
        5.3 遍历所有的键(属性名/成员变量名称)对应的Set集合对象
        5.4 获取当前的键name(属性名/成员变量名称)
        5.5 根据当前的键,获取对应的值value(成员变量对应的值)
        5.6 通过Class类型的对象获取指定字段name对应的Field对象(getDeclaredField方法)
        5.7 取消java语言的访问检查
        5.8 Field对象调用set方法,完成成员变量的赋值(value)
 */
public class HMBeanUtils {
    //2.定义工具类HMBeanUtils,私有构造方法
    private HMBeanUtils(){}

    //3.在工具类HMBeanUtils中定义静态方法setProperty,作用是给指定对象的指定属性(成员变量)赋值指定的值
    public static void setProperty(Object bean, String name, Object value) throws Exception {
        //3.1 获取bean对象对应的Class类型的对象
        Class clazz = bean.getClass();

        //3.2 通过Class类型的对象获取指定字段name对应的Field对象(getDeclaredField方法)
        Field field = clazz.getDeclaredField(name);

        //3.3 取消java语言的访问检查
        field.setAccessible(true);

        //3.4 Field对象调用set方法,完成成员变量的赋值
        field.set(bean,value);
    }

    //4.在工具类HMBeanUtils中定义静态方法getProperty,作用是获取指定对象的指定行属性的值
    public static String getProperty(Object bean, String name) throws Exception {
        //4.1 获取bean对象对应的Class类型的对象
        Class clazz = bean.getClass();

        //4.2 通过Class类型的对象获取指定字段name对应的Field对象(getDeclaredField方法)
        Field field = clazz.getDeclaredField(name);

        //4.3 取消java语言的访问检查
        field.setAccessible(true);

        //4.4 Field对象调用get方法,获取成员变量指定属性name对应的值(Object类型的)
        Object value = field.get(bean);

        //4.5 返回对应的String类型的结果
        return value.toString();
    }

    //5.在工具类HMBeanUtils中定义静态方法populate,作用是把map集合中的键值对数据存储到对象bean中，
    //map中的键代表对象的属性，map中的值代表对象属性的值
    public static void populate(Object bean, Map map) throws Exception {
        //5.1 获取bean对象对应的Class类型的对象
        Class clazz = bean.getClass();

        //5.2 获取Map集合对象所有的键(属性名/成员变量名称)对应的Set集合对象
        Set names = map.keySet();

        //5.3 遍历所有的键(属性名/成员变量名称)对应的Set集合对象
        for (Object name : names) {
            //5.4 获取当前的键name(属性名/成员变量名称)
            //5.5 根据当前的键,获取对应的值value(成员变量对应的值)
            Object value = map.get(name);

            //5.6 通过Class类型的对象获取指定字段name对应的Field对象(getDeclaredField方法)
            Field field = clazz.getDeclaredField(name.toString());

            //5.7 取消java语言的访问检查
            field.setAccessible(true);

            //5.8 Field对象调用set方法,完成成员变量的赋值(value)
            field.set(bean,value);
        }
    }
}
