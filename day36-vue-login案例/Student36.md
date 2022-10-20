# vue
## vue语法
### Vue对象介绍

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>快速入门</title>

    <!--1. 引入vue的js文件-->
    <script src="./js/vue-2.6.12.js"></script>
</head>
<body>
<div id="app">
    <!--在span中显示username变量对应的值-->
    <!--{{插值表达式}}: 作用就是将data中变量的值渲染到页面上-->
    <span>我的名字是: {{username}}</span> <br>
    <span>我有1个女朋友,它的名字:{{girlfriend.name}},它的年龄:{{girlfriend.age}}</span><br>
    <span>我有2个好朋友,它的名字:{{friends[0]}}和{{friends[1]}}</span>
</div>
<script>
    //创建Vue对象
    let app = new Vue({
        el: "#app",//指定当前vue管理的界面范围, 注意:vue管理的标签必须是双标签(html 和 body除外)
        data: { //定义数据,常用的就是键值对,数组和对象
            "username": "张三",
            "girlfriend": {
                "name": "王铁锤",
                "age": "18"
            },
            "friends": [
                "王五",
                "李四"
            ]
        }
    });
</script>

</body>
</html>

~~~

>~~~js
>// Vue对象的介绍
>const app = new Vue({
>        el: "#app",  // el用于挂载视图，即使用css选择器，选中当前vue可以管理的视图范围，注意: vue选择视图必须使用的是双标签，html和body除外
>        data:{       // data是一个对象，里面存储的就是视图数据，支持js的各种数据类型(简单  对象  数组)
>            message:""
>        }
>})
>~~~



## 双向绑定

>~~~markdown
>* v-model是双向绑定，视图（View）和模型（Model）之间会互相影响。
>* 目前v-model的可使用元素有：input、select、textarea
>~~~

~~~html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="./js/vue-2.6.12.js"></script>
</head>
<body>
<div id="app">

    <h3>姓名：</h3>
    <input type="text" v-model="username">
    <div>您写的姓名是:{{username}}</div>


    <h3>性别：</h3>
    <input type="radio" value="男" v-model="sex"> 男 <br>
    <input type="radio" value="女" v-model="sex"> 女 <br>
    <div>您选择的性别是:{{sex}}</div>


    <h3>爱好：</h3>
    <input type="checkbox" value="抽烟" v-model="hobby">抽烟<br>
    <input type="checkbox" value="喝酒" v-model="hobby">喝酒<br>
    <input type="checkbox" value="烫头" v-model="hobby">烫头<br>
    <div>您选择的爱好是:{{hobby}}</div>


    <h3>段位：</h3>
    <select v-model="level">
        <option value="">请选择</option>
        <option value="青铜">青铜</option>
        <option value="白银">白银</option>
        <option value="王者">王者</option>
    </select>
    <div>您选择的段位是:{{level}}</div>

</div>
<script>
    let app = new Vue({
        el: "#app",
        data: {
            "username":"张三",
            "sex":"女",
            "hobby":["喝酒"],
            "level":"王者"
        }
    })
</script>
</body>
</html>
~~~

## 属性绑定

> ~~~markdown
> * 对于HTML标签属性，如果想要动态传值，不能使用{{}}，而应该使用专门的属性绑定语法
> 	标准语法：   v-bind:属性名="Vue中的变量"
> 	简写语法：         :属性名='Vue中的变量'
> ~~~

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="./js/vue-2.6.12.js"></script>
</head>
<body>
<div id="app">
    <h3>属性绑定基本使用</h3>
    有两个图片地址分别是:./img/vue.png 和 ./img/lj.jpg,请在下面输入地址,改变图片:<br>
    图片地址: <input type="text" v-model="imgSrc">
    图片宽度: <input type="text" v-model="imgWidth">
    <br>
    <img :src="imgSrc" :width="imgWidth">

</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            imgSrc: "./img/vue.png",
            imgWidth: "100px"
        },
    })
</script>
</body>
</html>
```

## 列表循环

>~~~markdown
>* 在vue中使用v-for实现数组的遍历，格式如下:
>* v-for="(item,index) in items"
>     items：要遍历的List
>     item： 每次遍历得到的临时变量
>     index：每次遍历的索引，从0开始计数(可省略)
>~~~

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="./js/vue-2.6.12.js"></script>
</head>
<body>
<!--
  v-for标签写在要遍历的元素上
  v-for="(item,index) in items"
    items：要遍历的List
    item： 每次遍历得到的临时变量
    index：每次遍历的索引，从0开始计数(可省略)
-->

<div id="app">
    <ul>
        <li v-for="(user,index) in users">
            {{index}}--{{user.id}}--{{user.name}}--{{user.address}}
        </li>
    </ul>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            users: [
                {id: 1, name: 'jack', address: '北京顺义'},
                {id: 2, name: 'lucy', address: '上海虹桥'},
                {id: 3, name: 'jerry', address: '天津宝坻'}
            ]
        }
    })
</script>
</body>
</html>
```

## 条件判断

> ~~~markdown
> * 语法：
> 	v-if="布尔表达式"
> 	v-else-if="布尔表达式"
> 	v-else
> * 注意：
> 	v-else元素必须紧跟在带v-if或者v-else-if元素的后面，否则它将不会被识别
> 	v-if还可以和v-for联合使用，当二者出现在一起时，会先遍历再判断条件
> ~~~

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="./js/vue-2.6.12.js"></script>
</head>
<body>

<!--
* 语法：
	v-if="布尔表达式"
	v-else-if="布尔表达式"
	v-else
* 注意：
	v-else元素必须紧跟在带v-if或者v-else-if元素的后面，否则它将不会被识别
	v-if还可以和v-for联合使用，当二者出现在一起时，会先遍历再判断条件
-->

<div id="app">
    <!--从文本框输入成绩, 然后判断成绩是否及格  >=60:及格    <60:不及格   其他:未知-->
    <h3>考试成绩练习</h3>
    请输入成绩:<input type="text" v-model="score"><br>
    你本次开始成绩:
    <span v-if="score >= 60">及格</span>
    <span v-else-if="score < 60">不及格</span>
    <span v-else>未知</span>

    <!--遍历users, 但是要求只显示性别为女的用户-->
    <h3>用户列表</h3>
    <ul>
        <li v-for="(user,index) in users" v-if="user.gender == '女'">{{user.name}}--{{user.gender}}</li>
    </ul>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            score: "未知",
            users: [
                {name: 'jack', gender: '女'},
                {name: 'lucy', gender: '女'},
                {name: 'jerry', gender: '男'}
            ]
        }
    })
</script>
</body>
</html>
```

## 事件处理

> ~~~markdown
> * 事件绑定
> 	1) 标准语法   v-on:事件名="js片段或函数名"   如果不想页面爆红,需要单独引入名称空间
> 	2) 简化语法   @事件名="js片段或函数名"       推荐使用
> ~~~

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="./js/vue-2.6.12.js"></script>
</head>
<body>
<div id="app">
    <b>数量：</b>
    <!--
        在vue中调用函数, 函数名后的()可以省略,但是不推荐
    -->
    <button @click="diff()">-</button>
    <input type="text" v-model="num" style="width: 30px;">
    <button @click="add()">+</button>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            num: 1
        },
        methods: {
            //定义方法
            add() {
                //在vue中,如果你要在自定义的方法中调用自定义的变量或者方法,都要强制使用this关键字
                this.num++;
            },
            diff() {
                if (this.num <= 1) {
                    return;
                }
                this.num--;
            }
        }
    })
</script>
</body>
</html>
```

## 异步交互

### axios使用

> Vue并没有直接处理ajax的组件，需要使用第三方插件实现。Vue官网推荐使用 Axios 插件实现ajax功能。

```js
// 执行get请求
axios.get('/url?name=admin&password=123').then(resp=>{
	console.log(resp.data);
})


// 执行get请求参数比较多的时候
axios.get('/url',{
    params:{
		name: 'admin',
		password: '123'
    }
}).then(resp=>{
	console.log(resp.data);
})


//执行post请求
axios.post('/url', {
    name: 'admin',
    password: '123'
}).then(resp=>{
    console.log(resp.data);
})
```

### 页面加载完成

>created方法用于定义页面加载完毕之后需要执行的事情
>
>~~~js
>const app = new Vue({
>	created() {
>		console.log("页面加载完毕了......");
>	}
>});
>~~~



## 总结

~~~html
<!--Vue对象模板-->
<script>
    const app = new Vue({
        el: "#app", // 管理(挂载)的页面
        data: {}, // 页面中数据,不要写成date
        methods: {}, //定义方法, 不要写成method 
        created() {} //页面加载完毕之后要执行的方法, 注意:1. 不要写成create   2. 不要把这方法写到methods里面去
    });
</script>

1. 单方向赋值
	html文本: {{文本}}
	html属性: <span :color="color"> </span>

2. 双向绑定
	<input type="text" v-model="name"></input>

3. 遍历循环
	<li v-for="(item,index) in items"></li>

4. 判断
	<span v-if=""></span>
	<span v-else-if=""></span>
	<span v-else></span>

5. 事件绑定
	<a @click="add()"></a>

6. ajax请求
	get请求
        axios.get('/url?name=admin&password=123').then(resp=>{
            console.log(resp.data);
        })
	post请求
        axios.post('/url', {
            name: 'admin',
            password: '123'
        }).then(resp=>{
            console.log(resp.data);
        })
~~~
# 综合案例(登录)
## 登录
```markdown
采用了一个页面刷新技术，当页面加载完毕之后发生请求
vue刷新界面采用created(){};方法
```
    登录界面
```html
<div class="row">
        <h3 style="text-align: center">学生列表</h3>
        <div class="col-lg-3"></div>
        <div class="col-lg-6">
            <table border="1" class="table table-bordered table-hover">
                <tr class="success" style="text-align: center">
                    <th>学号</th>
                    <th>姓名</th>
                    <th>生日</th>
                    <th>地址</th>
                    <th>操作</th>
                </tr>
                <tr v-for="(student,index) in findStudents">
                    <td>{{student.id}}</td>
                    <td>{{student.name}}</td>
                    <td>{{student.birthday}}</td>
                    <td>{{student.address}}</td>
                    <td>
                        <a class="btn btn-default btn-sm" data-toggle="modal" data-target="#updateModal" @click="findStudent(student.id)">修改</a>
                        <a class="btn btn-default btn-sm" href="javascript:void(0)" @click="deleteStudent(student.id)">删除</a>
                    </td>
                </tr>

                <tr>
                    <td colspan="9" align="center">
                        <a class="btn btn-primary" data-toggle="modal" data-target="#addModal">添加学生</a>
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-lg-3"></div>
    </div>
```
    scrip代码
```javascript
<script>
    let app = new Vue({
    el:"#app",
    data:{
    //登录数组    
    findStudents:[],
    //添加集合
    studentsAdd:{},
    //修改集合
    studentsUpdate:{}
},
    methods:{
    //查询方法：    
    findList(){
    axios.get("/studentServlet?action=findList").then(resp =>{
    this.findStudents = resp.data;
})
},
    //添加方法：
    addStudent(){
    axios.post("/studentServlet?action=add",this.studentsAdd).then(resp =>{
    if ("ok" === resp.data){
    //1. 清空添加表单
    this.studentAdd = {};

    //2. 关闭添加框
    $("#addModal").modal('hide');

    //3. 重新查询列表
    this.findList();
}
})
},
    //修改方法前先进行查询单个
    findStudent(studentId){
    axios.get("/studentServlet?action=findStudent&id="+studentId).then(resp =>{
    this.studentsUpdate = resp.data;
})
},
    updateStudent(){
    axios.post("/studentServlet?action=updateStudent",this.studentsUpdate).then(resp =>{
    if ("ok" === resp.data){
    //1. 清空添加表单
    this.studentsUpdate = {};

    //2. 关闭添加框
    $("#updateModal").modal('hide');

    //3. 重新查询列表
    this.findList();
}
})
},
    //删除方法
    deleteStudent(studentId){
    axios.get("/studentServlet?action=deleteStudent&id="+studentId).then(resp=>{
    if ("ok" === resp.data){
    this.findList();
}
})
}
},
    //刷新界面
    created(){
    this.findList();
}
});
</script>
```
    后端StudentServlet代码
```java
private void findList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 调用service查询
        List<Student> studentList = studentService.findList();
        //2. 将查询结果转json返回
        String json = new ObjectMapper().writeValueAsString(studentList);
        response.getWriter().write(json);
    }
```
    接口StudentService和StudentServiceImpl代码
```java
//接口
List<Student> findList();

//实现类
@Override
public List<Student> findList() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.findList();
        MyBatisUtil.close(sqlSession);
        return student;
        }
```
    接口mapper代码
```java
    //这边采用注解的方式
    @Select("select * from student")
    List<Student> findList();
```
## 添加
    添加界面
```html
<!-- 新增 -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="addModalLabel">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>学号：</label>
                        <input type="text" class="form-control" name="id" placeholder="请输入学号" v-model="studentsAdd.id">
                        <span>{{studentsAdd.id}}</span>
                    </div>
                    <div class="form-group">
                        <label>姓名：</label>
                        <input type="text" class="form-control" name="name" placeholder="请输入姓名" v-model="studentsAdd.name">
                        <span>{{studentsAdd.name}}</span>
                    </div>
                    <div class="form-group">
                        <label>生日：</label>
                        <input type="text" class="form-control" name="birthday" placeholder="请输入生日" v-model="studentsAdd.birthday">
                        <span>{{studentsAdd.birthday}}</span>
                    </div>
                    <div class="form-group">
                        <label>地址：</label>
                        <input type="text" class="form-control" name="address" placeholder="请输入地址" v-model="studentsAdd.address">
                        <span>{{studentsAdd.address}}</span>
                        <span>{{studentsAdd}}</span>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" @click="addStudent()">新增</button>
                </div>
            </div>
        </div>
    </div>
```
```markdown
添加的JavaScript代码看前面查询里面
```
    StudentServlet代码
```java
private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收请求(通过ajax使用post的请求体发送参数,后台使用数据流接收)
        //1-1 接收输入流
        ServletInputStream inputStream = request.getInputStream();
        String json = IoUtil.read(inputStream, "utf-8");
        Student student = new ObjectMapper().readValue(json, Student.class);
        studentService.add(student);
        response.getWriter().write("ok");
    }
```
    接口StudentService和实现类StudentServiceImol
```java
//接口
 void add(Student student);
//实现类
@Override
public void add(Student student) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.add(student);
        MyBatisUtil.close(sqlSession);
        }
```
    接口SrudentMapper
```java
    @Insert("insert into student values(#{id},#{name},#{birthday},#{address})")
    void add(Student student);
```
## 修改
```html
<!-- 修改 -->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="updateModalLabel">修改</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>学号：</label>
                        <input type="text" class="form-control" name="id" disabled v-model="studentsUpdate.id">
                    </div>
                    <div class="form-group">
                        <label>姓名：</label>
                        <input type="text" class="form-control" name="name" placeholder="请输入学号" v-model="studentsUpdate.name">
                    </div>
                    <div class="form-group">
                        <label>生日：</label>
                        <input type="text" class="form-control" name="birthday" placeholder="请输入姓名" v-model="studentsUpdate.birthday">
                    </div>
                    <div class="form-group">
                        <label>地址：</label>
                        <input type="text" class="form-control" name="address" placeholder="请输入地址" v-model="studentsUpdate.address">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" @click="updateStudent()">修改</button>
                </div>
            </div>
        </div>
    </div>
```
```markdown
修改的JavaScript看前面查询中的
```
    StudentServlet中的代码
```java
//提交修改代码
    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String json = IoUtil.read(inputStream, "utf-8");
        Student student = new ObjectMapper().readValue(json, Student.class);
        studentService.update(student);
        response.getWriter().write("ok");
    }
//修改前要查询下要修改的内容，将修改的内容返回
    private void findStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Student student = studentService.findStudent(id);
        String json = new ObjectMapper().writeValueAsString(student);
        response.getWriter().write(json);
    }
```
    接口StudentService和实现类StudentServiceImpl
```java
    //接口StudentService
    //修改
    void update(Student student);
    //修改前的查询
    Student findStudent(String id);
    
    //实现类
    @Override
    public void update(Student student) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.update(student);
        MyBatisUtil.close(sqlSession);
        }
        
    @Override
    public Student findStudent(String id) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.findStudent(id);
        MyBatisUtil.close(sqlSession);
        return student;
        }
```
    接口：StudentMapper
```java
    @Update("update student set name=#{name},birthday=#{birthday},address=#{address} where id=#{id}")
    void update(Student student);

    @Select("select * from student where id=#{id}")
    Student findStudent(String id);
```
## 删除
    注:当a标签中存在href超链接的时候会先执行超链接，而不去执行后面的响应事件，所以要干掉超链接
        href="javascript:void(0)" 阻止超练级的跳转
        delete 不能作为自定义的方法名称
```html
//这段上下文从查询中查找
<a class="btn btn-default btn-sm" href="javascript:void(0)" @click="deleteStudent(student.id)">删除</a>
```
```javascript
从查询的JavaScript中查看
```
    StudentServlet
```java
private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        studentService.deleteStudent(id);
        response.getWriter().write("ok");
    }
```
    接口StudentService和实现类StudentServiceImpl
```java
//接口StudentService
void deleteStudent(String id);
//实现类StudentServiceImpl
@Override
public void deleteStudent(String id) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.delete(id);
        MyBatisUtil.close(sqlSession);
        }
```
     接口：StudentMapper
```java
@Delete("delete from student where id=#{id}")
    void delete(String id);
```
