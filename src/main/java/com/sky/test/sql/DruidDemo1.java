package com.sky.test.sql;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DruidDemo1 {

    public static void main(String[] args) {
        // 声明配置变量
        Properties pro = new Properties();
        InputStream stream =
                DruidDemo1.class.getResourceAsStream("/druid.properties");

        // 声明数据库变量，需要释放
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // 加载配置文件
            pro.load(stream);

            // 获取连接池和连接
            DataSource db = DruidDataSourceFactory.createDataSource(pro);
            conn = db.getConnection();

            // 执行查询
            String sql = "select id, name, address from person";
            stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery(sql);

            // 获取结果
            while (result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                String address = result.getString(3);
                System.out.printf("id:%d name:%s address:%s\n", id, name, address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
