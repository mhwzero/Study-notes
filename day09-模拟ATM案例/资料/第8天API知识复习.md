# API

什么是API：应用程序编程接口，是Java为我们写好的一些程序，我们可以直接调用

# String

## String是什么

String代表一个字符串，可以用来封装一段字符串

## 怎样得到一个字符串

```
第一种：直接使用""，这也是我们建议的使用方式
第二种：构造器
	String s1 = new String();	// 得到一个空字符串，相当于直接使用""
	String s2 = new String("love");	// 不建议使用，相当于String s2 = "love";
	
第三种：接收字符数组作为参数
	char[] chs = {'a', 'b', 'c'};
	String s3 = new String(chs);
	
第四种：接收字节数组作为参数
	byte[] bytes = {97, 98, 99};
	String s4 = new String(bytes);
```

## String非常重要的一个特性：不可变性

因为我们对字符串的每一次修改，实际上是产生了一个新的对象

## 从内存的角度看

```
直接使用""给出的字符串位于字符串常量池中，相同内容只存储一份
运算得到的字符串位于堆内存
new出来的字符串位于堆内存
```

## 几道面试笔试题

```
String s1 = "abc";
String s2 = "abc";
sout(s1 == s2);	// true, 因为都位于字符串常量池
char[] chs = {'a', 'b', 'c'};
String s3 = new String(chs);
sout(s1 == s3);	// s1位于字符串常量池，s3位于堆内存
String s4 = new String(chs);
sout(s3 == s4);	// 每次new实际上是产生了一个新的对象
String s5 = "a" +"b" + "c";
sout(s3 == s5);	// false s5位于字符串常量池，s3位于堆内存
sout(s2 == s5);	// true 编译期优化
```

## String类常用API

| API                                     | 说明                                 |
| --------------------------------------- | ------------------------------------ |
| equals(String str)                      | 比较字符串内容是否相同               |
| equalsIgnoreCase(String str)            | 忽略大小写比较字符串内容             |
| length()                                | 获取字符串长度                       |
| charAt(int index)                       | 获取指定锁定处的字符                 |
| toCharArray()                           | 将字符串转换成字符数组               |
| subString(int beginIndex, int endIndex) | 截取指定范围内的子字符串，包前不包后 |
| subString(int beginIndex)               | 截取指定索引位置到末尾的子字符串     |
| split(String regex)                     | 根据指定的规则切分字符串             |
| replace(String oldChar, String newChar) | 将字符串中所有前面部分替换成后面部分 |



# ArrayList

 ## 是集合的一种

什么是集合？集合也是一种容器

## ArrayList和数组的区别

数组一旦定义完成并启动，类型确定，长度不变

ArrayList长度可以改变，类型可以选择不固定

## 怎样得到一个ArrayList对象

```
ArrayList list = new ArrayList();
```

## ArrayList对泛型的支持

```
ArrayList<String> list = new ArrayList<>();
ArrayList<Integer> list = new ArrayList<>();
ArrayList<Double> list = new ArrayList<>();
```

ArrayList和泛型都只支持引用数据类型，不支持基本数据类型

## ArrayList常用API

| API                 | 说明                           |
| ------------------- | ------------------------------ |
| add(E e)            | 将元素添加到集合的末尾         |
| add(int index, E e) | 将元素添加到集合指定的索引位置 |
| get(int index)      | 根据索引获取一个元素           |
| size()              | 获取ArrayList集合中元素的个数  |
| remove(int index)   | 根据索引删除元素               |
| remove(E e)         | 删除指定内容的元素             |
| set(int index, E e) | 修改指定索引位置处的元素       |

## ArrayList边遍历边删除元素

如果直接从前面删除，可能会出现漏删数据的问题

2种解决方法：

1. 从前往后遍历，每删除一个元素，索引i--;
2. 从后往前遍历

## ArrayList存储自定义类型元素

```
ArrayList<Movie> movies = new ArrayList<>();
```

## ArrayList搜索元素

```
public Student getStudentById(ArrayList<Student> students, int id) {
	for(int i = 0; i < students.size(); i++) {
		if(students.get(i).getId() == id) {
			// 找到了
			return students.get(i);
		}
	}
	return null;
}
```

