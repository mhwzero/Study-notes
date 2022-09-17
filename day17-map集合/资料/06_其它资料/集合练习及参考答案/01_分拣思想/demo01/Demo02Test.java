package com.itheima.demo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    --推荐使用 Map<String,ClassRoom>
				ClassRoom类参照以下代码:
					public class ClassRoom {
						private String no;//班号
						private List<Student> stus;//班级有多个学生
						private double total;//班级总分
						//...
					}
 */
public class Demo02Test {
    public static void main(String[] args) {
        //1.考试,获取所有的学生组成的List集合,泛型Student
        List<Student> list = exam();
        //2.批改成绩
        Map<String,ClassRoom> map = count(list);
        //3.查看成绩
        view(map);
    }
    //查看成绩
    private static void view(Map<String, ClassRoom> map) {
        //遍历map集合
        for(Map.Entry<String, ClassRoom> entry : map.entrySet()) {
            //获取班号
            String no = entry.getKey();
            //获取班级对象
            ClassRoom classRoom = entry.getValue();
            //获取总分
            double total = classRoom.getTotal();
            //计算平均分
            double avg = total / classRoom.getList().size();
            System.out.println(no+ " 班级, 总分: "+total+", 平均分: "+avg);
        }
    }

    /*
        把list集合中的学生对象,放入到Map集合中
        分拣的思想:
     */
    private static Map<String,ClassRoom> count(List<Student> list) {
        //创建Map集合对象:String代表班号,ClassRoom班级对象
        Map<String, ClassRoom> map = new HashMap<>();
        //遍历list集合
        for(Student student : list) {
            //获取班号
            String no = student.getNo();
            //获取班号对应的ClassRoom
            ClassRoom classRoom = map.get(no);
            //判断classRoom是否存在
            if(classRoom==null) {
                //创建班级
                classRoom = new ClassRoom(no);
                //把班级对象存入map集合
                map.put(no,classRoom);
            }
            //把Student对象添加到ClassRoom当中
            classRoom.getList().add(student);
            //修改总分
            //原来的总分
            double total = classRoom.getTotal();
            classRoom.setTotal(total+student.getScore());
        }
        //返回map集合对象
        return map;
    }

    //考试的方法
    private static List<Student> exam() {
        //创建ArrayList集合对象
        List<Student> list = new ArrayList<>();
        //存储学生信息
        list.add(new Student("zs01","001",95));
        list.add(new Student("ls01","001",85));
        list.add(new Student("ws01","001",55));
        list.add(new Student("zl01","001",75));
        list.add(new Student("zs02","002",75));
        list.add(new Student("ls02","002",65));
        list.add(new Student("ws02","002",85));
        list.add(new Student("zl02","002",95));
        //返回集合对象
        return list;
    }
}
