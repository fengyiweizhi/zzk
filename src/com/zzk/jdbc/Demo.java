package com.zzk.jdbc;

import java.sql.*;

/**
 *jdbc
 * @author 风亦未止
 */
public class Demo {
    public static void main(String[] args){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String userName="root";
            String passWord="123456";
            String url="jdbc:mysql://localhost:3306/hello?serverTimezone=UTC";
            connection = DriverManager.getConnection(url, userName, passWord);
            //定义sql，创建状态通道（进行sql语句的发送）不安全
            statement = connection.createStatement();
            //这样查询不不安全
            resultSet = statement.executeQuery("SELECT * FROM student");

            //为了安全，应该创建预状态通道（进行sql语句的发送）
            String sql="SELECT * FROM student WHERE name=? AND id=?";
            //这样才安全
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"zk");
            preparedStatement.setInt(2,1);
            //执行sql语句
            ResultSet resultSet1 = preparedStatement.executeQuery();
            if (resultSet1.next()){
                System.out.println(resultSet1.getString("name")+resultSet1.getInt("age"));
            }

//           int i = statement.executeUpdate("INSERT INTO student (name, age, sex) VALUES (zzK, 123, nan4)");//增
//           int i = statement.executeUpdate("UPDATE student SET name='zk' WHERE id=1");//改
//           int i = statement.executeUpdate("DELETE FROM student WHERE id=1;");//查
//            if (i>0){
//                System.out.println("插入成功");
//            }else {
//                System.out.println("插入失败");
//            }

            //取出结果集信息
            while (resultSet.next()){//判断是否有下一条数据
                System.out.println("姓名："+resultSet.getString("name")+" 年龄："+resultSet.getInt("age")+" 性别："+resultSet.getString("sex"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (resultSet!=null){
                    resultSet.close();
                }
                if ( connection!=null){
                    connection.close();
                }
                if ( statement!=null){
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
