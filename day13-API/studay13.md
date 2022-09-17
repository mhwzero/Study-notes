# <center>API</center>
[toc]
## object类
### Object类介绍
是整个类的体系结构中的最顶层父类,是所有类的最终父类,它里面定义的方法,其它类都有. 类Object是类层次结构的根类。每个类都使用Object作为超类。 所有对象（包括数组）都实现这个类的方法。
### Objct常用方法
 
```
1、public String toString():放回调用方法的对象的字符串表示形式。
   字符串形式： 理解位返回对象的地址值,类的全名称 + @ + 16进制的int数字
```
```java
//内部源代码分析:
public String toString() {
        return getClass().getName() + "@"
        + Integer.toHexString(hashCode());
        }
        //getClass().getName(): 获取类的全名称
        Integer.toHexString(hashCode()): 把对象的哈希值转换成16进制的int数字
```
```
2、public boolean equals(Object obj): 比较调用方法的对象和方法参数对象是否相等。两种情况：true(相等)和false(不等);默认比较对象的地址值,然而只要new对象的地址值就是不相同               
       如果是比较引用类型的地址，用 == 不就可以解决吗？那父类equals方法存在的意义就是为了被子类重写，以便子类自己来定制比较规则。
   toString方法默认是返回当前对象在堆内存中的地址信息:类的全限名@内存地址那toString方法存在的意义为了被子类重写，以便返回对象的内容信息，而不是地址信息！！ 
```
```java
内部源代码分析:
public boolean equals(Object obj) {
        return (this == obj);
        }
        
        this代表: 调用方法的对象
        obj代表: 调用方法时传递的参数对象
        ==: 在比较两个对象的内存地址值是否相同 
```
```

3、重写toString方法
       目的: 返回对象的内容,而不是地址值
  	   快捷键: alt + insert --> toString --> 选择成员变量 --> ok
   重写equals方法：
       目的:比较对象的内容,而不是地址值
  	   快捷键: alt + insert --> equals && hashCode() --> 选择成员变量 --> ok
```
### equals在不同的类中的用法：
```
        Object：所有类的父类：比较的是地址
                格式：对象名.equals(对象名)
        String：String类重写Object类的方法；比较的是内容，但如果传入的一方是null会报空指针异常
                格式：对象名.equals(对象名)
        Objects：Objects类重写Object类的方法；比较的也是内容，但避免了像String一样出现的空指针异常问题，又因为该方法是static静态方法，所以调用的时候采用类名调用
                格式:Objects.equals(对象名1，对象名2)
        自己书写(alt+insert快捷输入)
   注意：String  Objects  Object里面都是使用静态方法的，所以只能采用 类名. 来调用
        自己书写的是不是静态方法可以使用类对象来调用的
```
```java
//自己书写：
//原格式：
```
```java
//this：调用方法的对象
//o：传递参数对象
//this == 0：调用方法的对象和参数是同一个对象(自己和自己比)，直接放回true
@Override
public boolean equals(Object o) {
        if (this == o) return true;
        //0 == null：参数对象o是null，直接返回false
        //getClass() != o.getClass()：调用方法对象和参数对象不属于同一个类型的，直接返回false
        //instanceof：比较是否为同一个类
        if (o == null || getClass() != o.getClass()) return false;
        //把参数对象强制转换成Student类型
        Student student = (Student) o;
        //this.age == student.age: 调用方法的对象的age属性和方法参数对象的age属性相同
        //&&: 逻辑与 并且
        //Objects.equals(name, student.name):
        // 使用Objects类调用equals方法比较 调用方法的对象的name 和 方法参数对象的name 属性是否相同相同
        return age == student.age && Objects.equals(name, student.name);
        }
@Override
public int hashCode() {
        return Objects.hash(name, age);
        }
```
```java
修改格式：
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || o instanceof Student) return false;
    Student student = (Student) o;
    return age == student.age && name.equals(student.name);
}

@Override
public int hashCode() {
    return Objects.hash(name, age);
}
```
## Date类
### Date类的介绍和使用
```
1.java.util.Date类介绍:类 Date 表示特定的瞬间，精确到毫秒。
2.注意:
    (1)时间原点: 1970年1月1日 0时0分0秒   认为是0毫秒
    (2)时间标准: 采用格林威治时间标准
    (3)北京时间与标准时间相差8小时
3.构造方法:
     (1)public Date(): 把当前时间毫秒值(运行程序的此时此刻)封装成Date对象
     (2)public Date(long date): 把构造方法参数指定的毫秒值封装成Date对象
 4.常用常用方法:
     (1)public long getTime(): 返回调用方法的Date对象对应的毫秒值
     (2)public void setTime(long time): 把方法参数指定的毫秒值设置给调用方法的Date对象
```
```java
public class Demo02Date {
    public static void main(String[] args) {

        Date d2 = new Date(0L);//把特定的瞬间0毫秒那个时刻,封装成Date对象
        System.out.println(d2);

        //创建当前时间对应的Date对象
        Date d1 = new Date();
        System.out.println(d1);//Wed Sep 23 10:08:08 CST 2020
        System.out.println(d1.toString());//Wed Sep 23 10:08:08 CST 2020

        //获取当前时间Date对象对应的毫秒值
        long time = d1.getTime();

        System.out.println(time);//1600827409225

        //把当前时间向后推算5天
        time += 5*24*60*60*1000;

        //调用setTime方法,给Date对象设置成5天后的毫秒值
        d1.setTime(time);
        System.out.println(d1);
    }
}
```
### DateFormat类
#### DateFormat类介绍
```
1.作用:
        用来完成Date对象和String对象之间的相互转换的

    2.常用功能
        (1)格式化(就是把Date对象转换成String对象)
            public String format(Date date): 把方法参数Date对象转换成String对象并返回
                参数:
                    Date date: 日期对象
                返回值:
                    String: 返回的是String对象

        (2)解析(就是把String对象转换成Date对象)
            public Date parse(String source): 把方法参数String对象转换成Date对象并返回
                参数:
                    String source: String对象
                返回值:
                    Date: 返回的是日期对象
    3.使用
        java.text.DateFormat是一个抽象类,不能直接new对象
        常用子类:java.text.SimpleDateFormat类
            构造方法:
                public SimpleDateFormat(String pattern)
                参数:
                    String pattern: String类型的日期格式
```
#### 日期格式化为字符串
```
把Date对象格式化成String对象的实现步骤
        1.创建String类型的日期格式对象patter,需要指定具体的格式
        2.创建日期格式化SimpleDateFormat类的对象sdf,构造方法参数传递日期格式对象patter
        3.创建当前毫秒值对应的日期Date对象date
        4.使用日期格式化SimpleDateFormat类的对象sdf调用format方法,传递日期对象date,
            获取指定格式的String对象
        5.打印String对象
```
```java
public class Demo04DateFormat {
    public static void main(String[] args) {
        //1.创建String类型的日期格式对象patter,需要指定具体的格式
        String patter = "yyyy年MM月dd日 HH点mm分ss秒SSS毫秒";

        //2.创建日期格式化SimpleDateFormat类的对象sdf,构造方法参数传递日期格式对象patter
        SimpleDateFormat sdf = new SimpleDateFormat(patter);

        //3.创建当前毫秒值对应的日期Date对象date
        Date date = new Date();

        //4.使用日期格式化SimpleDateFormat类的对象sdf调用format方法,传递日期对象date,
        //获取指定格式的String对象
        String strDate = sdf.format(date);

        //5.打印String对象
        System.out.println(strDate);
    }
}
```
#### 字符串转换成日期
```
把String对象解析成Date对象的实现步骤
        1.创建String类型的日期格式对象patter,需要指定具体的格式
        2.创建日期格式化SimpleDateFormat类的对象sdf,构造方法参数传递日期格式对象patter
        3.创建String对象strDate,保存指定格式的日期时间
        4.使用日期格式化SimpleDateFormat类的对象sdf调用parse方法,传递String的日期对象strDate,
            获取Date对象
        5.打印Date对象
```
```java
public class Demo05DateFormat {
    public static void main(String[] args) throws ParseException {
        //1.创建String类型的日期格式对象patter,需要指定具体的格式
        String patter = "yyyy年MM月dd日 HH点mm分ss秒SSS毫秒";

        //2.创建日期格式化SimpleDateFormat类的对象sdf,构造方法参数传递日期格式对象patter
        SimpleDateFormat sdf = new SimpleDateFormat(patter);

        //3.创建String对象strDate,保存指定格式的日期时间
        String strDate = "2020年09月23日 10点54分22秒442毫秒";
        //String strDate = "2020-09-23 10:54:22:442";//错误: 和上面的日期格式不匹配,报出解析异常

        //4.使用日期格式化SimpleDateFormat类的对象sdf调用parse方法,传递String的日期对象strDate,
        //获取Date对象
        Date date = sdf.parse(strDate);

        //5.打印Date对象
        System.out.println(date);
    }
}
```
### Calendar类
#### Colendar类的介绍
```
 java.util.Calendar类: 日历类,内部提供了大量的与日期时间相关的信息,想要什么就那什么,非常方便
    java.util.Calendar类是一个抽象类,不能直接创建对象
        不常用子类: java.util.GregorianCalendar类 用起来太麻烦


    解决方案:
        在java.util.Calendar类的内部提供静态方法获取其子类对象
            public static Calendar getInstance(): 获取抽象类Calendar类的子类对象
            返回值类型:
                java.util.Calendar类: 是抽象类,说明方法内部必然会返回该抽象类的子类对象  
```
```java
public class Demo03Calendar {
    public static void main(String[] args) {
        //获取Calendar类的子类对象
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
    }
}
```
#### Canlendar类的常用方法
```
Calendar类的常用方法
        public int get(int field) ：返回给定日历字段的值。
            参数:
                int field: 代表的是要获取的是哪个字段
            返回值:
                int: 代表的是获取到的字段对应的值

        public void set(int field, int value) ：将给定的日历字段设置为给定值。
            参数:
                int field: 代表的是要给哪个字段设置值
                int value: 代表的是设置的值是什么

        public abstract void add(int field, int amount) ：
            根据日历的规则，为给定的日历字段添加或减去指定的时间量。
            给指定字段增加指定的值
            参数:
                int field: 代表的是要给哪个字段增加值
                int amount: 代表的是增加的值是多少
                    正数表示增加,负数表示减少

        public Date getTime() ：把调用方法的Calendar对象转换成Date对象并返回
        public void setTime(Date date): 把调用方法传递的参数Date对象设置给调用方法的Calendar对象

        Calendar类当中的常量
        Calendar.YEAR           代表年     1
        Calendar.MONTH          代表月     2
        Calendar.DAY_OF_MONTH   代表日     5
```
#### Conlendar类的练习
```
1.需求:Calendar类的练习_获取任意一年的二月有多少天
          如果可以搞到任意年份的3月份的第1天,把天数减1,得到的就是二月份的最后一天

    2.实现步骤:
        (1)创建键盘录入Scanner类的对象
        (2)获取键盘录入的代表年份的int数字,保存到int变量year中
        (3)获取当前日期时间的Calendar对象cal
        (4)Calendar对象cal调用方法把年份设置成year
        (5)Calendar对象cal调用方法把月份设置成3月
        (6)Calendar对象cal调用方法把天数设置成1
        (7)Calendar对象cal调用方法把天数减1,之后就是2月份的最后一天
        (8)Calendar对象cal调用方法获取天数,保存到int变量days中,表示的就是二月份总共有多少天
        (9)打印int变量days的值
```
```java
public class Demo02CalendarTest {
    public static void main(String[] args) {
        //(1)创建键盘录入Scanner类的对象
        Scanner sc = new Scanner(System.in);

        //(2)获取键盘录入的代表年份的int数字,保存到int变量year中
        System.out.println("请输入一个整数数字(代表年份):");
        int year = sc.nextInt();

        //(3)获取当前日期时间的Calendar对象cal
        Calendar cal = Calendar.getInstance();

        //(4)Calendar对象cal调用方法把年份设置成year
        //cal.set(Calendar.YEAR, year);

        //(5)Calendar对象cal调用方法把月份设置成3月
        //cal.set(Calendar.MONTH, 2);

        //(6)Calendar对象cal调用方法把天数设置成1
        //cal.set(Calendar.DAY_OF_MONTH, 1);

        cal.set(year,2,1);//同时设置年月日,不用指定具体的字段

        //(7)Calendar对象cal调用方法把天数减1,之后就是2月份的最后一天
        cal.add(Calendar.DAY_OF_MONTH, -1);

        //(8)Calendar对象cal调用方法获取天数,保存到int变量days中,表示的就是二月份总共有多少天
        int days = cal.get(Calendar.DAY_OF_MONTH);

        //(9)打印int变量days的值
        System.out.println(year + "年的二月份总共有: " + days + " 天");
    }
}
```
### Arrrays工具类
#### 工具类的Arrays的用法
```
    java.util.Arrays类: 此类是用来操作数组的工具类
    Collections: 操作集合的工具类
    Objects: 操作对象的工具类
    工具类的特点:
        1.所有的成员都是static修饰的,直接用类名调用即可,不需要对象
        2.把构造方法private修饰，该无参构造成为死的。
        
    常用方法:
        public static void sort(int[] a) 对指定的int数组进行升序排列

        public static int binarySearch(int[] a,int key): 
            对数组进行二分查找法，找不到元素返回(-插入点)-1
            
    	public static String toString(int[] a) 将数组转成字符串	
```
```java
public class Demo06Arrays {
    public static void main(String[] args) {
        //定义数组
        int[] array = {10,9,3,6,5,1,2};
        System.out.println("排序前: "+Arrays.toString(array));

        //调用方法按照从小到大的顺序排序
        MyArrays.sort(array);

        System.out.println("排序后: "+Arrays.toString(array));

        System.out.println("二分超找1: "+Arrays.binarySearch(array,1));//0
        System.out.println("二分超找6: "+Arrays.binarySearch(array,6));//4
        System.out.println("二分超找10: "+Arrays.binarySearch(array,10));//6
    }
}
```

