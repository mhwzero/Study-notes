package com.itheima.p1_interface;

//定义USB接口
/*
    接口中不能定义变量,只能定义常量
    接口中常量:默认修饰符public static final
    建议:
        常量名称: 字母全部大写,单词之间使用_隔开
 */
public interface USB {
    //版本
    public static final double VERSION = 3.0;
    //最大传输速度
    public static final int MAX_SPEED_OF_TRANSFER = 500;

    //静态方法: 展示USB接口的相关信息
    public static void show() {
        System.out.println("USB接口版本: " + USB.VERSION);
        System.out.println("USB接口最大传输速度: " + USB.MAX_SPEED_OF_TRANSFER + "MB/s");
        //show方法和内部输出的常量都在当前接口中,所以可以省略接口名
        System.out.println("USB接口版本: " + VERSION);
        System.out.println("USB接口最大传输速度: " + MAX_SPEED_OF_TRANSFER + "MB/s");
    }

    //抽象方法: 开启设备
    public abstract void open();

    //抽象方法: 关闭设备
    //接口抽象方法有默认修饰符public abstract : 可以省略
    /*public abstract */ void close();

    /*
        接口功能升级,添加新的抽象方法,
        导致其它实现类全部报错,其它实现类必须重新实现新的抽象方法
        太麻烦
        解决方案: 默认方法
     */
    //public abstract void method();

    /*
        接口功能升级,添加新的默认方法
     */
    public default void drive() {
        System.out.println("USB接口提供的默认驱动程序....");
    }

    //静态方法
    public static void thanks() {
        System.out.println("感谢使用USB接口....");
    }
}
