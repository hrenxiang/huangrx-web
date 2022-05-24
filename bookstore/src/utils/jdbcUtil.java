package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Charon
 * @date 2020/7/7
 **/
public class jdbcUtil {

    private static DataSource ds;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        InputStream is = jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pro = new Properties();

        try {
            pro.load(is);

            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return 返回的的为Connection连接对象
     */
    public static Connection getConnection() {
        Connection conn = conns.get();

        try {
            if (conn == null) {
                conn = ds.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void commitAndClose() {

        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则就会出错。（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();

    }

    public static void rollbackAndClose() {

        Connection connection = conns.get();

        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则就会出错。（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 关闭数据库连接
     *
     * @param conn 连接对象
     */
    public static void close(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * update执行sql语句时使用
     *
     * @param conn  连接对象
     * @param pstmt 数据库操作对象
     */
    public static void close(Connection conn, Statement pstmt) {

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * query时使用
     *
     * @param conn  连接对象
     * @param pstmt 数据库操作对象
     * @param rs    结果集对象
     */
    public static void close(Connection conn, Statement pstmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return 返回数据库连接池对象
     */
    public static DataSource getDataSouce() {
        return ds;
    }
}
