package JDBCTest_05;

import Util.DBUtil2;

import java.sql.*;

public class JDBC {

    private JDBC(){}

    public static void select() {

        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs=null;

        try {
            conn = DBUtil2.getConnection();

            conn.setAutoCommit(false);

            String sql = "select * from xs_kc where 课程号=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"101");

            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("学号")+":"+rs.getString("课程号")+":"+rs.getString("成绩"));
            }

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
            DBUtil2.Close(conn,ps,rs);
        }

    }

    //修改
    public static void update() {

        Connection conn=null;
        PreparedStatement ps = null;

        try {

            conn = DBUtil2.getConnection();

            conn.setAutoCommit(false);

            String sql = "update xs_kc set 学号=? where 课程号=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "10000");
            ps.setString(2, "888");

            int count = ps.executeUpdate();
            System.out.println(count);

            conn.commit();
        }catch (Exception e){
            if (conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            DBUtil2.Close(conn,ps);
        }
    }

    //删除
    public static void delete() {

        Connection conn=null;
        PreparedStatement ps = null;

        try {

            conn = DBUtil2.getConnection();

            conn.setAutoCommit(false);

            String sql = "delete from xs_kc where 学号=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "081360");

            int count = ps.executeUpdate();
            System.out.println(count);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil2.Close(conn,ps);
        }
    }

    //添加
    public static void insert() {

        Connection conn=null;
        PreparedStatement ps = null;

        try {

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
