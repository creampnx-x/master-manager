package com.example.dao;

import java.sql.*;

public class BaseDao {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;database=master_manager";
    private static String user = "root";
    private static String password = "root";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }


    public ResultSet executeSQL(String preparedSql, Object[] param) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    statement.setObject(i + 1, param[i]);
                }
            }
            result = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                BaseDao.closeAll(connection, statement, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
