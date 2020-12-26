package com.sky.test.sql;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class MyDataSource {
    private static DataSource db;

    static {
        Properties pro = new Properties();
        InputStream stream =
                DruidDemo1.class.getResourceAsStream("/druid.properties");

        try {
            pro.load(stream);
            db = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return db;
    }
}
