package demo;

public class Test2 {
    public static void main(String[] args) {
        // 需求：数组元素求最大值
        // 模拟的是颜值数据比较
        // 1.静态初始化一个数组，存储一批颜值数据
        int[] faceScores = {15, 9000, 10000, 20000, 9500, -5};

        // 3.在循环外，定义一个变量，用来记录当前最大值，建议使用数组的第一个元素
        int max = faceScores[0];

        // 2.遍历数组
        for (int i = 1; i < faceScores.length; i++) {
            // 当前获取到的颜值数据
//            faceScores[i]
            // 4.将当前得到的颜值数据和临时最大值比较
            if (faceScores[i] > max) {
                max = faceScores[i];
            }
        }

        System.out.println("最大颜值是：" + max);
    }
}
