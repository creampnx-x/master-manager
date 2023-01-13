package com.example.mastermanager;

import com.example.dao.AchievementsIdentificationDao;
import com.example.model.Identification;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "IdentifyList", value = "/IdentifyList")
public class IdentifyList extends HttpServlet {
    AchievementsIdentificationDao database = new AchievementsIdentificationDao();
    Gson gson = new GsonBuilder().create();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cors(response);
        String userType = request.getParameter("user_type");
        long user = Long.parseLong(request.getParameter("user_id"));

        try {
            ArrayList<Identification> list = database.getFullIdentificationList(user, Objects.equals(userType, "admin"), Objects.equals(userType, "mentor"));
            response.getWriter().write(gson.toJson(list));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        cors(response);
    }

    void cors(HttpServletResponse response) {
        /* 允许跨域的主机地址 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "4200");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }
}
