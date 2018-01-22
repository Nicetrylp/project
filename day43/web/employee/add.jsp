<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/20
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
    <s:form action="/employee/add" method="POST">
        姓名 : <input type="text" name="employee.name"><br>
        年龄 : <input type="text" name="employee.age"><br>
        部门 : <input type="text" name="employee.department"><br>
        入职时间 : <input type="text" name="employee.time"><br>
        住址 : <input type="text" name="employee.address"><br>
        电话 : <input type="text" name="employee.phoneNumber"><br>
        <input type="submit" value="添加">
    </s:form>
</body>
</html>
