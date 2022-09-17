package com.itheima.p5_var_params;

/*
    可变参数: 可以变化的参数
        在JDK1.5之后，如果我们定义一个方法需要接受多个参数，并且多个参数类型一致，我们可以对其简化.

    格式:
        一定是在定义方法参数时,使用: 数据类型 ... 变量名称
        修饰符 返回值类型 方法名称(数据类型 ... 变量名称) {...}

    使用:
        可变参数的本质就是数组,调用含有可变参数的方法时,
            可以传递参数列表,可以传递数组,还可以不传参数
 */
public class Demo05VarParams {
    public static void main(String[] args) {
        //输出调用: 传递参数列表
        System.out.println(getSum());
        System.out.println(getSum(10, 20));
        System.out.println(getSum(10, 20, 30));
        System.out.println(getSum(10, 20, 30, 40));

        //输出调用: 传递数组
        System.out.println(getSum(new int[]{10, 20}));
        System.out.println(getSum(new int[]{10, 20, 30}));
        System.out.println(getSum(new int[]{10, 20, 30, 40}));
    }

    //定义方法,获取多个int数字之和
    public static int getSum(int... array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    //定义方法,获取一个int数组之和
    /*public static int getSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }*/

    /*//定义方法,获取2个int数字之和
    public static int getSum(int a, int b) {
        return a + b;
    }

    //定义方法,获取3个int数字之和
    public static int getSum(int a, int b, int c) {
        return a + b + c;
    }

    //定义方法,获取4个int数字之和
    public static int getSum(int a, int b, int c, int d) {
        return a + b + c + d;
    }*/
}
