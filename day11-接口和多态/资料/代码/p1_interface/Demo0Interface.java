package com.itheima.p1_interface;
/*
    接口中抽象方法的定义和使用
        1.接口中抽象方法的定义格式
            public abstract 返回值类型 方法名称(形式参数列表...);
            注意:
                (1)和以前定义方法格式相同,但是需要去掉{},添加abstract
                (2)返回值类型和参数列表根据需求确定
                (3)接口中抽象方法,有默认修饰符public abstract,不写也有
                    抽象类中抽象方法必须写public abstract,不能省略

        2.接口中抽象方法的使用
            (1)不能直接创建接口的对象
            (2)定义实现类 实现 接口 关键字 implements
               格式:
                    public class 类名 implements 接口A,接口B {
                        //覆盖重写接口中的所有的抽象方法
                    }
            (3)实现类中覆盖重写接口中的所有的抽象方法
                去掉abstract关键字,添加{}
                快捷键: ctrl + i
            (4)创建实现类对象
            (5)使用实现类对象调用方法
*/
public class Demo0Interface {
    public static void main(String[] args) {
        //错误: 不能直接创建接口对象
        //USB usb = new USB();
        //创建USB接口实现类UDisk的对象
        UDisk uDisk = new UDisk();

        //调用成员方法
        uDisk.open();
        uDisk.close();
        System.out.println("-----------");

        //创建USB接口实现类HMScanner的对象
        HMScanner hmScanner = new HMScanner();
        //调用成员方法
        hmScanner.open();
        hmScanner.close();
    }
}
