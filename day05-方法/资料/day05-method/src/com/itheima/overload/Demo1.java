package com.itheima.overload;

import java.io.OutputStream;

public class Demo1 {
    public static void main(String[] args) {
        // 目标；掌握方法重载的书写形式
        // 要求：同一个类中，方法名相同，形参列表不同
        fire();
        fire("小日子过得挺好的某国");
        fire("小日子过得挺好的某国", 10);
//        OutputStream os = null;
//        os.write();
    }

    public static void fire() {
//        System.out.println("默认给米国发射一枚武器");
        fire("小日子过得挺好的某国");
    }

    public static void fire(String location) {
//        System.out.println("默认给" + location + "发射一枚武器");
        fire(location, 1);
    }

    public static void fire(String location, int num) {
        System.out.println("默认给" + location + "发射" + num + "枚武器");
    }
}
