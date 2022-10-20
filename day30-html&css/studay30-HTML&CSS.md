# HTML&CSS
[toc]
# HTML
## html规范
```html
<!--
    1. <!DOCTYPE html> 用于声明当前是一个HTML5的文档, 放在文件第一行
    2. 一个Html中基本架构
        <html>
            <head>
                主要的作用是告诉浏览器应当如何解析这个页面
            </head>
            <body>
                主要是浏览器要解析的内容
            </body>
        </html>
    3. 一个HTML页面主要由HTML标签   和  HTML文本 组成
    4. HTML标签分为单标签和双标签
        单标签: 只有开始标签,没有结束标签    <hr color="red">
        双标签: 有开始标签,也有结束标签    <body></body>
    5. 在标签上支持特定属性, 属性是用于控制标签的细节的
    6. HTML标签是不区分大小写的,推荐小写
-->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>人生第一个HTML页面</title>
    </head>
    <body>

        Hello World

        <hr color="red">

        Hello 398

    </body>
</html>
```
## html基本标签
### 标题
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>标题</title>
</head>
<body>
<!--
    标题：
    作用: 展示普通文本为标题
    特点: 字体加粗, 自成一行
    语法: h1---h6 (数组变大,文字变小)
        align: 控制标题水平位置 center  left  right
-->

<h1 align="center">标题1</h1>
<h2>标题2</h2>
<h3>标题3</h3>
<h4>标题4</h4>
<h5>标题5</h5>
<h6>标题6</h6>
</body>
</html>
```
### 水平线
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>水平线</title>
</head>
<body>
<!--
    作用: 渲染一条水平线
    语法: <hr>  单标签
    属性:
       color：颜色， 用于设置颜色线条颜色，通过英文字母或者RGB表示
            英文单词: red  blue  green  pink  purple yellow black white
            RGB:
       width：宽度， 用于设置线条的长度，可以是用绝对像素或者百分百设置
            绝对: px
            相当: 百分比
-->

<hr color="red">
<hr color="#25689c">

<hr color="blue" width="200px" align="left">
<hr color="blue" width="50%" align="left">

</body>
</html>
```
### 段落和换行
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>段落和换行</title>
</head>
<body>
<!--
    换行: <br>   单标签

    段落:  <p>一段内容，使用这个标签的效果是一段文字的上下会留出空白</p>

    空格: &emsp;(中文)   &nbsp;(英文)
-->

<p>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;传智专修学院是一所为互联网、人工智能、工业4.0培养高精尖科技人才的应用型大学。<br>学校经江苏省宿迁市教育局批准，由江苏传智播客教育科技股份有限公司投资创办。
</p>
<p>
    &emsp;&emsp;当今世界已进入人工智能、机器人时代，人工智能、机器人已成为未来30年、甚至50年科技革命最重要的发展方向。世界各国越来越重视，我国政府也高度关注人工智能的发展，无论是党的十八大、十九大，还是2017、2018、2019的政府工作报告，均提出要重点发展人工智能、机器人，并提升到国家战略层面。
</p>
<p>
    &emsp;&emsp;技术发展首要是人才，而我国这方面人才非常紧缺。根据国家相关部门测算，目前我国人工智能人才的缺口就已经超过了500万，国内的供求比例仅为1:10，供需比例严重失衡。并且随着社会信息革命的进一步深入，相应人才的缺口会越来越大。但在这些新技术面前，目前我国关于这方面人才的规模化培养，无论是高校还是科研机构，均没有成熟的培养体系和方案，都还处于摸索阶段。
</p>
</body>
</html>
```
### 文字效果
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>文字效果</title>
</head>
<body>
<!--
    <b>文字</b>：加粗标签

    <i>文字</i>： 斜体标签

    <u>文字</u>：下划线标签，在文字的下方有一条横线
-->
<p>
    <b>你看,这行文字加粗了:乾坤未定,你我皆是黑马</b>
</p>
<p>
    你看,这行文字倾斜了:<i>乾坤未定,你我皆是黑马</i>
</p>
<p>
    你看,这行文字有个下划线呢:<u>乾坤未定,你我皆是黑马</u>
</p>

</body>
</html>
```
### 超链接
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>超链接</title>
</head>
<body>
<!--
    作用：用于给文字添加超链接效果，点击文字是跳转一个目标页面
    语法：<a>文字</a>
    属性:
        href: 指定一个页面的地址
            绝对地址: https://www.baidu.com/
            相对地址: ./ 当前文件所在目录  ../ 当前文件上层目录
        target: 目标页面的开启位置
            _self 在当前页签打开目标页面(默认)
            _blank 在新页签打开打开目标页面

-->

<a href="https://www.baidu.com/">百度一下,你就知道</a><br>

<a href="./01-标题.html">标题</a><br>
<a href="../02_css/05-公司简介案例.html">公司简介案例.html</a><br>



<a href="https://www.baidu.com/" target="_self">百度一下,你就知道</a><br>
<a href="https://www.baidu.com/" target="_blank">百度一下,你就知道</a><br>

</body>
</html>
```
### 图像
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>图像</title>
</head>
<body>
<!--
    作用：用于在HTML页面中引入一个图片
    语法：<img/>   单标签
    属性:
        src: 图片的地址,支持绝对和相对路径写法
        alt：用于在指定咋图片丢失时要显示的文字提示
        width：用于设置图片宽度（浏览器会根据设置的宽度按照比例自动调整高度）

-->

<img src="//gw.alicdn.com/bao/uploaded///asearch.alicdn.com/bao/uploaded/O1CN01XSXiv11bCzHXHjKgq_!!2213305323430.jpg_300x300q90.jpg_.webp">

<br>
<img src="../img/cj.jpg" width="320px" alt="这是一种吃鸡的图片">

</body>
</html>
```
### 音频和视频
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>音频和视频</title>
</head>
<body>
<!--
   audio：定义音频。支持的音频格式：MP3、WAV、OGG 

* src：规定音频的 URL

* controls：显示播放控件

video：定义视频。支持的音频格式：MP4, WebM、OGG

* src：规定视频的 URL
* controls：显示播放控件
-->

<audio src="../img/jq.mp3" controls></audio>
<video src="../img/ds.mp4" controls width="500px"></video>

</body>
</html>
```
### 有序和无序
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>列表</title>
</head>
<body>
<!--
    有序列表
    <ol>
       <li>文字</li>
       <li>文字</li>
    </ol>
    无序列表
    <ul>
       <li>文字</li>
       <li>文字</li>
    </ul>
-->

<ul>
    <li>红楼梦</li>
    <li>三国演义</li>
    <li>水浒传</li>
    <li>西游记</li>
</ul>

<ol>
    <li>红楼梦</li>
    <li>三国演义</li>
    <li>水浒传</li>
    <li>西游记</li>
</ol>
</body>
</html>
```
### div和span
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>div和span标签</title>
</head>
<body>
<!--
    <div> 和 <span> 是没有语义的，它们就是一个盒子，用来装内容的
        div: 块级元素,特点是自占一行,宽度就是行宽度
        span: 行内元素,特点是只占span中内容的宽度

-->

<div>这是在div中的文字</div>
<div>这是在div中的文字</div>
<div>这是在div中的文字</div>

<hr>

<span>这是在span中的文字少时诵诗书所所所所所所所所所所所所所</span>
<span>这是在span中的文字</span>
<span>这是在span中的文字</span>


</body>
</html>
```
## 单元格
### 合并单元格
```
table 表格	
	width: 设置宽度	
	height: 设置高度	
	border: 设置边框	
	align: 水平位置
	cellspacing: 外边距	
	cellpadding: 内边距
tr	
	bgcolor  设置一行的背景色
td	
	bgcolor  设置一个单元格的背景色	
	align    设置单元格内文字的水平位置	
	height   设置单元格高度
```
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>表格合并</title>
</head>
<body>
<!--
    合并需求:
        1. 合并1-2和1-3为一个
        2. 合并2-1和3-1为一个
-->

<table width="300px" height="200px" align="center" border="1" cellpadding="0" cellspacing="0" >
    <tr>
        <td>1-1</td>
        <td colspan="2" align="center">1-2</td>

    </tr>
    <tr>
        <td rowspan="2">2-1</td>
        <td>2-2</td>
        <td>2-3</td>
    </tr>
    <tr>

        <td>3-2</td>
        <td>3-3</td>
    </tr>
</table>
</body>
</html>
```
## 表单标签
```
form: 表单标签,千万注意,不要跟from混淆了
        action: 表单的提交地址, 由于现在我们还没有学习后端服务器技术, 所以临时提交给自己,写法为###
        method: 请求方式,支持GET(默认) 和 POST
        		get：请求参数在地址栏拼接，不安全，对参数总长度有限制
		        post：参数不在地址栏拼接，相对安全，对参数总长度没有限制

    表单项: 分为三大类(文本框  下拉框  文本域)
        文本框: 使用type区分不同的小类型 <input>
            1) text: 普通文本框
                name: 键
                value: 设置值, 大部分情况下,是需要用户手动填写
                placeholder: 文本框提示
            2) password: 密码框 特点是,输入的内容会被显示为.
            3) date: 日期框
            4) radio: 单选框 一组单选框name的值必须一致; value值需要提前给定; 可以使用checked设置默认选中
            5) checkbox: 复选框 一组复选框name的值必须一致; value值需要提前给定; 可以使用checked设置默认选中
            6) file: 文件框
            7) submit: 提交按钮 作用是当点击的时候,将当前表单中的所有内容提交出去; value用于声明按钮内容
            8) reset: 重置按钮 作用就是将表单重置为初始状态
            9) button: 目前无用,需要跟js中的事件配合
            10) hidden: 隐藏域, 仅仅不在页面上显示, 会向后台提交
        下拉框
            select 下拉框
                name
                multiple 多选
            option
                value
                selected  默认值
        文本域
            textarea
```
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>表单</title>
</head>
<body>

<form action="###" method="POST">
    <input type="hidden" name="key" value="toutoude">
    用户名: <input type="text" name="username" value="" placeholder="请输入用户名"><br>
    密码:<input type="password" name="pwd"><br>
    出生日期: <input type="date" name="birthday"><br>
    性别: 男 <input type="radio" name="sex" value="man" checked>
        女 <input type="radio" name="sex" value="women"><br>
    爱好: 抽烟 <input type="checkbox" name="hobby" value="smoke">
        喝酒 <input type="checkbox" name="hobby" value="drink" checked>
        烫头 <input type="checkbox" name="hobby" value="hot" checked><br>
    头像: <input type="file" name="picture"><br>
    <input type="submit" value="注册">
    <input type="reset" value="重新填写">
    <input type="button" value="普通按钮"><br>
    学历: <select name="xueli">
            <option value="0">小学</option>
            <option value="1">初中</option>
            <option value="2">高中</option>
         </select>
    专业: <select name="zhuanye" multiple>
            <option value="0" selected>数学</option>
            <option value="1" selected>计算机</option>
            <option value="2">自动化</option>
         </select><br>
    个人简介: <textarea name="desc" cols="30" rows="10"></textarea>
</form>

</body>
</html>
```
# css
## 选择器
```
选择器作用：找出页面一组特定的标签

1. 标签选择器       使用标签名称选中一类标签        语法：标签名{css样式}
2. 类选择器          使用class属性选中一类标签        语法：.class{css样式}
3. id选择器          使用id属性选中一个标签            语法：#id{css样式}
```
```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>CSS选择器</title>

    <style>
        /*1. 标签选择器 直接使用标签名*/
        span{
            font-size: 20px ;
        }
        /*2. class选择器 选出的是所有属性中含有class=值的标签     .female => class=female*/
        .female{
            color: red;
        }
        .hero{
            font-weight: bold;
        }
        /*3. id选择器 选出的是所有的属性中含有id=值的标签  #boss => id = boss*/
        #boss{
            font-size: 50px;
            color: purple;
        }
    </style>

</head>
<body>

<!--
    需求:
        1. 让页面上的所有字体变成20px
        2. 所有女性变红, 所有英雄加粗
        3. 灭霸变成50px,紫色
-->
<span class="female">古力娜扎</span>
<span class="female">迪丽热巴</span>
<span class="female hero">黑寡妇</span>

<span class="male hero">钢铁侠</span>
<span class="male hero">超人</span>


<span id="boss" class="male">灭霸</span>


</body>
</html>
```
## 样式
```
文本属性:设置文本的颜色,行高,缩进,文本的修饰(有无下划线)等
        字体属性:设置文字的大小,字体,风格(倾斜),是否加粗
        需求：
            1.p段落文字绿色
            2.p段落文字大小20px
            3.p段落行高40px
            4.p段落字体加粗
            5.p段落字体楷体
			6.p段落字体倾斜
            7.p段落首行缩进40px
			8.p段落中的文字水平居中
			9.a标题背景颜色为粉色
			10.隐藏a标题部分
```
```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>CSS样式</title>
    <style>
        p{
            color: green; /*p段落文字绿色*/
            font-size: 20px;/*p段落文字大小20px*/
            line-height: 40px;/*p段落行高40px*/
            font-weight: bold;/*p段落字体加粗  bold粗  正常normal*/
            font-family: '楷体';/*p段落字体楷体*/
            font-style: italic;/*p段落字体倾斜 italic倾斜  正常normal*/
            text-indent: 40px;/*p段落首行缩进40px*/
            text-align: center;/*p段落中的文字水平居中*/
        }

        a{
            background-color: pink;
            display: block;/*none 隐藏  block 块  inline 行内*/
        }

    </style>

</head>
<body>
<div>

	<a> 学习的误区：</a><br/>
    <p>
        眼睛：看了一遍记住了<br/>
        耳朵：听了一遍明白了<br/>
        脑子：想了一遍搞懂了<br/>
        手：你们会个屁！^_^ <br>
    </p>

    <div style="display: inline">1</div>
    <div style="display: inline">2</div>
</div>
</body>
</html>
```