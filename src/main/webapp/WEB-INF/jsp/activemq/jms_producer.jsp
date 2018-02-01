<%--
  Created by IntelliJ IDEA.
  User: unicom
  Date: 2018/1/30
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JMS-Producer</title>
</head>
<body>
<h1>JMS-Producer!!!</h1>
<form action="onsend" method="post">

    MessageText:<textarea name="message">${time }</textarea>

    <input type="submit" value="提交" />
</form>
<h2><a href="welcome">返回主页</a></h2>
</body>
</html>
