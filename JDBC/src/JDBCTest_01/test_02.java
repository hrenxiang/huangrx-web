package JDBCTest_01;

import java.sql.*;

/**
 * @author Charon
 * @date 2020/6/17
 **/
public class test_02 {

    public static void main(String[] args) {

        /*1.注册驱动：知道是那个数据库
        public class DriverManager extends Object用于管理一组JDBC驱动程序的基本服务
        registerDriver​(Driver driver) 使用 DriverManager注册给定的驱动程序。*/

        Statement stmt = null;
        Connection conn = null;

        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

        /*2.打开通道，进行连接：与数据库惊醒连接
        public static Connection getConnection​(String url,String user,String password) throws SQLException
        尝试建立与给定数据库URL的连接。 DriverManager尝试从一组已注册的JDBC驱动程序中选择适当的驱动程序。
        参数url - 表单 jdbc:subprotocol:subname的数据库URL  user - 正在进行连接的数据库用户  password - 用户密码*/

            String url = "jdbc:mysql://127.0.0.1:3306/xscj";
            String user = "root";
            String password = "hhhh";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("数据库连接成功=" + conn);
            //数据库连接成功=com.mysql.jdbc.JDBC4Connection@5d099f62


            //3.获取数据库操作对象：没有对象怎么操作
            stmt = conn.createStatement();


            //4.执行sql语句，DQL,DML操作

            String sql = "insert into xs_kc() values('081250','101','100','5')";
            //专门执行DML语句的（insert delete update）
            //返回是“影响数据库中的记录条数”
//            int executeUpdate​(String sql)  throws SQLException  (Statement的方法)
//            执行给定的SQL语句，这可能是INSERT ， UPDATE ，或DELETE声明，或者不返回任何内容，如SQL DDL语句的SQL语句。
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "保存成功" : "保存失败");

            //5.若是查询语句，处理查询结果集


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //6.释放资源
            // 为了保证资源一定释放，在finally语句中关闭资源
            //并且要遵循从小到大，依次关闭
            //分别对其 try..catch..
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

}
