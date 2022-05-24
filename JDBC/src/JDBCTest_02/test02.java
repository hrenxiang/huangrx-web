package JDBCTest_02;

import java.sql.*;

public class test02 {

    public static void main(String[] args) {

        Statement stmt = null;
        Connection conn = null;

        try{
            //1、注册驱动
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xscj","root","hhhh");

            //3、获取数据库操作对象
            stmt = conn.createStatement();
            String sql = "delete from xs_kc where 学号= '081250'";

            //4、执行sql 语句
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "执行成功":"执行失败");

        }catch(SQLException e){
            e.printStackTrace();
        }finally{}
            //6、关闭资源
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
    }
}
