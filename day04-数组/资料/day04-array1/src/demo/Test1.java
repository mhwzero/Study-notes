package demo;

public class Test1 {
    public static void main(String[] args) {
        // 需求：数组元素求和，模拟计算部门总销售额
        // 1.定义一个数组，静态初始化，存储部门所有员工的销售额
        int[] money = {16, 26, 36, 6, 100};

        // 3.在循环外定义一个累加变量，用来记录总和
        int sum = 0;

        // 2.遍历数组
        for (int i = 0; i < money.length; i++) {
            // 当前遍历到的数组元素
//            money[i]
            sum += money[i];
        }

        // 4.打印结果
        System.out.println("部门总销售额是：" + sum);
    }
}
