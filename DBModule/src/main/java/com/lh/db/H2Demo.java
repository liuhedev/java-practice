package com.lh.db;

import java.sql.*;

/**
 * @author liuhe
 * @date 2020/03/24
 */
public class H2Demo {
    //服务式
//    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
//    内嵌式-持久化
    private static final String JDBC_URL = "jdbc:h2:~/test";

    //连接H2数据库时使用的驱动类，org.h2.Driver这个类是由H2数据库自己提供的，在H2数据库的jar包中可以找到
    private static final String DRIVER_CLASS = "org.h2.Driver";
    //用户名
    private static final String USER = "sa";
    //连接数据库时使用的密码，默认为空
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            // 加载H2数据库驱动
            Class.forName(DRIVER_CLASS);
            // 根据连接URL，用户名，密码获取数据库连接
            Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String createSql = "CREATE TABLE IF NOT EXISTS t_tech (id int auto_increment primary key,name varchar(20),age int)";
            statement.execute(createSql);

            String sql = "insert into t_tech(`name`,`age`) values('tom',14)";
            statement.executeUpdate(sql);

            String selectSql = "select * from t_tech where age>12";

            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                System.out.println(name + "#" + age);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
