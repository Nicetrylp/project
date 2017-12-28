<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2017/12/28
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="JS/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <button id="btn">点我获取数据</button>
  <table border="1"></table>
  </body>
  <script type="text/javascript">
    $('#btn').click(function () {
        $('table tr').remove();
        $.get("/get",function (JsonData,status) {
            console.log(status);
            if (status == "success"){
                $('table').append(
                    $('<tr>').append(
                        $('<th>').text("id")
                    ).append(
                        $('<th>').text("username")
                    ).append(
                        $('<th>').text("gender")
                    )
                );
                var parseJSON = $.parseJSON(JsonData);
                $.each(parseJSON,function (index,obj) {
                    $('table').append(
                        $("<tr>").append(
                            $('<td>').text(obj['id'])
                        ).append(
                            $('<td>').text(obj['username'])
                        ).append(
                            $('<td>').text(obj['gender'])
                        )
                    )
                })
            }
        })
    })
  </script>
</html>
