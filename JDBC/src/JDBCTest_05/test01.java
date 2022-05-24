package JDBCTest_05;

import Util.DBUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class test01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的课程号");
        String Course = sc.nextLine();

        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs =null;

        try {
            //获取连接
            conn = DBUtil2.getConnection();
            //开启事务
            conn.setAutoCommit(false);

            //获取预编译数据库操作对象
            String sql = "select * from xs_kc where 课程号=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, Course);

            //运行sql语句
            rs = ps.executeQuery();

            //处理结果集
            while (rs.next()){
                System.out.println(rs.getString(1)+":"+rs.getString(2));
            //提交事务
            conn.commit();
            }
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
            DBUtil2.Close(conn,ps,rs);

        }
    }
}
