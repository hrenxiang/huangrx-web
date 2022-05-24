package JDBCTest_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class text_04_properties {

    public static void main(String[] args) {


        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Statement stmt = null;
        Connection conn = null;

        try {
            //1、注册驱动
            Class.forName(driver);

            //2、获取连接
            conn = DriverManager.getConnection(url, user, password);

            //3、获取数据库操作对象
            stmt = conn.createStatement();
            String sql = "delete from xs_kc where 学号 = '081250'";

            //4、执行sql 语句
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "执行成功" : "执行失败");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //6、关闭资源
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
