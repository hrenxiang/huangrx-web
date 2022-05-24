package JDBCTest_02;

import java.sql.*;

public class text05_Select {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xscj","root","hhhh");
            //3.获取数据库对象
            stmt = conn.createStatement();
            //4.执行sql语句
            String sql = "select 学号,课程号,成绩,学分 from xs_kc";
            rs = stmt.executeQuery(sql);
            //5.遍历查询结果集
            while (rs.next()) {
                String 学号 = rs.getString("学号");
                String 课程号 = rs.getString("课程号");
                String 成绩 = rs.getString("成绩");
                String 学分 = rs.getString("学分");
                System.out.println(学号 + "|" + 课程号 + "|" + 成绩 + "|" + 学分);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }finally{
            //6.关闭资源
            try{
                if (rs != null){
                    rs.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if (stmt != null){
                    stmt.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if (conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
}
}
