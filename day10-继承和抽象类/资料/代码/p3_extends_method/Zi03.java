package com.itheima.p3_extends_method;

public class Zi03 extends Fu03 {
    public void methodZi() {
        System.out.println("Zi03..methodZi..");
    }
    /*
        覆盖重写:
            父类有,但是子类又自己重新写了一份
            要求:
                方法声明(第一行)必须和父类保持一致
            特点:
                子类对象调用方法,访问的是子类重写后的
     */
    @Override
    public void method() {
        System.out.println("Zi03..method..");
    }

    /*
        不是方法重写:
            原因: 参数和父类方法不一样
        和上面的方法:
            构成了重载关系(名称相同,但是参数列表不同)
        @Override: 此注解作用是检测方法是否是对父类方法的覆盖重写
        是: 不会报错
        不是: 会报错的
     */
    //@Override
    public void method(int num) {
        System.out.println("Zi03..method.." + num);
    }

    //小王生活很奢靡
    @Override
    public void drive() {
        System.out.println("开着法拉利,一路高歌去东莞...");
    }
}
