package JDBCTest_05;

import Util.DBUtil3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Charon
 * @date 2020/6/18
 * 复习JDBC CURD使用方法
 * 1.注册驱动
 * 2.获取连接
 * 3.获取预编译数据库操作对象
 * 4.执行sql语句
 * 5.处理查询结果集
 * 6.关闭资源
 **/
public class test_03 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil3.getConnection();
            String sql = "select * from xs where 性别=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "1");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + "|" + rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            DBUtil3.close(conn, ps, rs);

        }
    }
}
