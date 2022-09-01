package com.itheima.demo;

import java.util.Random;

public class      Demo3 {
    public static void main(String[] args) {
        // 需求：定义一个方法，用来生成一个指定位数的随机验证码
        // 大写字母、小写字母、数字
        System.out.println(createCode(4));
        System.out.println(createCode(8));
    }

    public static String createCode(int num) {
        // 4.在for循环外定义一个String类型的变量，用来记录最终的结果
        String code = "";
        // 1.使用for循环，生成num位随机字符
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            // 2.随机生成0,1,2的数字，分别代表大写字母、小写字母、数字
            int type = random.nextInt(3);
            // 3.使用switch语句判断要生成的字符的类型
            switch (type) {
                case 0:
                    // 大写字母
                    // A-Z A:65 Z:65+25  (65, 65+25) -> -65 -> (0, 25) + 65
                    char data = (char) (random.nextInt(26) + 65);
                    code += data;
                    break;
                case 1:
                    // 小写字母
                    char data1 = (char) (random.nextInt(26) + 97);
                    code += data1;
                    break;
                case 2:
                    // 数字
                    int data2 = random.nextInt(10);
                    code += data2;
                    break;
                default:

            }
        }

        return code;
    }
}
