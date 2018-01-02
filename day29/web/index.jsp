<%--
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
  <%--<a href="register.html">注册点我</a>--%>
  <%--<a href="login.html">登录点我</a>--%>
  <table border="1">
  </table>
  </body>
<script type="text/javascript">
  $.get("http://localhost:8080/index",function (data, stutas) {
      $('tr').remove();
      console.log(stutas);
      if (stutas == "success"){
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
</script>
</html>
