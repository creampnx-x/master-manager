package com.example.mastermanager.module1.DAO;


import java.sql.Connection;
import java.sql.DriverManager;

public class DAOBase implements DAO {
    @Override
    public Connection getConnection() {
        String URL="jdbc:sqlserver://localhost:1433; DatabaseName=StudentManage ;useUnicode=true&characterEncoding=UTF-8";
        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(URL,"sa","sa");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}