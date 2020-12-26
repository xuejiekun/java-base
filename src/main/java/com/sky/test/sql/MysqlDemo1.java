package com.sky.test.sql;

import com.sky.test.log.MyLogger;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;

public class MysqlDemo1 {
    private static String CONNECT_URL;
    private static String USER;
    private static String PASSWORD;
    private static final Logger logger = MyLogger.getLogger();

    static {
        try {
            GetProperties.setResourceFile("/druid.properties");
            CONNECT_URL = GetProperties.getProperties("url");
            USER = GetProperties.getProperties("username");
            PASSWORD = GetProperties.getProperties("password");

            logger.debug(CONNECT_URL);
            logger.debug(USER);
            logger.debug(PASSWORD);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(CONNECT_URL, USER, PASSWORD);

//            String sql = "insert into person(name, address) value (?, ?)";
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, "xiaohong");
//            stmt.setString(2, "hongkong");
//            stmt.executeUpdate();

            String sql = "select id, name, address from person";
            stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                String address = result.getString(3);
                System.out.printf("id:%d name:%s address:%s\n", id, name, address);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
