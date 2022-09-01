package com.itheima.loop;

public class BreakAndContinueDemo11 {
    public static void main(String[] args) {
        // 目标：掌握break和continue关键字的使用
        // break：跳出当前循环的执行
        // 假设你现在有女朋友了，你犯错误了，她让你连续跪搓衣板10天，但是跪到第9天，实在跪不下去了，分手了
        for (int i = 1; i <= 10; i++) {
            System.out.println("快乐地跪搓衣板~~~第" + i + "天");
            if (i == 9) {
                System.out.println("受不了了，分手吧");
                break;
            }
        }
        System.out.println("=====================");
        // continue: 结束当次循环的当次执行，循环会继续执行
        // 假设你现在有新女朋友了，你又犯错误了，她让你跪榴莲，但是到了第7天的时候，给她买了一个lv包，她很开心，当天不用跪了，但是依然不解气，第8天，和后面继续跪
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                continue;
            }
            System.out.println("快乐地跪搓榴莲~~~第" + i + "天");
        }
    }
}
