package com.itheima.p1_interface;
/*
    接口中默认方法的定义格式和使用
        问题:
            定义接口后,有很多实现类在使用接口,如果对接口功能升级添加了新的抽象方法
            导致所有的实现类必须修改代码,太麻烦
        解决方案: 默认方法
        默认方法的定义格式:
            public default 返回值类型 方法名称(形式参数列表...){
                //方法体;
            }
        默认方法的使用: 只能使用实现类对象调用默认方法
        注意:
            1.接口中的默认方法,不强制要求实现类进行覆盖重写
            2.但是实现类可以根据需求,选择性的覆盖重写接口中的默认方法
            3.如果实现类覆盖重写接口中的默认方法,必须去掉default关键字
*/
public class Demo02InterfaceDefault {
    public static void main(String[] args) {
        //创建USB接口实现类UDisk的对象
        UDisk uDisk = new UDisk();
        //接口实现类对象调用默认方法
        uDisk.drive();
        System.out.println("-----------");

        //创建USB接口实现类HMScanner的对象
        HMScanner hmScanner = new HMScanner();
        //接口实现类对象调用默认方法
        hmScanner.drive();
    }
}
