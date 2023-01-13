package com.example.mastermanager.module1.DAO;

import com.example.mastermanager.module1.pojo.User;
import com.example.mastermanager.module1.DAO.DAOBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends DAOBase implements UserDao {
    private static final String STUDENT_SELECT1_SQL = "SELECT * FROM [User] where username = ?";
    private static final String STUDENT_INSERT_SQL = "INSERT INTO [User] (uid,username,password,ident,realname,subject) VALUES(?,?,?,?,?,?) ";

    @Override
    public User Login(String username,String password) {
        Connection con = null;
        User user = new User();
        try {
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_SELECT1_SQL);
            psmt.setString(1, username);
            ResultSet rs = psmt.executeQuery();
            String p = "";
            int u = -1;
            rs.next();
            user.setUid(rs.getInt("uid"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setIdent(rs.getString("ident"));
            user.setRealname(rs.getString("realname"));
            user.setSubject(rs.getString("subject"));
            if (rs.getString("password").equals(password))
                return user;
            psmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUDENT_INSERT_SQL);
            psmt.setInt(1, user.getUid());
            psmt.setString(2, user.getUsername());
            psmt.setString(3, user.getPassword());
            psmt.setString(4, user.getRealname());
            psmt.setString(5, user.getIdent());
            psmt.setString(6, user.getSubject());
            psmt.executeUpdate();
            System.out.println("添加成功");
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
