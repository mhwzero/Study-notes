package com.itheima.p4_quanxian;
/*
    权限修饰符                   public          protected           默认(什么都不写)           private
    在同一个类中                   √                  √                     √                    √
    在同一个包中(子类/无关类)       √                  √                     √
    不同包的子类                   √                  √
    不同包的无关类                 √
 */
public class Demo04QuanXian {
    public static void main(String[] args) {
        //测试同一个类中的四种访问权限
        Fu04 fu04 = new Fu04();
        fu04.method();
        System.out.println("------------");

        //测试同一个包的子类中的四种访问权限
        Zi04 zi04 = new Zi04();
        zi04.show();
        zi04.method();
        System.out.println("------------");

        //测试同一个包的无关类中的四种访问权限
        Fu04 fu041 = new Fu04();
        System.out.println(fu041.a);
        System.out.println(fu041.b);
        System.out.println(fu041.c);
        //错误: 同一个包的无关类中,private权限不能使用
        //System.out.println(fu041.d);
    }
}
