<%@ page import="java.util.List" %>
<%@ page import="com.nicetry.bean.Book" %><%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2017/12/29
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="JS/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <div><a href="quit">退出</a></div>
  <%--<table border="1">--%>
  <%--</table>--%>
  <%
    if (session.getAttribute("username")!=null){
        %>
    <table border="1">
      <tr>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
      </tr>

  <%
    Object books = pageContext.getAttribute("books", pageContext.APPLICATION_SCOPE);
    List<Book> books1 = (List<Book>) books;
    for (Book book : books1) {
  %>
  <tr>
    <td>
      <a href="book.jsp"><%
        out.write(book.getBookname());
      %></a>
    </td>
    <td>
      <%
        out.write(book.getAuthor());
      %>
    </td>
    <td>
      <%
        out.write(book.getPrice());
      %>
    </td>
  </tr>

  <%
    }%>
    </table>
        <%
    }
  %>
  </body>
<script type="text/javascript">
    function show() {
        $.get("http://localhost:8080/day28/index",function (data, status) {
            $('tr').remove();
            $('h1').text("");
            console.log(status);
            if (status == "success"){
                $('h1').text("登录成功");
                $('table').append(
                    $('<tr>').append(
                        $('<td>').text("id")
                    ).append(
                        $('<td>').text("用户名")
                    ).append(
                        $('<td>').text("昵称")
                    )
                )
                var parseJSON = $.parseJSON(data);
                $.each(parseJSON,function (index,obj) {
                    $('table').append(
                        $("<tr>").append(
                            $('<td>').text(obj['id'])
                        ).append(
                            $('<td>').text(obj['username'])
                        ).append(
                            $('<td>').text(obj['nickname'])
                        )
                    )
                })
            }
        })
    }
    $('a').click(function () {
        var value = $(this).text();
        console.log(value);
        $.get("http://localhost:8080/day28/book?bookname="+value)
    })
</script>
</html>
