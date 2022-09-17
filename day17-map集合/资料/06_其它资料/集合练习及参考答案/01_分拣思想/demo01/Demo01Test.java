package com.itheima.demo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    练习二:
	1.要求:定义一个Student类
		属性:
			String name  姓名
			String no 	 班号
			double score 成绩
	2.现在将若干Student对象放入List中,请统计出每个班级的总分和平均分

	3.功能实现要求
		(1)随便自己想怎么写,就怎么写(只要实现功能就可以)
		(2)按照以下指定思路实现:
			--不推荐使用 Map<String,List<Student>> 操作不方便(按照这种思路如何实现)
			--推荐使用 Map<String,ClassRoom>
				ClassRoom类参照以下代码:
					public class ClassRoom {
						private String no;//班号
						private List<Student> stus;//班级有多个学生
						private double total;//班级总分
						//...
					}
 */
public class Demo01Test {
    public static void main(String[] args) {
        /*
            (2)按照以下指定思路实现:
			--不推荐使用 Map<String,List<Student>> 操作不方便(按照这种思路如何实现)
         */
        //定义Map集合,键String:班级编号,值List:班级里面的学生
        Map<String,List<Student>> map = new HashMap<>();
        //向map集合中添加数据
        List<Student> list01 = new ArrayList<>();
        list01.add(new Student("zs01","001",95));
        list01.add(new Student("ls01","001",85));
        list01.add(new Student("ws01","001",55));
        list01.add(new Student("zl01","001",75));
        List<Student> list02 = new ArrayList<>();
        list02.add(new Student("zs02","002",75));
        list02.add(new Student("ls02","002",65));
        list02.add(new Student("ws02","002",85));
        list02.add(new Student("zl02","002",95));
        map.put("001",list01);
        map.put("002",list02);
        /*
            遍历map集合
         */
        for(Map.Entry<String,List<Student>> entry : map.entrySet()) {
            //获取key:班级编号
            String no = entry.getKey();
            //获取班级中的所有学生
            List<Student> list = entry.getValue();
            //求总分
            double sum = getSum(list);
            //求品均分
            double avg = sum/list.size();

            System.out.println(no+"班级的总分: "+sum+", 平均分: "+avg);
        }

    }

    /*
        定义一个方法,求出List集合中所有Student对象的成绩之和
     */
    public static double getSum(List<Student> list) {
        double sum = 0;
        for(Student student : list) {
            sum = sum + student.getScore();
        }
        return sum;
    }
}
