package com.itheima.test04;

import java.util.HashMap;
import java.util.Map;
/*
	第四题:
		后面在学习web课程,会在页面上填写数据提交到服务器,
		在服务器中每次通过硬编码(new对象,然后使用对象调用set方法)的方式,
		给对象的属性赋值,非常麻烦,尤其是如果提交的数据非常多,这个问题将非常严重。

	本题目要求:
		定义工具类HMBeanUtils，工具类中定义以下方法：
		public static void setProperty(Object bean,String name,Object value)：
			功能给对象bean的属性name，赋值为value

		public static String getProperty(Object bean,String name)：
			获取对象bean的name属性的值

		public static void populate(Object bean,Map map)：
			把map集合中的键值对数据存储到对象bean中，map中的键代表对象的属性，map中的值代表对象属性的值

	实现步骤:
		1.定义标准的java类(JavaBean)Person类,定义成员变量,空参/满参构造,toString方法,set/get方法
		2.定义工具类HMBeanUtils,私有构造方法
		3.在工具类HMBeanUtils中定义静态方法setProperty,作用是给指定对象的指定属性(成员变量)赋值指定的值
			3.1 获取bean对象对应的Class类型的对象
			3.2 通过Class类型的对象获取指定字段name对应的Field对象(getDeclaredField方法)
			3.3 取消java语言的访问检查
			3.4 Field对象调用set方法,完成成员变量的赋值

		4.在工具类HMBeanUtils中定义静态方法getProperty,作用是获取指定对象的指定行属性的值
			4.1 获取bean对象对应的Class类型的对象
			4.2 通过Class类型的对象获取指定字段name对应的Field对象(getDeclaredField方法)
			4.3 取消java语言的访问检查
			4.4 Field对象调用get方法,获取成员变量指定属性name对应的值(Object类型的)
			4.5 返回对应的String类型的结果

		5.在工具类HMBeanUtils中定义静态方法populate,作用是把map集合中的键值对数据存储到对象bean中，
			map中的键代表对象的属性，map中的值代表对象属性的值
			5.1 获取bean对象对应的Class类型的对象
			5.2 获取Map集合对象所有的键(属性名/成员变量名称)对应的Set集合对象
			5.3 遍历所有的键(属性名/成员变量名称)对应的Set集合对象
			5.4 获取当前的键name(属性名/成员变量名称)
			5.5 根据当前的键,获取对应的值value(成员变量对应的值)
			5.6 通过Class类型的对象获取指定字段name对应的Field对象(getDeclaredField方法)
			5.7 取消java语言的访问检查
			5.8 Field对象调用set方法,完成成员变量的赋值(value)

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

 */
public class Test04 {
	public static void main(String[] args) throws Exception {
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
