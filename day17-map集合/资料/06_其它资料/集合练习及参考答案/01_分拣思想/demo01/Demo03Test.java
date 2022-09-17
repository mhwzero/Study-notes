package com.itheima.demo01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    练习一:
        ArrayList<Integer> list 里面存放的是学生成绩{80，90，100，60，50，30，55，98，36}，
        对ArrayList集合中的成绩进行统计，将统计后的结果放入
        map中，"及格的学员数量" = 5   "不及格的学员数量"=4
        最后打印map集合

        思考:能否按照课程中统计字符串中每个字符数量的思路完成
 */
public class Demo03Test {
    public static void main(String[] args) {
        Integer[] array = {80,90,100,60,50,30,55,98,36};
        List<Integer> list = Arrays.asList(array);
        int count1 = 0;
        int count2 = 0;
        for(int num : list) {
            if(num>=60) {
                count1++;
            } else {
                count2++;
            }
        }
        //存入到map当中
        Map<String,Integer> map = new HashMap<>();
        map.put("及格的学员数量",count1);
        map.put("不及格的学员数量",count2);
        //遍历:
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }
}
