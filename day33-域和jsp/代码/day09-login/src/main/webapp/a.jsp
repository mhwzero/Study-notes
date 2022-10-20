<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>获取域对象中得值</h3>
request域对象中得name的值:${requestScope.name}<br>
session域对象中得name的值:${sessionScope.name}<br>

省略了域对象的标识: ${name}


<h3>获取域对象中各种类型的值</h3>
获取域对象中的对象:${user22.username}--${user22.balance}<br>
获取域对象中的集合:${userList[0]}--${userList[1]}
</body>
</html>
