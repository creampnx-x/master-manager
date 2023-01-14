package com.example.mastermanager.project.dao.impl;

import com.example.mastermanager.project.dao.DAO;

import java.sql.Connection;
import java.sql.DriverManager;


/*
* 基于SqlServer的连接实现类
* */
public class DAOBase implements DAO {
    @Override
    public Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433; DatabaseName=master_manager";
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, "root", "root");
            System.out.println("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }
        return conn;
    }
}
