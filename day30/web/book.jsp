<%@ page import="com.nicetry.bean.Book" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/3
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书详情</title>
</head>
<body>
<%
    Object book = pageContext.getAttribute("book_1", pageContext.APPLICATION_SCOPE);
    Book book1 = (Book) book;
    %>
<h1>
    <%
        out.write(book1.getBookname());
    %>
</h1>
<h1>
    <%
        out.write(book1.getAuthor());
    %>
</h1>
<h1>
    <%
        out.write(book1.getPrice());
    %>
</h1>
<%
%>
</body>
</html>
