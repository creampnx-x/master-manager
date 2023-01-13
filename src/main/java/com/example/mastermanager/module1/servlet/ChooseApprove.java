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

@WebServlet("/chooseApprove")
public class ChooseApprove extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int cid = Integer.parseInt(request.getParameter("cid"));
        int mid = Integer.parseInt(request.getParameter("mid"));
        DAOFactory.getInstance().getChooseDAO().updateChoose(new Choose("",mid,"",cid,0,1));//只要按mid和cid更新state
        request.getRequestDispatcher("/teacher.jsp").forward(request, response);
    }
}