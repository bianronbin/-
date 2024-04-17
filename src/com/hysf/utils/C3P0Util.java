package com.hysf.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.*;

public class C3P0Util {
    private static ComboPooledDataSource ds = null;

    static {
        ds = new ComboPooledDataSource();
        try {
            //注册驱动
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            //设置数据库地址
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8");
            //设置数据库用户名
            ds.setUser("root");
            //设置数据库密码
            ds.setPassword("123456");
            //当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。Default: 3
            ds.setAcquireIncrement(3);
            //定义在从数据库获取新连接失败后重复尝试的次数。Default: 30
            ds.setAcquireRetryAttempts(30);
            //两次连接中间隔时间，单位毫秒。Default: 1000
            ds.setAcquireRetryDelay(1500);
            //c3p0数据库连接池中初始化时的连接数
            ds.setInitialPoolSize(5);
            //c3p0数据库连接池维护的最多的连接数
            ds.setMaxPoolSize(20);
            //c3p0数据库连接池维护的最少连接数
            ds.setMinPoolSize(5);
            //c3p0数据库连接池最多维护的Statement的个数
            ds.setMaxStatements(30);
            //每个连接中可以最多使用的Statement的个数
            ds.setMaxStatementsPerConnection(5);
        } catch (PropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 从数据库链接池获取链接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放连接回链接池
     */
    public static void release(ResultSet rs, PreparedStatement pst, Statement st, Connection conn) {
        try {
            if (rs != null)
                rs.close();
            if (pst != null)
                pst.close();
            if (st != null)
                st.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
