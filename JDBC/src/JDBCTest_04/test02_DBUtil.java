package JDBCTest_04;

import Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test02_DBUtil {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //获取连接
            conn = DBUtil.getConnection();
            //获取预编译数据库操作对象
            String sql = "select * from xs_kc where 课程号 like ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"1%");

            //执行语句
            rs = ps.executeQuery();

            //处理结果集
            while(rs.next()){
                System.out.println(rs.getString("课程号"));
            }
            //
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
    }
}
