# <center>面试题</center>
[toc]
## 1、JVM运行时数据区描述一下及每个区的作用
|序号|区域名称|共享|作用|异常|备注|
|:---|:---:|:---:|:---:|:---:|---:|
|1|程序计数器|线程私有|记录当前线程锁执行的字节码行号指示器。|Java虚拟机规范中唯一一个没有规定OutOfMemoryError(内存不足错误)的区域。|--|
|2|Java虚拟机|线程私有|存放局部变量表、操作数据栈、动态链接、方法出口等信息。|栈深大于允许的最大深度，抛出StackOverflowError(栈溢出错误)。|常说的“栈”说的就是Java虚拟机栈，或者是Java虚拟机栈中的局部变量表。|
|3|本地方法栈|线程私有|和Java虚拟机栈类似，不过是为JVM用到的Native方法服务。|同上||
|4|Java堆|线程共享|存放实例化数据。|内存不足时，抛出OutOfMemoryError(内存不足错误)。|通过-Xmx和-Xms控制大小。GC的主要管理对象。|
|5|方法区|线程共享|存放类信息（版本、字段、方法、接口等）、常量、静态变量、即时编译后的代码等数据。|内存不足时，抛出OutOfMemoryError(内存不足错误)。|--|
|6|运行时常量池|线程共享|存放编译期生成的各种字面量和符号引用。|内存不足时，抛出OutOfMemoryError(内存不足错误)。|属于“方法区”的一部分。|
|7|直接内存|--|如NIO可以使用Native函数库直接分配堆外内存，该内存受计算机内存限制。|内存不足时，抛出OutOfMemoryError(内存不足错误)。|不是JVM运行时数据区的一部分，也不是JVM虚拟机规范中定义的内存区域。但这部分内存也被频繁的使用。所以放到一起。

[JVM运行时数据区描述一下及每个区的作用](https://cloud.tencent.com/developer/article/1793351)
## 2、静态变量与实例变量区别？
```
静态变量前要加上关键字static，实例变量则不会。

实例变量是属于某个对象的属性，必须创建了实例对象，其中的实例变量才会分配空间，才能使用这个实例变量。
静态变量不属于任何的实例对象，而是属于类，也称为类变量，只要程序加载了类的字节码，不用创建任何实例对象，就会被分配空间。
总之就是，静态变量不需要创建任何的对象就可以直接使用，而实例变量需要先创建实例对象才能被使用。
```
## 3、String类的常用方法有哪些?
```
1、和长度有关：

int length() 得到一个字符串的字符个数
2、和数组有关：


byte[] getByte() ) 将一个字符串转换成字节数组
char[] toCharArray() 将一个字符串转换成字符数组
String split(String) 将一个字符串按照指定内容劈开

3、和判断有关：


boolean equals() 判断两个字符串的内容是否一样
boolean equalsIsIgnoreCase(String) 忽略太小写的比较两个字符串的内容是否一样
boolean contains(String) 判断一个字符串里面是否包含指定的内容
boolean startsWith(String) 判断一个字符串是否以指定的内容开头
boolean endsWith(String) 判断一个字符串是否以指定的内容结尾

4、和改变内容有关：


String toUpperCase() 将一个字符串全部转换成大写
String toLowerCase() 将一个字符串全部转换成小写
String replace(String,String) 将某个内容全部替换成指定内容
String replaceAll(String,String) 将某个内容全部替换成指定内容，支持正则
String repalceFirst(String,String) 将第一次出现的某个内容替换成指定的内容
String substring(int) 从指定下标开始一直截取到字符串的最后
String substring(int,int) 从下标x截取到下标y-1对应的元素
String trim() 去除一个字符串的前后空格

5、和位置有关：


char charAt(int) 得到指定下标位置对应的字符
int indexOf(String) 得到指定内容第一次出现的下标
int lastIndexOf(String) 得到指定内容最后一次出现的下标

```
## 4、接口和抽象类的区别是什么？
```
1、最重要的区别是，接口的方法不可以有实现，并且是绝对的抽象方法。抽象类可以有实例方法用来实现默认行为。
2、接口中的变量申明默认是final, 而抽象类中变量申明可以是非final。
3、接口中的成员默认是public修饰，而抽象类中成员可以是private, protected等等。
4、接口通过关键字implements被其他类实现，而抽象类则是通过extends关键字被其他类扩展.
5、接口可以扩展（extends）另外一个/或多個接口，抽象类可以扩展（extends）另一个Java类并(或)实现（implements）多个Java接口.
6、Java类可以实现多个接口但是只能扩展一个抽象类.
7、接口是绝对抽象而且无法实例化，抽象类也无法实例化但是如果类中有main()方法是可以被调用的。
8、与抽象类相比，接口更慢，因为它需要额外的间接寻址。
```
## 5、Java 中的 final 关键字有哪些用法
```
当final修饰变量时，被修饰的变量必须被初始化(赋值)，且后续不能修改其值，实质上是常量；
当final修饰方法时，被修饰的方法无法被所在类的子类重写（覆写）；
当final修饰类时，被修饰的类不能被继承，并且final类中的所有成员方法都会被隐式地指定为final方法，但成员变量则不会变。
```
## 6、StringBuffer、StringBuilder的区别是什么？
```

```
## 7、String str = “i” 和String str = new String(“1”)一样吗？
```
因为内存的分配方式不一样。String str="i"的方式，Java 虚拟机会将其分配到常量池中；
而 String str=new String(“i”)方式，则会被分到堆内存中，但进入堆内存的时候会先进入堆常量池中是否有这个常量，
如果没有则将堆常量写入，再写入堆内存中。
```
##8、重载(overload)和重写(override)的区别?
```
方法的重写(Overriding)和重载(Overloading)是java多态性的不同表现，重写是父类与子类之间多态性的一种表现，重载可以理解成多态的具体表现形式。

(1)方法重载是一个类中定义了多个方法名相同,而他们的参数的数量不同或数量相同而类型和次序不同,则称为方法的重载(Overloading)。
(2)方法重写是在子类存在方法与父类的方法的名字相同,而且参数的个数与类型一样,返回值也一样的方法,就称为重写(Overriding)。
(3)方法重载是一个类的多态性表现,而方法重写是子类与父类的一种多态性表现
```
## 9、Java 中的值传递和引用传递
```
1）、值传递 在方法的调用过程中，实参把它的实际值传递给形参，此传递过程就是将实参的值复制一份传递到函数中，
这样如果在函数中对该值（形参的值）进行了操作将不会影响实参的值。因为是直接复制，所以这种方式在传递大量数据时，运行效率会特别低下。

2）、引用传递 引用传递弥补了值传递的不足，如果传递的数据量很大，直接复过去的话，会占用大量的内存空间，
而引用传递就是将对象的地址值传递过去，函数接收的是原始值的首地址值。在方法的执行过程中，形参和实参的内容相同，指向同一块内存地址，
也就是说操作的其实都是源数据，所以方法的执行将会影响到实际对象。

总的来说:
引用类型传引用，形参和实参指向同一个内存地址（同一个对象），所以对参数的修改会影响到实际的对象。
```
##10、关于==与equals的区别
```
     ==：一般用于基本数据类型的比较，在引用数据类型中比较的是地址
     equals：一般用于引用数据类型的比较，比较的是内容是否相等。格式为：值1.equals(值2)
注意： instanceof：一般用于类的比较。格式为：变量名 instanceof 类型 
 通俗的理解为：判断关键字左边的变量，是否是右边的类型，放回boolean类型结果
```
## 11、sleep和wait的区别？ 
```
     sleep是让线程休眠，到时间后会继续执行;
     wait是等待，需要唤醒再继续执行，
     
使用方面：
        从使用的角度来看sleep方法是Thread线程类的方法，而wait是Object顶级类的方法。
        sleep可以在任何地方使用，而wait只能在同步方法和同步块中使用。
CPU及锁资源释放:
        sleep、wait调用后都会暂停当前线程并让出CPU的执行时间，但不同的是sleep不会释放当前持有对象的锁资源，到时间后会继续执行，而wait会释放所有的锁并需要notify/notifyAll后重新获取到对象资源后才能继续执行。
        异常捕获方面：
        sleep需要捕获或者抛出异常，而wait/notify/notifyAll则不需要。
```
## 12、请写出你最常见的几个 Runtime Exception？与非运行时异常的区别？
```
常见的 Runtime Exception：
1、NullPointerException － 当调用一个未初始化的引用变量（实际值为null）的实例Field、实例方法时都会引发该异常。
2、ArithmeticException － 算术异常。比如5/0将引发该异常。
3、ArrayIndexOutOfBoundsException：数组索引越界异常。
4、ClassCastException：类型转换异常。
5、IllegalArgumentException：参数非法的异常。

```
## 13、try catch有return，发生异常，走return还是finally
```
1、finally块的语句在try或catch中的return语句执行之后返回之前执行。
2、finally语句块不改变栈中的值y，可改变堆中的值。
y的类型如果是基本类型，其临时存放在栈中，则在finally块里被修改也不影响y，如果是存放在堆中的引用类型则可以。finally块里改变文本字符串也不影响y。
3、finally里的return语句覆盖try或catch中的return语句直接返回。
```
![try catch、return、finally的执行顺序](https://www.cnblogs.com/east7/p/14533249.html)
## 14、Java注解可以加在什么地方？Java自带注解有哪些？哪里有用到注解？
```

```
## 15、什么是双亲委派模型？为什么要使用双亲委派模型
```

```
## 16、浅拷贝和深拷贝区别
```

```
## 17、Java内存泄漏
```

```
## 18、集合类中主要有几种接口
```

```
## 19、HashSet如何检查重复？
```

```
## 20、HashMap和HashSet区别？
|HashMap|HashSet|
|:---:|:---:|
|实现了Map接口|实现了Set接口|
|存储键值对|仅存储对象|
|调用put()方法向map中添加元素|调用add方法向Set()中添加元素|
|HashMap使用键(key)计算Hashcode|HashSet使用成员对象来计算hashcode值，对于两个对象来说hashcode可能相同，所以equals()方法用来判断对象的相等性，如果两对象不同的话，返回false|
|HashMap相对于HashSet较快，因为它是使用唯一的键获取对象|HashSet较HashMap来说比较慢|
    HashMap相较于HashSet较快，因为它是使用唯一的键获取对象，HashSet较HashMap来说比较慢
## 21、HashMap底层实现原理是什么？
```

```
## 22、Hashtable与HashMap有什么不同之处？
```

```
## 23、红黑树有什么特征？
```

```
## 24、字节流和字符流区别？
```

```
## 25、BIO和NIO区别？
```

```
## 26、创建线程有几种方式？
```

```
## 27、线程的状态转换？
```

```
## 28、start和run的区别？
```

```
## 29、创建线程池的核心参数有哪些？
```

```
## 30、Synchronized作用，Synchronized 和 volatile 的区别
```

```