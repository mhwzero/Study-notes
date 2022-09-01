package com.itheima.p4_extends_override;

/*
    1.定义老款手机OldPhone类
        成员方法: 打电话,发短信,显示来电
 */
public class OldPhone {
    //打电话
    public void call(String who) {
        System.out.println("正在给.." + who + "..打电话..");
    }

    //发短信
    public void sendMessage(String who, String msg) {
        System.out.println("正在给.." + who + "..发短信.." + msg);
    }

    //显示来电
    public void show() {
        System.out.println("110来电...");
    }

}
