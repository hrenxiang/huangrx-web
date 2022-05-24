package JDBCTest_04;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test01 {


    public static void main(String[] args) {

        //初始化UI，获取用户信息
        Map<String,String> logininfo = init();

        //写方法，传值
        method(logininfo);
    }

    private static void method(Map<String, String> logininfo) {

        String id = logininfo.get("id");
        String balance = logininfo.get("balance");
        //String id2 = logininfo.get("id2");
        //String balance2 = logininfo.get("balance2");

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;


        try {

            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sql","root","hhhh");
            //开启事务
            conn.setAutoCommit(false);
            //3.获取预编译数据库操作对象
            //ps = conn.prepareStatement("insert into deposit values (?,?)");
            //ps = conn.prepareStatement("delete from deposit where id=? and balance =?");
            //ps = conn.prepareStatement("update deposit set id = ? ,balance=? where id=?");
            ps = conn.prepareStatement("select * from user where userName=? and userPwd=?");

            ps.setString(1,id);
            ps.setString(2,balance);
            //ps.setString(1,id2);
            //ps.setString(2,balance2);

            //4.执行语句
            //int count = ps.executeUpdate();
            //System.out.println(count);
            rs = ps.executeQuery();

            //5.处理查询结果集
            while(rs.next()){
                String id3 = rs.getString(1);
                String userName = rs.getString(2);
                String userPwd = rs.getString(3);
                String realName = rs.getString(4);
                System.out.println(id3+","+userName+userPwd+realName);
            }

            //提交语句
            conn.commit();
        }catch (Exception e){
            if (conn !=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally{

            //6.关闭资源
            try {
                   if (rs!=null){
                       rs.close();
                   }
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                if (ps!=null){
                    ps.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private static Map<String, String> init() {

        Scanner sc = new Scanner(System.in);

        System.out.print("id:");
        String id = sc.nextLine();
        System.out.print("balance:");
        String balance = sc.nextLine();

        /*System.out.print("id2:");
        String id2 = sc.nextLine();
        System.out.print("balance2:");
        String balance2 = sc.nextLine();*/

        Map<String,String> logininfo=new HashMap<String, String>();

        logininfo.put("id",id);
        logininfo.put("balance",balance);
        /*logininfo.put("id2",id2);
        logininfo.put("balance2",balance2);*/

        return logininfo;
    }


}
