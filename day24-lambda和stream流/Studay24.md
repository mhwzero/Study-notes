#  day13【lambda和Stream】

今日内容介绍

```java
Properties集合
Lambda表达式
函数式接口
Stream流
```

```java
能够理解函数式编程相对于面向对象的优点
能够掌握Lambda表达式的标准格式
能够掌握Lambda表达式的省略格式与规则
能够使用Consumer<T>函数式接口
能够使用Predicate<T>函数式接口
能够理解流与集合相比的优点
```



## 第一章 Properties集合【重点】

### 1.1 Properties集合回顾

```java
/*
    java.util.Properties集合是Hashtable的子类,双列集合
        主要使用的是与String相关的方法

    常用方法:
        public  Object setProperty(String k,String v): 保存一个键值对(属性名=属性值)
        public  String getProperty(String key): 根据属性名获取属性值
        public Set<String> stringPropertyNames(): 获取所有属性值对应的Set集合


    java.lang.System类: 与系统相关的工具类
    静态方法:
        public static Properties getProperties(): 获取系统相关的属性名及属性值

 */
public class Demo01Properties {
    public static void main(String[] args) {
        //System类调用静态方法,获取Properties对象
        Properties props = System.getProperties();
        //增强for遍历
        for (String propertyName : props.stringPropertyNames()) {
            String propertyValue = props.getProperty(propertyName);
            System.out.println(propertyName+"::"+propertyValue);
        }
    }
    //Properties集合的基本使用
    private static void method01() {
        Properties props = new Properties();
        //添加键值对
        props.setProperty("name","zhangsan");
        props.setProperty("age","28");
        props.setProperty("gender","nan");

        //遍历
        Set<String> propertyNames = props.stringPropertyNames();
        for (String propertyName : propertyNames) {
            String propertyValue = props.getProperty(propertyName);
            System.out.println(propertyName+"::"+propertyValue);
        }
    }
}

```



### 1.2 Properties集合的load方法【重要】

```java
/*
    Properties集合    
    与IO流相关的成员方法(必须由Properties对象调用)
        load方法内部,指挥InputStream/Reader的子类对象,读取文件,load方法内部把获取到的文件内容,
        进行处理,处理成键值对的形式,存储到Properties集合对象中,至于如何处理的,我们不关心

        public void load(InputStream inStream)： 从字节输入流中读取键值对。
            参数:
                 InputStream inStream: 抽象父类,传递子类FileInputStream对象

        public void load(Reader reader)： 从字符输入流中读取键值对。
            参数:
                 Reader reader: 抽象父类,传递子类FileReader对象

     使用步骤:
        1.load方法加载的文件,要求扩展名(配置信息).properties,一般存储到src根目录下,
            数据存储格式: 属性名=属性值,注释: 用#
        2.创建Properties集合对象
        3.创建InputStream/Reader的子类对象,绑定源文件
        4.Properties集合对象调用load方法传递InputStream/Reader的子类对象,
        	把文件内容以键值对的方式加载到Properties集合对象中
        5.遍历集合
 */
public class Demo02Properties {
    public static void main(String[] args) throws IOException {
        //2.创建Properties集合对象
        Properties props = new Properties();

        //3.创建InputStream/Reader的子类对象,绑定源文件
        InputStream is = new FileInputStream("day13_sw\\src\\config.properties");

        //4.Properties集合对象调用load方法传递InputStream/Reader的子类对象,
        //把文件内容以键值对的方式加载到Properties集合对象中
        props.load(is);

        //5.遍历集合
        Set<String> propertyNames = props.stringPropertyNames();

        for (String propertyName : propertyNames) {
            String propertyValue = props.getProperty(propertyName);
            System.out.println(propertyName+"::::"+propertyValue);
        }
    }
}
```



### 1.3 Properties集合的store方法【了解】

```java
/*
    Properties集合与IO流相关的成员方法(必须由Properties对象调用)
        store方法内部,指挥OutputStream/Writer的子类对象,把Properties集合内容键值对内容,
        以键值对的方式写入到目标文件中,至于如何处理的,我们不关心

        - public void store(OutputStream outStream,String comments)：
        	把Properties集合对象的键值对保存到文件中
            参数:
                 OutputStream outStream: 抽象父类,传递子类FileOutputStream对象
                 String comments: 给properties文件的说明信息 可以直接写为null

        - public void store(Writer writer,String comments)：
        	把Properties集合对象的键值对保存到文件中
            参数:
                 Writer writer: 抽象父类,传递子类FileWriter对象
                 String comments: 给properties文件的说明信息 可以直接写为null
 */
public class Demo03Properties {
    public static void main(String[] args) throws IOException {
        //2.创建Properties集合对象
        Properties props = new Properties();

        //3.创建InputStream/Reader的子类对象,绑定源文件
        InputStream is = new FileInputStream("day13_sw\\src\\config.properties");

        //4.Properties集合对象调用load方法传递InputStream/Reader的子类对象,
        //把文件内容以键值对的方式加载到Properties集合对象中
        props.load(is);

        //5.遍历集合
        Set<String> propertyNames = props.stringPropertyNames();

        for (String propertyName : propertyNames) {
            String propertyValue = props.getProperty(propertyName);
            if("age".equals(propertyName)) {//age属性的值增加10岁
                props.setProperty(propertyName,Integer.parseInt(propertyValue)+10+"");
            }
        }
        OutputStream os = new FileOutputStream("day13_sw\\src\\config.properties");
        //把Properties集合对象中的内容存储到文件中
        props.store(os,null);
    }
}
```



## 第二章 Lambda表达式

### 2.1 函数式编程思想和Lambda表达式体验

### 学习目标: 能够理解函数式编程相对于面向对象的优点

```java
/*
    函数式思想则尽量忽略面向对象的复杂语法——强调做什么，而不是以什么形式做。

    lambda表达式书写规则:
        使用匿名内部类的方式中,只保留覆盖重写后方法的()和{},在()和{}之间,添加->,其它全部省略

        可以推导,就是可以省略
        行为参数化
        lambda表达式是对 匿名内部类的简化书写格式
 */
public class Demo01Lambda {
    public static void main(String[] args) {
        //1.匿名内部类对象的方式,创建并开启线程
        //通过匿名内部类对象的方式,给Thread对象,传递一段代码执行
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程任务A执行了...");
            }
        }).start();

        //2.lambda表达式的方式
        //通过lambda表达式的方式,给Thread对象,传递一段代码执行
        new Thread(()-> {
                System.out.println("线程任务B执行了...");
            }
        ).start();
    }
}
```



### 2.2 Lambda表达式的标准格式

### 学习目标: 能够掌握Lambda表达式的标准格式

```java
/*
    Lambda表达式的标准格式
        1.lambda表达式的组成
            (1)一个箭头:    ->
            (2)一些参数:    ()内部可以写参数
            (3)一段代码:    {}中的内容

        2.标准格式:
            (参数类型 参数名称) -> { 代码语句 }

        3.格式解释:
            (1)小括号(): 就是以前定义方法的小括号,内部写的是方法参数列表
                        没有参数,也不能省略
            (2)箭头->: 代表方法的参数传递
            (3)大括号{}:  就是以前定义方法的{},代表方法体,方法的功能代码

 */
public class Demo02Lambda {
    public static void main(String[] args) {
        //1.匿名内部类方式创建并开启线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程任务A执行了...");
            }
        }).start();
        
        //2.lambda表达式方式
        new Thread(() -> {
                System.out.println("线程任务B执行了...");
            }
        ).start();
    }
}
```



### 2.3 Lambda表达式有参数有返回值

```java
/*
    Lambda表达式有参数有返回值

    Arrays工具类,实现自定义排序
	静态方法
        public static <T> void sort(T[] arr，Comparator<T> comp):
        	将数组arr中元素按照指定规则comp排序。
        参数:
            1.T[] arr: 对象数组
            2.Comparator<T> comp: 接口,传递实现类对象/匿名内部类对象
                抽象方法:
                    public int compare(T o1,T o2):用来指定排序的规则的 
                    	第一个参数 - 第二个参数: 升序
                    	第二个参数 - 第一个参数: 降序
                    		参数T是引用类型,不能直接减
                举例:
                    按照Person对象age属性,从小到大排序
                        public int compare(Person o1,Person o2) {
                            return o1.getAge() - o2.getAge();
                        }
                    按照Student对象age属性,从大到小排序
                        public int compare(Person o1,Person o2) {
                            return o2.getAge() - o1.getAge();
                        }

	    定义Person数组,对数组元素按照年龄升序排列
 */
public class Demo03Lambda {
    public static void main(String[] args) {

        //创建Person数组
        Person[] ps = 
        	{new Person("张三",18),new Person("李四",38),new Person("王五",28)};

        System.out.println("排序前: "+ Arrays.toString(ps));

        //1.匿名内部类的方式
        //age从小到大
        Arrays.sort(ps, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();//age从小到大
            }
        });

        System.out.println("年龄从小到大排序后: "+ Arrays.toString(ps));

        //2.使用lambda表达式的方式
        //age从大到小
        Arrays.sort(ps,(Person p1,Person p2)->{
            return p2.getAge() - p1.getAge();
        });

        System.out.println("年龄从大到小排序后: "+ Arrays.toString(ps));
    }
}
```

```java
public class Person {
    private String name;
    private int age;
    //toString方法,set/get方法自己生成
}

```



### 2.4 Lambda表达式的省略格式

### 学习目标: 能够掌握Lambda表达式的省略格式与规则

```java
/*
    Lambda表达式的省略格式
        1.数据类型可以省略: 
        	(Person p) 简化为 (p)
            (Person p1,Person p2) 简化为 (p1,p2)

        2.如果只有一个参数: ()可以省略 
        	(Person p) 简化为 (p) 再简化为 p
            注意: 没有参数,()不能省略

        3.如果{}中只有一句话,那么{}和分号和return,全部可以省略
            注意: 要么全部省略,要么全部保留

        4.->: 永远不能省略


    Collections工具类,实现自定义排序
	public static <T> void sort(List<T> list，Comparator<T> comp):
		将集合list中元素按照指定规则comp排序。
	参数:
		1.List<T> list: 接口,传递实现类对象  ArrayList,LinkedList
		2.Comparator<T> comp: 接口,传递实现类对象/匿名内部类对象
			抽象方法:
				public int compare(T o1,T o2):用来指定排序的规则的
				第一个参数 - 第二个参数: 升序
				第二个参数 - 第一个参数: 降序
				参数T是引用类型,不能直接减

			举例:
				按照Person对象age属性,从小到大排序
                    public int compare(Person o1,Person o2) {
                        return o1.getAge() - o2.getAge();
                    }

				按照Student对象age属性,从大到小排序
                    public int compare(Person o1,Person o2) {
                        return o2.getAge() - o1.getAge();
                    }
    List集合存储多个Person对象,完成对List集合的排序,按照年龄排序
 */
public class Demo04Lambda {
    public static void main(String[] args) {
        //创建List集合对象,并添加数据
        List<Person> list = new ArrayList<>();
        Collections.addAll(list,
                           new Person("张三",18),
                           new Person("李四",38),
                           new Person("王五",28));
        
        System.out.println("按照年龄排序前: "+list);

        //1.匿名内部类的方式
        //age从小到大
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("年龄升序排序后: "+list);

        //2.使用lambda表达式的标准格式
        //age从大到小
        Collections.sort(list,(Person p1,Person p2)->{
            return p2.getAge() - p1.getAge();
        });
        System.out.println("年龄降序排序后: "+list);


        //3.使用lambda表达式的简化格式
        //age从小到大
        Collections.sort(list,(p1,p2)->p1.getAge() - p2.getAge());

        System.out.println("年龄升序排序后: "+list);
    }
}

```

### 2.5 Lambda表达式的前提

```java
/*
    Lambda表达式的前提
        1.必须要有接口(函数式接口):
            该接口中必须被覆盖重写的抽象方法,只能有一个,可以有默认方法,可以有静态方法
        2.必须有方法使用函数式接口作为方法参数
    @Override: 检测子类方法是否是对父类方法的覆盖重写
    @FunctionalInterface: 检测是否是函数是接口的
 */
```

### 2.6 自定义函数式接口

```java
//函数式接口
@FunctionalInterface
public interface MyFunctionalInter {
    //抽象方法
    public abstract void method();
    //public abstract void show(String str);

    //默认方法
    public default void show() {
        System.out.println("默认方法show执行了...");
    }
    //静态方法
    public static void print() {
        System.out.println("静态方法print执行了...");
    }
}
//测试类
public class Demo03LambdaBase {
    public static void main(String[] args) {
        //1.匿名内部类的方式
        fun(new MyFunctionalInter() {
            @Override
            public void method() {
                System.out.println("匿名内部类的方式....");
            }
        });
        System.out.println("---------------");

        //2.使用lambda表达式的标准格式
        fun(()->{
            System.out.println("使用lambda表达式的标准格式...");
        });
        System.out.println("---------------");

        //3.使用lambda表达式的简化格式
        fun(()-> System.out.println("使用lambda表达式的简化格式"));
    }
    /*
        定义方法,使用函数式接口作为方法参数
        调用方法时:
            可以传递实现类对象/匿名内部类对象
            可以传递lambda表达式

            MyFunctionalInter mfi = new MyFunctionalInter() {..}
            左边: 接口
            右边: 实现类对象
            多态
     */
    public static void fun(MyFunctionalInter mfi) {
        //调用抽象方法
        mfi.method();
        //调用默认方法
        mfi.show();
        //调用静态方法
        MyFunctionalInter.print();
    }
}

```



## 第三章 函数式接口
    为steam流的使用
### 3.1 Supplier接口的get方法

```java
/*
    java中常用的函数式接口,都被定义在java.util.function包中

        java.util.function.Supplier<T>接口: 供给型接口 
        功能: 提供一个T类型的数据
        抽象方法:
            public abstract T get(): 获取一个泛型指定类型的数据
 */
public class Demo04Supplier {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        //1.匿名内部类的方式
        fun(new Supplier<String>() {
            @Override
            public String get() {
                return s1 + s2;
            }
        });

        //2.使用lambda表达式的标准格式
        fun(()->{
            return s1.toUpperCase() + s2.toUpperCase();
        });

        //3.使用lambda表达式的简化格式
        fun(()->s1.substring(0,1)+s2.substring(0,1));
    }
    /*
        定义方法,使用函数式接口Supplier作为参数
     */
    
    public static void fun(Supplier<String> supplier) {
        //调用抽象方法get,获取字符串str
        //至于str的内容是什么以及如何获取,这里说不清楚
        String str = supplier.get();
        System.out.println(str);
    }
}

```

### 3.2 Supplier接口的get方法练习求数组最大值

```java
/*
    Supplier接口的get方法练习求int数组最大值
 */
public class Demo05SupplierTest {
    public static void main(String[] args) {
        int[] arr = {10,50,30,20,40};
        //1.匿名内部类的方式
        fun(new Supplier<Integer>() {
            @Override
            public Integer get() {
                //int数组最大值
                int max = arr[0];
                for(int i = 1;i<arr.length;i++) {
                    if(arr[i]>max) {
                        max = arr[i];
                    }
                }
                return max;
            }
        });
        //2.使用lambda表达式的标准格式
        fun(()->{
            //int数组的和
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        });
        //3.使用lambda表达式的简化格式    和标准格式一样
    }
    /*
        定义方法,使用函数式接口Supplier作为参数
     */
    public static void fun(Supplier<Integer> supplier){
        //调用抽象方法get,获取int数字value
        //至于value的内容是什么以及如何获取,这里说不清楚
        int value = supplier.get();
        System.out.println(value);
    }
}
```



### 3.3 Consumer接口的accept方法

### 学习目标: 能够使用Consumer<T>函数式接口

```java
/*
    --------------------------------重点掌握-----------------------
    java中常用的函数式接口,都被定义在java.util.function包中
        java.util.function.Consumer<T>接口: 消费型接口 功能: 消费(处理)一个T类型的数据
        抽象方法:
            public abstract void accept(T t): 消费一个泛型指定类型的数据t
            accept单词: 接收的意思
            什么叫做消费呢?只要给accept方法添加方法体{},就叫做消费,不管{}中写的是什么
    练习:
        给你一个字符串,请按照大写的方式进行消费

 */
public class Demo06Consumer {
    public static void main(String[] args) {
        String s = "hello World";

        //1.匿名内部类的方式
        fun(s, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());//按照大写处理
            }
        });

        //2.使用lambda表达式的标准格式
        fun(s,(String str)->{
            System.out.println(str.toLowerCase());//按照小写处理
        });

        //3.使用lambda表达式的简化格式
        fun(s,str-> System.out.println(s+"的长度: "+str.length()));//打印长度
    }
    /*
        定义方法,使用函数式接口Consumer作为参数
     */
    public static void fun(String ss,Consumer<String> consumer) {
        //调用抽象方法accept,处理字符串ss
        //如何处理字符串ss,说不清
        consumer.accept(ss);
    }
}
```



### 3.4 Function接口的apply方法

```java
/*
    --------------------------------重点掌握-----------------------
    java中常用的函数式接口,都被定义在java.util.function包中

        java.util.function.Function<T, R>接口: 转换型接口 功能: 把T类型的数据转换成R类型
        抽象方法:
            public abstract R apply(T t): 根据方法参数T类型的t,获取R类型的数据

            转换前: T类型
            转换后: R类型

        练习:
            给你一个String的数字,你给我转成一个int数字
            转换前: String类型   <---T
            转换后: Integer类型  <---R
 */
public class Demo07Function {
    public static void main(String[] args) {
        String str = "1235";
        //1.匿名内部类的方式
        fun(str, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(str);
            }
        });

        //2.使用lambda表达式的标准格式
        fun(str,(String strNum)->{
            //return strNum.length();//返回的int数字代表的是字符串的长度
            return Integer.parseInt(strNum);//把String数字,解析成int
        });

        //3.使用lambda表达式的简化格式
        fun(str,strNum->Integer.parseInt(strNum));

        //1.匿名内部类的方式
        fun(str, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(str);//把String数字,解析成int
            }
        });

    }
    /*
        定义方法,使用函数式接口Function作为参数
     */
    public static void fun(String strNum,Function<String,Integer> f){
        //根据方法参数String类型的strNum
        //获取int数字num,至于如何根据String类型的strNum获取int数字num说不清
        int num = f.apply(strNum);
        System.out.println(num+100);
    }

}

```

### 3.5 Predicate的test方法

### 学习目标: 能够使用Predicate<T>函数式接口

```java
/*
    --------------------------------重点掌握-----------------------
    java中常用的函数式接口,都被定义在java.util.function包中

        java.util.function.Predicate<T>接口: 判断型接口 功能: 根据T类型的数据获取boolean类型的结果
        抽象方法:
            public abstract boolean test(T t): 根据方法参数T类型的数据t,返回一个boolean类型的结果

    练习:
        //1.练习:判断字符串长度是否大于5
        //2.练习:判断字符串是否包含"H"
 */
public class Demo08Predicate {
    public static void main(String[] args) {
        String s = "itheima";

        //1.匿名内部类的方式
        fun(s, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //return s.length()>5;
                return s.contains("H");//判断是否包含H
            }
        });

        //2.使用lambda表达式的标准格式
        fun(s,(String str)->{return str.length()>5;});

        //3.使用lambda表达式的简化格式
        fun(s,str->str.length()>5);
    }
    /*
        定义方法,使用函数式接口Predicate作为参数
     */
    public static void fun(String ss,Predicate<String> p) {
        //调用抽象方法test,根据字符串ss,获取boolean结果
        //至于根据字符串ss,如何获取boolean结果,说不清
        boolean result = p.test(ss);
        System.out.println(result);
    }
}
```



## 第四章 Stream流

### 4.1 Stream流的体验

```java
/*
    需求:从List集合中按照以下条件筛选出符合条件的数据
        1. 首先筛选所有姓张的人；
        2. 然后筛选名字有三个字的人；
        3. 最后进行对结果进行打印输出。
    通过传统的操作集合的方式
 */
public class Demo01Stream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        //1. 首先筛选所有姓张的人；
        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if(name.startsWith("张")) {
                zhangList.add(name);
            }
        }
        //2. 然后筛选名字有三个字的人；
        List<String> zhangSaZiList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                zhangSaZiList.add(name);
            }
        }

        //3. 最后进行对结果进行打印输出。
        for (String name : zhangSaZiList) {
            System.out.println(name);
        }
    }
}
```

```java
/*
    需求:
        1. 首先筛选所有姓张的人；
        2. 然后筛选名字有三个字的人；
        3. 最后进行对结果进行打印输出。
    通过Stream流 + 匿名内部类的方式
 */
public class Demo02Stream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //获取List集合对象对应的Stream流对象
        Stream<String> s = list.stream();
        //1. 首先筛选所有姓张的人；
        Stream<String> s2 = s.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张");
            }
        });

        //2. 然后筛选名字有三个字的人；
        Stream<String> s3 = s2.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        });
        //3. 最后进行对结果进行打印输出。
        s3.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
```

```java
/*
    需求:
        1. 首先筛选所有姓张的人；
        2. 然后筛选名字有三个字的人；
        3. 最后进行对结果进行打印输出。

    通过Stream流 + lambda表达式标准格式
    简化格式: 自己写
 */
public class Demo03Stream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        //获取List集合对象对应的Stream流对象
        Stream<String> s = list.stream();
        //1. 首先筛选所有姓张的人；
        Stream<String> s2 = s.filter((String name) -> {
            return name.startsWith("张");
        });
        //2. 然后筛选名字有三个字的人；
        Stream<String> s3 = s2.filter((String name) -> {
            return name.length() == 3;
        });
        //3. 最后进行对结果进行打印输出。
        s3.forEach((String name)->{
            System.out.println(name);
        });
    }
}
```

```java
/*
    需求:
        1. 首先筛选所有姓张的人；
        2. 然后筛选名字有三个字的人；
        3. 最后进行对结果进行打印输出。
    通过Stream流 + lambda表达式标准格式
    简化格式: 自己写
 */
public class Demo04Stream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        //获取List集合对象对应的Stream流对象
        //2. 然后筛选名字有三个字的人；
        //3. 最后进行对结果进行打印输出。
        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(System.out::println);
    }
}
```



### 4.2 流式思想的介绍

![1602322734160](img/1602322734160.png)



### 4.3 获取Stream流的方式

### 学习目标: 能够理解流与集合相比的优点

```java
/*
    获取Stream流的方式    
        java.util.stream.Stream<T>流: 是Java 8新加入的最常用的流接口。
            问题: 要想使用Stream流,必须先获取到Stream<T>接口的实现类对象
        方式一: 获取Collection集合对象的Stream流对象
            java.util.Collection<T>接口: 单列集合的根接口
            默认方法:
                public default Stream<E> stream(): 获取Collection集合对象的Stream流对象
                返回值类型:
                    java.util.stream.Stream<T>: 接口,该方法内部必然返回接口的实现类对象
            也就是说: 如果能够调用Collection接口中的默认方法stream,也就可以获取到Stream流对象
                Collection接口中的默认方法stream必须由Collection接口的实现类对象调用
                Collection接口的实现类: ArrayList/LinkedList/HashSet/LinkedHashSet
        方式二: 获取数组对应的Stream流对象
            java.util.stream.Stream<T>接口
            静态方法: 由接口名称直接调用
                public static<T> Stream<T> of(T... values): 获取方法可变参数对应的Stream流对象
                返回值类型:
                    java.util.stream.Stream<T>: 接口,该方法内部必然返回接口的实现类对象
                参数列表:
                    T... values: 可变参数,可以传递参数列表,可以传递数组,还可以不传参
   //1.获取List集合对象对应的Stream流对象
   //2.获取Set集合对象对应的Stream流对象   
 */
public class Demo02GetStream {
    public static void main(String[] args) {
        //1.获取List集合对象对应的Stream流对象
        List<String> list = new ArrayList<>();
        Stream<String> s1 = list.stream();
        System.out.println(s1);

        //2.获取Set集合对象对应的Stream流对象
        Set<Integer> set = new HashSet<>();
        Stream<Integer> s2 = set.stream();
        System.out.println(s2);

        //Map集合
        Map<String,String> map = new HashMap<>();

        //3.获取Map集合键对应的Set集合对象对应的Stream流对象
        Set<String> set2 = map.keySet();
        Stream<String> s3 = set2.stream();
        System.out.println(s3);

        //4.获取Map集合值对应的Collection集合对象对应的Stream流对象
        Collection<String> coll = map.values();
        Stream<String> s4 = coll.stream();
        System.out.println(s4);

        //5.获取Map集合键值对对应的Set集合对象对应的Stream流对象
        Set<Map.Entry<String, String>> set3 = map.entrySet();
        Stream<Map.Entry<String, String>> s5 = set3.stream();
        System.out.println(s5);
        System.out.println("---------------------");

        String[] arr = {"张无忌", "张翠山", "张三丰", "张一元"};
        //获取数组对应的Stream流对象
        Stream<String> s6 = Stream.of(arr);
        System.out.println(s6);

        Stream<String> s7 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃", "爷爷", "蛇精", "蝎子精");
        System.out.println(s7);
    }
}
```

### 4.4 Stream的forEach方法

```java
/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public abstract void forEach(Consumer<T> con):
            按照方法参数con指定的规则对Stream流对象中的元素逐一处理
            参数:
                Consumer<T> con: 消费型接口,传递匿名内部类对象,lambda表达式
        java.util.function.Consumer<T>接口: 消费型接口 功能: 消费(处理)一个T类型的数据
        抽象方法:
            public abstract void accept(T t): 消费一个泛型指定类型的数据t
            accept单词: 接收的意思
            什么叫做消费呢?只要给accept方法添加方法体{},就叫做消费,不管{}中写的是什么
 */
public class Demo03ForEach {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃", "爷爷", "蛇精", "蝎子精");
        //1.匿名内部类的方式
       /* s.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/
        //2.使用lambda表达式的标准格式
        /*s.forEach((String name)->{
            System.out.println(name);
        });*/
        //2.使用lambda表达式的简化格式
        s.forEach(name-> System.out.println(name));
    }
}
```

**Collection集合的forEach方法**

```java
//Stream流遍历Collection集合
public class Demo07CollectionForeach {
    public static void main(String[] args) {
        //创建Collection集合
        Collection<String> coll = new ArrayList<>();
        //添加元素
        Collections.addAll(coll, "Hello", "Java", "C++", "Python");

        //单列和双列集合内部都有foreach方法,直接调用即可
        //单列集合调用forEach方法,传递匿名内部类对象
        coll.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //单列集合调用forEach方法,传递lambda表达式标准格式
        coll.forEach((String s)->{
            System.out.println(s);
        });
        //单列集合调用forEach方法,传递lambda表达式标准格式
        coll.forEach(s-> System.out.println(s));

    }
}
```

**Map集合的forEach方法**

```java
//Map集合的forEach方法
public class Demo08MapForeach {
    public static void main(String[] args) {
        //创建Map集合对象,并添加键值对
        Map<String, String> map = new HashMap<>();
        map.put("邓超", "孙俪");
        map.put("李晨", "范冰冰");
        map.put("刘德华", "柳岩");

        //Map集合有forEach方法
        //双列集合调用forEach方法,传递匿名内部类对象
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + "::::" + value);
            }
        });
        //双列集合调用forEach方法,传递lambda表达式标准格式
        map.forEach((String key, String value) -> {
            System.out.println(key + "==" + value);
        });
        //双列集合调用forEach方法,传递lambda表达式简化格式
        map.forEach((key, value) -> System.out.println(key + "==" + value));
    }
}
```



### 4.5 Stream的filter方法

```java
/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public abstract Stream<T> filter(Predicate<T> p):
            按照方法参数p指定的条件对Stream流对象中的元素进行过滤,返回一个新的Stream流对象
            参数:
                Predicate<T> p: 判断型型接口,传递匿名内部类对象,lambda表达式

        java.util.function.Predicate<T>接口: 
        	判断型接口 功能: 根据T类型的数据获取boolean类型的结果
        抽象方法:
            public abstract boolean test(T t): 根据方法参数T类型的数据t,返回一个boolean类型的结果

    练习:
        步骤一: 过滤出所有带娃的
        步骤二: 遍历输出结果
 */
public class Demo04Filter {
    public static void main(String[] args) {
        //创建Stream流对象
        Stream<String> s = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃", "爷爷", "蛇精", "蝎子精");

        //1.匿名内部类的方式
        /*Stream<String> s2 = s.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("娃");
            }
        });*/

        //2.使用lambda表达式的标准格式
        /*Stream<String> s2 = s.filter((String name) -> {
            return name.contains("娃");
        });*/


        //3.使用lambda表达式的简化格式
        Stream<String> s2 = s.filter(name -> name.contains("娃"));

        //遍历输出
        s2.forEach((String name)->{
            System.out.println(name);
        });

    }
}
```



### 4.6 Stream的count方法

```java
/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public abstract long count(): 获取Stream流对象中的元素的个数

        注意:
            此方法没有参数,调用时不需要传递参数,根不能再写lambda表达式了

 */
public class Demo05Count {
    public static void main(String[] args) {
        //创建Stream流对象
        Stream<String> s = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃", "爷爷", "蛇精", "蝎子精");

        //获取Stream流对象中的元素的个数
        long num = s.count();
        System.out.println("Stream流对象中的元素的个数: "+num);

    }
}

```

### 4.7 Stream的limit和skip方法

```java
/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public abstract Stream<T> limit(long n):
            获取Stream流对象中的前n个元素,返回一个新的Stream流对象

        public abstract Stream<T> skip(long n):
            跳过Stream流对象中的前n个元素,返回一个新的Stream流对象

            共同的参数:
                long n: 表示数字


    练习:
        步骤一: 只要前7个
        步骤二: 跳过前4个
        步骤三: 遍历输出
 */
public class Demo06LimitSkip {
    public static void main(String[] args) {
        //创建Stream流对象
        Stream<String> s = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃", "爷爷", "蛇精", "蝎子精");

        //步骤一: 只要前7个
        Stream<String> s2 = s.limit(7);

        //步骤二: 跳过前4个
        Stream<String> s3 = s2.skip(4);


        //遍历输出
        s3.forEach((String name)->{
            System.out.println(name);
        });

    }
}

```



### 4.8 Stream的concat方法

```java
/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    静态方法: 由接口名称调用
        public static <T> Stream<T> concat(Stream<T> a, Stream<T> b):
            把方法参数指定的两个Stream流对象合并成一个Stream流对象返回
 */
public class Demo07Concat {
    public static void main(String[] args) {
        String str = "hello";
        str = str.concat("world");
        System.out.println(str);//helloworld

        //创建Stream流对象
        Stream<String> s1 = Stream.of("大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃");
        Stream<String> s2 = Stream.of("爷爷", "蛇精", "蝎子精");

        //把s1和s2合并
        Stream<String> s12 = Stream.concat(s1, s2);

        //遍历输出
        s12.forEach(name-> System.out.println(name));


    }
}

```

### 4.9 传统模式完成案例

```java
/*
    Stream流综合练习
    要求:
        1. 第一个队伍只要名字为3个字的成员姓名；
        2. 第一个队伍筛选之后只要前3个人；
        3. 第二个队伍只要姓张的成员姓名；
        4. 第二个队伍筛选之后不要前2个人；
        5. 将两个队伍合并为一个队伍；
        6. 打印整个队伍的姓名信息。

    按照传统操作集合的方式
 */
public class Demo02StreamTest {
    public static void main(String[] args) {
        List<String> o = new ArrayList<>();
        o.add("迪丽热巴");
        o.add("宋远桥");
        o.add("苏星河");
        o.add("老子");
        o.add("庄子");
        o.add("孙子");
        o.add("洪七公");

        //1. 第一个队伍只要名字为3个字的成员姓名；
        List<String> oSaZi = new ArrayList<>();
        for (String name : o) {
            if (name.length() == 3) {
                oSaZi.add(name);
            }
        }

        //2. 第一个队伍筛选之后只要前3个人；
        List<String> oSaZiLimit3 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            oSaZiLimit3.add(oSaZi.get(i));
        }

        List<String> t = new ArrayList<>();
        t.add("古力娜扎");
        t.add("张无忌");
        t.add("张三丰");
        t.add("赵丽颖");
        t.add("张二狗");
        t.add("张天爱");
        t.add("张三");

        //3. 第二个队伍只要姓张的成员姓名；
        List<String> tZhang = new ArrayList<>();
        for (String name : t) {
            if (name.startsWith("张")) {
                tZhang.add(name);
            }
        }

        //4. 第二个队伍筛选之后不要前2个人；

        List<String> tZhangSkip2 = new ArrayList<>();
        for (int i = 2; i < tZhang.size(); i++) {
            tZhangSkip2.add(tZhang.get(i));
        }

        //5. 将两个队伍合并为一个队伍；
        List<String> ot = new ArrayList<>();
        ot.addAll(oSaZiLimit3);//把方法参数集合对象中的元素添加到ot中
        ot.addAll(tZhangSkip2);//把方法参数集合对象中的元素添加到ot中

        //6. 打印整个队伍的姓名信息。
        for (String name : ot) {
            System.out.println(name);
        }
    }
}
```

### 4.10 Stream流的方式完成案例

```java
/*
    Stream流综合练习
    要求:
        1. 第一个队伍只要名字为3个字的成员姓名；
        2. 第一个队伍筛选之后只要前3个人；
        3. 第二个队伍只要姓张的成员姓名；
        4. 第二个队伍筛选之后不要前2个人；
        5. 将两个队伍合并为一个队伍；
        6. 打印整个队伍的姓名信息。

    按照Stream流 + 匿名内部类对象
 */
public class Demo03StreamTest {
    public static void main(String[] args) {
        List<String> o = new ArrayList<>();
        o.add("迪丽热巴");
        o.add("宋远桥");
        o.add("苏星河");
        o.add("老子");
        o.add("庄子");
        o.add("孙子");
        o.add("洪七公");

        //获取第一个队伍的Stream流对象
        Stream<String> os1 = o.stream();

        //1. 第一个队伍只要名字为3个字的成员姓名；
        Stream<String> os2 = os1.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 3;
            }
        });


        //2. 第一个队伍筛选之后只要前3个人；
        Stream<String> os3 = os2.limit(3);


        List<String> t = new ArrayList<>();
        t.add("古力娜扎");
        t.add("张无忌");
        t.add("张三丰");
        t.add("赵丽颖");
        t.add("张二狗");
        t.add("张天爱");
        t.add("张三");

        //获取第二个队伍的Stream流对象
        Stream<String> ts1 = t.stream();

        //3. 第二个队伍只要姓张的成员姓名；
        Stream<String> ts2 = ts1.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.charAt(0) == '张';
            }
        });


        //4. 第二个队伍筛选之后不要前2个人；
        Stream<String> ts3 = ts2.skip(2);


        //5. 将两个队伍合并为一个队伍；
        Stream<String> ots3 = Stream.concat(os3, ts3);


        //6. 打印整个队伍的姓名信息。
        ots3.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

    }
}
```

```java
/*
    Stream流综合练习
    要求:
        1. 第一个队伍只要名字为3个字的成员姓名；
        2. 第一个队伍筛选之后只要前3个人；
        3. 第二个队伍只要姓张的成员姓名；
        4. 第二个队伍筛选之后不要前2个人；
        5. 将两个队伍合并为一个队伍；
        6. 打印整个队伍的姓名信息。

    按照Stream流 + lambda表达式标准格式
 */
public class Demo04StreamTest {
    public static void main(String[] args) {
        List<String> o = new ArrayList<>();
        o.add("迪丽热巴");
        o.add("宋远桥");
        o.add("苏星河");
        o.add("老子");
        o.add("庄子");
        o.add("孙子");
        o.add("洪七公");

        //获取第一个队伍的Stream流对象
        Stream<String> os1 = o.stream();

        //1. 第一个队伍只要名字为3个字的成员姓名；
        Stream<String> os2 = os1.filter((String name) -> {
            return name.length() == 3;
        });


        //2. 第一个队伍筛选之后只要前3个人；
        Stream<String> os3 = os2.limit(3);

        List<String> t = new ArrayList<>();
        t.add("古力娜扎");
        t.add("张无忌");
        t.add("张三丰");
        t.add("赵丽颖");
        t.add("张二狗");
        t.add("张天爱");
        t.add("张三");

        //获取第二个队伍的Stream流对象
        Stream<String> ts1 = t.stream();

        //3. 第二个队伍只要姓张的成员姓名；
        Stream<String> ts2 = ts1.filter((String name) -> {
            return name.startsWith("张");
        });


        //4. 第二个队伍筛选之后不要前2个人；
        Stream<String> ts3 = ts2.skip(2);


        //5. 将两个队伍合并为一个队伍；
        Stream<String> ots3 = Stream.concat(os3, ts3);


        //6. 打印整个队伍的姓名信息。
        ots3.forEach((String name)->{
            System.out.println(name);
        });
    }
}

```

```java
/*
    Stream流综合练习
    要求:
        1. 第一个队伍只要名字为3个字的成员姓名；
        2. 第一个队伍筛选之后只要前3个人；
        3. 第二个队伍只要姓张的成员姓名；
        4. 第二个队伍筛选之后不要前2个人；
        5. 将两个队伍合并为一个队伍；
        6. 打印整个队伍的姓名信息。

    按照Stream流 + lambda表达式简化格式
 */
public class Demo05StreamTest {
    public static void main(String[] args) {
        List<String> o = new ArrayList<>();
        o.add("迪丽热巴");
        o.add("宋远桥");
        o.add("苏星河");
        o.add("老子");
        o.add("庄子");
        o.add("孙子");
        o.add("洪七公");

        //获取第一个队伍的Stream流对象
        Stream<String> os1 = o.stream();

        //1. 第一个队伍只要名字为3个字的成员姓名；
        Stream<String> os2 = os1.filter(name -> name.length() == 3);


        //2. 第一个队伍筛选之后只要前3个人；
        Stream<String> os3 = os2.limit(3);

        List<String> t = new ArrayList<>();
        t.add("古力娜扎");
        t.add("张无忌");
        t.add("张三丰");
        t.add("赵丽颖");
        t.add("张二狗");
        t.add("张天爱");
        t.add("张三");

        //获取第二个队伍的Stream流对象
        Stream<String> ts1 = t.stream();

        //3. 第二个队伍只要姓张的成员姓名；
        Stream<String> ts2 = ts1.filter(name -> name.startsWith("张"));


        //4. 第二个队伍筛选之后不要前2个人；
        Stream<String> ts3 = ts2.skip(2);


        //5. 将两个队伍合并为一个队伍；
        Stream<String> ots3 = Stream.concat(os3, ts3);


        //6. 打印整个队伍的姓名信息。
        ots3.forEach(name-> System.out.println(name));

    }
}

```

```java
/*
    Stream流综合练习
    要求:
        1. 第一个队伍只要名字为3个字的成员姓名；
        2. 第一个队伍筛选之后只要前3个人；
        3. 第二个队伍只要姓张的成员姓名；
        4. 第二个队伍筛选之后不要前2个人；
        5. 将两个队伍合并为一个队伍；
        6. 打印整个队伍的姓名信息。

    按照Stream流 + lambda表达式简化格式 三行搞定
 */
public class Demo06StreamTest {
    public static void main(String[] args) {
        List<String> o = new ArrayList<>();
        o.add("迪丽热巴");
        o.add("宋远桥");
        o.add("苏星河");
        o.add("老子");
        o.add("庄子");
        o.add("孙子");
        o.add("洪七公");

        //获取第一个队伍的Stream流对象


        //1. 第一个队伍只要名字为3个字的成员姓名；



        //2. 第一个队伍筛选之后只要前3个人；
        Stream<String> os = o.stream().filter(name -> name.length() == 3).limit(3);


        List<String> t = new ArrayList<>();
        t.add("古力娜扎");
        t.add("张无忌");
        t.add("张三丰");
        t.add("赵丽颖");
        t.add("张二狗");
        t.add("张天爱");
        t.add("张三");

        //获取第二个队伍的Stream流对象


        //3. 第二个队伍只要姓张的成员姓名；



        //4. 第二个队伍筛选之后不要前2个人；

        Stream<String> ts = t.stream().filter(name -> name.startsWith("张")).skip(2);


        //5. 将两个队伍合并为一个队伍；



        //6. 打印整个队伍的姓名信息。

        Stream.concat(os,ts).forEach(name-> System.out.println(name));

    }
}
```

### 4.11 Stream的map方法

```java
/*
    java.util.stream.Stream<T>接口: 我们已经可以获取Stream接口的实现类对象
    抽象方法:
        public abstract <R> Stream<R> map(Function<T, R> mapper)
            按照方法参数mapper指定的方式把Stream流对象中的T类型的元素转换成R类型,返回新的Stream流
            参数:
                Function<T, R> mapper: 转换型接口

        java.util.function.Function<T, R>接口: 转换型接口 
        功能: 把T类型的数据转换成R类型
        抽象方法:
            public abstract R apply(T t): 根据方法参数T类型的t,获取R类型的数据
            转换前: T类型
            转换后: R类型
   	map: 映射
   	如果需要将流中的元素映射到另一个流中,可以使用map方法.方法签名
   	public abstract <R> Stream<R> map(Function<T, R> mapper);
   	该方法需要一个Function函数式接口参数,可以将当前流中的T类型数据转换为另一种R类型的流.
 */
```

```java
public class Demo07StreamMap {
    public static void main(String[] args) {
        // {new Person("张三", 18), new Person("李四", 38), new Person("王五", 28)};
        //创建List集合对象strList,存储数据类型String
        List<String> strList = new ArrayList<>();
        //添加多个字符串,每个字符串代表一个Person对象的信息
        Collections.addAll(strList,"张三:18","李四:38","王五:28");

        //获取List集合对象strList对应的Stream流对象
        Stream<String> s = strList.stream();

        //把Stream流对象中的每个String,转换成Person对象
        Stream<Person> s2 = s.map(new Function<String, Person>() {
            @Override
            public Person apply(String personInfo) {
                //把字符串按照:进行切割
                String[] array = personInfo.split(":");
                //把切割后的数组信息封装成Person对象并返回
                return new Person(array[0], Integer.parseInt(array[1]));
            }
        });
        //遍历存储Person对象的Stream流对象
        s2.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });
    }
}
```

```java
public class Demo08StreamMap {
    public static void main(String[] args) {
        // {new Person("张三", 18), new Person("李四", 38), new Person("王五", 28)};
        //创建List集合对象strList,存储数据类型String
        List<String> strList = new ArrayList<>();
        //添加多个字符串,每个字符串代表一个Person对象的信息
        Collections.addAll(strList,"张三:18","李四:38","王五:28");

        strList.stream()
                .map((String personInfo)->{
                    //把字符串按照:进行切割
                    String[] array = personInfo.split(":");
                    //把切割后的数组信息封装成Person对象并返回
                    return new Person(array[0], Integer.parseInt(array[1]));
                })
                .forEach((Person p)->{
                    System.out.println(p);
                });

    }
}

```



### 4.12 收集Stream结果

```java
对流操作完成之后,如果需要将结果进行收集,例如获取对应的集合/数组等,如何操作?
Stream流提供collect方法,其参数需要一个java.util.stream.Collector<T,A,R>接口对象来指定收集到哪种集合中.
    
Stream流对象中的内容收集到集合中,Stream接口(已经获取到实现类对象)提供抽象方法:
	<R, A> R collect(Collector<? super T, A, R> collector);
	参数:
		java.util.stream.Collector collector: 接口
		需要传递接口实现类对象,但是发现自己做实现类几乎不可能,非常麻烦,方法非常多
		幸运的是,java.util.stream.Collectors工具类提供一些方法,获取Collector<T,A,R>接口实现类对象
        public static <T> Collector<T, ?, List<T>> toList(): 转换为List集合
        public static <T> Collector<T, ?, Set<T>> toSet(): 转换为Set集合
        
Stream流对象中的内容收集到数组中:
	Stream流对象中的内容收集到数组中,Stream接口(已经获取到实现类对象)提供抽象方法:
	Object[] toArray()
        要求:
            使用Stream流,List集合对象中的每个Person对象的年龄增加两岁,
            放入新的List集合中
```

```java
public class Demo09StreamCollect {
    public static void main(String[] args) {
        //创建List集合对象,并添加数据
        List<Person> list = new ArrayList<>();
        Collections.addAll(list,
                new Person("张三", 18),
                new Person("李四", 38),
                new Person("王五", 28));

        //获取List集合对象的Stream流对象
        Stream<Person> s = list.stream();

        //利用map方法,把每个Person对象的年龄增加两岁后,存储到新的Stream流对象中
        Stream<Person> s2 = s.map(new Function<Person, Person>() {
            @Override
            public Person apply(Person person) {
                //把年龄增加两岁
                person.setAge(person.getAge() + 2);
                return person;
            }
        });

        //利用collect方法把Stream流对象,转换成List集合对象
        list = s2.collect(Collectors.toList());

        //遍历新的List集合
        list.forEach(p-> System.out.println(p));
    }
}
```

```java
public class Demo10StreamCollect {
    public static void main(String[] args) {
        //创建List集合对象,并添加数据
        List<Person> list = new ArrayList<>();
        Collections.addAll(list,
                new Person("张三", 18),
                new Person("李四", 38),
                new Person("王五", 28));

        //获取List集合对象的Stream流对象
        //利用map方法,把每个Person对象的年龄增加两岁后,存储到新的Stream流对象中
        //利用collect方法把Stream流对象,转换成List集合对象
        list = list.stream().map((Person person) -> {
            person.setAge(person.getAge() + 2);
            return person;
        }).collect(Collectors.toList());

        //遍历新的List集合
        list.forEach(p -> System.out.println(p));
    }
}
```





![1651041970279](img/1651041970279.png)

![1651041980891](img/1651041980891.png)