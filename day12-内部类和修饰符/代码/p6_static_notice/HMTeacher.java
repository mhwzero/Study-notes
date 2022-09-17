package com.itheima.p6_static_notice;

//此类只针对黑马的老师
public class HMTeacher {
    String name;//不能使用static修饰: 属于每个对象的特有数据
    static String country = "CHINA";//使用static修饰: 属于所有对象的共享数据

    //静态方法
    public static void showCountry() {
        //省略了类名: 静态变量country和静态方法showCountry都在当前的类中
        //(1)静态方法可以直接访问静态变量和静态方法。
        System.out.println("国籍: " + country);
        //省略了类名: 静态方法welcome和静态方法showCountry都在当前的类中
        welcome();

        //静态方法中不能使用非静态方法和非静态成员变量
        /*
            静态内容是最先被加载到内存的静态区中的,此时没有对象(哪来的this),
            而非静态的成员变量存在于对象中,既然没有对象,就不能使用非静态内容
         */
        //System.out.println("姓名: " + name);
        //System.out.println("姓名: " + this.name);

        //showName();
        //this.showName();
    }

    //静态方法
    public static void welcome() {
        System.out.println("黑马程序员欢迎您...");
    }

    //非静态方法
    public void showName() {
        System.out.println("姓名: " + name);
        /*
            非静态方法内部可以直接使用静态变量和静态方法
            非静态方法必须由对象调用,既然已经有了对象了,
            静态内容早已经被加载到内存了,所以可以调用
         */
        System.out.println("国籍: " + country);
        welcome();
    }
}
