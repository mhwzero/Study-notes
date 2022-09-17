package com.itheima.p1_final_class;

import java.util.ArrayList;
import java.util.Collection;

//ArrayList没有被final修饰,可以被继承
public class MyArrayList extends ArrayList {
    //根据父类生成构造方法(快捷键生成)
    public MyArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public MyArrayList() {
    }

    public MyArrayList(Collection c) {
        super(c);
    }
}
