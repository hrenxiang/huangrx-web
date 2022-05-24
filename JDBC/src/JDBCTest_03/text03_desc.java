package JDBCTest_03;

import java.sql.*;
import java.util.Scanner;

public class text03_desc {


    public static void main(String[] args) {


        //initUI();[初始化界面，返回用户给的信息]
        String s = initUI();

        //传递得到的信息，给数据库中的内容排序
        sort(s);
    }

    private static void sort(String s) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //注册driver
            Class.forName("com.mysql.jdbc.Driver");

            //getConnection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xscj", "root", "hhhh");

            //createStatement
            stmt = conn.createStatement();

            //执行sql
            String sql = "select * from xs_kc order by 学号 "+s;
            rs = stmt.executeQuery(sql);

            //处理select resultset
            while (rs.next()){
                String 学号 = rs.getString("学号");
                String 课程号 = rs.getString("课程号");
                String 成绩 = rs.getString("成绩");
                String 学分 = rs.getString("学分");
                System.out.println(学号 + "|" + 课程号 + "|" + 成绩 + "|" + 学分);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {


            //close
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    private static String initUI() {

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入desc或者asc：");
        String s = sc.nextLine();

        return s;
    }


}
