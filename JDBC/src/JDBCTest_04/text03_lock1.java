package JDBCTest_04;

import Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class text03_lock1 {


    public static void main(String[] args) {

        Connection conn=null;
        PreparedStatement ps=null;

        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "update user set userPwd= ? where userName=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"999");
            ps.setString(2,"hh");

            int count = ps.executeUpdate();
            System.out.println(count);
            conn.commit();

        } catch (Exception e) {
            if (conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            e.printStackTrace();
        }finally{

            DBUtil.close(conn,ps);

        }


    }

}
