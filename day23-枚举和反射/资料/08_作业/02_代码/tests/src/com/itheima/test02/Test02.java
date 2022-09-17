package com.itheima.test02;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

/*
    第二题:
        后面使用JDBC连接数据库，需要给出相关参数。
        如果在代码中直接调用set方法设置相关参数,后期维护非常麻烦。
        可以把相关参数保存在.properties文件中，利用Properties集合+反射,读取配置文件信息,完成数据库的配置。
        本练习通过Properties集合+反射技术,读取.properties文件信息,创建HMDataBaseConfig类的对象并给其成员变量完成赋值。


    实现步骤:
        //1.定义HMDataSourceConfig类,定义成员变量,set/get方法,toString方法,空参/满参构造
        //2.在src根目录下定义配置文件hmDataSourceConfig.properties,保存多个键值对

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
public class Test02 {
    public static void main(String[] args) throws Exception {
       /* HMDataBaseConfig hmDataBaseConfig = new HMDataBaseConfig();
        hmDataBaseConfig.setDriverClass("com.mysql.jdbc.Driver");
        hmDataBaseConfig.setUrl("jdbc:mysql://localhost:3306/day15");
        hmDataBaseConfig.setUser("root");
        hmDataBaseConfig.setPassword("abc");
        System.out.println(hmDataBaseConfig);*/

        //1、创建Properties集合对象
        Properties props = new Properties();

        //2、通过类加载器,获取资源的字节输入流
        InputStream is = Test02.class.getClassLoader().getResourceAsStream("hmDataSourceConfig.properties");

        //3、Properties集合对象调用load方法，以键值对的方式加载配置文件信息
        props.load(is);

        //4、获取类的全名称
        String className = props.getProperty("DataSourceName");

        //5、获取类的Class类型的对象
        Class clazz = Class.forName(className);

        //6、根据Class类型的对象创建一个具体的对象出来
        Object obj = clazz.newInstance();

        //7、获取Properties集合对象，所有的键对应的Set集合
        Set<String> propertyNames = props.stringPropertyNames();

        //8、遍历Set集合
        for (String propertyName : propertyNames) {
            //8.1、根据键获取对应的值
            String propertyValue = props.getProperty(propertyName);

            //8.2、如果键名不是DataSourceName，则代表是属性名
            if (!"DataSourceName".equals(propertyName)) {
                //8.3、根据属性名获取对应的set方法的名称
                String setMethodName = getSetMethodName(propertyName);

                //8.4、获取set方法对应的Method对象
                Method setMethod = clazz.getMethod(setMethodName, String.class);

                //8.5、执行set方法,给obj对象成员赋值
                setMethod.invoke(obj,propertyValue);
            }

        }
        //9、打印对象
        System.out.println(obj);
    }

    //定义方法,根据成员变量名称获取对应的set方法的名称
    public static String getSetMethodName(String fieldName) {
        //driverClass --> setDriverClass
        return "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
    }
}
