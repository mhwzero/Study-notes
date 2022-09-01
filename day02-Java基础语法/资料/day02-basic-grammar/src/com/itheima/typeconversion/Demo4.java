package com.itheima.typeconversion;

public class Demo4 {
    public static void main(String[] args) {
        // 需求：根据父母身高预测子女身高
        // 1.定义两个变量，分别存储父亲身高和母亲身高
        int father = 177;
        int mother = 165;

        // 2.根据规则预测子女身高
        int son = (int)((father + mother) * 1.08 / 2);
        int daughter = (int) ((father * 0.923 + mother) / 2);

        System.out.println(son);
        System.out.println(daughter);
    }
}
