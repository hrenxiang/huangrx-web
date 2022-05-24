package JDBCTest_04;

import Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class text03_lock {

    public static void main(String[] args) {

        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            conn=DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "select * from user where userName=? for update";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"hh");
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("userName")+":"+rs.getString("userPwd"));
            }
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
            DBUtil.close(conn,ps,rs);
        }
    }
}
