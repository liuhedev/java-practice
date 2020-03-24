package com.lh.db;

import com.mysql.jdbc.Driver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author liuhe
 * @date 2020/03/23
 */
public class JdbcUtils {

    static String driverClass = null;
    static String url = null;
    static String username = null;
    static String password = null;

    static Connection connection = null;
    static ResultSet resultSet = null;
    static Statement statement = null;

    static {
        try {
            //1. 创建一个属性配置对象
            Properties properties = new Properties();
            //使用类加载器，去读取src底下的资源文件。 后面在servlet
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("application.properties");
            //导入输入流。
            properties.load(is);

            //读取属性
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接对象
     *
     * @return
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            //1. 创建一个属性配置对象
            Class.forName(driverClass);
            //2. 建立连接 参数一： 协议 + 访问的数据库 ， 参数二： 用户名 ， 参数三： 密码。
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void releaseDbResource(Connection conn, Statement st, ResultSet rs) {
        closeConn(conn);
        closeStatement(st);
        closeResultSet(rs);
    }

    private void closeResultSet(ResultSet rs) {
        try {
            if (null != rs) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeStatement(Statement st) {
        try {
            if (null != st) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConn(Connection conn) {
        try {
            if (null != conn) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
