package com.lh.db;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * @author liuhe
 * @date 2020/03/23
 */
public class StatementDemo {

    //协议 + 访问的数据库 ， 参数二： 用户名 ， 参数三： 密码。
    public static String url = "jdbc:mysql://localhost/students";
    public static String username = "root";
    public static String password = "root";

    public static void main(String[] args) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
//            1、注册驱动
            DriverManager.registerDriver(new Driver());
//            2、创建链接
            connection = DriverManager.getConnection(url, username, password);
//            3.创建statement代理操作数据库
            statement = connection.createStatement();
            String sql = "select * from t_student";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("id=" + id + "===name=" + name + "==age=" + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            4、释放资源
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                } // ignore
                connection = null;
            }
        }

    }
}
