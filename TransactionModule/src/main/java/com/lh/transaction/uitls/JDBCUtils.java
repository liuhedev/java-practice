package com.lh.transaction.uitls;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author liuhe
 * @date 2020/03/25
 */
public class JDBCUtils {

    //    相当于new ArrayList<>();一个线程一个连接
    static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static ComboPooledDataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource();
    }

    public static ComboPooledDataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取连接对象
     *
     * @return
     */
    public static Connection getConn() {
        try {
            Connection connection = threadLocal.get();
            if (null == connection) {
                connection = (Connection) dataSource.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void close(Connection conn, Statement statement) {
        close(conn, statement, null);
    }

    /**
     * 关闭连接，释放资源
     */
    public static void close(Connection conn, Statement statement, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
