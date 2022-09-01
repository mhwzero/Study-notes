package com.itheima.random;

import java.util.Random;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        // 需求：猜数字游戏，随机生成一个1-100之间的随机数，让用户猜测，猜大提示过大，猜小提示过小，直到猜中
        // 1.生成1个1-100之间的随机数
        Random random = new Random();
        int data = random.nextInt(100) + 1;

        // 2.让用户猜测
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请您输入一个1-100之间的整数：");
            int input = scanner.nextInt();
            if (input > data) {
                System.out.println("您猜大了，请您重新输入");
            } else if (input < data) {
                System.out.println("您猜小了，请您重新输入");
            } else {
                System.out.println("恭喜您，猜中了，喝酒吧");
                break;
            }
        }
    }
}
