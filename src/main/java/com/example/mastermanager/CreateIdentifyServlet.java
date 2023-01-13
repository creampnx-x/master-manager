package com.example.mastermanager;

import com.example.dao.AchievementsIdentificationDao;
import com.example.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.Objects;

@WebServlet(name = "CreateIdentifyServlet", value = "/CreateIdentifyServlet")
public class CreateIdentifyServlet extends HttpServlet {
    AchievementsIdentificationDao database = new AchievementsIdentificationDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cors(response);

        // 先判断 user
        String userType = request.getParameter("user_type");
        long userID = Long.parseLong(request.getParameter("user_id"));

        // 先新建 paper
        Paper paper = new Paper();
        paper.setName(request.getParameter("paper_name"));
        paper.setRepo(request.getParameter("paper_repo"));
        paper.setStatus(request.getParameter("paper_status"));
        paper.setTime(new Date(Long.parseLong(request.getParameter("paper_time"))));
        paper.setIndexType(request.getParameter("paper_index_type"));
        paper.setResource(request.getParameter("paper_resource"));
        paper.setPublication(request.getParameter("paper_publication"));
        String noPaper = request.getParameter("no_paper");
        long paperID = !Objects.equals(noPaper, "1") ? Long.parseLong(String.valueOf((int) (Math.random() * 1000000))) : -1;
        paper.setId(paperID);
        try {
            database.insertPaper(paper);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 判断是否是博士新建prize
        long prizeID = -1;
        if (Objects.equals(userType, "doctor")) {
            prizeID = Long.parseLong(String.valueOf((int) (Math.random() * 1000000)));
            Prize prize = new Prize();
            prize.setId(prizeID);
            prize.setName(request.getParameter("prize_name"));
            prize.setPrizeLevel(request.getParameter("prize_level"));
            prize.setAwardsRank(request.getParameter("awards_rank"));
            prize.setRank(request.getParameter("rank"));
            prize.setResource(request.getParameter("prize_resource"));
            prize.setTime(new Date(Long.parseLong(request.getParameter("prize_time"))));
            try {
                database.insertPrize(prize);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        // 判断是否是博士新建成果
        long achievementsID = Long.parseLong(String.valueOf((int) (Math.random() * 1000000)));
        if (userType == "master") {
            MasterAchievements masterAchievements = new MasterAchievements();
            masterAchievements.setPaper(paperID);
            masterAchievements.setId(achievementsID);
            masterAchievements.setTextbook(request.getParameter("textbook"));
            masterAchievements.setStandard(request.getParameter("standard"));
            masterAchievements.setReport(request.getParameter("report"));
            masterAchievements.setPatent(request.getParameter("patent"));
            masterAchievements.setDevCertificate(request.getParameter("dev_certificate"));
            try {
                database.insertMasterIdentification(masterAchievements);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            DoctorAchievements doctorAchievements = new DoctorAchievements();
            doctorAchievements.setId(achievementsID);
            doctorAchievements.setPaper(paperID);
            doctorAchievements.setPrize(prizeID);
            doctorAchievements.setOthers(request.getParameter("others"));
            doctorAchievements.setStandard(request.getParameter("standard"));
            try {
                database.insertDoctorIdentification(doctorAchievements);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        // 创建成果实体
        long identificationID = Long.parseLong(String.valueOf((int) (Math.random() * 1000000)));
        AchievementsIdentification identification = new AchievementsIdentification();
        identification.setId(identificationID);
        identification.setSponsor(userID);
        identification.setAchievements(achievementsID);
        identification.setInitialStatus("pending");
        identification.setFinalStatus("pending");
        identification.setUserType(userType);
        identification.setMentor(Long.parseLong(request.getParameter("mentor")));
        try {
            database.insertIdentification(identification);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        response.getWriter().write(String.valueOf(identificationID));
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
