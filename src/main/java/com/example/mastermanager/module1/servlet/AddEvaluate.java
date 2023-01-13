package com.example.mastermanager.module1.servlet;

import com.example.mastermanager.module1.DAO.DAO;
import com.example.mastermanager.module1.DAO.DAOFactory;
import com.example.mastermanager.module1.pojo.Choose;
import com.example.mastermanager.module1.pojo.Course;
import com.example.mastermanager.module1.pojo.Evaluate;
import com.example.mastermanager.module1.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addEvaluate")
public class AddEvaluate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Evaluate evaluate = new Evaluate(Integer.parseInt(request.getParameter("sid")),request.getParameter("sname"),request.getParameter("cname"),Integer.parseInt(request.getParameter("num")),request.getParameter("subject"),request.getParameter("property"),request.getParameter("object"),request.getParameter("tname"),request.getParameter("time"),request.getParameter("self"),request.getParameter("comment"));

        DAOFactory.getInstance().getEvaluateDAO().addEvaluate(evaluate);
        request.getRequestDispatcher("teacher.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
