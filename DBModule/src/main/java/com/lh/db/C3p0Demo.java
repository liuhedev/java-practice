package com.lh.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author liuhe
 * @date 2020/03/24
 */
public class C3p0Demo {

    public static void main(String[] args) {
//        handleDbByCode();
        handleDbByXml();
    }

    private static void handleDbByXml() {
        //默认会读取xml文件内容。 所以xml的名字必须固定。
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //获取连接
        Connection conn = null;
        //3. 执行语句
        String sql = "insert into t_student values(null ,?,?)";
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "lisi2");
            ps.setInt(2, 19);
            int i = ps.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源..回收连接对象
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleDbByCode() {
        try {
            //1. 创建一个属性配置对象
            Properties properties = new Properties();
            //使用类加载器，去读取src底下的资源文件。 后面在servlet
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("application.properties");
            //导入输入流。
            properties.load(is);

            //读取属性
            String driverClass = properties.getProperty("driverClass");
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driverClass);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);

            dataSource.setInitialPoolSize(5);
            dataSource.setMaxPoolSize(10);

            Connection connection = dataSource.getConnection();
            String sql = "insert into t_student values(null,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "猪八戒");
            preparedStatement.setInt(2, 30);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
