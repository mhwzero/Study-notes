package com.itheima.random;

// 1.导包
import java.util.Random;

public class Demo1 {
    public static void main(String[] args) {
        // 目标：学会使用随机数技术Random类
        // 2.抄代码，得到一个随机数对象
        Random random = new Random();

        // 3.生成随机数
        int number = random.nextInt(10);    // 0-(n-1)，不包括小括号中的数字
        System.out.println("随机生成了：" + number);

        System.out.println("===============");
        // 生成1-10之间的随机数
        // 1-10  -1  ->  0-9  --> +1  --> 1-10
        int num = random.nextInt(10) + 1;
        System.out.println(num);

        System.out.println("===============");
        // 生成65-91之间的随机数
        // 65-91  -65 --> 0-26 (27)  +65 --> 65-91
        int result = random.nextInt(27) + 65;
        System.out.println(result);

        // 51-98
        // -51
        // 0-47
        // 51
        // 51-98
        System.out.println(random.nextInt(48) + 51);
    }
}
