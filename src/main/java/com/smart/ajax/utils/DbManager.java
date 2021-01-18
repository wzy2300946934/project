package com.smart.ajax.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DbManager {
    private static DataSource dataSource;
    public static final String PROPERTIES_NAME="db.properties";

    static {
        Properties properties = new Properties();
        try {
            properties.load(DbManager.class.getClassLoader().getResourceAsStream(PROPERTIES_NAME));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接的方法
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    public static void close(ResultSet resultSet, Connection connection, Statement statement) throws SQLException {
        if (resultSet!=null){
            resultSet.close();
        }
        if (connection!=null){
            connection.close();
        }
        if (statement!=null){
            statement.close();
        }
    }

    public static void close(Connection connection, Statement statement) throws SQLException {
        close(null,connection,statement);
    }


}
