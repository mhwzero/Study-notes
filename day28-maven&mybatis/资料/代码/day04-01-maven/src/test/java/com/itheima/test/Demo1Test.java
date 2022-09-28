package com.itheima.test;

import com.itheima.demo.Demo1;
import org.junit.Test;

//类Test
public class Demo1Test {

    //test方法名
    @Test
    public void testSayHello() {
        new Demo1().sayHello();
    }
}
