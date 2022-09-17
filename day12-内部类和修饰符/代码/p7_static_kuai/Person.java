package com.itheima.p7_static_kuai;

//此类只针对咱们中国人
public class Person {
    String name;//不能使用static修饰: 每个对象的特有数据
    static String country;//必须使用static修饰: 所有的对象的共享数据

    //静态代码块
    static {
        System.out.println("静态代码块被执行了...");
        //(3)完成静态成员变量的赋值
        country = "CHINA";
        /*
            静态代码块在类的加载时机执行的,此时没有对象,
            就没有非静态内容
         */
        //System.out.println("姓名: " + name);
        //System.out.println("姓名: " + this.name);

        //调用静态方法
        init();
    }

    //静态方法
    public static void showCountry() {
        System.out.println("国籍: " + country);
    }

    //空参构造
    public Person() {
        System.out.println("空参构造被执行了...");
    }

    //定义静态方法,模拟项目的初始化过程
    public static void init() {
        System.out.println("项目正在启动,需要10秒钟...");
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            //请直接复制下面的代码: 让程序此处休眠1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("项目启动完毕,请尽情使用...");
    }
}
