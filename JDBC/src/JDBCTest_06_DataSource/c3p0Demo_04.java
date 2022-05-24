package JDBCTest_06_DataSource;

import Util.DBUtil_c3p0;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Charon
 * @date 2020/6/24
 * @内容  c3p0利用工具类操作数据库
 **/
public class c3p0Demo_04 {

    @Test
    public void test_insert(){

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            /*1.导包，写配置，加载配置*/
            /*2.获取数据源对象*/
            /*3.获取连接*/
            conn = DBUtil_c3p0.getconnection();
            String sql = "insert into xs_kc values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"088888");
            pstmt.setString(2,"888");
            pstmt.setInt(3,100);
            pstmt.setInt(4,88);

            /*4.执行sql*/
            int count = pstmt.executeUpdate();
            if (count>=1){
                System.out.println("执行成功！");
            }else {
                System.out.println("执行失败！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil_c3p0.close(conn,pstmt);
        }

    }

}
