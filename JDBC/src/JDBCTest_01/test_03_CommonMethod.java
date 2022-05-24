package JDBCTest_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test_03_CommonMethod {

    public static void main(String[] args) {

        Connection conn = null;

        try {

            //1、注册驱动（用com.mysql.jdbc.Driver中提供的静态代码块)
            Class.forName("com.mysql.jdbc.Driver");

            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xscj", "root", "hhhh");
            System.out.println("数据库连接成功" + conn);

            //3、获取数据库管理对象


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }

}
