package com.lh.db;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * @author liuhe
 * @date 2020/03/23
 */
public class JdbcUtils {

    static String driverClass = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql:///heima02";
    static String username = "root";
    static String password = "root";

    static Connection connection = null;
    static ResultSet resultSet = null;
    static Statement statement = null;

    /**
     * 获取连接对象
     *
     * @return
     */
    public static Connection getConn() {
        Connection conn = null;
        try {

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
