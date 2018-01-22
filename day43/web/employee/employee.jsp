<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/20
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有员工</title>
</head>
<body>
    <c:if test="#session.show != null">
    <table border="1">
        <tr>
            <th>姓名</th>
            <th>年龄</th>
            <th>部门</th>
            <th>入职时间</th>
            <th>家庭住址</th>
            <th>电话号码</th>
            <th>操作</th>
        </tr>
    <s:iterator value="#session.show" var="employee">
        <tr>
            <td><s:property value="%{#employee.getName}"/> </td>
            <td><s:property value="%{#employee.getAge}"/> </td>
            <td><s:property value="%{#employee.getDepartment}"/> </td>
            <td><s:property value="%{#employee.getTime}"/> </td>
            <td><s:property value="%{#employee.getAddress}"/> </td>
            <td><s:property value="%{#employee.getPhoneNumber}"/> </td>
            <s:url action="redact" var="redact" >
                <s:param name="employee.name" value="%{#employee.name}"/>
                <s:param name="employee.age" value="%{#employee.age}"/>
                <s:param name="employee.department" value="%{#employee.department}"/>
                <s:param name="employee.time" value="%{#employee.time}"/>
                <s:param name="employee.address" value="%{#employee.address}"/>
                <s:param name="employee.phoneNumber" value="%{#employee.phoneNumber}"/>
                <s:param name="employee.id" value="%{#employee.id}"/>
            </s:url>
            <td><s:a href="%{redact}">编辑</s:a> </td>
        </tr>
    </s:iterator>
    </table>
    </c:if>
    <%--<s:property value="#session.show"/>--%>
</body>
</html>
