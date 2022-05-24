package Util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author Charon
 * @date 2020/6/18
 * 复习JDBC工具类的书写
 * 0.给出无参构造方法
 * 1.绑定jdbc配置文件
 * 2.获取文件中的信息，使其在一个静态代码块中代码（引文这些信息只需要加载一次）
 * 3.静态代码块中应包含 驱动注册，因为注册一次就够了
 * 4.整合可以使jdbc代码书写简单的方法
 * --- 获取连接
 * --- 关闭资源
 **/
public class DBUtil3 {

    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public DBUtil3() {
    }

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        user = bundle.getString("user");
        password = bundle.getString("password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Connection conn, Statement ps, ResultSet rs) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static void close(Connection conn, Statement ps) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}