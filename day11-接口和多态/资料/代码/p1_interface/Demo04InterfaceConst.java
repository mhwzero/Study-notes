package com.itheima.p1_interface;
/*
    接口中成员变量的使用
    接口中定义的变量,都是常量(值不可以改变)
    默认修饰符public static final 不写也有
    接口中常量默认值认为是无效的必须显式赋值
    接口中的常量的使用: 接口名称.常量名称
    建议: 接口中常量的命名全部使用大写字母,单词之间用_分隔
*/
public class Demo04InterfaceConst {
    public static void main(String[] args) {
        //直接调用接口静态方法
        USB.show();
        System.out.println("-----------");
        //直接输出接口中的常量
        System.out.println(USB.VERSION + "::" + USB.MAX_SPEED_OF_TRANSFER + "MB/s");
    }
}
