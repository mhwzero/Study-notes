package com.itheima.arraylist;

import java.util.ArrayList;

public class Test4 {
    public static void main(String[] args) {
        // 需求：某个班考试成绩分别为：98, 77, 66, 89, 79, 50, 100
        // 现在需要临时删除分数低于80分的成绩
        // 1.用一个ArrayList存储一批分数
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(98);
        scores.add(77);
        scores.add(66);
        scores.add(89);
        scores.add(79);
        scores.add(50);
        scores.add(100);

        //   98, 89, 100
        //               i

        // 2.遍历集合，判断当前得到的分数是否低于80分，低于就删掉

        // 有问题的代码，不严谨，可能漏删数据
//        for (int i = 0; i < scores.size(); i++) {
//            int score = scores.get(i);
//            // 3.判断当前分数是否低于80分
//            if (score < 80) {
//                scores.remove(i);
//            }
//        }

        // 正确的解决方案1：每次删除一个元素，当前索引减1
//        for (int i = 0; i < scores.size(); i++) {
//            int score = scores.get(i);
//            // 3.判断当前分数是否低于80分
//            if (score < 80) {
//                scores.remove(i);
//                i--;
//            }
//        }

//        98, 89, 100
//      i
        // 正确的解决方案2：从后面往前倒着遍历
        for (int i = scores.size() - 1; i >= 0; i--) {
            int score = scores.get(i);
            // 3.判断当前分数是否低于80分
            if (score < 80) {
                scores.remove(i);
            }
        }

        System.out.println(scores);

    }
}
