package com.itheima.p5_duotai;
/*
    多态的好处:
       可以使用父类/接口,作为方法的参数,提高方法的扩展性

    问题:
       下面分别是用Animal的子类Dog和Cat作为方法参数,定义了两个方法
       Animal的子类可以有任意多个,这样定义的方法也就会有任意多个
       每创建一个子类,就得再添加一个方法,太麻烦

       解决方案:
           所有的子类对象,都可以当做父类类型使用
           所以可以使用父类类型作为方法的参数

        类作为方法的参数:
            调用方法时,传递的是该类的对象或者是该类的子类对象

        类的数据体现形式是对象
        抽象类的数据体现形式是子类对象
        接口的数据体现形式是实现类对象
        暴露新的问题: 方法内部不能直接调用子类的特有行为了(后面解决)
*/
public class Demo08DuoTai {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //调用方法
        showAnimal(dog);
        Cat cat = new Cat();
        //调用方法
        showAnimal(cat);
    }

    //定义方法,参数是父类Animal类型
    //方法的参数是类的话,调用方法必须传递该类的对象/子类对象
    //方法被调用时: Animal a = dog = new Dog(); 左侧是父类变量,右侧是子类对象  多态
    //方法被调用时: Animal a = cat = new Cat(); 左侧是父类变量,右侧是子类对象  多态
    public static void showAnimal(Animal a) {
        a.eat();
        a.sleep();
        /*
            缺点:
                多态调用,不能直接调用子类的特有方法
         */
        //a.kanHome();
        //a.catchMouse();
    }
}
