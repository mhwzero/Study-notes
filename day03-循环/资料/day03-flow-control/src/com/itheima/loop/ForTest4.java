package com.itheima.loop;

public class ForTest4 {
    public static void main(String[] args) {
        // 需求：打印所有的水仙花数
        int count = 0;
        // 1.使用for循环得到所有的三位数
        for (int i = 100; i <= 999; i++) {
            // 2.每拿到一个三位数，得到个位、十位、百位
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;

            // 3.判断是否是水仙花数
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                // 是水仙花数
                System.out.print(i + "\t");
                count++;
            }
        }
        System.out.println();
        System.out.println("100-999之间的水仙花数个数为：" + count);
    }
}
