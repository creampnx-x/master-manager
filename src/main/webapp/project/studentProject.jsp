<%@ page import="com.example.mastermanager.project.po.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ConcurrentModificationException" %>
<%@ page import="com.example.mastermanager.project.po.Contribution" %>
<%@ page import="com.example.mastermanager.project.dao.impl.DAOFactory" %>
<%@ page import="com.example.mastermanager.project.po.Project" %><%--
  Created by IntelliJ IDEA.
  User: 13407
  Date: 2023/1/10
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>studentProject</title>
</head>
<body>
    <center>
        <h1>学生项目管理页面</h1>
        <h2>我的项目：</h2>
        <%
            // 从bean中获取学生信息
            User student = (User) request.getSession().getAttribute("studentBean");
            System.out.println(student);
            // 查询学生项目
            List<Contribution> result = DAOFactory.getInstance().getContributionDAO().getStudentContribution(student);
            if (result.size() == 0) {
                out.println("<h2>您还没有参与项目！</h2>");
            } else {
                out.println("<table border='1px solid' width='1300px' height='50px'>");
                out.println("<tr>");

                    out.println("<td>");
                    out.println("贡献表id");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("项目id");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("负责人id");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("项目编号");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("项目类型");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("项目名称");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("我的工作");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("开始时间");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("结束时间");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("我承担工作折合经费（万元）");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("项目总经费");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("负责人已确认");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("导师已确认");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("已提交");
                    out.println("</td>");

                    out.println("<td>");
                    out.println("操作");
                    out.println("</td>");

                out.println("</tr>");

                for (Contribution contribution : result) {
                    Project project = new Project();
                    project.setPid(contribution.getPid());
                    project = DAOFactory.getInstance().getProjectDAO().getProjectByPid(project);
                    out.println("<tr>");

                        out.println("<td>");
                        out.println(contribution.getCid());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getPid());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getLeader());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getPnum());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getPtype());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getPname());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getWork());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getBegintime());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getEndtime());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(contribution.getFund());
                        out.println("</td>");

                        out.println("<td>");
                        out.println(project.getFund());
                        out.println("</td>");

                        out.println("<td>");
                        if (contribution.isLeader())
                            out.println("是");
                        else
                            out.println("否");
                        out.println("</td>");

                        out.println("<td>");
                        if (contribution.isTeacher())
                            out.println("是");
                        else
                            out.println("否");
                        out.println("</td>");

                        out.println("<td>");
                        if (contribution.isSubmit())
                            out.println("是");
                        else
                            out.println("否");
                        out.println("</td>");

                        out.println("<td>");
                        out.println("<form action='Confirm' method='POST'>");
                        out.println("<input type='submit' value='提交贡献表'>");
                        out.print("<input type='hidden' value='");
                        out.print(contribution.getCid());
                        out.println("' name='cid'>");
                        out.println("</form>");
                        out.println("</td>");

                    out.println("</tr>");
                }

                out.println("</table>");
            }
        %>
    </center>
</body>
<script>
    var success_type = '<%= request.getParameter("success")%>'
    if (success_type === '1'){
        setTimeout(function () {
            window.alert("提交成功！")
        }, 200)
    }

    var error_type = '<%= request.getParameter("error")%>'
    if (error_type === '1'){
        setTimeout(function () {
            window.alert("当前贡献表已提交，请勿重复提交！")
        }, 200)
    }
</script>
</html>
