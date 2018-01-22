<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/20
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<s:form action="/user/login" method="POST">
    <s:fielderror fieldName="login"/>
    用户名:<input type="text" name="user.username"><s:fielderror fieldName="username"/> <br>
    密码:<input type="password" name="user.password"><s:fielderror fieldName="password"/><br>
    <input type="submit" value="登录"/>
</s:form>
</body>
</html>
