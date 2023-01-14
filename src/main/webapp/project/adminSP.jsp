<%--
  Created by IntelliJ IDEA.
  User: 13407
  Date: 2023/1/10
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>研究生参与项目录入</title>
</head>
<body>
<center>
    <form action="../addSProject" method="post">
        项目id: <input type="number" name="pid"><br>
        学生id: <input type="number" name="uid"><br>
        参与时间: <input type="text" placeholder="XXXX-XX-XX" name="begintime"><br>
        结束时间: <input type="text" placeholder="XXXX-XX-XX" name="endtime"><br>
        负责工作: <input type="text" name="work"><br>
        负责工作资金: <input type="number" name="fund"><br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
</center>
</body>
</html>
