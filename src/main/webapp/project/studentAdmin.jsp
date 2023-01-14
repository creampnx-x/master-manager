<%--
  Created by IntelliJ IDEA.
  User: 13407
  Date: 2023/1/10
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>studentAdmin-项目管理</title>
</head>
<body>
    <center>
        <h1>研究生培养管理员</h1>
        <a href="project/adminTP.jsp">导师项目录入</a><br>
        <a href="project/adminSP.jsp">研究生参与项目录入</a>
    </center>
</body>
<script>
    var success_type = '<%= request.getParameter("success")%>'
    if (success_type === '1'){
        setTimeout(function () {
            window.alert("导师项目录入成功！")
        }, 200)
    } else if (success_type === '2') {
        setTimeout(function () {
            window.alert("研究生参与项目录入成功！")
        }, 200)
    }
</script>
</html>
