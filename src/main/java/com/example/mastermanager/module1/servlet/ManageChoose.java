package com.example.mastermanager.module1.servlet;

import com.example.mastermanager.module1.DAO.DAOFactory;
import com.example.mastermanager.module1.pojo.Choose;
import com.example.mastermanager.module1.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/choose")
public class ManageChoose extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Choose> list = DAOFactory.getInstance().getChooseDAO().selectByTid(user.getUid());//获取审批列表
        request.setAttribute("list",list);
        request.getRequestDispatcher("/choose.jsp").forward(request, response);
    }
}