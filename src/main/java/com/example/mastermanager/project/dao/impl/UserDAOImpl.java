package com.example.mastermanager.project.dao.impl;

import com.example.mastermanager.project.dao.UserDAO;
import com.example.mastermanager.project.po.Project;
import com.example.mastermanager.project.po.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl extends DAOBase implements UserDAO {
    private Connection conn;

    private static final String USER_SELECT_SQL = "select * from [User] where userid = ? and password = ?";
    @Override
    public User getUser(User user) {
        System.out.println("getUser()");
        conn = null;
        User result = null;
        try {
            conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(USER_SELECT_SQL);
            preparedStatement.setInt(1, user.getUid());
            preparedStatement.setString(2, user.getPassword());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = new User();
                result.setUid(rs.getInt("userid"));
                result.setRealname(rs.getString("realname"));
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password"));
                result.setSubject(rs.getString("subject"));
                result.setRid(rs.getInt("roleid"));
                System.out.println("查询到用户信息：" + result);
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
}
