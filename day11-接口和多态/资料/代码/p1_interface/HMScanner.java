package com.itheima.p1_interface;
//USB接口实现类扫描仪
public class HMScanner implements USB {
    @Override
    public void open() {
        System.out.println("扫描仪开启,绿灯闪闪....");
    }

    @Override
    public void close() {
        System.out.println("扫描仪关闭,绿灯闪闪....");
    }

    /*
        接口中的默认方法,不强制要求实现类必须覆盖重写
        但是实现类可以根据需求选择性的进行覆盖重写
        但是注意:
            重写接口默认方法时,必须去掉default关键字
     */
    @Override
    public void drive() {
        System.out.println("使用扫描仪专用驱动");
    }

    //静态方法
    /*
        注意:
            使用@Override报错: 说明类中的静态方法不是对接口静态方法的覆盖重写
            类中的静态内容属于类本身,和接口无关,所以静态内容不存在覆盖重写
            接口中的静态内容属于接口本身,和实现类以及对象无关,所以静态内容不存在覆盖重写
     */
    //@Override
    public static void thanks() {
        System.out.println("感谢使用扫描仪设备....");
    }
}
