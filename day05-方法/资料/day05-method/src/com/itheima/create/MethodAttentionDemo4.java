package com.itheima.create;

public class MethodAttentionDemo4 {


    public static void main(String[] args) {
        // 目标：掌握方法使用的注意事项
//        1. 方法的编写顺序无所谓。
        add(10, 20);

//        2.方法与方法之间是平级关系，不能嵌套定义。
//        public static void print() {
//            System.out.println("HelloWorld");
//        }

//        3.方法的返回值类型为void（无返回值），方法内则不能使用return返回数据，如果方法的返回值类型写了具体类型，方法内部则必须使用return返回对应类型的数据。

//        4.return语句下面，不能编写代码，因为永远执行不到，属于无效的代码。

//        5.方法不调用就不执行,  调用时必须严格匹配方法的参数情况。
//        print(100);
//        add(1, 2, 3);

//        6.有返回值的方法调用时可以选择定义变量接收结果，或者直接输出调用，甚至直接调用；无返回值方法的调用只能直接调用。
        int result = add(1, 2); // 接收方法调用的返回值
        System.out.println(result);

        System.out.println(add(1, 2));  // 输出调用

        add(1, 2);  // 直接调用

//        无返回值方法的调用只能直接调用。
        print();
//        int x = print();
//        System.out.println(print());
    }

    public static int add(int a, int b) {
        return a + b;
//        System.out.println("Hello");
//        int c = a + b;
//        return c;
//        return 3.14;
    }

    public static void print() {
        System.out.println("HelloWorld");
        // 方法的返回值类型为void（无返回值），方法内则不能使用return返回数据
//        return 3;
    }


}
