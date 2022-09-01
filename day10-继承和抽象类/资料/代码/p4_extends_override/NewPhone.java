package com.itheima.p4_extends_override;

/*
    4.定义新款手机NewPhone类 继承 老款手机OldPhone类
        成员方法: 打电话(直接使用父类的),发短信(直接使用父类的),来电显示(功能增强,覆盖重写父类的)
 */
public class NewPhone extends OldPhone {
    @Override
    public void show() {
        /*
            显示点好号码的功能,父类已经实现,
            子类方法中可以直接调用
         */
        super.show();
        //System.out.println("110来电...");
        System.out.println("地址: 香港");
        System.out.println("头像: 🐱");
    }
}
