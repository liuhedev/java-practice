package com.lh.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author liuhe
 * @date 2020/03/24
 */
public class PreparedStatementDemo {

    public static void main(String[] args) {
        Connection conn = JdbcUtils.getConn();

        // insert(conn);
        select(conn);

    }

    private static void select(Connection conn) {
        String sql = "select * from t_student where name=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "liuhe");
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean next = resultSet.next();
            if (next){
                String age = resultSet.getString("age");
                System.out.println(age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insert(Connection conn) throws SQLException {
        try {
            String sql = "insert into t_student values(null , ? , ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //3. 填充占位符
            preparedStatement.setString(1, "唐三藏");
            preparedStatement.setInt(2, 28);

            //4. 执行Statement
            int result = preparedStatement.executeUpdate();
            System.out.println("result=" + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
