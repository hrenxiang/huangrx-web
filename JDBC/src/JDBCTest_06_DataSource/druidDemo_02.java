package JDBCTest_06_DataSource;

import Util.DruidUtil;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Charon
 * @date 2020/6/23
 * druidutil 工具类的测试
 **/
public class druidDemo_02 {

    @Test
    public void test_util(){

        /*0.导包，写配置文件，工具类，静态代码块（加载配置文件）已经加载*/
        Connection conn = null;
        PreparedStatement pstmt=null;
        /*1.获取数据库连接池*/
        try {
            /*2.获取连接*/
            conn = DruidUtil.getConnection();
            /*3.书写sql语句，获取数据库操作对象,添加值*/
            String sql = "insert into xs_kc values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"081260");
            pstmt.setString(2,"100");
            pstmt.setInt(3,90);
            pstmt.setInt(4,10);

            /*4.执行sql语句*/
            int i = pstmt.executeUpdate();
            System.out.println(i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{

            DruidUtil.close(conn,pstmt);

        }

    }

}
