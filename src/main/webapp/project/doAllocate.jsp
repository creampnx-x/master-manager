<%--
  Created by IntelliJ IDEA.
  User: 13407
  Date: 2023/1/10
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分配项目</title>
</head>
<body>
    <center>
        <br><br><br><br>
        <form action="GetAllocate" method="post">
            学号: <input type="number" name="uid"><br><br>
            承担工作: <input type="text" name="work"><br><br>
            承担工作经费（万元）: <input type="number" name="fund"><br><br>
            开始时间: <input type="text" placeholder="XXXX-XX-XX" name="begintime"><br><br>
            结束时间: <input type="text" placeholder="XXXX-XX-XX" name="endtime"><br><br>
            <input type="submit" value="分配">
            <input type="reset" value="重置">
        </form>
    </center>
</body>
</html>
