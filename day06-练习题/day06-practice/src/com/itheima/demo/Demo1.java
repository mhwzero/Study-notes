package com.itheima.demo;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        // 需求：机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱
        // 旺季（5-10月）头等舱打9折、经济舱8.5折；淡季（11月-4月）头等舱打7折、经济舱6.5折；
        // 1.使用键盘录入三个信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请您输入机票原价:");
        double price = scanner.nextDouble();

        System.out.println("请您输入月份:");
        int month = scanner.nextInt();

        System.out.println("请您输入仓位类型（头等舱/经济舱）:");
        String type = scanner.next();

        double result = calc(price, month, type);
        if (result != -1) {
            System.out.println("您最终的机票价格是：" + result);
        }
    }

    // 2.定义一个方法，用来计算机票优惠价格
    public static double calc(double price, int month, String type) {
        // 3.先使用if-else判断月份是旺季还是淡季
        if (month >= 5 && month <= 10) {
            // 旺季
            // 4.使用switch判断是头等舱还是经济舱
            switch (type) {
                case "头等舱":
                    price = price * 0.9;
                    break;
                case "经济舱":
                    price = price * 0.85;
                    break;
                default:
                    System.out.println("您录入的仓位类型有误");
                    price = -1;
            }
        } else if (month == 11 || month == 12 || month >= 1 && month <= 4) {
            // 淡季
            switch (type) {
                case "头等舱":
                    price = price * 0.7;
                    break;
                case "经济舱":
                    price = price * 0.65;
                    break;
                default:
                    System.out.println("您录入的仓位类型有误");
                    price = -1;
            }
        } else {
            System.out.println("您录入的月份信息有误");
            price = -1;
        }
        return price;
    }
}
