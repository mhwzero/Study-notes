package com.itheima.branch;

public class SwitchDemo5 {
    public static void main(String[] args) {
        // 目标：掌握switch使用的注意事项
//        表达式类型只能是byte、short、int、char，JDK5开始支持枚举，JDK7开始支持String、不支持double、float、long。
//        byte b1 = 126;
//        int b1 = 30;
        char b1 = 'a';
        switch (b1 + 10) {

        }

        // 不支持double、float
//        double d = 3.14;
//        switch (d) {
//
//        }

//        double d1 = 0.1;
//        double d2 = 0.2;
//        System.out.println(d1 + d2);    // 0.30000000000000004
//        switch (d1 + d2) {
//
//        }

//        long l = 3;
//        switch (l) {
//
//        }


//        case给出的值不允许重复，且只能是字面量，不能是变量。
        int a = 10;
        switch (a) {
            case 1:
                break;
            case 10:
                break;
//            case 10:
//                break;
        }


//        不要忘记写break，否则会出现穿透现象。

        String weekday = "周二";

        switch (weekday) {
            case "周一":
                System.out.println("埋头苦干，解决bug  ");
                break;
            case "周二":
                System.out.println("请求大牛程序员帮忙");
            case "周三":
                System.out.println("今晚啤酒、龙虾、小烧烤");
            case "周四":
                System.out.println("主动帮助新来的女程序解决bug");
            case "周五":
                System.out.println("今晚吃鸡");
                break;
            case "周六":
                System.out.println("与王婆介绍的小芳相亲");
                break;
            case "周日":
                System.out.println("郁郁寡欢、准备上班");
                break;
            default:
                System.out.println("输入星期数据有误！");
        }
    }
}
