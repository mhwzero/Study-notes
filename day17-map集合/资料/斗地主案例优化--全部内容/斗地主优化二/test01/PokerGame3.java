package test01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    思考2:
        在思考1的基础上,分别把准备牌,洗牌,发牌,看牌定义成四个方法
 */
public class PokerGame3 {
    public static void main(String[] args) {
        //调用方法准备牌: 获取存储54张扑克的List集合对象
        List<String> pokers = zhunBeiPai();
        //调用方法洗牌
        xiPai(pokers);

        //调用方法,完成发牌,获取存储多个玩家的List集合对象
        List<Player> playerList = faPai(pokers);

        //四:看牌
        kanPai(playerList);
    }

    //定义方法看牌
    public static void kanPai(List<Player> playerList) {
        for (Player player : playerList) {
            System.out.println(player.getPlayerName() + ": " + player.getList());
        }
    }

    //定义方法发牌
    public static List<Player> faPai(List<String> pokers) {
        //三:发牌
        //1.创建四个List集合对象p1,p2,p3,bottom,分别代表三个玩家和一个底牌
        Player p1 = new Player("玩家一");
        Player p2 = new Player("玩家二");
        Player p3 = new Player("玩家三");
        Player bottom = new Player("底牌");
        //2.遍历存储54张扑克的牌盒List集合对象pokers(一: 普通for循环 + get(索引)  二: 增强for循环  三: 迭代器)
        //注意: 此处只能使用方式一普通for循环 + get(索引),原因需要通过元素的索引值决定到底发给哪个玩家,但是增强for/迭代器都是没有索引的
        for (int i = 0; i < pokers.size(); i++) {
            //2.1 获取当前扑克,保存String变量poker中
            String poker = pokers.get(i);
            //2.2 判断如果当前扑克的索引编号 大于 50
            if (i > 50) {
                //直接留作底牌(不参与发牌)
                bottom.getList().add(poker);
            } else {
                //2.3 判断如果当前扑克的索引编号 小于或等于 50,参与发牌,根据索引%3的结果发给不同的玩家
                if (i % 3 == 0) {
                    //发给玩家一
                    p1.getList().add(poker);
                } else if (i % 3 == 1) {
                    //发给玩家二
                    p2.getList().add(poker);
                } else {
                    //发给玩家三
                    p3.getList().add(poker);
                }
            }
        }
        //创建存储多个玩家Player对象的List集合对象
        List<Player> playerList = new ArrayList<>();
        //把上面的多个玩家添加到存储玩家的List集合中
        Collections.addAll(playerList, p1, p2, p3, bottom);
        //返回存储所有玩家对象的List集合对象
        return playerList;
    }

    //定义方法洗牌
    private static void xiPai(List<String> pokers) {
        //二:洗牌(打乱牌盒pokers中的元素的顺序)
        Collections.shuffle(pokers);
        //System.out.println(pokers);
        //System.out.println(pokers.size());
    }

    //定义获取存储54张扑克的List集合对象
    private static List<String> zhunBeiPai() {
        //一:准备牌
        //1.创建List集合对象pokers,存储数据类型String,代表牌盒,用来存储54张扑克
        List<String> pokers = new ArrayList<>();
        //2.创建List集合对象colors,存储数据类型String,代表花色,用来存储多个花色
        List<String> colors = new ArrayList<>();
        //3.创建List集合对象nums,存储数据类型String,代表数字,用来存储多个数字
        List<String> nums = new ArrayList<>();
        //4.向存储多个花色List集合对象colors中添加所有需要用到的花色
        Collections.addAll(colors, "♥-♠-♣-♦".split("-"));
        //5.向存储多个花色List集合对象nums中添加所有需要用到的数字
        //添加2-10
        Collections.addAll(nums,"3-4-5-6-7-8-9-10-J-Q-K-A-2".split("-"));
        //6.循环嵌套遍历存储花色的集合colors和存储数字的集合nums
        for (String num : nums) {//增强for遍历数字
            for (String color : colors) {//增强for遍历花色
                //7.拼接一张扑克,存储String变量poker中
                String poker = color + num;
                //8.把当前拼接的扑克poker添加到牌盒pokers中
                pokers.add(poker);
            }
        }
        //9.向牌盒pokers中添加小王和大王
        pokers.add("小王");
        pokers.add("大王");
        //10.打印牌盒
        //System.out.println(pokers);
        //System.out.println(pokers.size());
        return pokers;
    }
}
