package com.itheima.demo;

import java.util.Random;
import java.util.Scanner;

public class Demo8 {
    public static void main(String[] args) {
        // 需求：模拟双色球系统
        // 规则：有6个红球，1个蓝球，红球号码的范围是1-33，要求不重复，蓝球号码的范围是1-16

        // Step 1.生成一组中奖号码并返回
        int[] luckyNumbers = createLuckyNumbers();
//        printArray(luckyNumbers);

        // Step 2.用户选号
        int[] userNumbers = userInputNumbers();

//        printArray(userNumbers);

        judge(luckyNumbers, userNumbers);

    }
    // 判断红球命中个数和蓝球命中个数
    private static void judge(int[] luckyNumbers, int[] userNumbers) {
        // 判断红球命中个数和蓝球命中个数
        int redHit = 0;
        int blueHit = 0;

        // 先遍历用户选号
        for (int i = 0; i < userNumbers.length - 1; i++) {
            // 再遍历幸运号码
            for (int j = 0; j < luckyNumbers.length - 1; j++) {
                // 判断是否命中
                if (userNumbers[i] == luckyNumbers[j]) {
                    // 红球命中了一个
                    redHit++;
                    break;
                }
            }
        }

//        if (userNumbers[userNumbers.length - 1] == luckyNumbers[luckyNumbers.length - 1]) {
//            // 蓝球命中了
//            blueHit++;
//        }

        blueHit = userNumbers[userNumbers.length - 1] == luckyNumbers[luckyNumbers.length - 1] ? ++blueHit : blueHit;

        System.out.println("您命中了" + redHit + "个红球");
        System.out.println("您命中了" + blueHit + "个蓝球");

        // 判断中奖金额
        if (redHit <= 2 && blueHit == 1) {
            System.out.println("恭喜您，中了5元小奖");
        } else if (redHit == 3 && blueHit == 1 || redHit == 4 && blueHit == 0) {
            System.out.println("恭喜您，中了10元小奖");
        } else if (redHit == 4 && blueHit == 1 || redHit == 5 && blueHit == 0) {
            System.out.println("恭喜您，中了200元奖");
        } else if (redHit == 5 && blueHit == 1) {
            System.out.println("恭喜您，中了3000元大奖");
        } else if (redHit == 6 && blueHit == 0) {
            System.out.println("恭喜您，中了500万元特等奖");
        }  else if (redHit == 6 && blueHit == 1) {
            System.out.println("恭喜您，中了1000万元超级大奖，可以不上班了");
        } else {
            System.out.println("太遗憾了，再来一注吧，下回见！");
        }

    }

    private static int[] userInputNumbers() {
        // 1.动态初始化一个长度为7的数组
        int[] numbers = new int[7];

        // 2.遍历数组让用户输入6个红球号码
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.println("请您选择第" + (i + 1) + "个红球号码(1-33)：");
            numbers[i] = scanner.nextInt();
        }

        // 3.让用户输入一个蓝球
        System.out.println("请您选择蓝球号码(1-16)：");
        numbers[numbers.length - 1] = scanner.nextInt();

        // 4.返回用户选号
        return numbers;
    }
    //获取随机生成的双色球(红球)
    private static int[] createLuckyNumbers() {
        // 1.动态初始化一个长度为7的数组
        int[] numbers = new int[7];
        // 11, 22, 0, 0, 0
        //         18
        //         i
        //  0   1  2
        //      j
        // 2.遍历数组，生成前面6个红球
        Random random = new Random();
        for (int i = 0; i < numbers.length - 1; i++) {
            // 3.随机生成一个红球
            // 1-33 -> 0-32 (33) + 1
            while (true) {
                int num = random.nextInt(33) + 1;
                // 4.判断当前随机生成的数字在幸运号码数组中是否存在
                boolean flag = true;    // 先假设生成的数字可用
                for (int j = 0; j < i; j++) {
                    if (num == numbers[j]) {
                        // 重复，不可用
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    // 可用
                    numbers[i] = num;
                    break;
                }
            }
        }

        // 5.生成一个蓝球
        numbers[numbers.length - 1] = random.nextInt(16) + 1;
        return numbers;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1 ? arr[i] : arr[i] + ", ");
        }
        System.out.println("]");
    }
}
