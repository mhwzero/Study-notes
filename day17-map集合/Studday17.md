# <center>Map集合</center>
[toc]
# Map集合
## Map集合的特点
    java.util.Map<K,V>接口:
       双列集合根接口,内部定义的方法,子接口/实现类都有
       K: 键的类型,唯一
       V: 值的类型,可以重复
       和java.util.Collection<T>接口: 单列集合的根接口,无关的
    
    Map<K,V>接口的特点:
       1.键唯一,值可以重复
       2.一个键对应一个值,叫一一对应关系(映射关系/键值对关系)
       3.依靠键维护映射关系(可以通过键获取到值,但是不能通过值获取键)
![](./img/1601287013534.png)
## Map集合的实现类的特点
```
Map接口常用实现类:
java.util.HashMap<K,V>集合特点          ----使用
    1.键具备哈希特性: 
		哈希表 数组 + 单向链表/红黑树(链表数量>8 同时 数组元素>=64,链表变成红黑树)
    2.查询速度非常快,增删速度也不慢
    3.键要唯一: 键所属的类覆盖重写hashCode和equals方法
    4.键无序: 不保证存入和取出的顺序是一致的
    5.键无索引: 不能通过索引的方式获取键
    6.允许存储null键和null值
    7.线程不同步,不安全,但是效率高

java.util.Hashtable<K,V>集合特点          ----不使用
    1.键具备哈希特性: 哈希表 数组 + 单向链表
    2.查询速度非常快,增删速度也不慢
    3.键要唯一: 键所属的类覆盖重写hashCode和equals方法
    4.键无序: 不保证存入和取出的顺序是一致的
    5.键无索引: 不能通过索引的方式获取键
    6.不允许存储null键和null值
    7.线程同步,安全,但是效率低

java.util.LinkedHashMap<K,V>集合特点          ----使用
    1.键具备哈希特性和链表特性: 
		哈希表 数组 + 双向链表/红黑树(链表数量>8 同时 数组元素>=64,链表变成红黑树)
    2.查询速度非常快,增删速度也不慢
    3.哈希特性保证键要唯一: 键所属的类覆盖重写hashCode和equals方法
    4.链表特性保证键有序: 保证存入和取出的顺序是一致的
    5.键无索引: 不能通过索引的方式获取键
    6.允许存储null键和null值
    7.线程不同步,不安全,但是效率高
```
## Map集合的常用方法
```
Map接口中的常用方法
	public V put(K key, V value) : 把指定的键与指定的值添加到Map集合中。
    	如果键key,是第一次存储,返回null
    	如果键key已经存在,返回是被替换掉的值
    	键相同,值被替换

	public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
    	键不存在: 返回null
	public V remove(Object key) : 
		把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
		
	public boolean containsKey(Object key) :判断该集合中是否有此键。
	public boolean containsValue(Object value) :判断该集合中是否有此值。
```
```java
//测试代码
public class Demo02Map {
    public static void main(String[] args) {
        //多态创建Map集合对象
        Map<String,String> map = new HashMap<>();

        //public V put(K key, V value) : 把指定的键与指定的值添加到Map集合中。
        String value = map.put("文章","马伊琍");
        System.out.println(value);

        value = map.put("文章","姚笛");
        System.out.println(value);

        map.put("黄晓明","杨颖");

        map.put("谢霆锋","王菲");


        System.out.println(map);

        //获取值"姚笛"
        value = map.get("文章");
        System.out.println(value);

        //没有键
        value = map.get("宝强");
        System.out.println(value);

        //判断是否包含键"黄晓明"
        boolean result = map.containsKey("黄晓明");
        System.out.println("是否包含键黄晓明:"+result);//true

        //判断是否包含键"宝强"
        result = map.containsKey("宝强");
        System.out.println("是否包含键宝强:"+result);//false

        //判断是否包含值"王菲"
        System.out.println("是否包含值王菲: "+map.containsValue("王菲"));//true

        //判断是否包含值"马伊琍"
        System.out.println("是否包含值马伊琍: "+map.containsValue("马伊琍"));//false

        //删除键"文章"
        value = map.remove("文章");
        System.out.println(value);//姚笛
        System.out.println(map);

        System.out.println("键值对数量: "+map.size());//2

        System.out.println("是否为空: "+map.isEmpty());//false

        //清空
        map.clear();

        System.out.println("键值对数量: "+map.size());//0

        System.out.println("是否为空: "+map.isEmpty());//true

    }
}
```
## Map集合的获取所有的键和值的功能
```
Map接口中的常用方法
	public Set<K> keySet() : 获取Map集合中所有的键，存储到Set集合中。
	public Collection<V> values() :返回Map集合中的所有值到Collection集合。
```
```java
public class Demo03Map {
    public static void main(String[] args) {
        //多态创建Map集合对象
        Map<String,Integer> map = new HashMap<>();

        //put: 添加键值对
        map.put("b",98);
        map.put("d",100);
        map.put("a",97);
        map.put("c",99);
        System.out.println(map);

        //keySet方法:获取所有的键对应的Set集合
        Set<String> set = map.keySet();

        //迭代器遍历
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("------------");

        //values方法: 获取所有的值对应的Collection集合
        Collection<Integer> coll = map.values();

        //增强for遍历
        for (Integer num : coll) {
            System.out.println(num);
        }
    }
}
```
## Map集合的遍历_通过键找值
![遍历](./img/1601287456801.png)
```java
/*
    Map集合第一种遍历方式: 根据键找值
        实现步骤:
        1.创建Map集合对象,指定键和值的类型
        2.Map集合对象调用put方法,添加键值对
        3.Map集合对象调用keySet方法,获取所有的键对应的Set集合
        4.遍历(迭代器/增强for)所有的键对应的Set集合
            4.1获取到当前的键
            4.2Map集合对象调用get方法,传递当前的键,获取对应的值
            4.3打印键和值
 */
public class Demo02_01MapEach {
    public static void main(String[] args) {        
        //1.创建Map集合对象,指定键和值的类型
        Map<String,String> map = new HashMap<>();
        //2.Map集合对象调用put方法,添加键值对
        map.put("邓超","孙俪");
        map.put("李晨","范冰冰");
        map.put("刘德华","柳岩");		
        //keySet方法+增强for
        //3.Map集合对象调用keySet方法,获取所有的键对应的Set集合
        Set<String> set = map.keySet();
        //4.遍历(增强for)所有的键对应的Set集合
        for (String key : set) {
            //4.1获取到当前的键: key
            //4.2Map集合对象调用get方法,传递当前的键,获取对应的值
            String value = map.get(key);
            //4.3打印键和值
            System.out.println(key+"----"+value);

        }
        System.out.println("-----------------");
        //最简单的增强for遍历
        //快捷键: map.keySet().for
        for (String key : map.keySet()) {
            System.out.println(key+"====="+map.get(key));
        }
        //method02();
    }
}

public class Demo02_02MapEach {
    public static void main(String[] args) {
        //1.创建Map集合对象,指定键和值的类型
        Map<String,String> map = new HashMap<>();
        //2.Map集合对象调用put方法,添加键值对
        map.put("邓超","孙俪");
        map.put("李晨","范冰冰");
        map.put("刘德华","柳岩");        
		//keySet方法+迭代器
        //3.Map集合对象调用keySet方法,获取所有的键对应的Set集合
        Set<String> set = map.keySet();
        //4.遍历(迭代器)所有的键对应的Set集合
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            //4.1获取到当前的键
            String key = it.next();
            //4.2Map集合对象调用get方法,传递当前的键,获取对应的值
            String value = map.get(key);
            //4.3打印键和值
            System.out.println(key+"::::"+value);
        }
    }
}
```
## Map集合的遍历_通过键值对的方式分析
```
Map集合遍历方式二: 键值对方式
    原理分析:
    Map<K,V>接口内部定义静态的内部接口Entry<K,V>,用来描述结婚(键值对/映射关系)的
    Map接口的所有实现类内部,必然定义类实现Entry接口,覆盖重写抽象方法,
    描述自己的结婚证(键值对/映射关系)

    Map接口内部静态接口Entry<K,V>抽象方法:
        public abstract K getKey(): 获取键
        public abstract V getValue(): 获取值
        public abstract V setValue(V newValue): 修改值,返回的被修改的值

    Map集合的所有实现类内部,已经描述了结婚证(键值对/映射关系),
		但是如何获取所有的结婚证(键值对/映射关系)?
    Map<K,V>接口内部,定义抽象方法,用来获取所有的结婚证(键值对/映射关系)
    public abstract Set<Entry> entrySet(): 用来获取所有的结婚证(键值对/映射关系)
    Map接口的所有实现类,必然覆盖重写entrySet方法,获取键值对对象组成的Set集合
```
![](./img/1601287879467.png)
## Map集合的遍历_通过键值对的代码实现
```
/*
    Map集合遍历方式二: 键值对方式
    实现步骤:
        1.创建Map集合对象,指定键和值的类型
        2.Map集合对象调用put方法,添加键值对
        3.Map集合对象调用entrySet方法,获取所有的键值对对应的Set集合
        4.遍历(迭代器/增强for)所有的键值对对应的Set集合
            4.1获取到当前的键值对对象
            4.2当前的键值对对象调用getKey方法,获取键
            4.3当前的键值对对象调用getValue方法,获取值
            4.4打印键和值
 */
```
```java
public class Demo04_01MapEach {
    public static void main(String[] args) {
        //1.创建Map集合对象,指定键和值的类型
        Map<String,String> map = new HashMap<>();
        //2.Map集合对象调用put方法,添加键值对
        map.put("邓超","孙俪");
        map.put("李晨","范冰冰");
        map.put("刘德华","柳岩");
        //entrySet方法 + 增强for
        //3.Map集合对象调用entrySet方法,获取所有的键值对对应的Set集合
        Set<Map.Entry<String,String>> set = map.entrySet();
        //4.遍历(增强for)所有的键值对对应的Set集合
        for (Map.Entry<String, String> entry : set) {
            //4.1获取到当前的键值对对象: entry
            //4.2当前的键值对对象调用getKey方法,获取键
            //4.3当前的键值对对象调用getValue方法,获取值
            //4.4打印键和值
            System.out.println(entry.getKey()+"::::"+entry.getValue());
        }
        System.out.println("--------------");
        //最简单的增强for
        //快捷键: map.entrySet().for
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"::::"+entry.getValue());
        }
    }
}
```
```java
public class Demo04_01MapEach {
    public static void main(String[] args) {
        //1.创建Map集合对象,指定键和值的类型
        Map<String,String> map = new HashMap<>();
        //2.Map集合对象调用put方法,添加键值对
        map.put("邓超","孙俪");
        map.put("李晨","范冰冰");
        map.put("刘德华","柳岩");
        //3.Map集合对象调用entrySet方法,获取所有的键值对对应的Set集合
        Set<Map.Entry<String, String>> set = map.entrySet();
        //4.遍历(迭代器)所有的键值对对应的Set集合
        Iterator<Map.Entry<String, String>> it = set.iterator();
        while(it.hasNext()) {
            //4.1获取到当前的键值对对象
            Map.Entry<String, String> entry = it.next();
            //4.2当前的键值对对象调用getKey方法,获取键
            String key = entry.getKey();
            //4.3当前的键值对对象调用getValue方法,获取值
            String value = entry.getValue();
            //4.4打印键和值
            System.out.println(key+"::::"+value);
        }
    }
}
```
## HashMap存储自定义对象并遍历
```java
//JavaBean类又叫做pojo类
public class Student {
    private String name;
    private int age;
    //覆盖重写hashCode和equals方法
    //生成空参/满参,set/get/toString方法
}
/*
	HashMap存储自定义对象
        练习：每位学生（姓名，年龄）都有自己的家庭住址。那么，既然有对应关系，
        则将学生对象和家庭住址存储到map集合中。学生作为键, 家庭住址作为值。
        注意，学生姓名相同并且年龄相同视为同一名学生。
        
   	使用keySet完成遍历的实现步骤:
        1.创建标准的Studnet类
        2.创建HashMap集合对象,键: Student,值: String
        3.HashMap集合对象调用put方法,添加键值对
        4.HashMap集合对象调用keySet方法,获取所有的键对应的Set集合
        5.使用迭代器遍历所有的键对应的Set集合
            5.1获取当前的键
            5.2HashMap集合对象调用get方法,传递当前的键,获取对应的值
            5.3打印键和值
*/
public class Demo03HashMapTest {
    public static void main(String[] args) {
        //1.创建标准的Studnet类
        //2.创建HashMap集合对象,键: Student,值: String
        HashMap<Student,String> hm = new HashMap<>();

        //3.HashMap集合对象调用put方法,添加键值对
        hm.put(new Student("张三",38),"北京");
        hm.put(new Student("张三",38),"南京");
        hm.put(new Student("李四",18),"上海");
        hm.put(new Student("李四",18),"武汉");
        hm.put(new Student("王五",28),"广州");
        hm.put(new Student("王五",28),"深圳");

        //4.HashMap集合对象调用keySet方法,获取所有的键对应的Set集合
        Set<Student> set = hm.keySet();

        //5.使用迭代器遍历所有的键对应的Set集合
        Iterator<Student> it = set.iterator();
        while(it.hasNext()) {
            //5.1获取当前的键
            Student key = it.next();
            //5.2HashMap集合对象调用get方法,传递当前的键,获取对应的值
            String value = hm.get(key);
            //5.3打印键和值
            System.out.println(key+"::::"+value);
        }
    }
}
```
## LinkedHashMap集合的使用
```
/*
	LinkedHashMap存储自定义对象
        练习：每位学生（姓名，年龄）都有自己的家庭住址。那么，既然有对应关系，
        则将学生对象和家庭住址存储到map集合中。学生作为键, 家庭住址作为值。
        注意，学生姓名相同并且年龄相同视为同一名学生。
    使用entrySet完成遍历
    实现步骤:
        1.创建标准的Student类
        2.创建LinkedHashMap集合对象,键: Student,值: String
        3.LinkedHashMap集合对象调用put方法,添加键值对
        4.LinkedHashMap集合对象调用entrySet方法,获取所有的键值对对应的Set集合
        5.使用增强for遍历所有的键值对对应的Set集合
            5.1获取当前的键值对对象
            5.2键值对对象调用getKey方法,获取对应的键
            5.3键值对对象调用getValue方法,获取对应的值
            5.4打印键和值
*/
```
```java
public class Demo04LinkedHashMapTest {
    public static void main(String[] args) {
        //2.创建LinkedHashMap集合对象,键: Student,值: String
        Map<Student, String> map = new LinkedHashMap<>();
        //3.LinkedHashMap集合对象调用put方法,添加键值对
        map.put(new Student("李四", 18), "上海");
        map.put(new Student("李四", 18), "武汉");
        map.put(new Student("张三", 38), "北京");
        map.put(new Student("张三", 38), "南京");
        map.put(new Student("王五", 28), "广州");
        map.put(new Student("王五", 28), "深圳");

        //4.Map集合对象调用entrySet方法,获取所有的键值对组成的Set集合对象set
        Set<Map.Entry<Student, String>> set = map.entrySet();
        //5.使用(迭代器)遍历所有的键值对组成的Set集合对象set
        Iterator<Map.Entry<Student, String>> it = set.iterator();
        while (it.hasNext()) {
            //5.1 获取当前的键值对对象,保存Entry对象entry中
            Map.Entry<Student, String> entry = it.next();
            //5.2 使用Entry对象entry调用getKey方法获取键,使用Entry对象entry调用getValue方法获取值
            Student key = entry.getKey();
            String value = entry.getValue();
            //5.3 打印输出键和值
            System.out.println(key + "::" + value);
        }
        System.out.println("-----------");
        //增强for
        for (Map.Entry<Student, String> entry : set) {
            System.out.println(entry.getKey() + "==" + entry.getValue());
        }
        System.out.println("-----------");
        //增强for快捷键
        for (Map.Entry<Student, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "~~~" + entry.getValue());
        }
    }
}
```
## map集合对象调用entrySet()方法和调用keySet()方法的区别
```
values():方法是获取集合中的所有的值----没有键，没有对应关系，

KeySet():
将Map中所有的键存入到set集合中。因为set具备迭代器。所有可以迭代方式取出所有的键，再根据get方法。获取每一个键对应的值。 keySet():迭代后只能通过get()取key 

entrySet()：
Set<Map.Entry<K,V>> entrySet() //返回此映射中包含的映射关系的 Set 视图。 Map.Entry表示映射关系。entrySet()：迭代后可以e.getKey()，e.getValue()取key和value。返回的是Entry接口 

entrySet()方法要比KeySet()方法遍历速度快
```
## Properties集合介绍
```
java.util.Properties集合: 代表属性集
	数据存储格式: 属性名=属性值 name=zhangsan age=18 可以存储文件中
	Properties是Hashtable的子类
   	Hashtable是Map集合的实现类
    所以: Properties也是Map集合的实现类,Map集合中定义的方法,它都有
    
Properties的特点:
    1.Properties也是Map集合的实现类,Map集合中定义的方法,它都有
    2.Hashtable是Map接口的实现类,具有泛型K代表键的类型,V代表值的类型
        但是Properties继承Hashtable时,确定键的类型Object以及值的类型Object
        所以创建Properties集合对象时,不能再指定泛型
    3.Properties集合提供了参数和返回值都是String的方法,而String后期可以写在文件中
    4.Properties集合是唯一一个和IO流配合使用的双列集合

Properties集合的使用
	空参构造
    	public Properties(): 可以直接创建对象
```
## Properties集合的基本使用
```
Properties集合常用方法:
	public Object setProperty(String key,String value): 向集合中存储键值对。
    	等价于Map集合
    	public V put(K k,V v): 向集合中存储键值对。

	public String getProperty(String key): 获取集合中键对应的值，无此键返回null。
    	等价于Map集合
    	public V get(K k): 根据键获取值

	public Set<String> stringPropertyNames(): 集合中的所有键存储到Set集合。
    	等价于Map集合
    	public Set<K> keySet(): 集合中的所有键存储到Set集合。
```
```java
public class Demo04Properties {
    public static void main(String[] args) {
        //创建Properties集合对象
        Properties props = new Properties();
        System.out.println(props);
        //public Object setProperty(String key,String value): 向集合中存储键值对。
        props.setProperty("name","zhangsan");
        props.setProperty("age","18");
        props.setProperty("gender","nan");
        System.out.println(props);

        //public String getProperty(String key): 获取集合中键对应的值，无此键返回null。
        String name = props.getProperty("name");
        String age = props.getProperty("age");
        String gender = props.getProperty("gender");

        System.out.println(name+"::"+age+"::"+gender);

        System.out.println("-------------------");
        //public Set<String> stringPropertyNames(): 集合中的所有键存储到Set集合。
        Set<String> propertyNames = props.stringPropertyNames();

        //增强for遍历
        for (String propertyName : propertyNames) {
            //propertyName: 属性名
            //获取属性值
            String propertyValue = props.getProperty(propertyName);
            System.out.println(propertyName+"::::"+propertyValue);
        }

    }
}
```
## Map练习字符个数的案例分析
![案例分析](./img/1601288696426.png)
## 统计字符个数的代码实现
```
统计一个字符串中每个字符出现次数。
实现步骤:
     统计一个字符串中每个字符出现次数。
    实现步骤:
        1.创建键盘录入Scanner类的对象
        2.获取键盘录入的字符串保存String变量str中
        3.创建Map集合对象map,键Character,值Integer
        4.遍历(方式一: for+charAt(索引),方式二:toCharArray+for遍历数组)字符串str
        5.获取当前字符保存char变量ch中
        6.判断如果当前Map集合对象map中不包含ch键,向Map集合对象map中存储ch键和1作为值
        7.判断如果当前Map集合对象map中包含ch键
        7.1 获取对应的值表示已经出现的次数,增加1后保存int变量count中
        7.2 向Map集合对象map中存储ch键和count作为值
        8.打印Map集合对象map
```
```java
public class Demo05MapCount {
    public static void main(String[] args) {
        //1.创建键盘录入Scanner类的对象
        Scanner sc = new Scanner(System.in);
        //2.获取键盘录入的字符串保存String变量str中
        System.out.println("请输入一个字符串: ");
        String str = sc.nextLine();
        //3.创建Map集合对象map,键Character,值Integer
        Map<Character, Integer> map = new HashMap<>();
        //4.遍历(方式一: for+charAt(索引),方式二:toCharArray+for遍历数组)字符串str
        for (int i = 0; i < str.length(); i++) {
            //5.获取当前字符保存char变量ch中
            char ch = str.charAt(i);
            //6.判断如果当前Map集合对象map中不包含ch键
            if (!map.containsKey(ch)) {
                //向Map集合对象map中存储ch键和1作为值
                map.put(ch, 1);
            } else {
                //7.判断如果当前Map集合对象map中包含ch键
                //7.1 获取对应的值表示已经出现的次数,增加1后保存int变量count中
                int count = map.get(ch) + 1;
                //7.2 向Map集合对象map中存储ch键和count作为值
                map.put(ch, count);
            }
        }
        //8.打印Map集合对象map
        System.out.println("map = " + map);
    }
}

```
# 集合嵌套
## 集合嵌套List嵌套List
![集合嵌套图解](./img/1601291540995.png)
```
/*
    List嵌套List集合
    需求：创建3个List集合，每个集合中分别存储一些字符串，将3个List集合存储到另一个List集合中。

    实现步骤:
        1.创建List集合对象bigList,代表楼层(存储多间教室)(小容器),泛型: List<String>
        2.创建三个List集合对象,代表三个教室(小容器),泛型: String
        3.分别向三个小List集合对象中添加数据
        4.把三个小List集合存储到大的List集合对象中
        5.遍历(迭代器/增强for)大的List集合对象bigList
        6.获取到大List集合对象中的当前的小List集合对象smallList
        7.遍历(迭代器/增强for)小的List集合对象smallList
*/
```
```java
public class Demo03ListList {
    public static void main(String[] args) {
        //1.创建List集合对象bigList,代表楼层(存储多间教室)(小容器),泛型: List<String>
        List<List<String>> bigList = new ArrayList<>();

        //2.创建三个List集合对象,代表三个教室(小容器),泛型: String
        List<String> smallList01 = new ArrayList<>();
        List<String> smallList02 = new ArrayList<>();
        List<String> smallList03 = new ArrayList<>();

        //3.分别向三个小List集合对象中添加数据
        Collections.addAll(smallList01,"张三","李四","王五");
        Collections.addAll(smallList02,"赵六","孙七","马伊琍");
        Collections.addAll(smallList03,"宝强","柳岩","小涛子");

        //4.把三个小List集合存储到大的List集合对象中
        bigList.add(smallList01);
        bigList.add(smallList02);
        bigList.add(smallList03);

        //Collections.addAll(bigList,smallList01,smallList02,smallList03);

        //5.遍历(迭代器)大的List集合对象bigList
        Iterator<List<String>> bigIt = bigList.iterator();//获取大集合的迭代器对象

        while(bigIt.hasNext()) {
            //6.获取到大List集合对象中的当前的小List集合对象smallList
            List<String> smallList = bigIt.next();
            //7.遍历(迭代器)小的List集合对象smallList
            Iterator<String> smallIt = smallList.iterator();//获取小集合的迭代器对象
            while (smallIt.hasNext()) {
                System.out.println(smallIt.next());
            }
            System.out.println("-----------------");
        }
    }
}
```
## 集合嵌套List嵌套Map
![嵌套集合](./img/1601291674096.png)
```
List嵌套Map
        需求：
        	1班级有第三名同学，学号和姓名分别为：
        		001=张三，002=李四，003=王五
        	2班有三名同学，学号和姓名分别为：
        		001=黄晓明，002=杨颖，003=刘德华，004=朱丽倩
        请将同学的信息以键值对的形式存储到2个Map集合中，在将2个Map集合存储到List集合中。
        
    实现步骤:
        1.创建List集合list,代表楼层(多间教室,大容器),泛型: Map<String,String>
        2.创建三个Map集合对象,分别代表教室(小容器),泛型: String,String
        3.分别向三个Map集合对象中添加键值对
        4.把三个Map集合对象添加到List集合对象中(把三间教室,装入楼层中)
        5.遍历(迭代器/增强for)List集合对象
        6.获取到当前的Map集合对象
        7.遍历(迭代器/增强for)当前的Map集合对象(keySet/entrySet方法)
```
```java
public class Demo04ListMap {
    public static void main(String[] args) {
        //1.创建List集合list,代表楼层(多间教室,大容器),泛型: Map<String,String>
        List<Map<String,String>> list = new ArrayList<>();
        //2.创建三个Map集合对象,分别代表教室(小容器),泛型: String,String
        Map<String,String> map01 = new HashMap<>();
        Map<String,String> map02 = new HashMap<>();
        Map<String,String> map03 = new HashMap<>();
        //3.分别向三个Map集合对象中添加键值对
        map01.put("001","张三");
        map01.put("002","李四");
        map01.put("003","王五");
        map02.put("001","黄晓明");
        map02.put("002","杨颖");
        map02.put("003","刘德华");
        map03.put("001","小涛子");
        map03.put("002","小男子");
        map03.put("003","小程子");
        //4.把三个Map集合对象添加到List集合对象中(把三间教室,装入楼层中)
        list.add(map01);
        list.add(map02);
        list.add(map03);
        //Collections.addAll(list,map01,map02,map03);
        //5.遍历(迭代器)List集合对象
        Iterator<Map<String, String>> bigIt = list.iterator();
        while (bigIt.hasNext()) {
            //6.获取到当前的Map集合对象
            Map<String, String> map = bigIt.next();
            //7.遍历(迭代器)当前的Map集合对象(keySet方法)
            Set<String> set = map.keySet();
            Iterator<String> smallIt = set.iterator();
            while (smallIt.hasNext()) {
                String key = smallIt.next();//键
                //根据键获取值
                String value = map.get(key);
                System.out.println(key+"::::"+value);
            }
            System.out.println("----------------------");
        }
    }
}
```
## 集合嵌套Map嵌套Map
![](./img/1601291808215.png)
```
/*
    Map嵌套Map
        需求：有以下数据结构，使用集合存储。
        java基础班 集合 存储的是 学号 键，值学生姓名
            001 张三
            002 李四
        java就业班
            001 王五
            002 赵柳

        实现步骤:
            1.创建大Map集合对象bigMap,代表楼层(大容器),
                泛型: 键 String(教室名字) 值 Map<String,String>(教室中的学生)

            2.创建两个小Map集合对象,代表教室(小容器),泛型: 键: String 值: String
            3.分别向两个小Map集合对象中存储键值对数据
            4.把两个小Map集合对象存储到大的Map集合对象中,指定键: String(教室名字)
            5.遍历(迭代器/增强for)大Map集合对象(keySet/entrySet方法)
            6.获取到当前的小Map集合对象
            7.遍历(迭代器/增强for)小Map集合对象(keySet/entrySet方法)
*/
```
```java
public class Demo05MapMap {
    public static void main(String[] args) {
        //1.创建大Map集合对象bigMap,代表楼层(大容器),泛型: 键 String(教室名字) 值 Map<String,String>(教室中的学生)
        Map<String,Map<String,String>> bigMap = new HashMap<>();

        //2.创建两个小Map集合对象,代表教室(小容器),泛型: 键: String 值: String
        Map<String,String> smallMap01 = new HashMap<>();
        Map<String,String> smallMap02 = new HashMap<>();

        //3.分别向两个小Map集合对象中存储键值对数据
        smallMap01.put("001","黄晓明");
        smallMap01.put("002","杨颖");
        smallMap02.put("001","张三");
        smallMap02.put("002","李四");

        //4.把两个小Map集合对象存储到大的Map集合对象中,指定键: String(教室名字)
        bigMap.put("JavaSE",smallMap01);
        bigMap.put("JavaEE",smallMap02);

        //System.out.println(bigMap);

        //5.遍历(迭代器)大Map集合对象(entrySet方法)
        //获取大Map集合对象的所有键值对组成的Set集合
        Set<Map.Entry<String,Map<String,String>>> bigSet = bigMap.entrySet();        
        Iterator<Map.Entry<String,Map<String,String>>> bigIt = bigSet.iterator();
        while(bigIt.hasNext()) {
            //获取到大Map集合中的一个Entry对象
            Map.Entry<String,Map<String,String>> bigEntry = bigIt.next();            
            String className = bigEntry.getKey();//获取键,班级名称
            System.out.println(className+" 班级有如下学生: ");
            //6.获取到当前的小Map集合对象
            Map<String,String> smallMap = bigEntry.getValue();
            //7.遍历(迭代器)小Map集合对象(entrySet方法)
            //获取到小Map集合中的一个Entry对象组成的Set集合
            Set<Map.Entry<String,String>> smallSet = smallMap.entrySet();            
            //获取到小Map集合中的一个Entry对象组成的Set集合的迭代器对象
            Iterator<Map.Entry<String, String>> smallIt = smallSet.iterator();
            while(smallIt.hasNext()) {
                //获取到小Map集合中的一个Entry对象
                Map.Entry<String, String> smallEntry = smallIt.next();
                String id = smallEntry.getKey();
                String name = smallEntry.getValue();
                System.out.println(id+"="+name);
            }
            System.out.println("-----------------------");
        }
    }
}
```
## Hashtable和HashMap的区别
```
    1.HashMap可以存储null键和null值(HashMap允许将 null 作为一个 entry 的 key 或者 value，而 Hashtable 不允许。)
	2.Hashtable不能存储null键和null值
	3.HashMap线程不同步,不安全,但是效率高
	4.Hashtable线程同步,安全,但是效率低
```
### Hashtable和HashMap的区别
```
HashMap和Hashtable都实现了Map接口，但决定用哪一个之前先要弄清楚它们之间的分别。主要的区别有：线程安全性，同步(synchronization)，以及速度。

1、HashMap几乎可以等价于Hashtable，除了HashMap是非synchronized的，并可以接受null(HashMap可以接受为null的键值(key)和值(value)，而Hashtable则不行)。
2、HashMap是非synchronized，而Hashtable是synchronized，这意味着Hashtable是线程安全的，多个线程可以共享一个Hashtable；而如果没有正确的同步的话，多个线程是不能共享HashMap的。Java 5提供了ConcurrentHashMap，它是HashTable的替代，比HashTable的扩展性更好。
3、另一个区别是HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的enumerator迭代器不是fail-fast的。所以当有其它线程改变了HashMap的结构（增加或者移除元素），将会抛出ConcurrentModificationException，但迭代器本身的remove()方法移除元素则不会抛出ConcurrentModificationException异常。但这并不是一个一定发生的行为，要看JVM。这条同样也是Enumeration和Iterator的区别。
4、由于Hashtable是线程安全的也是synchronized，所以在单线程环境下它比HashMap要慢。如果你不需要同步，只需要单一线程，那么使用HashMap性能要好过Hashtable。
5、HashMap不能保证随着时间的推移Map中的元素次序是不变的。

```
[Hashtable和HashMap的区别](http://www.cnblogs.com/binyue/p/4545550.html)
## hashmap hashtable  ConcurrentHashMap的区别
```
同步：synchronized关键字
hashmap：不同步，效率高
hashtable：同步方法，效率低
ConcurrentHashMap：同步的是方法内容的部分地方，效率极高
```
## hashset的底层用hashmap写的，hashmap使用的键值对的形式，为什么hashset是一种值？
    hashset中的add方法采用的是hashmap中put方法，put传值的时候只传了一个键，而值在hashset中是固定的