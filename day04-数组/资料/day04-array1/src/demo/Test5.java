package demo;

import java.util.Random;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        // 需求：模拟随机排名
        // 假设公司有5名员工，请先录入5名员工的工号，然后产生一组随机的工号顺序
        // 1.动态初始化一个长度为5的数组，用来存储5名员工的工号
        int[] ids = new int[5];

        // 2.让用户录入5名员工的工号
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("请您录入第" + (i + 1) + "位员工的工号：");
            int id = scanner.nextInt();
            ids[i] = id;
        }

        // 3.提前看一下原来的员工工号顺序
        System.out.println("交换前的元素位置：");
        for (int i = 0; i < ids.length; i++) {
            System.out.print(ids[i] + "\t");
        }
        System.out.println();

        // 5.定义一个Random随机数技术
        Random random = new Random();

        // 4.遍历数组元素，每次随机一个索引，和当前索引处的元素交换
        for (int i = 0; i < ids.length; i++) {
            // 当前索引位置处的元素：ids[i]
            // 6.产生一个0-4的随机数
            int index = random.nextInt(ids.length);
            // 生成索引处的元素是：ids[index]

            // 7.交换这两个元素
            int temp = ids[i];
            ids[i] = ids[index];
            ids[index] = temp;
        }

        System.out.println("交换后的元素位置：");
        for (int i = 0; i < ids.length; i++) {
            System.out.print(ids[i] + "\t");
        }
    }
}
