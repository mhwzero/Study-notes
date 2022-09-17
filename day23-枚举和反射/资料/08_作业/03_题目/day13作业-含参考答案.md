# day13反射

# 知识点

## 题目1（加强训练）

面向对象学习多态的好处可以提高代码的扩展性,但是如果直接new子类对象赋值给父类的引用,后期更换子类,必须要修改源代码,太麻烦。写一个"框架"，不能改变该类的任何代码的前提下，可以帮我们创建任意类的子类对象，并且执行其中任意方法。



### 训练目标

读取配置文件信息，利用反射创建对象，并调用方法。

### 训练提示

1、如何读取properties配置文件？

2、如何根据字符串类名创建该类的对象？

3、如何根据字符串方法名获取方法并执行？

### 参考方案

使用Properties集合加载配置文件信息，反射创建对象调用方法。

### 操作步骤

1、定义抽象父类Animal，该类中定义抽象方法eat

2、定义子类Dog，继承抽象父类Animal，重写抽象方法eat

3、定义config.properties配置文件,指定类名和方法名

4、编写测试类

4.1、创建Properties集合对象

4.2、获取类加载器

4.3、通过类加载器,获取配置文件的字节输入流对象

4.4、Properties集合对象调用load方法，以键值对的方式加载配置文件信息

4.5、获取类的全名称

4.6、获取要执行的方法名称

4.7、根据类的全名称获取类的Class类型的对象

4.8、根据Class类型的对象获取要执行的方法对应的Method对象

4.9、Class类型的对象创建一个具体的对象出来

4.10、Method对象调用invoke方法,执行具体的功能

### 参考答案

~~~java
//1、定义抽象父类Animal，该类中定义抽象方法eat
public abstract class Animal {
    public abstract void eat();
}
~~~

```java
//2、定义子类Dog，继承抽象父类Animal，重写抽象方法eat
public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头....");
    }
}

```

```properties
#3、定义config.properties配置文件,指定类名和方法名
className=itheima02.Cat#注意修改包名
methodName=eat
```

```java
//4、编写测试类
public class Test01 {
    public static void main(String[] args) throws Exception {
        //4.1、创建Properties集合对象
        Properties props = new Properties();
        //4.2、获取类加载器
        ClassLoader classLoader = Demo03ReflectTest.class.getClassLoader();

        //4.3、获取类加载器,获取资源的字节输入流
        InputStream is = classLoader.getResourceAsStream("config.properties");
        //4.4、Properties集合对象调用load方法，以键值对的方式架子配置文件信息
        props.load(is);

        //4.5、获取类的全名称
        String className = props.getProperty("className");
        //4.6、获取要执行的方法名称
        String methodName = props.getProperty("methodName");

        //4.7、获取类的Class类型的对象
        Class<?> clazz = Class.forName(className);

        //4.8、根据Class类型的对象获取要执行的方法对应的Method对象
        Method eatMethod = clazz.getMethod("eat");

        //4.9、Class类型的对象创建一个具体的对象出来
        Object obj = clazz.newInstance();

        //4.10、Method对象调用invoke方法,执行具体的功能
        eatMethod.invoke(obj);
    }
}

```



### 视频讲解

另附avi格式视频。



## 题目2（加强训练）

后面使用JDBC连接数据库，需要给出相关参数。如果在代码中直接调用set方法设置相关参数,后期维护非常麻烦。可以把相关参数保存在.properties文件中，利用Properties集合+反射,读取配置文件信息,完成数据库的配置。
本练习通过Properties集合+反射技术,读取.properties文件信息,创建HMDataBaseConfig类的对象并给其成员变量完成赋值。配置文件和HMDataBaseConfig类的信息如下图所示：

![](img\02_hmDataSourceConfig.jpg)

![](img\02_HMDataBaseConfig.jpg)

### 训练目标

能够读取.properties文件,利用反射创建对象封装信息。

### 训练提示

1、如何读取.properties配置文件？

2、如何通过String的类名创建对象？

3、如何给私有String成员变量赋值？

### 参考方案

使用Properties集合，IO流，反射创建对象并封装数据。

### 操作步骤

1、创建Properties集合对象

2、通过类加载器,获取资源的字节输入流

3、Properties集合对象调用load方法，以键值对的方式加载配置文件信息

4、获取类的全名称

5、获取类的Class类型的对象

6、根据Class类型的对象创建一个具体的对象出来

7、获取Properties集合对象，所有的键对应的Set集合

8、遍历Set集合

8.1、根据键获取对应的值

8.2、如果键名不是DataSourceName，则代表是属性名

8.3、根据属性名获取对应的set方法的名称

8.4、获取set方法对应的Method对象

8.5、执行set方法,给obj对象成员赋值

9、打印对象

### 参考答案

```java
public class Test02 {
    public static void main(String[] args) throws Exception {
        //1、创建Properties集合对象
        Properties props = new Properties();

        //2、通过类加载器,获取资源的字节输入流
        InputStream inputStream = Test02.class.getClassLoader().getResourceAsStream("hmDataSourceConfig.properties");

        //3、Properties集合对象调用load方法，以键值对的方式架子配置文件信息
        props.load(inputStream);

        //4、获取类的全名称
        String dataSourceName = props.getProperty("DataSourceName");

        //5、获取类的Class类型的对象
        Class clazz = Class.forName(dataSourceName);

        //6、根据Class类型的对象创建一个具体的对象出来
        Object obj = clazz.newInstance();

        //7、获取Properties集合对象，所有的键对应的Set集合
        Set<String> propertyNames = props.stringPropertyNames();

        //8、遍历Set集合
        for (String propertyName : propertyNames) {
            //8.1、根据键获取对应的值
            String propertyValue = props.getProperty(propertyName);
            //8.2、如果键名不是类的全名称，则代表是属性名
            if(!"DataSourceName".equals(propertyName)) {
                //8.3、根据属性名获取对应的set方法的名称
                String setMethodName = getSetMethodName(propertyName);
                //8.4、获取set方法对应的Method对象
                Method setMethod = clazz.getMethod(setMethodName, String.class);
                //8.5、执行set方法,给obj对象成员赋值
                setMethod.invoke(obj,propertyValue);
            }
        }
        //9、打印对象
        System.out.println(obj);


    }
    //定义方法根据成员变量名获取set方法名称
    public static String getSetMethodName(String name) {
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }
}
```

```java
/*
    定义HMDataBaseConfig类
 */
public class HMDataBaseConfig {
    private String driverClass;
    private String url;
    private String user;
    private String password;

    public HMDataBaseConfig() {
    }

    public HMDataBaseConfig(String driverClass, String url, String user, String password) {
        this.driverClass = driverClass;
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

```

```
#配置文件
DataSourceName=domain.HMDataBaseConfig
driverClass=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/day16
user=root
password=abc
```



### 视频讲解

另附avi文件提供。

## 题目3（综合扩展）

题目2通过读取配置文件，创建父类或接口的子类或实现类对象。但是每次都写同样的代码,导致可读性差,代码臃肿。
为提高代码的维护和扩展性，以后做项目时，经常使用接口类型接收实现类对象，如果每次都像题目2中的代码，同样导致代码重复臃肿。

本题目要求定义工具类BeanFactory,内部定义静态方法newInstance读取.properties配置文件,获取接口名和对应的实现类名,通过反射创建实现类对象,方法参数传递接口的Class对象。配置文件如下图：

![](img/03_beans.jpg)

![](img\03_result.jpg)

### 训练目标

能够读取.properties文件,利用反射创建接口实现类对象。

### 训练提示

1、如何在方法参数中传递接口的名称?

2、如何让方法返回具体类型,而不是Object类型?

### 参考方案

使用Properties集合，IO流，反射创建接口实现类对象。

### 操作步骤

1、定义FlyAble接口,该接口中定义抽象方法fly

2、定义FlyAble接口实现类Bird,重写抽象方法fly

3、定义JumpAble接口,该接口中定义抽象方法jump

4、定义JumpAble接口实现类Cat,重写抽象方法jump

5、定义BeanFactory类,该类中定义newInstance方法

5.1、获取传递的接口名

5.2、通过类加载器,获取资源的字节输入流

5.3、创建Properties集合对象

5.4、Properties集合对象调用load方法，以键值对的方式加载配置文件信息

5.5、Properties集合对象调用getProperty方法，获取接口实现类的名称

5.6、反射创建对象并返回

5.7、出现异常返回null

6、定义测试类

​	



### 参考答案

beans.properties文件内容:

```xml
FlyAble=itheima03.Bird
JumpAble=itheima03.Cat
```

```java
//1、定义FlyAble接口,该接口中定义抽象方法fly
public interface FlyAble {
    public abstract void fly();
}
```

```java
//2、定义FlyAble接口实现类Bird,重写抽象方法fly
public class Bird  implements FlyAble{
    @Override
    public void fly() {
        System.out.println("鸟儿在飞....");
    }
}
```

```java
//3、定义JumpAble接口,该接口中定义抽象方法jump
public interface JumpAble {
    public abstract void jump();
}
```

```java
//4、定义JumpAble接口实现类Cat,重写抽象方法jump
public class Cat implements JumpAble {
    @Override
    public void jump() {
        System.out.println("猫儿在跳...");
    }
}
```

```java
//5、定义BeanFactory类,该类中定义newInstance方法
public class BeanFactory {
    public static <T> T newInstance(Class<T> clazz) {
        //5.1、获取传递的接口名
        String name = clazz.getSimpleName();
        //5.2、通过类加载器,获取资源的字节输入流
       InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");
        //5.3、创建Properties集合对象
        Properties props = new Properties();
        //5.4、Properties集合对象调用load方法，以键值对的方式架子配置文件信息
        props.load(inputStream);
        //5.5、Properties集合对象调用getProperty方法，获取接口实现类的名称
        String className = props.getProperty(name);
        //5.6、反射创建对象并返回
        try {
            return (T) Class.forName(className).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		//5.7、出现异常返回null
        return null;
    }   
}

```

```java
//6、定义测试类
public class Test03 {
    public static void main(String[] args) throws IOException {
        FlyAble flyAble = BeanFactory.newInstance(FlyAble.class);
        flyAble.fly();
        JumpAble jumpAble = BeanFactory.newInstance(JumpAble.class);
        jumpAble.jump();

    }
}
```

### 视频讲解

另附avi文件提供。

## 

## 题目4（综合扩展）

后面在学习web课程,会在页面上填写数据提交到服务器,在服务器中每次通过硬编码(new对象,然后使用对象调用set方法)的方式,给对象的属性赋值,非常麻烦,尤其是如果提交的数据非常多,这个问题将非常严重（如下图所示）。

![](img\04_location.jpg)

定义工具类HMBeanUtils，工具类中定义以下方法：

```
public static void setProperty(Object bean,String name,Object value)：功能给对象bean的属性name，赋值为value
```

```
public static String getProperty(Object bean,String name)：获取对象bean的name属性的值
```

```
public static void populate(Object bean,Map map)：把map集合中的键值对数据存储到对象bean中，map中的键代表对象的属性，map中的值代表对象属性的值
```

### 训练目标

能够使用反射获取属性字段并完成赋值。

### 训练提示

1、如何获取属性字段？

2、属性字段都是private修饰，如何赋值？

3、如何遍历Map集合对象，键作为对象属性，值作为对象属性的值，并完成赋值？

### 参考方案

使用反射完成对象属性的赋值

### 操作步骤

1、定义Person类，指定私有属性

2、定义工具类HMBeanUtils,构造方法私有

3、工具类HMBeanUtils,定义静态方法setProperty,完成给对象属性赋值

3.1、根据JavaBean对象获取对应的字节码对象

3.2、根据字节码对象获取对应的Field对象

3.3、取消 Java 语言访问检查

3.4、调用set方法,完成赋值

4、工具类HMBeanUtils,定义静态方法getProperty,根据对象属性名获取属性值

4.1、根据JavaBean对象获取对应的字节码对象

4.2、根据字节码对象获取对应的Field对象

4.3、取消 Java 语言访问检查

4.4、调用get方法,获取属性值

4.5、返回String形式的属性值

5、工具类HMBeanUtils,定义静态方法populate,把map集合中的键值对数据存储到对象bean中

5.1、根据JavaBean对象获取对应的字节码对象

5.2、获取Map中所有的键对应的Set集合

5.3、遍历所有的键对应的Set集合

5.4、根据键来获取对应的Field对象

5.5、根据键来获取Map中对应的value

5.6、取消 Java 语言访问检查

5.7、调用set方法,完成赋值

6、定义测试类,完成三个方法的测试

6.1、创建JavaBean对象

6.2、创建Map集合对象

6.3、Map集合对象添加数据

6.4、调用方法,把Map集合数据封装到对象中

6.5、打印对象

6.6、重新创建JavaBean对象

6.7、调用setProperty方法，给对象属性赋值

6.8、调用getProperty方法，获取对象属性值

6.9、打印结果

### 参考答案

```java
//1、定义Person类，指定私有属性
@Data
public class Person {
    private String name;
    private int age;
    private String gender;
    private String birthday;
}
```

```java
//2、定义工具类HMBeanUtils,构造方法私有
public class HMBeanUtils {
   	private HMBeanUtils() {}	
	//3、工具类HMBeanUtils,定义静态方法setProperty,完成给对象属性赋值
	public static void setProperty(Object bean,String name,Object value) throws Exception {
		//3.1、根据JavaBean对象获取对应的字节码对象
		Class clazz = bean.getClass();

		//3.2、根据字节码对象获取对应的Field对象
		Field f = clazz.getDeclaredField(name);

		//3.3、取消 Java 语言访问检查
		f.setAccessible(true);

		//3.4、调用set方法,完成赋值
		f.set(bean, value);
	}
	//4、工具类HMBeanUtils,定义静态方法getProperty,根据对象属性名获取属性值
	public static String getProperty(Object bean,String name) throws ReflectiveOperationException {

		//4.1、根据JavaBean对象获取对应的字节码对象
		Class clazz = bean.getClass();

		//4.2、根据字节码对象获取对应的Field对象
		Field f = clazz.getDeclaredField(name);

		//4.3、取消 Java 语言访问检查
		f.setAccessible(true);

		//4.4、调用get方法,获取属性值
		Object obj = f.get(bean);

		//4.5、返回String形式的属性值
		return obj.toString();
	}
	
	//5、工具类HMBeanUtils,定义静态方法populate,把map集合中的键值对数据存储到对象bean中
	public static void populate(Object bean,Map map) throws ReflectiveOperationException {

		//5.1、根据JavaBean对象获取对应的字节码对象
		Class clazz = bean.getClass();

		//5.2、获取Map中所有的键对应的Set集合
		Set keys = map.keySet();

		//5.3、遍历所有的键对应的Set集合
		for (Object key : keys) {
			try {
				//5.4、根据键来获取对应的Field对象
				Field f = clazz.getDeclaredField(key.toString());

				//5.5、根据键来获取Map中对应的value
				Object value = map.get(key);

				//5.6、取消 Java 语言访问检查
				f.setAccessible(true);

				//5.7、调用set方法,完成赋值
				f.set(bean, value);

			} catch(NoSuchFieldException e) {
				//e.printStackTrace();
			}
		}
	}
	
}

```



```java
//6、定义测试类,完成三个方法的测试
public class Test04 {
	public static void main(String[] args) throws ReflectiveOperationException {
		//6.1、创建JavaBean对象
		Person p = new Person();
		
		//6.2、创建Map集合对象
		Map map = new HashMap();
        //6.3、Map集合对象添加数据
		map.put("name", "zhaoliu");
		map.put("age", 20);
		map.put("gender", "other");
		map.put("birthday", "2041-01-04");
		//6.4、调用方法,把Map集合数据封装到对象中
		HMBeanUtils.populate(p, map);
        //6.5、打印对象
		System.out.println(p);
        System.out.println("-----------------------------------------------");
        
        //6.6、重新创建JavaBean对象
		p = new Person();
        //6.7、调用setProperty方法，给对象属性赋值
        HMBeanUtils.setProperty(p, "name", "wangwu");
		HMBeanUtils.setProperty(p, "age", 20);
        HMBeanUtils.setProperty(p, "gender", "男");
        HMBeanUtils.setProperty(p, "birthday", "2088-8-8");
        
        //6.8、调用getProperty方法，获取对象属性值
        String name = HMBeanUtils.getProperty(p, "name");
		String age = HMBeanUtils.getProperty(p, "age");
        String gender = HMBeanUtils.getProperty(p, "gender");
		String birthday = HMBeanUtils.getProperty(p, "birthday");
        
        //6.9、打印结果
        System.out.println(name);
		System.out.println(age);
        System.out.println(gender);
		System.out.println(birthday);
	}
}

```

### 视频讲解

另附avi文件提供。

## 题目5（综合扩展）

模拟Junit测试的注解@Test，@Before,@After，首先需要编写自定义注解@MyTest，@MyBefore,@MyAfter，并添加元注解，保证自定义注解只能修饰方法，且在运行时可以获得。

编写目标类（测试类），然后给目标方法（测试方法）使用 @MyTest注解,@MyBefore注解,@MyAfter注解，编写三个方法，其中两个加上@MyTest注解。

最后编写调用类，使用main方法调用目标类，模拟Junit的运行，只要有@MyTest注释的方法都会运行。

### 训练目标

能够自定义注解，并解析自定义注解。

### 训练提示

1、如何自定义注解，如何保证自定义注解只能修饰方法，且在运行时可以获得？

2、如何获取含有自定义注解@MyBefore和@MyAfter的方法?

3、如何在运行含有@MyTest注解的方法前运行含有@MyBefore注解的方法?

4、如何在运行含有@MyTest注解的方法后运行含有@MyAfter注解的方法?

### 参考方案

自定义注解,并使用反射解析自定义注解。

### 操作步骤

1、自定义注解@MyTest，保证自定义注解只能修饰方法，且在运行时可以获得。

2、自定义注解@MyBefore，保证自定义注解只能修饰方法，且在运行时可以获得。

3、自定义注解@MyAfter，保证自定义注解只能修饰方法，且在运行时可以获得。

4、定义目标类MyTargetClass

4.1、定义show方法,method方法，print方法，before方法，after方法

4.2、在show方法和print方法上添加@MyTest注解,在before方法上添加@MyBefore注解,在after方法上添加@Myafter注解

5、定义测试类Test05

5.1、获取Class类型的对象

5.2、快捷方式,创建对象

5.3、Class类型的对象获取所有的方法对象,方法对象数组

5.4、遍历方法对象数组,获取到MyBefore和MyAfter修饰的方法对象

5.5、遍历方法对象数组,对每个方法对象进行判断

	5.5.1、先执行MyBefore注解修饰的方法
	
	5.5.2、再执行MyTest注解修饰的方法
	
	5.5.3、最后执行MyAfter注解修饰的方法

### 参考答案

```java
//1、自定义注解@MyTest，保证自定义注解只能修饰方法，且在运行时可以获得。
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
}
```

```java
//2、自定义注解@MyBefore，保证自定义注解只能修饰方法，且在运行时可以获得。
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyBefore {
}
```

```java
//3、自定义注解@MyAfter，保证自定义注解只能修饰方法，且在运行时可以获得。
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAfter {
}
```

```java
//4、编写目标类MyTargetClass
//4.1、定义show方法,method方法，print方法，before方法，after方法
public class MyTargetClass {
    @MyTest
    public void show() {
        System.out.println("show...");
    }
    public void method() {
        System.out.println("method...");
    }
    @MyTest
    public void print() {
        System.out.println("print...");
    }

    @MyBefore
    public void before() {
        System.out.println("before....");
    }
    @MyAfter
    public void after() {
        System.out.println("after....");
    }    
}

```



```java
//5、定义测试类Test05
public class Test05 {
    public static void main(String[] args) throws Exception {
		//5.1、获取Class类型的对象
        Class<MyTargetClass> clazz = MyTargetClass.class;

        //5.2、快捷方式,创建对象
        Demo08MyJunit obj = clazz.newInstance();

        //5.3、Class类型的对象获取所有的方法对象,方法对象数组
        Method[] ms = clazz.getMethods();

        //5.4、遍历方法对象数组,获取到MyBefore和MyAfter修饰的方法对象
        Method beforeMethod = null;
        Method afterMethod = null;
        for (Method m : ms) {
            //如果方法上,含有MyBefore注解
            if(m.isAnnotationPresent(MyBefore.class)) {
                beforeMethod = m;
            }
            //如果方法上,还有MyAfter注解
            if(m.isAnnotationPresent(MyAfter.class)) {
                afterMethod = m;
            }

        }
        //5.5、遍历方法对象数组
        for (Method m : ms) {
            //判断,当前方法对象上是否具有MyTest注解
            if(m.isAnnotationPresent(MyTest.class)) {
                //如有具有MyTest注解
                //5.5.1、先执行MyBefore注解修饰的方法
                if(beforeMethod != null) {
                    beforeMethod.invoke(obj);
                }
                //5.5.2、再执行MyTest注解修饰的方法
                m.invoke(obj);
                //5.5.3、最后执行MyAfter注解修饰的方法
                if (afterMethod != null) {
                    afterMethod.invoke(obj);
                }
            }

        }
    }
}
```

### 视频讲解

另附avi文件提供。


