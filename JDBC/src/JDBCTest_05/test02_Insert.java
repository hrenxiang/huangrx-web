package JDBCTest_05;

import Util.DBUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test02_Insert {

    public static void main(String[] args) {

        Connection conn =null;
        PreparedStatement ps = null;

        try {
            //获取连接
            conn = DBUtil2.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            //获取预编译数据库操作对象
            String sql = "insert into xs_kc  values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "081360");
            ps.setString(2, "888");
            ps.setString(3, "100");
            ps.setString(4, "10");

            //运行sql语句
            int count = ps.executeUpdate();
            System.out.println(count);

            //提交事务
            conn.commit();

        } catch (SQLException e) {

            if (conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally{
            //关闭资源
            DBUtil2.Close(conn,ps);

        }
    }
}