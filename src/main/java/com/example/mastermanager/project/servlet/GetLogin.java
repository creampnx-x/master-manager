package com.example.mastermanager.project.servlet;

import com.example.mastermanager.project.dao.UserDAO;
import com.example.mastermanager.project.dao.impl.DAOFactory;
import com.example.mastermanager.project.po.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class GetLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String forWardUrl = "";

        Integer uid = Integer.parseInt(request.getParameter("id"));
        String pwd = request.getParameter("pwd");

        /*
         * 用户登录验证
         * 查询数据库是否有对应uid和pwd的数据
         * */
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        User user = new User();
        user.setUid(uid);
        user.setPassword(pwd);
        User result = null;
        result = userDAO.getUser(user);
        if (result == null) {
            forWardUrl = "login.jsp?error=1";
        } else {
            if (result.getRid() == 4) {
                forWardUrl = "project/teacherProject.jsp";
                // 设置Bean共享，供视图层使用
                request.getSession().setAttribute("teacherBean", result);
            } else if (result.getRid() == 5) {
                forWardUrl = "project/studentProject.jsp";
                // 设置Bean共享，供视图层使用
                request.getSession().setAttribute("studentBean", result);
            } else if (result.getRid() == 1) {
                forWardUrl = "project/studentAdmin.jsp";
                request.getSession().setAttribute("studentAdminBean", result);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forWardUrl);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }
}
