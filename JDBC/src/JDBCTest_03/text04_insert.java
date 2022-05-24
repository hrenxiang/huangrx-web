package JDBCTest_03;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class text04_insert {

    public static void main(String[] args) {

        ArrayList<String> arrays = initUI();

        insert(arrays);
    }

    private static void insert(ArrayList<String> arrays) {

        String id = arrays.get(0);
        String userName = arrays.get(1);
        String userPwd = arrays.get(2);
        String realName = arrays.get(3);

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sql", "root", "hhhh");

            //String sql = "insert into user values(?,?,?,?)";
            //String sql = "update user set userName =?,userPwd =?,realName =? where id =?";
            String sql = "delete from user where id=?";

            ps = conn.prepareStatement(sql);

            //insert
            /*ps.setString(1, id);
            ps.setString(2, userName);
            ps.setString(3, userPwd);
            ps.setString(4, realName);*/

            //update
            /*ps.setString(1, userName);
            ps.setString(2, userPwd);
            ps.setString(3, realName);
            ps.setString(4, id);*/

            //delete
            ps.setString(1, id);

            int count = ps.executeUpdate();
            System.out.println(count == 1 ? "执行成功" : "执行失败");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {


            try {
                if (ps != null) {
                    ps.close();
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

    private static ArrayList<String> initUI() {

        Scanner sc = new Scanner(System.in);

        System.out.print("id:");
        String id = sc.nextLine();

        System.out.print("userName:");
        String userName = sc.nextLine();

        System.out.print("userPwd:");
        String userPwd = sc.nextLine();

        System.out.print("realName:");
        String realName = sc.nextLine();

        ArrayList<String> arrays = new ArrayList<String>();
        arrays.add(id);
        arrays.add(userName);
        arrays.add(userPwd);
        arrays.add(realName);

        return arrays;
    }
}
