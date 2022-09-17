package com.itheima.test05;

import java.lang.reflect.Method;

/*
    第五题
        模拟Junit测试的注解@Test，@Before,@After，
        首先需要编写自定义注解@MyTest，@MyBefore,@MyAfter，
        并添加元注解，保证自定义注解只能修饰方法，且在运行时可以获得。

        编写目标类（测试类），然后给目标方法（测试方法）使用 @MyTest注解,@MyBefore注解,@MyAfter注解，
        编写三个方法，其中两个加上@MyTest注解。

        最后编写调用类，使用main方法调用目标类，模拟Junit的运行，只要有@MyTest注释的方法都会运行。

    实现步骤:
        1、自定义注解@MyTest，保证自定义注解只能修饰方法，且在运行时可以获得。
        2、自定义注解@MyBefore，保证自定义注解只能修饰方法，且在运行时可以获得。
        3、自定义注解@MyAfter，保证自定义注解只能修饰方法，且在运行时可以获得。
        4、定义目标类MyTargetClass
            4.1、定义show方法,method方法，print方法，before方法，after方法
            4.2、在show方法和print方法上添加@MyTest注解,在before方法上添加@MyBefore注解,在after方法上添加@Myafter注解
        5、定义测试类Test05
            5.1  获取目标类MyTargetClass的Class对象
            5.2  Class对象获取所有的方法对应的Method对象数组
            5.3  遍历Method对象数组
            5.4  获取含有MyBefore注解的方法
            5.5  获取含有MyAfter注解的方法
            5.6  遍历Method对象数组
                5.6.1 获取当前方法Method对象
                5.6.2 如果当前方法Method对象上含有@MyTest,说明该方法是要运行的方法
                5.6.3 判断如果存在含有@MyBefore注解的方法,先执行该方法
                5.6.4 再执行含有@MyTest的方法
                5.6.5 判断如果存在含有@MyAfter注解的方法,最后执行该方法


 */
public class Test05 {
    public static void main(String[] args) throws Exception {
        //5.1  获取目标类MyTargetClass的Class对象
        Class<MyTargetClass> clazz = MyTargetClass.class;

        //方法的执行,需要对象的支持,快捷方式通过Class对象创建一个具体的对象出来
        MyTargetClass obj = clazz.newInstance();

        //5.2  Class对象获取所有的方法对应的Method对象数组
        Method[] ms = clazz.getMethods();

        //定义Method对象保存含有MyBefore注解的Method方法对象
        Method myBeforeMethod = null;

        //定义Method对象保存含有MyAfter注解的Method方法对象
        Method myAfterMethod = null;

        //5.3  遍历Method对象数组
        for (Method m : ms) {
            //5.4  获取含有MyBefore注解的方法
            if(m.isAnnotationPresent(MyBefore.class)) {
                myBeforeMethod = m;
            }
            //5.5  获取含有MyAfter注解的方法
            if (m.isAnnotationPresent(MyAfter.class)) {
                myAfterMethod = m;
            }
        }
        //5.6  遍历Method对象数组
        for (Method m : ms) {
            //5.6.1 获取当前方法Method对象: m
            //5.6.2 如果当前方法Method对象上含有@MyTest,说明该方法是要运行的方法
            if(m.isAnnotationPresent(MyTest.class)) {
                //5.6.3 判断如果存在含有@MyBefore注解的方法,先执行该方法
                if (myBeforeMethod != null) {
                    myBeforeMethod.invoke(obj);
                }

                //5.6.4 再执行含有@MyTest的方法
                m.invoke(obj);

                //5.6.5 判断如果存在含有@MyAfter注解的方法,最后执行该方法
                if (myAfterMethod != null) {
                    myAfterMethod.invoke(obj);
                }
            }

        }
    }
}
