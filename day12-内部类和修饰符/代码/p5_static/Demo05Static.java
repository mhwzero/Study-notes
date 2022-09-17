package com.itheima.p5_static;
/*
    static修饰修饰成员变量(类变量: 依赖于类,与对象无关)
        1.定义格式:
            static 数据类型 变量名称 = 数据值;

        2.使用格式:
            类名.静态成员变量名称;        推荐使用
            对象名.静态成员变量名称;      不推荐使用
    static修饰成员方法(类方法: 依赖于类,与对象无关)
        1.定义格式:
            public static 返回值类型 方法名称(参数列表...) {...}

        2.使用格式:
           类名.静态成员方法名称(...)        推荐使用
            对象名.静态成员方法名称(...)      不推荐使用

        3.注意:
            静态成员变量也有默认初始化值


 */
public class Demo05Static {
    public static void main(String[] args) {
        JavaEE398Student stu1 = new JavaEE398Student();
        //不推荐: 对象名.静态成员变量名
        //编译时,会变成类名.静态成员变量名
        System.out.println(stu1.room);//null
        //推荐使用: 类名.静态成员变量名
        System.out.println(JavaEE398Student.room);//null

        //通过类名给静态变量赋值
        JavaEE398Student.room = "JYL101";
        JavaEE398Student stu2 = new JavaEE398Student();

        System.out.println(stu1.room);//JYL101
        System.out.println(stu2.room);//JYL101
        System.out.println(JavaEE398Student.room);//JYL101

        //调用静态方法
        //不推荐: 对象名.静态成员方法名(参数列表)
        //编译时,会变成类名.静态成员方法名(参数列表)
        stu1.showRoom();
        stu2.showRoom();
        //推荐使用: 类名.静态成员方法名(参数列表)
        JavaEE398Student.showRoom();
    }
}
