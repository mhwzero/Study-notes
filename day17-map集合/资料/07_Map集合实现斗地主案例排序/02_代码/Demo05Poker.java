package itheima04_poker;

import java.util.*;

/*
    斗地主综合案例(按照从小到大的顺序看牌)
    实现步骤:
        一: 准备牌
            1.创建Map集合对象pokers,代表牌盒,用来存储54张扑克,键Integer(编号),值String(扑克)
            2.创建List集合对象colors,存储数据类型String,用来存储所有的花色
            3.向List集合对象colors中存储所有的花色
            4.创建List集合对象nums,存储数据类型String,用来存储所有的数字
            5.向List集合对象nums中存储所有的数字
            6.循环嵌套遍历存储数字的List集合对象nums和存储花色的List集合对象colors
            7.拼接一张扑克,保存String变量poker中
            8.把当前拼接的扑克poker存储牌盒pokers中,并指定编号
            9.向牌盒pokers中存储小王,并指定编号
            10.向牌盒pokers中存储大王,并指定编号
        二: 洗牌(洗的是54张扑克的编号)
            1.获取Map集合对象pokers(牌盒)的所有的键对应的Set集合对象set
            2.把存储所有的键对应的Set集合转换成List集合对象list
            3.使用Collections工具类静态方法shuffle打乱List集合对象list中元素(54张扑克的编号)的顺序
        三: 发牌(发的是编号)
            1.创建四个List集合对象p1,p2,p3,bottom,存储数据类型Integer,分别代表三个玩家和一个底牌
            2.遍历存储编号的List集合对象(只能使用: for+get(索引) 原因: 根据索引%3的结果发给不同的玩家)
            3.获取当前扑克的编号,保存int变量num中
            4.判断当前扑克的编号的索引 大于 50,把当前扑克的编号留作底牌
            5.判断当前扑克的编号的索引 小于 50, 根据索引%3的结果,把编号发给不同的玩家

        四: 看牌
 */
@SuppressWarnings("all")
public class Demo05Poker {
    public static void main(String[] args) {
        //一: 准备牌
        //1.创建Map集合对象pokers,代表牌盒,用来存储54张扑克,键Integer(编号),值String(扑克)
        Map<Integer, String> pokers = new HashMap<>();
        //2.创建List集合对象colors,存储数据类型String,用来存储所有的花色
        List<String> colors = new ArrayList<>();
        //3.向List集合对象colors中存储所有的花色
        Collections.addAll(colors, "♥", "♠", "♦", "♣");
        //4.创建List集合对象nums,存储数据类型String,用来存储所有的数字
        List<String> nums = new ArrayList<>();
        //5.向List集合对象nums中存储所有的数字
        Collections.addAll(nums, "3-4-5-6-7-8-9-10-J-Q-K-A-2".split("-"));

        //6.循环嵌套遍历存储数字的List集合对象nums和存储花色的List集合对象colors
        int index = 0;//给54张扑克进行编号
        for (String num : nums) {
            for (String color : colors) {
                //7.拼接一张扑克,保存String变量poker中
                String poker = color + num;
                //8.把当前拼接的扑克poker存储牌盒pokers中,并指定编号
                pokers.put(index++, poker);
            }
        }
        //9.向牌盒pokers中存储小王,并指定编号
        pokers.put(index++, "小王");
        //10.向牌盒pokers中存储大王,并指定编号
        pokers.put(index, "大王");
        //System.out.println(pokers);
        //System.out.println(pokers.size());

        //二: 洗牌(洗的是54张扑克的编号)
        //1.获取Map集合对象pokers(牌盒)的所有的键对应的Set集合对象set
        Set<Integer> set = pokers.keySet();
        //2.把存储所有的键对应的Set集合转换成List集合对象list
        //通过ArrayList有参构造传递Collection集合对象
        List<Integer> list = new ArrayList<>(set);
        //System.out.println(list);
        //3.使用Collections工具类静态方法shuffle打乱List集合对象list中元素(54张扑克的编号)的顺序
        Collections.shuffle(list);

        //System.out.println(list);

        //三: 发牌(发的是编号)
        //1.创建四个List集合对象p1,p2,p3,bottom,存储数据类型Integer,分别代表三个玩家和一个底牌
        List<Integer> p1 = new ArrayList<>();//玩家一
        List<Integer> p2 = new ArrayList<>();//玩家二
        List<Integer> p3 = new ArrayList<>();//玩家三
        List<Integer> bottom = new ArrayList<>();//底牌
        //2.遍历存储编号的List集合对象(只能使用: for+get(索引) 原因: 根据索引%3的结果发给不同的玩家)
        for (int i = 0; i < list.size(); i++) {
            //3.获取当前扑克的编号,保存int变量num中
            int num = list.get(i);
            //4.判断当前扑克的编号的索引 大于 50,把当前扑克的编号留作底牌
            if (i > 50) {
                bottom.add(num);
            } else {
                //5.判断当前扑克的编号的索引 小于 50, 根据索引%3的结果,把编号发给不同的玩家
                if (i % 3 == 0) {
                    //发给玩家一
                    p1.add(num);
                } else if (i % 3 == 1) {
                    //发给玩家二
                    p2.add(num);
                } else {
                    //发给玩家三
                    p3.add(num);
                }
            }
        }
        //四: 看牌
        lookPokers(p1,"玩家一",pokers);
        lookPokers(p2,"玩家二",pokers);
        lookPokers(p3,"玩家三",pokers);
        lookPokers(bottom,"底牌",pokers);
    }

    /*
        定义方法完成看牌
            参数:
                List<Integer> list: 玩家手里获取到的扑克的编号
                String playerName: 玩家名称
                Map<Integer,String> pokers: 存储54张扑克和对应编号的牌盒
     */
    public static void lookPokers(List<Integer> list, String playerName, Map<Integer, String> pokers) {
        //1.对玩家手里的扑克编号进行升序排序
        Collections.sort(list);
        System.out.print(playerName + ": [ ");
        //2.遍历玩家手里的扑克编号
        for (int num : list) {
            //3.根据编号获取对应的扑克
            String poker = pokers.get(num);
            System.out.print(poker + "  ");
        }
        System.out.println("]");
    }
}
