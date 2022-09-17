package com.itheima.p6_poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    斗地主综合案例实现步骤分析
        一: 准备牌
            1.创建List集合对象pokers,代表牌盒,用来存储54张扑克,存储数据类型String
            2.创建List集合对象colors,代表花色,用来存储所有的花色,存储数据类型String
            3.向存储所有的花色的List集合对象colors中存储所有的花色
            4.创建List集合对象nums,代表数字,用来存储所有的数字,存储数据类型String
            5.向存储所有的数字的List集合对象nums中存储所有的数字
            6.循环嵌套遍历存储数字和花色的List集合对象nums和colors
            7.拼接一张扑克,存储String变量poker中
            8.把当前拼接的扑克poker添加到牌盒pokers中
            9.向牌盒pokers中添加小王和大王
            10.打印牌盒pokers
        二: 洗牌(打乱牌盒pokers中的元素的顺序)
            java.util.Collections集合工具类中提供静态方法,完成打乱List集合元素顺序
            public static void shuffle(List<?> list): 打乱方法参数List集合对象中的元素的顺序
        三: 发牌
            1.创建四个List集合对象p1,p2,p3,bottom,分别代表三个玩家和一个底牌,存储数据类型String
            2.遍历存储54张扑克的牌盒pokers(方式一: for + get(索引)  方式二: 迭代器   方式三: 增强for)
            注意: 此处只能使用for + get(索引)的方式遍历,因为需要根据索引决定发给哪个玩家
            3.获取当前扑克保存String变量poker中
            4.判断当前扑克索引值 > 50,不参与发牌,直接留作底牌
            5.判断当前扑克索引值 <= 50,参与发牌,根据索引%3的结果发给不同的玩家
        四: 看牌

    思考1:
        每个玩家是一个对象,有玩家名称,玩家手里拿到的多张牌(List集合中)
        定义玩家Player类,优化此代码

    思考2:
        在思考1的基础上,分别把准备牌,洗牌,发牌,看牌定义成四个方法

    思考3:
        在思考1和思考2的基础上定义类Poker描述扑克牌
        成员变量:
            int num: 表示当前扑克牌的大小
            String content: 表示当前扑克牌的花色和数字
        把Poker类融入到思考2中的代码中
 */
public class Demo06PokerGame {
    public static void main(String[] args) {
        //1.创建List集合对象pokers,代表牌盒,用来存储54张扑克,存储数据类型String
        List<String> pokers = new ArrayList<>();
        //2.创建List集合对象colors,代表花色,用来存储所有的花色,存储数据类型String
        List<String> colors = new ArrayList<>();
        //3.向存储所有的花色的List集合对象colors中存储所有的花色
        Collections.addAll(colors, "♥", "♠", "♣", "♦");
        //4.创建List集合对象nums,代表数字,用来存储所有的数字,存储数据类型String
        List<String> nums = new ArrayList<>();
        //5.向存储所有的数字的List集合对象nums中存储所有的数字
        Collections.addAll(nums, "3-4-5-6-7-8-9-10-J-Q-k-A-2".split("-"));
        //6.循环嵌套遍历存储数字和花色的List集合对象nums和colors
        for (String num : nums) {
            for (String color : colors) {
                //7.拼接一张扑克,存储String变量poker中
                String poker = color + num;
                //8.把当前拼接的扑克poker添加到牌盒pokers中
                pokers.add(poker);
            }
        }
        //9.向牌盒pokers中添加小王和大王
        pokers.add("小王");
        pokers.add("大王");
        //10.打印牌盒pokers
        //System.out.println(pokers);
        //System.out.println(pokers.size());

        // 二: 洗牌(打乱牌盒pokers中的元素的顺序)
        Collections.shuffle(pokers);

        //System.out.println(pokers);
        //System.out.println(pokers.size());

        //三: 发牌
        //1.创建四个List集合对象p1,p2,p3,bottom,分别代表三个玩家和一个底牌,存储数据类型String
        List<String> p1 = new ArrayList<>();//玩家一
        List<String> p2 = new ArrayList<>();//玩家二
        List<String> p3 = new ArrayList<>();//玩家三
        List<String> bottom = new ArrayList<>();//底牌
        //2.遍历存储54张扑克的牌盒pokers(方式一: for + get(索引)  方式二: 迭代器   方式三: 增强for)
        //注意: 此处只能使用for + get(索引)的方式遍历,因为需要根据索引决定发给哪个玩家
        for (int i = 0; i < pokers.size(); i++) {
            //3.获取当前扑克保存String变量poker中
            String poker = pokers.get(i);
            //4.判断当前扑克索引值 > 50,不参与发牌,直接留作底牌
            if (i > 50) {
                //不参与发牌,直接留作底牌
                bottom.add(poker);
            } else {
                //5.判断当前扑克索引值 <= 50,参与发牌,根据索引%3的结果发给不同的玩家
                if (i % 3 == 0) {
                    //发给玩家一
                    p1.add(poker);
                } else if (i % 3 == 1) {
                    //发给玩家二
                    p2.add(poker);
                } else {
                    //发给玩家三
                    p3.add(poker);
                }
            }
        }
        //四: 看牌
        System.out.println("玩家一: " + p1);
        System.out.println("玩家二: " + p2);
        System.out.println("玩家三: " + p3);
        System.out.println("底牌: " + bottom);
    }
}
