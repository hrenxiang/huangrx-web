package Util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Charon
 * @date 2020/6/24
 * @content c3p0工具类
 **/
public class DBUtil_c3p0 {

    private static ComboPooledDataSource ds;

    static {
        /*try {
            *//*1.导包，写配置，加载配置*//*
            InputStream is = DBUtil_c3p0.class.getClassLoader().getResourceAsStream("c3p0-config.xml");
            Properties pro = new Properties();
            pro.load(is);

            *//*2.创建数据源对象*//*
            ds = new ComboPooledDataSource();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        ds = new ComboPooledDataSource();
    }

    /*连接*/
    public static Connection getconnection() throws SQLException {
        return ds.getConnection();
    }

    /*归还*/
    public static void close(Connection conn, Statement pstmt, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /*归还*/
    public static void close(Connection conn, Statement pstmt){

        if (pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /*获取数据源对象，dbutil/jdbctemplate时调用*/
    public static DataSource getDataSource(){
        return ds;
    }

}
