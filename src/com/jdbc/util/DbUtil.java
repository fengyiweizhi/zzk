package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 风亦未止
 */
public class DbUtil {
    private String userName="root";
    private String passWord="123456";
    private String url="jdbc:mysql://localhost:3306/flight?serverTimezone=UTC";
    //连接数据库
    protected Connection getConnection(){
        Connection connection = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection(url, userName, passWord);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

}
