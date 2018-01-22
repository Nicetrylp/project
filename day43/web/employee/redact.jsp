<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/20
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
</head>
<body>
    <s:form action="update" method="POST">
        <%--<s:property value="%{#session.employee}"/>--%>
        <s:textfield value="%{#session.employee.name}" name="employee.name" label="姓名"/>
        <s:textfield value="%{#session.employee.age}" name="employee.age" label="年龄"/>
        <s:textfield value="%{#session.employee.department}" name="employee.department" label="部门"/>
        <s:textfield value="%{#session.employee.time}" name="employee.time" label="入职时间"/>
        <s:textfield value="%{#session.employee.address}" name="employee.address" label="家庭住址"/>
        <s:textfield value="%{#session.employee.phoneNumber}" name="employee.phoneNumber" label="电话号码"/>
        <s:hidden value="%{#session.employee.id}" name="employee.id"/>
        <s:submit value="修改"/>
    </s:form>
</body>
</html>
