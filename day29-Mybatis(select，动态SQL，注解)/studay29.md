# Mybatis(select,动态SQL,注解)  
[toc]
# 查询
    采用了一个工具类
```java
public class MybatisUtil {
    private MybatisUtil(){}
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        try {
            //1、读取配置文件，读成数据流
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2、创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    public static void commitAndClose(SqlSession sqlSession){
        //5、提交事务(mybatis默认下，不会自动提交事务)
        sqlSession.commit();
        //6、释放资源
        sqlSession.close();
    }
}
```
    测试中事先声明的代码
```java
private SqlSession sqlSession = null;
    @Before//标注的方法会在Test方法之前运行
    public void before(){
        sqlSession = MybatisUtil.getSqlSession();
    }

    @After//标注的方法会在Test方法之后运行
    public void after(){
        MybatisUtil.commitAndClose(sqlSession);
    }
```
## 查询所有
### resultType和resultMap的区别
    当数据库中表内容的属性与实体类的成员变量相同时使用resultType
    当数据库中标的内容属性与实体类的成员变量不相同时使用resultMap，因为resultMap可以自定义一套映射
    格式：
```xml
    <!--resultMap 自定义一套映射关系
            id: 标识
            type: 结果集要映射到哪个实体类
        result 表示一条映射规则(对于主键列,一般是用id替代)
            column : 代表数据库返回结果中列
            property: 代表的是实体类中属性-->
<resultMap id="userMap" type="com.itheima.domain.User">
    <id column="uid" property="uid"></id>
    <result column="username" property="name"></result>
    <result column="password" property="password"></result>
    <result column="email" property="email"></result>
    <result column="birthday" property="birthday"></result>
</resultMap>
<!--下面的resultMap指向的是上面resultMap中id的内容-->
<select id="findAll2" resultMap="userMap">
select uid,name as username,password,email,birthday from user
</select>
```
### 接口
```java
//查询所有
    List<User> findAll();

    //查询所有
    List<User> findAll2();
```
### 映射
```xml
<!--
        对于查询来讲,一定要声明resultType,
        无论返回的是一个List<User>, 还是User, resultType="实体类类型"
    -->
    <select id="findAll" resultType="com.itheima.domain.User">
        select * from user
    </select>

    <resultMap id="userMap" type="com.itheima.domain.User">
        <id column="uid" property="uid"></id>
        <result column="username" property="name"></result>
        <result column="password" property="password"></result>
        <result column="email" property="email"></result>
        <result column="birthday" property="birthday"></result>
    </resultMap>
    <select id="findAll2" resultMap="userMap">
        select uid,name as username,password,email,birthday from user
    </select>
```
### 测试
```java
    @Test
    public void testFindAll() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindAll2() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll2();
        for (User user : userList) {
            System.out.println(user);
        }
    }
```
## 单条查询
### 接口
```java
//主键查询
    User findByUid(Integer uid);
```
### 映射
```xml
<select id="findByUid" parameterType="java.lang.Integer"
            resultType="com.itheima.domain.User">
        select * from user where uid = #{uid}
</select>
```
### 测试
```java
    @Test
    public void testFindByUid() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findByUid(1);
        System.out.println(user);
    }
```
## 多条查询
### 接口
```java
    //用户名和密码查询
    List<User> findByNameAndPassword1(
            @Param("username") String name,
            @Param("password") String password);
    //方式二
    List<User> findByNameAndPassword2(User user);
```
### 映射
```xml
<!--
        parameterType 是可以省略的
            select * from user where name = #{arg0} and password = #{arg1}
            select * from user where name = #{param1} and password = #{param2}
        #{}: 占位符,相当于JDBC中的?,里面的值
            1) 如果传入的参数是一个对象类型,#{}中里面写的就是对象中得属性名
            2) 如果传入的参数是一个简单类型(8种基本+8种包装+String),#{}可以随便写,推荐写方法形参
            3) 如果传入的参数是多个,我们要使用@Param("")注解在参数之前声明#{}里的内容
    -->
    <select id="findByNameAndPassword1" resultType="com.itheima.domain.User">
        select * from user where name = #{username} and password = #{password}
    </select>

    <select id="findByNameAndPassword2" resultType="com.itheima.domain.User">
        select * from user where name = #{name} and password = #{password}
    </select>
```
### 测试
```java
@Test
    public void testFindByNameAndPassword1() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findByNameAndPassword1("黑马","123");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByNameAndPassword2() {
        User userParam = new User();
        userParam.setName("黑马");
        userParam.setPassword("123");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findByNameAndPassword2(userParam);
        for (User user : userList) {
            System.out.println(user);
        }
    }
```
## 模糊查询
### 接口
```java
 //根据name模糊查询
    List<User> findByNameLike(String name);
```
### 映射
```xml
<!--
        select concat('黑','马') 拼接
    -->
    <select id="findByNameLike" resultType="com.itheima.domain.User">
        select * from user where name like concat('%',#{name},'%')
    </select>

    <!--尽量使用#{}-->
<!--    <select id="findByNameLike" resultType="com.itheima.domain.User">
        select * from user where name like "%${name}%"
    </select>-->
```
### 测试
```java
 @Test
    public void testFindByNameLike() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findByNameLike("黑马");
        for (User user : userList) {
            System.out.println(user);
        }
    }
```
## 返回主键
### 接口
```java
    void save(User user);
```
### 映射
```xml
<!--
        useGeneratedKeys="true": 告诉mybatis在保存完成之后,需要立即将主键返回来
         keyProperty="uid" : 返回的主键的值会赋值到传入参数的哪个属性上
    -->
    <insert id="save" parameterType="com.itheima.domain.User"
        useGeneratedKeys="true" keyProperty="uid">
        insert into user(uid,name,password,email,birthday)
        values(null,#{name},#{password},#{email},#{birthday})
    </insert>
```
### 测试
```java
@Test
    public void testSave() throws IOException {
        User user = new User();
        user.setName("黑马");
        user.setPassword("123");
        user.setBirthday(new Date());
        user.setEmail("123@itcast.cn");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //UserMapper.save
        mapper.save(user);
        System.out.println(user.getUid());
    }
```
# 动态SQL(采用标签)
## concat
    使用方式看上面的模糊查询
## if
### 接口
```java
 //if：根据User中不为空的属性进行查询
    List<User> findByUser1(User user);
```
### 映射
```xml
<select id="findByUser1" parameterType="User" resultType="com.itheima.domain.User">
        select * from user
    <where>
        <if test="name != null and name != ''">
            and name = #{name}
        </if>
        <if test="email != null and email !=''">
            and email = #{email}
        </if>
    </where>
    </select>
```
### 测试
```java
@Test
    public void testUpdate() {
        //0. 准备一个User对象
        User user = new User();
        user.setName("王五");
        user.setPassword("123");
        user.setBirthday(new Date());
        user.setEmail("123@itcast.cn");
        user.setUid(7);
        //System.out.println(user.getName());
        //约定大于编程
        //4. 通过sqlSession对象获取UserMapper的对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //UserMapper.save
        mapper.update(user);
    }
```
## choose
### 接口
```java
//choose:根据User中第一个不为空的属性进行查询
    List<User> findByUser2(User user);
```
### 映射
```xml
<select id="findByUser2" resultType="com.itheima.domain.User">
    select * from user
<where>
    <choose>
        <when test="name != null and name != ''">
            name = #{name}
        </when>
        <when test="mail != null and name != ''">
            email = #{email}
        </when>
    </choose>
</where>

</select>
```
### 测试
```java
@Test
    public void testFindByUser1(){
        //准备一个对象
        User user = new User();
        user.setName("李四");
        user.setEmail("123@itcast.cn");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findByUser1(user);
        for (User user1 : list) {
            System.out.println(user1);
        }
    }
```
## set
### 接口
```java
 void update(User user);
```
### 映射
```xml
<update id="update" parameterType="com.itheima.domain.User">
        update user
        <set>
            <if test="name != null and name != ''">
                name=#{name},
            </if>
            <if test="password != null and password != ''">
                password = #{password},
            </if>
            <if test="email != null and email != ''">
                email = #{email},
            </if>
            <if test="birthday != null and email !=''">
                birthday = #{birthday},
            </if>
        </set>
        where uid = #{uid}
    </update>
```
### 测试
```java
@Test
    public void testFindByUser2(){
        //准备一个对象
        User user = new User();
        user.setName("李四");
        user.setEmail("123@itcast.cn");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findByUser2(user);
        for (User user1 : list) {
            System.out.println(user1);
        }
    }
```
## foreach
### 接口
```java
//根据uids查询
    List<User> findByUids1(List<Integer> uids);

    List<User> findByUids2(Integer[] uids);

    List<User> findByUids3(User user);

```
### 映射
```xml
<!--
        select * from user where uid in (3,5,7)
        List======> (3,5,7,9)
        collection="遍历数据"
            collection: 方法传入的参数为集合类型
            array : 方法传入的参数为数组类型
            属性   : 方法传入的参数为一个对象
        item="临时变量"
        separator="分隔符"
        open="开始"
        close="结束"
    -->
    <select id="findByUids1" resultType="com.itheima.domain.User">
        select * from user where uid in
        <foreach collection="collection" item="it" separator="," open="(" close=")">
            #{it}
        </foreach>
    </select>

    <select id="findByUids2" resultType="com.itheima.domain.User">
        select * from user where uid in
        <foreach collection="array" item="it" separator="," open="(" close=")">
            #{it}
        </foreach>
    </select>

    <select id="findByUids3" resultType="com.itheima.domain.User">
        select * from user where uid in
        <foreach collection="uids" item="it" separator="," open="(" close=")">
            #{it}
        </foreach>
    </select>
```
### 测试
```java
 @Test
    public void testFindByUids1(){
        //指定数据源---collection
        List<Integer> collection = new ArrayList<Integer>();
        collection.add(3);
        collection.add(5);
        collection.add(7);


        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findByUids1(collection);
        for (User user : userList) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindByUids2(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findByUids2(new Integer[]{3,5,7});
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByUids3(){
        User userParam = new User();
        userParam.setUids(new Integer[]{3,5,7});
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findByUids3(userParam);
        for (User user : userList) {
            System.out.println(user);
        }
    }

```
## sql片段
    将上述中采用foreach完成查询映射修改
### 映射
```xml
<select id="findByUids1" resultType="com.itheima.domain.User">
        <include refid="myid"></include>
        <foreach collection="collection" item="it" separator="," open="(" close=")">
            #{it}
        </foreach>
    </select>

    <select id="findByUids2" resultType="com.itheima.domain.User">
        <include refid="myid"></include>
        <foreach collection="array" item="it" separator="," open="(" close=")">
            #{it}
        </foreach>
    </select>

    <select id="findByUids3" resultType="com.itheima.domain.User">
        <include refid="myid"></include>
        <foreach collection="uids" item="it" separator="," open="(" close=")">
            #{it}
        </foreach>
    </select>

    <!--
       sql片段,
       id : 标识
       include: 引入片段
    -->
    <sql id="myid">
        select * from user where uid in
    </sql>
```
# 注解
    采用注解可以不写但是不建议使用注解来完成动态SQL，使用注解完成动态SQL较于xml比较麻烦，所以使用动态SQL的时候采用xml
## 增删改查
### 接口
```java
    @Insert("insert into user values(null,#{name},#{password},#{email},#{birthday})")
    void insert(User user);
    @Update("update user set name = #{name} where uid =#{uid}")
    void update(User user);
    @Delete("delete from user where uid = #{uid}")
    void delete(Integer id);
    //查询全部
    @Select("select * from user")
    List<User> findAll();
```
### 测试
```java
public class MyBatisTest {
    private SqlSession sqlSession = null;
    @Before//标注的方法会在Test方法之前运行
    public void before(){
        sqlSession = MybatisUtil.getSqlSession();
    }

    @After//标注的方法会在Test方法之后运行
    public void after(){
        MybatisUtil.commitAndClose(sqlSession);
    }
    @Test
    public void testInsert(){
        //0. 准备一个User对象
        User user = new User();
        user.setName("张三");
        user.setPassword("111");
        user.setBirthday(new Date());
        user.setEmail("123@itcast.cn");
        //约定大于编程
        //4. 通过sqlSession对象获取UserMapper的对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //UserMapper.save
        mapper.insert(user);
    }
    @Test
    public void testUpdate() {
        //0. 准备一个User对象
        User user = new User();
        user.setName("李四");
        user.setUid(10);
        //约定大于编程
        //4. 通过sqlSession对象获取UserMapper的对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //UserMapper.save
        mapper.update(user);

    }

    @Test
    public void testDate() {
        //约定大于编程
        //4. 通过sqlSession对象获取UserMapper的对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //UserMapper.save
        mapper.delete(10);

    }
    @Test
    public void testSelect(){
        //约定大于编程
        //4. 通过sqlSession对象获取UserMapper的对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); //UserMapper.save
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
```
# 配置文件
```
* sqlMapConfig.xml 此文件中的标签有严格的顺序要求, 可以省略一部分, 但是不能乱序
* 主要选项
	properties: 引入外部的properties文件
	typeAlias: 给映射文件中实体类起别名
	environments: 用于配置数据库连接信息和事务管理器
	mappers: 用于引入映射文件
```
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!--读取一个外部的properties文件-->
    <properties resource="db.properties"></properties>

    <typeAliases>
        <!--方式1: type: 原类型  alias 别名-->
        <!--<typeAlias type="com.itheima.domain.User" alias="user"/>-->
        <!--方式2: 指定一个包名, 默认情况下包中所有类都会自动产生一个别名,规则就是类名首字母小写-->
        <!--<package name="com.itheima.domain"/>-->
    </typeAliases>

    <!--数据库连接信息  default: 默认哪个库生效-->
    <environments default="development">
        <!--一个数据库连接 -->
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>

        <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>

    <!--导入sql所在的文件-->
    <mappers>
        <!--   方式一：直接指定SQL文件位置     -->
        <!--        <mapper resource="UserMapper.xml"/>-->
        <!--    方式一另一种形式：指定接口的的文件位置，但需要SQL文件映射和接口文件最后在同一个目录中，方式：在resources包中创建一个跟接口所在的java包中的路径名一样的路径，注意的是在resources中不能使用 . 来连接应使用\    -->
        <!--        <mapper class="com.itheima.mapper.UserMapper"/>-->
        <!--    方式二： 直接写接口包名(注意的是要和上面的情况一样)   -->
        <package name="com.itheima.mapper"/>
    </mappers>
</configuration>
```
## 重要的总结
### MySQL中的#{}，${}的区别与使用
```
#{}的使用：
#{}: 占位符,相当于JDBC中的 ? 里面的值
            1) 如果传入的参数是一个对象类型,#{}中里面写的就是对象中得属性名
            2) 如果传入的参数是一个简单类型(8种基本+8种包装+String),#{}可以随便写,推荐写方法形参
            3) 如果传入的参数是多个,我们要使用@Param("")注解在参数之前声明#{}里的内容
  如果不采用 3 中方式的话，传入的多个参数的时候，通过反射或的是一个数组，那便会有特定的获取方式，不能随便写          
```
```
#{}和${}的区别：
    #表示占位符，相当于JDBC中的?，底层工作的是PreparedStetement对象，SQL只编译一次，而且没有SQL注入问题
    $ 表示字符串拼接，底层工作的是Statement对象，每次SQL都会重新编译，而且存在SQL注入问题(输入的字段可能是MySQL语句的特殊意义)
```
### resultMap和resultType
```
当数据库中表内容的属性与实体类的成员变量相同时使用resultType
    当数据库中标的内容属性与实体类的成员变量不相同时使用resultMap，因为resultMap可以自定义一套映射
    格式：
```
```xml
    <!--resultMap 自定义一套映射关系
            id: 标识
            type: 结果集要映射到哪个实体类
        result 表示一条映射规则(对于主键列,一般是用id替代)
            column : 代表数据库返回结果中列
            property: 代表的是实体类中属性-->
<resultMap id="userMap" type="com.itheima.domain.User">
    <id column="uid" property="uid"></id>
    <result column="username" property="name"></result>
    <result column="password" property="password"></result>
    <result column="email" property="email"></result>
    <result column="birthday" property="birthday"></result>
</resultMap>
<!--下面的resultMap指向的是上面resultMap中id的内容-->
<select id="findAll2" resultMap="userMap">
select uid,name as username,password,email,birthday from user
</select>
```
