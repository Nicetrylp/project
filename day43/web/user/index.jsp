<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/20
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="<s:url namespace="/employee" action="show"/>">点击员工信息查询</a>
  <a href="${pageContext.request.contextPath}/employee/add.jsp">添加员工</a>
  </body>
</html>
