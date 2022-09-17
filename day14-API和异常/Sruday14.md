# day05 【API、异常】

今日内容介绍

```j
Math类 
BigInteger类
BigDecimal类
基本类型包装类
异常
```

## 第一章 Math类

### 1.1 Math类的介绍【重点】

```java
/*
    java.lang.Math类: 用于数学运算的工具类
    特点:
        1.成员都使用static修饰
        2.构造方法private修饰
    静态成员:
        public static final double PI: 常量,代表圆周率
        public static int abs(int a): 返回参数的绝对值
        public static double ceil(double a): 返回大于或等于参数的最小double值，等于一个整数
        public static double floor(double a): 返回小于或等于参数的最大double值，等于一个整数
        public static int round(float a): 按照四舍五入返回最接近参数的int
        public static double pow(double a, double b): 计算a的b次方

    注意:
        以上方法中必须掌握ceil方法
        后面学习分页查询
        假设每页显示条数固定的: 10条
        如果有100条数据: 10页
        如果有101条数据: 11页
        如果有99条数据: 10页

        [1][2][3]...[10]
*/
```



### 1.2 Math类的使用【重点】

```java
public class Demo01Math {
    public static void main(String[] args) {
        System.out.println(Math.PI);//圆周率
        System.out.println(Math.abs(-6));//6
        System.out.println(Math.abs(6));//6
        System.out.println(Math.abs(-6.6));//6.6
        System.out.println(Math.abs(6.6));//6.6
        System.out.println("------------");

        System.out.println(Math.ceil(5.2));//6
        System.out.println(Math.ceil(5.6));//6
        System.out.println(Math.ceil(5.0));//5.0
        System.out.println(Math.ceil(-5.2));//-5.0
        System.out.println(Math.ceil(-5.6));//-5.0
        System.out.println(Math.ceil(-5.0));//-5.0
        System.out.println("------------");

        System.out.println(Math.floor(5.2));//5
        System.out.println(Math.floor(5.6));//5
        System.out.println(Math.floor(5.0));//5.0
        System.out.println(Math.floor(-5.2));//-6.0
        System.out.println(Math.floor(-5.6));//-6.0
        System.out.println(Math.floor(-5.0));//-5.0
        System.out.println("------------");

        System.out.println(Math.round(6.0));//6
        System.out.println(Math.round(6.49));//6
        System.out.println(Math.round(6.5));//7
        System.out.println("------------");

        //水仙花数字153: 1*1*1 + 5*5*5 + 3*3* = 153
        System.out.println(Math.pow(1,3)+Math.pow(5,3)+Math.pow(3,3));

    }
}
```



## 第二章 BigInteger类【重点】

### 2.1 大数运算介绍

```java
/*
    1.基本类型整数的取值范围?
        byte	1个字节	-128到127
        short	2个字节	正负3万多
        int		4个字节	正负21亿
        long	8个字节	大概19位数字

    2.基本类型整数取值范围最大的就是long类型, 如果整数的范围超过了long类型,怎么办呢?
        解决方案: 大整数
            java.math.BigInteger类: 代表超级大的整数,不可变的任意精度的整数。

    3.基本类型小数的取值范围?
        float	4个字节
        double	8个字节

    4.基本类型小数取值范围最大的就是double类型, 如果小数的范围超过了double类型,怎么办呢?
        解决方案: 大小数
            java.math.BigDecimal类: 代表超级大的小数,不可变的、任意精度的小数。 
    5.注意:
        如果数据的取值范围超出了数字的最大范围,此时这样的数字称为大数
        java.math.BigInteger类: 代表超级大的整数,不可变的任意精度的整数。
        java.math.BigDecimal类: 代表超级大的小数,不可变的、任意精度的小数。
*/
```

```java
public class Demo02BigNumber {
    public static void main(String[] args) {
        System.out.println(1111111);//默认int类型
        System.out.println(1111111111111L);//long类型
        //System.out.println(11111111111111111111L);//报错: 超出了long类型的取值范围

        System.out.println(66.66);
        System.out.println(666666666666666666666666666666666666666.66);
        //报错: 超出了double类型的取值范围
        //System.out.println(666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666.66);
    }
}

```



### 2.2 BigInteger类的使用

```java
/*
    BigInteger类的使用
    java.math.BigInteger类: 代表超级大的整数,不可变的任意精度的整数。
    1.构造方法:
        public BigInteger(String val): 
        	作用: 把构造方法参数String类型的val,转换成BigInteger类的对象
            参数: 必须是String类型的数字,内部不能出现非数字内容

    2.常用方法:
        数学运算中最常用的就是+,-,*,/,所以对于BigInteger类提供了对应的方法
        public BigInteger add(BigInteger val):
            完成数学中的加法运算,
            返回其值为 (this(调用add方法的BigInteger对象) + val(调用add方法时传递的参数BigInteger对象)) 的 BigInteger。

        public BigInteger subtract(BigInteger val):
            完成数学中的减法运算,
            返回其值为 (this(调用add方法的BigInteger对象) - val(调用add方法时传递的参数BigInteger对象)) 的 BigInteger。

        public BigInteger multiply(BigInteger val):
            完成数学中的乘法运算,
            返回其值为 (this(调用add方法的BigInteger对象) * val(调用add方法时传递的参数BigInteger对象)) 的 BigInteger。

        public BigInteger divide(BigInteger val):
            完成数学中的除法运算,
            返回其值为 (this(调用add方法的BigInteger对象) / val(调用add方法时传递的参数BigInteger对象)) 的 BigInteger。
*/

```

```java
public class Demo03BigInteger {
    public static void main(String[] args) {
        //创建BigInteger类对象
        BigInteger b1 = new BigInteger("66666666666666666666");
        System.out.println(b1);//66666666666666666666

        //报错: ""中不能有非数字符号
        //BigInteger b2 = new BigInteger("3333333333a3333333333");
        BigInteger b2 = new BigInteger("33333333333333333333");

        //调用add方法完成加法计算
        BigInteger b3 = b1.add(b2);
        System.out.println("和: " + b3);

        //调用subtract方法完成减法计算
        BigInteger b4 = b1.subtract(b2);
        System.out.println("差: " + b4);

        //调用multiply方法完成乘法计算
        BigInteger b5 = b1.multiply(b2);
        System.out.println("积: " + b5);

        //调用divide方法完成除法计算
        BigInteger b6 = b1.divide(b2);
        System.out.println("商: " + b6);
    }
}

```



### 2.3 浮点数的不精确性

```java
/*
    使用double完成加减乘除运算

    问题: 出现损失精度的问题

    不允许: 钱的问题

    解决方案: 使用java.math.BigDecimal类

 */
public class Demo04DoubleProblem {
    public static void main(String[] args) {
        double d1 = 0.03;
        double d2 = 0.02;
        System.out.println(d1 + d2);
        System.out.println(d1 - d2);
        System.out.println(d1 * d2);
        System.out.println(d1 / d2);
    }
}

```

## 第三章 BigDecimal类

### 3.1 BigDecimal类的介绍

```java
/*
    BigInteger类的使用
    java.math.BigDecimal类: 代表超级大的小数,不可变的任意精度的小数。
    1.构造方法:
        public BigDecimal(String val): 
        	作用: 把构造方法参数String类型的val,转换成BigDecimal类的对象
            参数: 必须是String类型的数字,内部不能出现非数字内容

    2.常用方法:
        数学运算中最常用的就是+,-,*,/,所以对于BigDecimal类提供了对应的方法
        对于+,-,*这些运算和BigInteger是一样的,就不再演示了
        但是对于 除法 运算,可能会出现 无限循环/无限不循环的结果
        然而BigDecimal是用来完成超级精确的数学运算,这样就导致
        BigDecimal不知道到底给你什么样的结果?
        解决方案:
            (1)告诉它保留多少位小数
            (2)如何保留小数

        public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode):
            按照方法参数指定的保留位数以及保留方式做除法运算
            参数:
                 int scale: 要保留几位小数
                 int roundingMode: 如何保留小数
                        BigDecimal.ROUND_UP 向上加1。
                        BigDecimal.ROUND_DOWN 直接舍去。
                        BigDecimal.ROUND_HALF_UP 四舍五入。
*/
```

### 3.2 BigDecimal类的使用

```java
public class Demo05BigDecimal {
    public static void main(String[] args) {
        //创建BigDecimal类的对象
        BigDecimal b1 = new BigDecimal("10.0");
        //报错: ""中不能有非数字符号
        //BigDecimal b2 = new BigDecimal("666a6666.666666666");
        BigDecimal b2 = new BigDecimal("3.0");

        BigDecimal b3 = b1.divide(b2,8,BigDecimal.ROUND_DOWN);
        System.out.println(b3);//0.33333333

        BigDecimal b4 = b1.divide(b2, 5, BigDecimal.ROUND_UP);
        System.out.println(b4);//0.33334

        BigDecimal b5 = b1.divide(b2, 5, BigDecimal.ROUND_DOWN);
        System.out.println(b5);//0.33333

        BigDecimal b6 = b1.divide(b2, 5, BigDecimal.ROUND_HALF_UP);
        System.out.println(b6);//0.33333
    }
}
```





## 第四章 基本类型包装类【重点】

### 4.1 包装类的概念

```java
/*
    包装类的概念
    ArrayList集合存储基本类型数据时,要求<>中必须指定基本类型对应的引用类型(包装类)

        基本类型                引用类型(包装类)
        byte                    Byte
        short                   Short
        int                     Integer
        long                    Long
        float                   Float
        double                  Double
        char                    Character
        boolean                 Boolean

    集合中永远只能存储引用类型:
        只需要在创建集合对象时,<>中指定对应的包装类,其它操作都可以按照基本类型完成

    引用类型(包装类)并不是对基本类型的简单替换,而是包装类中提供了大量的方法完成相关功能
*/
```

```java
public class Demo02BaoZhuang {
    public static void main(String[] args) {
        //创建ArrayList集合对象,存储整数
        //ArrayList<int> list = new ArrayList<int>();//错误:<>中不能写基本类型
        ArrayList<Integer> list = new ArrayList<>();

        list.add(100);
        list.add(200);
        list.add(300);
        list.add(500);

        //遍历
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            System.out.println(num);
        }
    }
}

```



### 4.2 Integer类对象的创建【重点】

```java
/*
    java.lang.Integer类对象的创建
    Integer 类在对象中包装了一个基本类型 int 的值。
    构造方法:
        public Integer(int value):
            把构造方法int参数value,转换成Integer对象

        public Integer(String value):
            把构造方法String参数value,转换成Integer对象
    思考:
        Integer类中有没有返回值是Integer类型的方法?

    静态方法:
        public static Integer valueOf(int i): 
        	作用: 把方法参数int类型的i转换成Integer类型并返回
        	
        public static Integer valueOf(String i): 
        	作用: 把方法参数String类型的i转换成Integer类型并返回

    注意:
        1.构造方法/静态方法参数不可以超出int的范围
        2.构造方法/静态方法如果采用String的参数,参数中不可以包含非数字字符
*/
```

```java
public class Demo03Integer {
    public static void main(String[] args) {
        //创建Integer类的对象
        Integer i1 = new Integer(300);
        System.out.println(i1);//300

        //Integer i2 = new Integer("30a00");//错误
        Integer i2 = new Integer("3000");
        System.out.println(i2);//300

        System.out.println("---------------");

        //Integer类调用静态方法,获取Integer对象
        Integer i3 = Integer.valueOf(300);
        System.out.println(i3);//300

        Integer i4 = Integer.valueOf("30a0");
        System.out.println(i4);

    }
}

```



### 4.3 Integer类的常用方法【重点】

```java
/*
    java.lang.Integer类: 内部会包装一个int/String数字
    1.思考:
        如何获取int数据的取值范围? 最大值和最小值(通过Integer类中的常量)
            public static final int   MAX_VALUE = 0x7f ff ff ff;
            public static final int   MIN_VALUE = 0x80000000;

    2.思考:
        如何获取int数字对应的二进制/八进制/十六进制数字?
            public static String toBinaryString(int i): 
                把方法参数int类型的i转换成二进制,并返回对应的String结果

            public static String toOctalString(int i): 
                把方法参数int类型的i转换成八进制,并返回对应的String结果

            public static String toHexString(int i): 
                把方法参数int类型的i转换成十六进制,并返回对应的String结果

        0b: 表示二进制
        0x: 表示十六进制
        0:  表示八进制
*/    
```

```java
public class Demo04IntegerMethod {
    public static void main(String[] args) {
        //int最大值
        System.out.println(Integer.MAX_VALUE);
        //int最小值
        System.out.println(Integer.MIN_VALUE);

        //定义int变量num
        int num = 100;
        //转换成二进制
        System.out.println(Integer.toBinaryString(num));//1100100
        //转换成八进制
        System.out.println(Integer.toOctalString(num));//144
        //转换成十六进制
        System.out.println(Integer.toHexString(num));//64
    }
}

```



### 4.4 包装类的自动装箱拆箱

```java
/*
    包装类的自动装箱拆箱
    自动装箱:
        基本类型数据,可以自动转换为对应的引用类型(包装类),是自动完成滴,不需要代码特殊处理

    自动拆箱:
        引用类型数据(包装类),可以自动转换为对应的基本类型,是自动完成滴,不需要代码特殊处理
*/    
```

```java
public class Demo05AutoBox {
    public static void main(String[] args) {
        //不建议使用
        Integer i1 = new Integer(300);
        System.out.println(i1);
        /*
            javac编译: 底层优化处理
            底层原理:
                Integer.valueOf(300)
         */
        Integer i2 = 300;//发生自动装箱
        System.out.println(i2);//默认调用toString方法
        /*
            valueOf方法的底层原理:
                调用构造方法创建Integer类的对象
                new Integer(300)
         */
        Integer i3 = Integer.valueOf(300);
        System.out.println(i3);
        System.out.println("----------------");
        /*
            javac编译: 底层优化处理
            底层原理:
                调用Integer类的成员方法intValue
                返回Integer对象i1中封装的int数据value的值
                i1.intValue()
         */
        int num = i1;//发生自动拆箱
        System.out.println(num);
        System.out.println("----------------");

        Integer i4 = 300;//发生自动装箱
        /*
            先发生自动拆箱:
                i4.intValue()方法: 把i4拆箱成300
            然后计算300 + 200的结果: 500
            最后发生自动装箱: 把500转向成Integer对象
                Integer.valueOf(500) --> new Integer(500)
         */        
        Integer i5 = i4 + 200;
        System.out.println(i5);        
    }
}

```



### 4.5 基本类型转换成对应的字符串

```java
/*
    基本类型int 转换成 String
        1.最简单/最常用的方式:
            基本类型int数据  + ""     借助+进行字符串拼接

        2.思考: String类中有没有参数是int类型,返回值是String类型方法?
            public static String valueOf(int i): 把方法参数int数据i,转换成String类型并返回

        3.思考: Integer类中有没有参数是int类型,返回值是String类型方法?
            public static String toString(int i)
*/
```

```java
public class Demo06ToString {
    public static void main(String[] args) {
        int num = 20;
        String strNum = num + "";
        System.out.println(strNum);//20
        System.out.println(strNum+20);//2020
        System.out.println("----------");

        String s = String.valueOf(num);
        System.out.println(s);//20
        System.out.println(s+20);//2020
        System.out.println("----------");

        String s2 = Integer.toString(num);
        System.out.println(s2);//20
        System.out.println(s2+20);//2020
    }
}

```



### 4.6 String解析成对应的基本类型

```java
/*
    String解析成对应的基本类型(很常用的)
        包装类中除了Character以外,每个包装类都会提供一个静态方法
            public static xxx parseXxx(String str): 
                把方法参数String数据str转换成xxx类型的数据

        Integer类:
            public static int parseInt(String str): 
                把方法参数String数据str转换成int类型的数据

        Double类:
            public static double parseDouble(String str): 
                把方法参数String数据str转换成double类型的数据

        Boolean类:
            public static boolean parseBoolean(String str): 
                把方法参数String数据str转换成boolean类型的数据
*/
```

```java
public class Demo07ParseString {
    public static void main(String[] args) {
        String str = "20";

        //把String数据转换成int数据
        int num = Integer.parseInt(str);
        System.out.println(num);//20
        System.out.println(num + 20);//40
        System.out.println("---------------");

        String str2 = "66.66";
        //把String数据转换成double数据
        double num2 = Double.parseDouble(str2);
        System.out.println(num2);//66.66
        System.out.println(num2 + 33.33);//99.99
        System.out.println("---------------");

        String str3 = "true";
        boolean reslut = Boolean.parseBoolean(str3);
        System.out.println(reslut);//true
        System.out.println(!reslut);//false
    }
}
```



## 第五章  异常【重点】

### 5.1 异常的概念和体系

```java
/*
    异常:程序中的意外问题,处理异常,提供一种预防机制(预案),写字楼中的消防栓 
    异常的体系:
        |--Object
            |--Throwable 程序中可能会出现的所有的不正常的情况
                |--Error 程序中的致命的问题,严重的错误
                    比如:绝症 一旦出现了Error,程序不能继续进行
                |--Exception(编译时期的异常) 程序中的小的问题,小的错误,
                    比如:感冒,发烧,阑尾炎 只要将问题处理了,程序可以继续运行
    异常和错误的区别
        异常: 感冒 发烧 阑尾炎 可以处理 处理之后代码可以继续执行
        错误: 癌症晚期 艾滋 非典 不能处理

        名称:
            错误: XxxError
            异常: XxxException
*/
```



### 5.2 异常的分类【了解】

```java
/*
    异常的分类
        |-- 编译时期异常:checked异常(受检测异常)。
            在编译时期,就会检查,如果没有处理异常,则编译失败。(如日期格式化异常)
            直接继承Exception

        |-- 运行时期异常:runtime异常。
            在运行时期,检查异常.
            在编译时期,运行异常编译器不会检测(不报错)。(如数学异常)
            不影响编译,可以正常生成.class文件,但是运行时期可能会出现问题
            直接继承RuntimeException
*/
```

```java
public class Demo01Exception {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = "2020-09-24";
        /*
            parse方法内部声明抛出ParseException异常,
            ParseException异常直接继承Exception,
            说明是编译时期异常,在编译阶段必须处理(目前用throws处理),
            不处理编译报错
         */
        Date date = sdf.parse(strDate);
        System.out.println(date);

        System.out.println("-----------");
        int[] array = {10, 20, 30};
        /*
            运行时期会报出索引越界异常:ArrayIndexOutOfBoundsException
            ArrayIndexOutOfBoundsException继承RuntimeException,是
            运行时期异常,不会影响编译,会产生.class文件,只不过在运行时期,
            可能会产生这种问题
         */
        int value = array[5];

        System.out.println(value);
    }
}

```



### 5.3 异常的产生和JVM处理异常的方式【重要】

```java
/*
    JVM默认的异常处理机制
        1.打印异常信息
        2.停止程序的执行(全都得死)
 */
public class Demo02Exception {
    public static void main(String[] args) {
        int[] array = {100, 200, 300};
        int value = getValue(array, 5);
        System.out.println("main方法中正确获取到数组元素值: " + value);
    }

    public static int getValue(int[] array, int index) {
        int value = array[index];
        System.out.println("getValue方法中正确获取到数组元素值: " + value);
        return value;
    }
}
```

![1600931895028](img/1600931895028.png)

## 第六章 异常处理

### 6.1 throw的用法【重要】

```java
/* 
    Demo02Exception中异常对象是由JVM创建并自动抛出的
        如果我们想自己创建异常对象并手动抛出
        需要使用throw关键字
        throw关键字: 扔,抛的意思
        throw关键字使用格式:
            throw 异常对象;
            throw new 异常类(...);
        注意:
            1.throw必须使用在方法内部
            2.throw后面必须写异常对象,而且只能写一个
            3.throw表示把一个具体的异常对象抛出给该方法的调用者
*/
```

```java
public class Demo03ExceptionThrow {
    public static void main(String[] args) {
        int[] array = {100, 200, 300};
        //array = null;
        int value = getValue(array, 5);

        System.out.println("main方法中正确获取到数组元素值: " + value);
    }

    public static int getValue(int[] array, int index) {
        //如果数组是null,抛出空指针异常
        if (array == null) {
            throw new NullPointerException("数组array是null了,不能获取元素了?");
        }
        //如果索引越界,抛出索引越界异常
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("数组索引越界了: "+index);
        }
        int value = array[index];
        System.out.println("getValue方法中正确获取到数组元素值: " + value);
        return value;
    }
}

```



### 6.2 throws声明抛出异常【重要】

```java
/*
    异常处理方式一:
    使用throws关键字: 声明抛出异常
        告诉方法的调用者,你调用我的方法时,我方法内部有可能会产生什么样子的异常,
        方法内部没有处理,谁调用我谁来处理
    使用格式:
        修饰符 返回值类型 方法名称(形式参数列表....) throws 异常类 {
            方法体;
        }
    场景:
        项目经理:   JVM
        项目组长:   main方法
        程序猿:     sports方法
    注意:
        1.throws关键字必须写在方法声明的后面
        2.throws关键字后面跟的是异常类,而且可以写多个
        3.throw必须使用在方法内部
        4.throw后面必须写异常对象,而且只能写一个
        5.throw表示把一个具体的异常对象抛出给该方法的调用者
*/
```

```java
public class Demo04ExceptionThrows {
    public static void main(String[] args) throws Exception {
        System.out.println("组长安排程序员跑圈开始....");
        sports(5);
        System.out.println("组长安排程序员跑圈结束....");
    }
    //模拟程序猿锻炼身体: 跑圈
    public static void sports(int num) throws Exception {
        System.out.println("已经跑了3圈....");
        if (num > 3) {
            throw new Exception("心脏病发作....");
        }
    }
}

```



### 6.3 throws声明抛出多个异常【了解】

```java
/*
    异常处理方式一:
        使用throws关键字: 声明抛出多个异常
        告诉方法的调用者,你调用我的方法时,我方法内部有可能会产生什么样子的异常,
        方法内部没有处理,谁调用我谁来处理
        使用格式:
            修饰符 返回值类型 方法名称(形式参数列表....) throws 异常类1,异常类2 {
                方法体;
            }
        场景:
            项目经理:   JVM
            项目组长:   main方法
            程序猿:     sports方法
 */
public class Demo05ExceptionThrows {
    public static void main(String[] args) throws ParseException,FileNotFoundException  {
        System.out.println("开始读取文件内容...");
        readFile(3);
        System.out.println("结束读取文件内容...");
    }

    //模拟读取文件内容的方法
    public static void readFile(int num) throws ParseException,FileNotFoundException {
        if (num == 1) {
            throw new ParseException("解析文件失败",num);
        }
        if (num == 2) {
            throw new FileNotFoundException("文件不存在");
        }
        System.out.println("文件内容: 好好学习天天向上....");
    }
}
```



### 6.4 try-catch处理异常【重要】

```java
/*
    异常处理方式二: 捕获处理
        try - catch 捕获处理
        使用格式:
            try {
                有可能产生异常的代码;
            } catch(异常类 对象名) {
                处理异常的代码;
            }

        try: {}中的内容,相当于教室,走廊
        catch:()中的内容,烟雾报警器
        catch:{}中的内容,消防栓,消防官兵

        try-catch的执行流程:
            1.try中没有产生异常,程序正常执行,catch中代码不执行
            2.try中的产生异常,try中产生异常的位置后续代码不再执行
                (1)有catch捕获
                    a.如果catch成功捕获,执行{}中处理异常的代码,处理完毕后,程序继续执行
                    b.如果catch没有成功捕获,继续抛出异常,抛给JVM,JVM采用中断处理
                (2)没有catch捕获 继续抛出
        场景:
            项目经理:   JVM
            项目组长:   main方法
            程序猿:     sports方法
 */
public class Demo06ExceptionTryCatch {
    public static void main(String[] args) {
        System.out.println("组长安排程序员跑圈开始....");
        try {
            sports(5);//产生一个异常对象: new Exception("心脏病发作....")
        } catch (Exception e) {
            //Exception e = new Exception("心脏病发作....");
            //一旦赋值成功,说明捕获了异常对象,执行catch中的代码
            //catch中的代码一旦不执行,说明异常被处理了,catch后面的代码可以继续执行了
            System.out.println("哥们辛苦,赶紧来点速效救心丸....");
        }
        System.out.println("组长安排程序员跑圈结束....");
    }

    //模拟程序猿锻炼身体: 跑圈
    public static void sports(int num) throws Exception {
        System.out.println("已经跑了3圈....");
        if (num > 3) {
            throw new Exception("心脏病发作....");
        }
    }
}

```



### 6.5 try-catch处理异常流程【了解】

![1600867579718](img/1600867579718.png)

### 6.6 多catch处理异常【了解】

```java
/*
    多个异常使用捕获又该如何处理呢？
        1. 多个异常分别处理。
        2. 多个异常一次捕获，多次处理。
            异常的父类只能写在最后面,不能写在前面
        3. 多个异常一次捕获一次处理。
 */
public class Demo07ExceptionTryCatch {
    public static void main(String[] args) {
        //1. 多个异常分别处理。一个异常写一个try-catch
        try {
            a();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            b();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("----------");

        //2. 多个异常一次捕获，多次处理。一个try,跟多个catch

        try {
            a();
            b();
        }/* catch (Exception e) {
            //多态: 父类变量可以接收所有的子类对象
            //Exception e = new ParseException("解析文件失败", 2);
            //Exception e = new FileNotFoundException("文件不存在");
            e.printStackTrace();
        } */catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("----------");

        //3. 多个异常一次捕获一次处理。
        try {
            a();
            b();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void a() throws ParseException {
        throw new ParseException("解析文件失败", 2);
    }

    public static void b() throws FileNotFoundException {
        throw new FileNotFoundException("文件不存在");
    }

}

```



### 6.7 try-catch-finally的使用【重要】

```java
/*
    有一些特定的代码无论异常是否发生，无论异常是否被正确处理,都需要执行的代码,写在finally中
    使用场景: 
    	后面使用IO流对象/操作数据库的连接对象后,必须要释放资源,
        而释放资源的代码就必须写在finally当中

    使用格式:
            try {
                有可能产生异常的代码;
            } catch(异常类 对象名) {
                处理异常的代码;
            } finally {
                必须要执行的代码;
            }
 */
public class Demo08TryCatchFinally {
    public static void main(String[] args) {
        try {
            int[] arr = {100, 200, 300};
            arr = null;
            int value = arr[2];
            System.out.println("value=" + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("索引越界异常被处理了....");
        } finally {
            System.out.println("老子一定要执行.....");
        }
    }
}

```



### 6.8 Throwable类中提供的常用方法【了解】

```java
/*
    Throwable中定义的获取异常信息：
        public String getMessage() :
            获取异常的描述信息,原因(提示给用户的时候,就提示错误原因) ---不用
        public String toString() :获取异常的类型和异常描述信息(不用)。---不用
        public void printStackTrace() :
            打印异常的跟踪栈信息并输出到控制台。   ---最常使用,JVM打印异常信息的默认方式
*/
public class Demo09ThrowableMethod {
    public static void main(String[] args) {
        try {
            int[] arr = {100, 200, 300};
            int value = arr[5];
            System.out.println("value=" + value);
            //Throwable --> Exception --> RuntimeException --> IndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            //String message = e.getMessage();
            //System.out.println(message);
            //String s = e.toString();
            //System.out.println(s);
            e.printStackTrace();
        }
    }
}

```



### 6.9 编译时期异常和运行时期异常的区别【重要】

```java
/*
    编译时期异常（受检测异常）
        特点:
            只要写上,就会报红线,必须处理
            要么throws进行处理
            要么try-catch进行处理
            【不能不管它】

    运行时期异常（不受监测）
        特点
            写上,不会报红线，可以不处理
            可以throws进行处理
            可以try-catch进行处理
            【还可以不管】
        对于运行时期异常,不建议使用throws/try-catch处理
*/
```

```java
//演示编译时期异常
public class Demo10ExceptionDiff {
    public static void main(String[] args) throws FileNotFoundException {
        a();
        b();
    }

    //定义方法,内部抛出编译时期异常
    //必须处理: 此处用throws,告诉调用者处理
    public static void a() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    //定义方法,内部抛出编译时期异常
    //必须处理: 此处方法内部try-catch处理,告诉调用者处理
    public static void b() {
        try {
            throw new ParseException("解析异常",2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //定义方法,内部抛出编译时期异常
    //不能不管它,目前既没有throws,又没有try-catch,所以报错
    /*public static void c() {
        throw new DataFormatException();
    }*/
}
//演示运行时期异常
public class Demo11ExceptionDiff {
    public static void main(String[] args)  {
        a();
        b();
    }

    //定义方法,内部抛出运行时期异常
    //写上,不会报红线，可以不处理
    public static void a()  {
        throw new NullPointerException();
    }

    //定义方法,内部抛出运行时期异常
    //可以throws进行处理
    public static void b() throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException();
    }

    //定义方法,内部抛出运行时期异常
    //可以内部try-catch
    public static void c() {
        try {
            throw new StringIndexOutOfBoundsException();
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}

```

### 6.10 异常后方法重写注意事项【了解】

```java
/*
    异常注意事项        
        1.父类方法没有抛出异常，子类覆盖父类该方法时也不可抛出异常。---重点掌握
            此时子类产生该异常，只能捕获处理，不能声明抛出
*/
```

```java
//父类
public class Fu {
    public void method() {
        System.out.println("Fu...method....");
    }
}

//子类
public class Zi extends Fu {
    /*
        父类method方法声明上,没有使用throws声明抛出异常
        子类重写后的方法,内部有异常,不能使用throws
        只能内部try-catch处理  ---使用场景: 在讲多线程(day09/day10)的时候会用到
     */
    @Override
    public void method()/* throws Exception*/ {
        System.out.println("Zi...method...");
        try {
            throw new Exception("子类重写后出问题了!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```





## 第七章  自定义异常【重要】

### 7.1 自定义异常简单演示

```java
/*
    自定义异常
        虽然jdk中提供了大量的异常类,但是和我们实际的业务开发场景无关
        所以我们需要根据需求自定义异常类
    步骤:
        1.自定义类继承Exception(编译时期异常)或者RuntimeException(运行时期异常)
            继承谁都可以,没有统一规定
        2.根据父类生成空参/满参构造
        3.代码中就可以使用throw关键字抛出异常对象
 */
public class Demo12MyException {
    public static void main(String[] args) {
        try {
            show();
        } catch (UserNameRegisterException e) {
            e.printStackTrace();
        }
    }

    public static void show() throws UserNameRegisterException {
        throw new UserNameRegisterException("用户名已经被注册了");
    }
}
```

```java
//自定义编译时期异常: 用户名已经被注册的异常类
public class UserNameRegisterException extends Exception {
    //空参构造
    public UserNameRegisterException() {
    }

    //满参构造
    public UserNameRegisterException(String message) {
        super(message);
    }
}
```



### 7.2 自定义异常练习

```java
/*
    自定义异常练习
        模拟注册操作，如果用户名已存在，则抛出异常并提示：亲，该用户名已经被注册。
    实现步骤:
        1.创建ArrayList集合list,存储数据类型String,模拟已经注册的用户
        2.向ArrayList集合list添加多个字符串,代表已经注册的用户
        3.定义方法判断新的用户名是否可以用
        4.创建键盘录入对象
        5.获取键盘录入的新的用户名,保存到String变量userName中
        6.调用步骤3中定义的方法,判断新的用户名是否可用
*/
```

```java
public class Demo13ExceptionTest {
    public static void main(String[] args) {
        //1.创建ArrayList集合list,存储数据类型String,模拟已经注册的用户
        ArrayList<String> list = new ArrayList<>();

        //2.向ArrayList集合list添加多个字符串,代表已经注册的用户
        list.add("jack");
        list.add("rose");
        list.add("lucy");
        list.add("lili");
        list.add("hanmeimei");
        list.add("lilei");

        //4.创建键盘录入对象
        Scanner sc = new Scanner(System.in);

        //5.获取键盘录入的新的用户名,保存到String变量userName中
        System.out.println("请输入您要注册的用户名: ");
        String userName = sc.nextLine();

        //6.调用步骤3中定义的方法,判断新的用户名是否可用
        /*
            checkUserName方法声明抛出了一个编译时期异常,必须处理
            要么throws,要么try-catch
            此处建议使用try-catch
            原因: 这里可能是一个比较大的网站,不能因为注册用户失败,而影响用户使用其它功能
            所以: 使用try-catch把这个问题处理掉,程序可以继续向下执行(用户可以继续完成除了注册以外的其它功能)
         */
        try {
            checkUserName(list,userName);
        } catch (UserNameRegisterException e) {
            e.printStackTrace();
        }

        System.out.println("看看其它图片....");
        System.out.println("看看其它视频....");
    }

    //3.定义方法判断新的用户名是否可以用
    public static void checkUserName(ArrayList<String> list, String userName) throws UserNameRegisterException {
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(userName)) {
                /*
                    抛出编译时期异常,必须处理
                    要么throws,要么try-catch
                    此处建议使用throws,由调用者来处理此异常
                    因为: 一旦抛出此异常,说明用户名已经被注册,检测用户名是否被注册的这个方法的功能代码
                    没有必要继续执行了
                 */
                throw new UserNameRegisterException("非常抱歉用户名: "+userName+" 已经被注册...");
            }
        }

        //执行到这里
        System.out.println("恭喜您,用户名: "+userName+" 可以使用...");
    }
}

```





