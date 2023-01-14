package com.example.mastermanager.project.dao.impl;

import com.example.mastermanager.project.dao.ProjectDAO;
import com.example.mastermanager.project.po.Project;
import com.example.mastermanager.project.po.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl extends DAOBase implements ProjectDAO {
    private Connection conn;

    private static final String PROJECT_INSERT_SQL = "insert into project(leader, project_number, project_type, project_name, fund, begintime, endtime) values(?, ?, ?, ?, ?, ?, ?)";
    @Override
    public void addProject(Project project) {
        conn = null;
        try {
            conn = getConnection();
            PreparedStatement psmt = conn.prepareStatement(PROJECT_INSERT_SQL);
            psmt.setInt(1, project.getLeader());
            psmt.setString(2, project.getPnum());
            psmt.setString(3, project.getPtype());
            psmt.setString(4, project.getPname());
            psmt.setDouble(5, project.getFund());
            psmt.setDate(6, project.getBegintime());
            psmt.setDate(7, project.getEndtime());
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

    private static final String PROJECT_DELETE_SQL = "delete from project where project_id = ?";
    @Override
    public void deleteProject(Project project) {
        conn = null;
        try {
            conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(PROJECT_DELETE_SQL);
            preparedStatement.setInt(1, project.getPid());
            preparedStatement.executeUpdate();
            preparedStatement.close();
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

    private static final String PROJECT_UPDATE_SQL = "update project set leader = ?, project_number = ?, project_type = ?, project_name = ?, fund = ?, begintime = ?, endtime = ? where project_id = ?";
    @Override
    public void updateProject(Project project) {
        conn = null;
        try {
            conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(PROJECT_UPDATE_SQL);
            preparedStatement.setInt(1, project.getLeader());
            preparedStatement.setString(2, project.getPnum());
            preparedStatement.setString(3, project.getPtype());
            preparedStatement.setString(4, project.getPname());
            preparedStatement.setDouble(5, project.getFund());
            preparedStatement.setDate(6, project.getBegintime());
            preparedStatement.setDate(7, project.getEndtime());
            preparedStatement.setInt(8, project.getPid());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static final String PROJECT_SELECT_SQL = "select * from project where project_id = ?";
    @Override
    public Project getProjectByPid(Project project) {
        conn = null;
        Project result = null;
        System.out.println("getProjectByPid():" + project.getPid());
        try {
            conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(PROJECT_SELECT_SQL);
            preparedStatement.setInt(1, project.getPid());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = new Project();
                result.setPid(rs.getInt("project_id"));
                result.setLeader(rs.getInt("leader"));
                result.setPnum(rs.getString("project_number"));
                result.setPtype(rs.getString("project_type"));
                result.setPname(rs.getString("project_name"));
                result.setFund(rs.getDouble("fund"));
                result.setBegintime(rs.getDate("begintime"));
                result.setEndtime(rs.getDate("endtime"));
                System.out.println("getProjectByPid:" + result);
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    private static final String PROJECT_SELECTBYLEADER_SQL = "select * from project where leader = ?";
    @Override
    public List<Project> getProjectByLeader(User user) {
        conn = null;
        List<Project> result = new ArrayList<>();
        try {
            conn = getConnection();
            PreparedStatement pt = conn.prepareStatement(PROJECT_SELECTBYLEADER_SQL);
            System.out.println(user);
            pt.setInt(1, user.getUid());
            ResultSet rs = pt.executeQuery();
            int i = 1;
            while (rs.next()) {
                Project project = new Project();
                project.setPid(rs.getInt("project_id"));
                project.setLeader(user.getUid());
                project.setPnum(rs.getString("project_number"));
                project.setPtype(rs.getString("project_type"));
                project.setPname(rs.getString("project_name"));
                project.setFund(rs.getDouble("fund"));
                project.setBegintime(rs.getDate("begintime"));
                project.setEndtime(rs.getDate("endtime"));

                result.add(project);
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
