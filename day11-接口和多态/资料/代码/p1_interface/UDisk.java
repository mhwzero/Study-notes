package com.itheima.p1_interface;

//USB接口实现类U盘
public class UDisk implements USB {
    //覆盖重写接口抽象方法
    @Override
    public void open() {
        System.out.println("U盘开启,红灯闪闪....");
    }

    @Override
    public void close() {
        System.out.println("U盘关闭,红灯闪闪....");
    }
}
