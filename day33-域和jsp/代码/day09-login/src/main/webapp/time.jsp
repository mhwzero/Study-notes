<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

欢迎访问本网站，当前时间为:

<%
    String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    out.write(time);
%>

</body>
</html>
