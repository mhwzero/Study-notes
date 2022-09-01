package com.itheima.branch;

public class SwitchDemo6 {
    public static void main(String[] args) {
        // 目标：了解switch穿透性的应用场景
        // 模拟一个月份天数查看器
        int month = 8;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month + "月有31天");
                break;
            case 2:
                System.out.println(month + "月闰年是29天，非闰年是28天");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + "月有30天");
                break;
            default:
                System.out.println("您输入的月份信息不正确");
        }
    }
}
