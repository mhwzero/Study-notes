package com.itheima.loop;

public class WhileTest6 {
    public static void main(String[] args) {
        // 需求：世界最高峰高度是8848860，纸张厚度0.1，折叠多少次，能达到山峰高度
        // 1.记录山峰高度
        double peakHeight = 8848860;
        // 2.记录纸张厚度
        double paperThickness = 0.1;

        // 4.在循环外定义一个变量记录折叠次数
        int count = 0;

        // 3.使用while循环，循环条件是纸张厚度小于山峰高度
        while (paperThickness < peakHeight) {
            // 折叠一次
            paperThickness *= 2;
            count++;
        }

        System.out.println("一共折叠了：" + count + "次，当前纸张厚度是：" + paperThickness);

    }
}
