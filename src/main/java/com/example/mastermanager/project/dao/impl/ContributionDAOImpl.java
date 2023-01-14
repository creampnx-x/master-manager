package com.example.mastermanager.project.dao.impl;

import com.example.mastermanager.project.dao.ContributionDAO;
import com.example.mastermanager.project.po.Contribution;
import com.example.mastermanager.project.po.User;
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import sun.awt.IconInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ContributionDAOImpl extends DAOBase implements ContributionDAO {
    private Connection conn;

    private static final String CONTRIBUTION_INSERT_SQL = "insert into contribution(project_id, userid, begintime, endtime, work, fund, leader_confirm, teacher_confirm, submit) values (?,?,?,?,?,?,?,?,?)";
    @Override
    public void addContribution(Contribution contribution) {
        conn = null;
        try {
            conn = getConnection();
            PreparedStatement psmt = conn.prepareStatement(CONTRIBUTION_INSERT_SQL);
            psmt.setInt(1, contribution.getPid());
            psmt.setInt(2, contribution.getUid());
            psmt.setDate(3, contribution.getBegintime());
            psmt.setDate(4, contribution.getEndtime());
            psmt.setString(5, contribution.getWork());
            psmt.setDouble(6, contribution.getFund());
            psmt.setBoolean(7, contribution.isLeader());
            psmt.setBoolean(8, contribution.isTeacher());
            psmt.setBoolean(9, contribution.isSubmit());
            psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static final String STUDENT_CONTRIBUTION_SQL = "select * from contribution where userid = ?";
    public List<Contribution> getStudentContribution(User user) {
        conn = null;
        List<Contribution> result = new ArrayList<>();
        try {
            conn = getConnection();
            PreparedStatement pt = conn.prepareStatement(STUDENT_CONTRIBUTION_SQL);
            pt.setInt(1, user.getUid());
            ResultSet rs = pt.executeQuery();
            while(rs.next()) {
                Contribution contribution = new Contribution();
                contribution.setCid(rs.getInt("contribution_id"));
                contribution.setPid(rs.getInt("project_id"));
                contribution.setUid(user.getUid());
                contribution.setBegintime(rs.getDate("begintime"));
                contribution.setEndtime(rs.getDate("endtime"));
                contribution.setWork(rs.getString("work"));
                contribution.setFund(rs.getDouble("fund"));
                contribution.setLeader(rs.getBoolean("leader_confirm"));
                contribution.setTeacher(rs.getBoolean("teacher_confirm"));
                contribution.setSubmit(rs.getBoolean("submit"));
                result.add(contribution);
            }
            pt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static final String TEACHER_STUDENT_CONTRIBUTION = "select * from contribution where project_id = ?";
    @Override
    public Contribution getContributionByPid(Integer pid) {
        conn = null;
        Contribution contribution = null;
        try {
            conn = getConnection();
            PreparedStatement pt = conn.prepareStatement(TEACHER_STUDENT_CONTRIBUTION);
            pt.setInt(1, pid);
            ResultSet rs = pt.executeQuery();
            while(rs.next()) {
                contribution = new Contribution();
                contribution.setCid(rs.getInt("contribution_id"));
                contribution.setPid(pid);
                contribution.setUid(rs.getInt("userid"));
                contribution.setBegintime(rs.getDate("begintime"));
                contribution.setEndtime(rs.getDate("endtime"));
                contribution.setWork(rs.getString("work"));
                contribution.setFund(rs.getDouble("fund"));
                contribution.setLeader(rs.getBoolean("leader_confirm"));
                contribution.setTeacher(rs.getBoolean("teacher_confirm"));
                contribution.setSubmit(rs.getBoolean("submit"));
            }
            pt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return contribution;
    }

    private static final String CONTRIBUTION_DELETE_SQL = "";
    @Override
    public void deleteContribution(Contribution contribution) {

    }

    private static final String CONTRIBUTION_UPDATE_SQL = "update contribution set project_id = ?, userid = ?, begintime = ?, endtime = ?, work = ?, fund = ?, leader_confirm = ?, teacher_confirm = ?, submit = ? where contribution_id = ?";
    @Override
    public void updateContribution(Contribution contribution) {
        conn = null;
        try {
            conn = getConnection();
            PreparedStatement pt = conn.prepareStatement(CONTRIBUTION_UPDATE_SQL);
            pt.setInt(1, contribution.getPid());
            pt.setInt(2, contribution.getUid());
            pt.setDate(3, contribution.getBegintime());
            pt.setDate(4, contribution.getEndtime());
            pt.setString(5, contribution.getWork());
            pt.setDouble(6, contribution.getFund());
            pt.setBoolean(7, contribution.isLeader());
            pt.setBoolean(8, contribution.isTeacher());
            pt.setBoolean(9, contribution.isSubmit());
            pt.setInt(10, contribution.getCid());
            pt.executeUpdate();
            pt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static final String CONTRIBUTION_SELECT_SQL = "select * from contribution where contribution_id = ?";
    @Override
    public Contribution getContributionByCid(Contribution contribution) {
        conn = null;
        Contribution result = null;
        try {
            conn = getConnection();
            PreparedStatement pt = conn.prepareStatement(CONTRIBUTION_SELECT_SQL);
            pt.setInt(1, contribution.getCid());
            ResultSet rs = pt.executeQuery();
            while(rs.next()) {
                result = new Contribution();
                result.setCid(rs.getInt("contribution_id"));
                result.setPid(rs.getInt("project_id"));
                result.setUid(rs.getInt("userid"));
                result.setBegintime(rs.getDate("begintime"));
                result.setEndtime(rs.getDate("endtime"));
                result.setWork(rs.getString("work"));
                result.setFund(rs.getDouble("fund"));
                result.setLeader(rs.getBoolean("leader_confirm"));
                result.setTeacher(rs.getBoolean("teacher_confirm"));
                result.setSubmit(rs.getBoolean("submit"));
            }
            pt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
