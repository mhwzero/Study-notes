package demo;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        // 需求：猜数字游戏，随机生成5个1-20之间的随机数，使用数组存储起来
        // 让用户不断猜测，直到猜中为止
        // 1.动态初始化一个长度为5的数组，用来存储5个1-20之间的随机数
        int[] data = new int[5];
        // 2.使用随机数技术，生成5个1-20之间的随机数
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            // 1-20 -> 0-19 (20) +1
            data[i] = random.nextInt(20) + 1;
        }

//        for (int i = 0; i < data.length; i++) {
//            System.out.println(data[i]);
//        }

        // 3.让用户猜测
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请您输入一个1-20之间的数字：");
            int input = scanner.nextInt();

            boolean flag = false;
            // 4.for循环遍历data数组，判断有没有用户输入的数字
            for (int i = 0; i < data.length; i++) {
                if (data[i] == input) {
                    // 猜中了
                    System.out.println("恭喜您猜中了！");
                    System.out.println("您猜中数字第一次出现的索引位置是：" + i);

                    System.out.println("数组中所有元素是：");
                    for (int j = 0; j < data.length; j++) {
                        System.out.print(data[j] + "\t");
                    }

                    flag = true;
                    break;
                }
            }

            if (flag == false) {
                System.out.println("您没有猜中，请重新猜测");
            } else {
                // 猜中了
                break;
            }
        }


    }
}
