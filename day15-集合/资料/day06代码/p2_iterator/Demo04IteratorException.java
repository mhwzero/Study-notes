package com.itheima.p2_iterator;

import java.util.ArrayList;
import java.util.Iterator;
/*
    并发修改异常
        原因: 使用迭代器遍历集合元素时,又通过集合对象本身调用集合的方法,修改了集合的长度
        解决方案:
            使用迭代器遍历集合元素时,不能通过集合对象本身调用集合的方法,修改集合的长度
            (1)使用Collection接口迭代器的方法修改长度: remove
            (2)使用List接口特有迭代器ListIterator中的方法修改长度: remove,add

        面试题一:
            1.并发修改异常的原理是什么?
            2.为什么使用迭代器遍历Collection集合时,使用集合对象的remove方法删除倒数第二个元素,不报并发修改异常?

 */
public class Demo04IteratorException {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        list.add("DDD");
        //删除元素BBB
        /*
            集合内部:
                成员变量int modCount: 记录对集合的实际修改次数
                使用集合对象每次调用add/remove方法,都会导致该变量的值增加1
                现在在获取之前调用了四次add方法,modCount的值是4
            iterator方法获取迭代器对象时:
                在迭代器内部有个成员变量int expectedModCount = modCount;
                获取迭代器对象时,预期修改次数expectedModCount的值就等于 实际修改次数modCount的值 就是 4
         */
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            /*
                方法内部判断 如果 实际修改次数modCount != 预期修改次数 expectedModCount
                抛出并发修改异常ConcurrentModificationException
             */
            String s = it.next();
            if ("BBB".equals(s)) {
                //导致集合实际修改次数modCount的值增加1,变成5
                list.remove(s);//通过集合修改长度,有问题
                //list.set(1, "B");//只修改了内容,没有修改长度,没有问题
                /*
                    方法内部在删除元素后,会把实际修改次数modCount 重新赋值给 预期修改次数 expectedModCount
                    导致:
                        next方法内部 modCount == expectedModCount  结果是true,不会报异常
                 */
                //it.remove();//通过迭代器修改长度,没有问题
            }
            /*if ("CCC".equals(s)) {
                list.remove(s);//为什么: 通过集合对象的remove方法删除CCC(集合的倒数第二个元素),就不报并发修改异常的呢?
            }*/
        }
        System.out.println(list);
    }
}