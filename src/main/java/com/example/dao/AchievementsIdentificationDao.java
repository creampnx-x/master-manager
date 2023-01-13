package com.example.dao;

import com.example.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AchievementsIdentificationDao {
    BaseDao baseDao = new BaseDao();

    public ArrayList<Identification> getFullIdentificationList(long user, boolean isAll, boolean isMentor) throws ClassNotFoundException, SQLException {
        ResultSet resultSet = baseDao.executeSQL(
                "SELECT * FROM dbo.achievements_identificate" +
                        (isAll ? ";" : (" WHERE " + (isMentor ? "mentor = ?;" : "sponsor = ?;"))),
                isAll ? new Object[]{} : new Object[]{user}
        );

        ArrayList<Identification> result = new ArrayList<>();

        while (resultSet.next()) {
            Identification identification = new Identification();
            identification.setId(resultSet.getInt("id"));
            if (resultSet.getString("user_type").equals("master")) {
                MasterAchievements masterAchievements = getMasterAchievements(resultSet.getInt("achievements"));
                Paper paper = getPaper((int) masterAchievements.getPaper());
                com.example.model.Achievements.MasterAchievements achievements = new com.example.model.Achievements.MasterAchievements(masterAchievements, paper);
                identification.setMasterAchievements(achievements);
            } else {
                DoctorAchievements doctorAchievements = getDoctorAchievements(resultSet.getInt("achievements"));
                Paper paper = getPaper((int) doctorAchievements.getPaper());
                Prize prize = getPrize((int) doctorAchievements.getPrize());
                com.example.model.Achievements.DoctorAchievements achievements = new com.example.model.Achievements.DoctorAchievements(paper, prize, doctorAchievements);
                identification.setDoctorAchievements(achievements);
            }
            identification.setSponsor(resultSet.getInt("sponsor"));
            identification.setInitialStatus(resultSet.getString("initial_status"));
            identification.setFinalStatus(resultSet.getString("final_status"));
            identification.setUserType(resultSet.getString("user_type"));
            result.add(identification);
        }

        return result;
    }

    /**
     * 获取成果认定列表
     *
     * @param sponsor 提出者
     * @return f
     */
    public ArrayList<AchievementsIdentification> getIdentificationList(int sponsor) throws ClassNotFoundException, SQLException {
        // _todo: 细化查询接口 已解决
        ResultSet resultSet = baseDao.executeSQL(
                "SELECT * FROM dbo.achievements_identificate WHERE sponsor = ?;",
                new Object[]{sponsor}
        );

        ArrayList<AchievementsIdentification> result = new ArrayList<>();
        AchievementsIdentification identification = new AchievementsIdentification();

        while (resultSet.next()) {
            identification.setId(resultSet.getInt("id"));
            identification.setAchievements(resultSet.getInt("achievements"));
            identification.setSponsor(resultSet.getInt("sponsor"));
            identification.setInitialStatus(resultSet.getString("initial_status"));
            identification.setFinalStatus(resultSet.getString("final_status"));
            identification.setUserType(resultSet.getString("user_type"));
            identification.setMentor(resultSet.getInt("mentor"));
            result.add(identification);
        }

        return result;
    }

    /**
     * @param id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public MasterAchievements getMasterAchievements(int id) throws ClassNotFoundException, SQLException {
        ResultSet resultSet = baseDao.executeSQL(
                "SELECT * FROM dbo.master_achievements WHERE id = ?;",
                new Object[]{id}
        );

        MasterAchievements achievements = new MasterAchievements();

        while (resultSet.next()) {
            achievements.setId(resultSet.getInt("id"));
            achievements.setPaper(resultSet.getInt("paper"));
            achievements.setDevCertificate(resultSet.getString("dev_certificate"));
            achievements.setPatent(resultSet.getString("patent"));
            achievements.setReport(resultSet.getString("report"));
            achievements.setStandard(resultSet.getString("standard"));
            achievements.setTextbook(resultSet.getString("textbook"));
        }

        return achievements;
    }

    public DoctorAchievements getDoctorAchievements(int id) throws ClassNotFoundException, SQLException {
        ResultSet resultSet = baseDao.executeSQL(
                "SELECT * FROM dbo.doctor_achievements WHERE id = ?;",
                new Object[]{id}
        );

        DoctorAchievements achievements = new DoctorAchievements();

        while (resultSet.next()) {
            achievements.setId(resultSet.getInt("id"));
            achievements.setPaper(resultSet.getInt("paper"));
            achievements.setStandard(resultSet.getString("standard"));
            achievements.setOthers(resultSet.getString("others"));
            achievements.setPrize(resultSet.getInt("prize"));
        }

        return achievements;
    }

    public Paper getPaper(int id) throws ClassNotFoundException, SQLException {
        ResultSet resultSet = baseDao.executeSQL(
                "SELECT * FROM dbo.paper WHERE id = ?;",
                new Object[]{id}
        );

        Paper paper = new Paper();

        while (resultSet.next()) {
            paper.setId(resultSet.getInt("id"));
            paper.setName(resultSet.getString("name"));
            paper.setRepo(resultSet.getString("repo"));
            paper.setResource(resultSet.getString("resource"));
            paper.setPublication(resultSet.getString("publication"));
            paper.setTime(resultSet.getDate("time"));
            paper.setIndexType(resultSet.getString("index_type"));
            paper.setStatus(resultSet.getString("status"));
        }

        return paper;
    }

    public Prize getPrize(int id) throws ClassNotFoundException, SQLException {
        ResultSet resultSet = baseDao.executeSQL(
                "SELECT * FROM dbo.prize WHERE id = ?;",
                new Object[]{id}
        );

        Prize prize = new Prize();

        while (resultSet.next()) {
            prize.setId(resultSet.getInt("id"));
            prize.setName(resultSet.getString("name"));
            prize.setResource(resultSet.getString("resource"));
            prize.setTime(resultSet.getDate("time"));
            prize.setAwardsRank(resultSet.getString("awards_rank"));
            prize.setPrizeLevel(resultSet.getString("prize_level"));
            prize.setRank(resultSet.getString("rank"));
        }

        return prize;
    }

    public long insertPaper(Paper paper) throws ClassNotFoundException {
        String values = String.format("values (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                paper.getId(), paper.getName(), paper.getPublication(), paper.getStatus(),
                paper.getIndexType(), paper.getTime().toString(), paper.getRepo(), paper.getResource());

        baseDao.executeSQL(
                "insert into dbo.paper " +
                        "(id, name, publication, status, index_type, time, repo, resource) " +
                        values,
                new Object[]{}
        );

        return paper.getId();
    }

    public long insertPrize(Prize prize) throws ClassNotFoundException {
        String sql = "insert into dbo.prize (id, name, prize_level, awards_rank, rank, time, resource) ";
        String values = String.format("values (%d, '%s', '%s', '%s', '%s', '%s', '%s');",
                prize.getId(), prize.getName(), prize.getPrizeLevel(), prize.getAwardsRank(), prize.getRank(), prize.getTime().toString(), prize.getResource());

        baseDao.executeSQL(sql + values, new Object[]{});
        return prize.getId();
    }

    public long insertMasterIdentification(MasterAchievements masterAchievements) throws ClassNotFoundException {
        String sql = "insert into dbo.master_achievements (id, paper, textbook, standard, patent, report, dev_certificate) ";
        String values = String.format("values (%d, %d, '%s', '%s', '%s', '%s', '%s');",
                masterAchievements.getId(), masterAchievements.getPaper(), masterAchievements.getTextbook(), masterAchievements.getStandard(),
                masterAchievements.getPatent(), masterAchievements.getReport(), masterAchievements.getDevCertificate());
        baseDao.executeSQL(sql + values, new Object[]{});
        return masterAchievements.getId();
    }

    public long insertDoctorIdentification(DoctorAchievements doctorAchievements) throws ClassNotFoundException {
        String sql = "insert into dbo.doctor_achievements (id, paper, prize, standard, others) ";
        String values = String.format("values (%d, %d, %d, '%s', '%s');",
                doctorAchievements.getId(), doctorAchievements.getPaper(), doctorAchievements.getPrize(),
                doctorAchievements.getStandard(), doctorAchievements.getOthers());

        baseDao.executeSQL(sql + values, new Object[]{});
        return doctorAchievements.getId();
    }

    public long insertIdentification(AchievementsIdentification achievementsIdentification) throws ClassNotFoundException {
        String sql = "insert into dbo.achievements_identificate (id, sponsor, achievements, initial_status, final_status, user_type, mentor) ";
        String values = String.format("values (%d, %d, %d, '%s', '%s', '%s', %d);",
                achievementsIdentification.getId(), achievementsIdentification.getSponsor(),
                achievementsIdentification.getAchievements(), achievementsIdentification.getInitialStatus(), achievementsIdentification.getFinalStatus(),
                achievementsIdentification.getUserType(), achievementsIdentification.getMentor());

        baseDao.executeSQL(sql + values, new Object[]{});
        return achievementsIdentification.getId();
    }

    public void deleteIdentification(long id) throws ClassNotFoundException {
        String sql = "delete from dbo.achievements_identificate where id = ?;";

        baseDao.executeSQL(sql, new Object[]{id});
    }

    public void updateStatus(boolean isLast, long id, String status) throws ClassNotFoundException {
        String identifyingNode = "initial_status";
        if (isLast) {
            identifyingNode = "final_status";
        }
        String sql = String.format("update dbo.achievements_identificate set %s='%s' where id = %d;",
                identifyingNode, status, id);
        baseDao.executeSQL(sql, new Object[]{});
    }
}
