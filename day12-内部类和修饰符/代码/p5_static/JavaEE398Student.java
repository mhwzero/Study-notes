package com.itheima.p5_static;

//此类只针对JavaEE398期的学生
public class JavaEE398Student {
    String name;//不能使用static修饰: 属于每个对象的特有数据
    static String room;//使用static修饰: 属于所有对象的共享数据

    //静态方法
    public static void showRoom() {
        //System.out.println("教室: " + JavaEE398Student.room);
        //room和当前方法都在当前类中,使用静态变量可以省略类名
        System.out.println("教室: " + room);
    }
}
