<%--
  Created by IntelliJ IDEA.
  User: 13407
  Date: 2023/1/10
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导师项目录入</title>
</head>
<body>
    <center>
        <form action="../addTProject" method="post">
            导师id: <input type="number" name="lid"><br>
            项目编号: <input type="text" name="num"><br>
            项目类型: <input type="text" name="type"><br>
            项目名称: <input type="text" name="name"><br>
            项目资金: <input type="number" name="fund"><br>
            启动时间: <input type="text" placeholder="XXXX-XX-XX" name="begintime"><br>
            结束时间: <input type="text" placeholder="XXXX-XX-XX" name="endtime"><br>
            <input type="submit" value="提交">
            <input type="reset" value="重置">
        </form>
    </center>
</body>
</html>
