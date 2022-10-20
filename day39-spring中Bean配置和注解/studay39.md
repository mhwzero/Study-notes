# Bean配置
## 作用域
```markdown
* 在Spring中，对于bean支持多种作用域，常见的有下面几个：
    - singleton(默认)    单例模式，即对象只创建一次，然后一直存在
    - prototype          多例模式，即每次获取bean的时候，IOC都给我们创建一个新对象
    - request            web项目中，Spring创建一个Bean的对象，将对象存入到request域中
    - session            web项目中，Spring创建一个Bean的对象，将对象存入到session域中
```
```xml
<!--
        scope="singleton"  单例对象
        scope="prototype"  多例对象
-->
        <bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl"
              scope="prototype">
        </bean>
```
## 生命周期
```markdown
        init-method="对象创建之后执行的方法"
        destroy-method="对象销毁之前要执行的方法"
```
```xml
 <!--
        scope="singleton"  单例对象
        scope="prototype"  多例对象
        init-method="对象创建之后执行的方法"
        destroy-method="对象销毁之前要执行的方法"
        id:别名
        class:类的全名称
-->
        <bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl"
              scope="prototype"
              init-method="m1" destroy-method="m2">
        </bean>
```
1. 单例对象在对象spring容器(工厂)创建的时候创建并且只创建一次，而且当向spring要的时候，会将使用权给予，而不会将这个对象给予，随着容器的关闭而关闭
2. 多例模式在向spring容器要的时候创建，并且spring创建后会将改对象给予，所以改对象不会随着spring的关闭而关闭
## 依赖注入
    依赖注入其实就是给类中的成员变量赋值，赋值的方式有两种：有参构造和set方法赋值
### 1、有参构造
    配置文件applicationContext.xml中的写法
```xml
<!--
        constructor-arg: 构造函数赋值
        name: 构造函数中形参名称
        index="0": 构造函数中形参索引,一般省略
        type="java.lang.String" : 构造函数中形参类型,一般省略
        value="" 给参数赋的值(只能给简单[基本 + 包装 + 字符串]类型的参数赋值)
        ref=""   给参数赋的值(给参数对象赋值) 他的值是配置文件中某个bean标签的id属性
-->
        <bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl">
            <constructor-arg name="name" value="大壮"></constructor-arg>
            <constructor-arg name="age" value="18"></constructor-arg>
            <constructor-arg name="birthday" ref="birthday"></constructor-arg>
        </bean>
```
### 2、set方法赋值
    配置文件applicationContext.xml中的写法
```xml
<!--
        property: set方法对属性赋值
        name: 属性名称
        value="" 给属性赋的值(只能给简单[基本 + 包装 + 字符串]类型的参数赋值)
        ref=""   给属性赋的值(给参数对象赋值) 他的值是配置文件中某个bean标签的id属性
    -->
    <bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl">
        <property name="name" value="小壮"></property>
        <property name="age" value="17"></property>
        <property name="birthday" ref="birthday"></property>
    </bean>
```
## 多配置文件
```markdown
* 注意:
    1. 同一个xml文件中不允许出现相同id的bean，如果出现会报错
    2. 多个xml文件如果出现相同id的bean，不会报错，但是后加载的会覆盖前加载，所以尽量保证bean的名称是唯一的
```

```xml
<!--导入另外的配置文件-->
    <import resource="bean2.xml"></import>
```
# JdbcTemplate
## JdbcTemplate执行MySQL语言的三种方式
1. update():执行增删改操作
```java
 jdbcTemplate.update("MySQL语句",？占位符的值);
```
2. query():执行查询全部操作
```java
jdbcTemplate.query("MySQL语句",new BeanPropertyRowMapper<返回值对象>(返回值对象.class));
```
3. queryForObject():执行查询单个操作
```java
jdbcTemplate.queryForObject("MySQL语句",new BeanPropertyRowMapper<返回值对象>(返回值对象.class),name);
```
# 注解版Bean配置
## 类的创建
```markdown
* @Component
	用于实例化对象，相当于配置文件中的<bean id="" class=""/>
	它支持一个value属性，相当于xml中bean的id，如果不写，默认值为类名的首字母小写

* @Controller  @Service  @Repository
	这三个注解的功能跟@Component类似，他们分别标注在不同的层上。
        @Controller  标注在表示层的类上
        @Service     标注在业务层的类上
        @Repository  标注在持久层的类上
	推荐使用这三个，当一个类实在不好归属在这三个层上时，再使用@Component
```
## 作用域
```markdown
* @Scope用于指定bean的作用范围(单例和多例)，相当于配置文件中的<bean scope="">
    scope="singleton"  单例对象
    scope="prototype"  多例对象

```
## 生命周期
```markdown
@PostConstruct: 此注解标注的方法会在当前对象创建之后自动执行(标注方法跟@Test一样)    
@PreDestroy：   此注解标注的方法会在当前对象销毁之前自动执行(标注方法跟@Test一样)
这两个注解标注方法分别在对象的创建之后和销毁之前执行。
* 相当于<bean init-method="方法名" destroy-method="方法名" /> 

```
## 依赖注入
    set方法赋值
```markdown
@Autowired
	这个注解表示依赖注入，他可以标注在属性上，也可以标注在方法上，当@Autowired标注在属性上的时候，属性对应的set方法可以省略不写
	Spring会在他的IOC容器中按照被标注属性的类型进行寻找，如果查找到了一个就进行注入，如果查找不到或者查找到多个就报错
改注解每次只能标记一个成员变量，如果有多个成员变量则需要每个成员变量上面都写一个
@Qualifier
	跟@Autowired联合使用，代表在按照类型匹配的基础上，再按照id匹配

```
# 案例总结
##  maven导包
```xml
<dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.22</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.1.6.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.15</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.1.6.RELEASE</version>
        </dependency>
    </dependencies>
```
## 持久层dao
    接口
```java
package com.itmhw.dao;

import com.itmhw.domain.Account;

import java.util.List;

public interface AccountDao {
    //增加
    void save(Account account);
    //删除(通过ID删除)
    void delete(Integer aid);
    //修改(通过name修改balance)
    void update(Account account);
    //查询所有
    List<Account> findAll();
    //查询单个(通过name查询)
    Account findByName(String name);
}
```
    实现类
```java
package com.itmhw.dao.impl;

import com.itmhw.dao.AccountDao;
import com.itmhw.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void save(Account account) {
        jdbcTemplate.update("insert into account values (null,?,?)",account.getName(),account.getBalance());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from account where aid = ?",id);
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update("update account set balance = ? where name = ?",account.getBalance(),account.getName());
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account findByName(String name) {
        return jdbcTemplate.queryForObject("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
    }
}

```
## 业务层service
    接口
```java
package com.itmhw.service;

import com.itmhw.domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);
    void delete(Integer id);
    void update(Account account);
    List<Account> findAll();
    Account findByName(String name);
}
```
    实现类
```java
package com.itmhw.service.impl;

import com.itmhw.dao.AccountDao;
import com.itmhw.domain.Account;
import com.itmhw.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findByName(String name) {
        return accountDao.findByName(name);
    }
}

```
## applicationContext.xml文件的配置 
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
			    http://www.springframework.org/schema/beans/spring-beans.xsd
			    http://www.springframework.org/schema/context
			    http://www.springframework.org/schema/context/spring-context.xsd">

    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
        <property name="url" value="jdbc:mysql://localhost:3306/db1??characterEncoding=utf8"></property>
        <property name="username" value="root"></property>
        <property name="password" value="123"></property>
    </bean>

    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
    <context:component-scan base-package="com.itmhw"></context:component-scan>
</beans>
```
