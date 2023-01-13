package com.example.mastermanager.module1.servlet;

import com.example.mastermanager.module1.pojo.User;
import com.example.mastermanager.module1.DAO.DAOFactory;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = DAOFactory.getInstance().getUserDAO().Login(username,password);

        if (user == null){
            request.getRequestDispatcher("/failed.jsp").forward(request, response);
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            System.out.println(user.getUid() + "   " + user.getIdent());
            if (user.getIdent().equals("研究生"))
                request.getRequestDispatcher("/student.jsp").forward(request, response);
            if (user.getIdent().equals("教师"))
                request.getRequestDispatcher("/teacher.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
