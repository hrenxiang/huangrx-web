package JDBCTest_03;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class text05_Transaction {

    public static void main(String[] args) {

        ArrayList<String> arrays = initUI();

        insert(arrays);
    }

    private static void insert(ArrayList<String> arrays) {

        String id = arrays.get(0);
        String balance = arrays.get(1);
        String id2 = arrays.get(2);
        String balance2 = arrays.get(3);

        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sql", "root", "hhhh");
            //void setAutoCommit​(boolean autoCommit) 将此连接的自动提交模式设置为给定状态
            conn.setAutoCommit(false);

            String sql = "update deposit set balance =? where id =?";

            ps = conn.prepareStatement(sql);

            //update
            ps.setString(1, balance);
            ps.setString(2, id);
            int count = ps.executeUpdate();
            System.out.println(count);

            /*String s=null;
            s.toString();*/

            ps.setString(1, balance2);
            ps.setString(2, id2);
            count += ps.executeUpdate();
            System.out.println(count);

            ps2 = conn.prepareStatement("select * from deposit");
            ResultSet rs = ps2.executeQuery();
            while (rs.next()){
                String id3 = rs.getString(1);
                String balance3 = rs.getString(2);
                System.out.println(id3+":"+balance3);
            }

            //空指针异常
            String s=null;
            s.toString();

            conn.commit();

        } catch (Exception e) {

            try {
                ps3 = conn.prepareStatement("select * from deposit");
                ResultSet rs = ps3.executeQuery();
                while (rs.next()){
                    String id4 = rs.getString(1);
                    String balance4 = rs.getString(2);
                    System.out.println(id4+":"+balance4);
                }
            }catch (Exception es){
                es.printStackTrace();
            }
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                ps4 = conn.prepareStatement("select * from deposit");
                ResultSet rs = ps4.executeQuery();
                while (rs.next()){
                    String id5 = rs.getString(1);
                    String balance5 = rs.getString(2);
                    System.out.println(id5+":"+balance5);
                }
            }catch (Exception es){
                es.printStackTrace();
            }

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

        System.out.print("balance:");
        String balance = sc.nextLine();

        System.out.print("id2:");
        String id2 = sc.nextLine();

        System.out.print("balance2:");
        String balance2 = sc.nextLine();

        ArrayList<String> arrays = new ArrayList<String>();
        arrays.add(id);
        arrays.add(balance);
        arrays.add(id2);
        arrays.add(balance2);


        return arrays;
    }
}
