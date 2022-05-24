package JDBCTest_03;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test01_userlogin {

    public static void main(String[] args) {

        //1.初始化登录页面
        Map<String,String> userloginInfo = initUI();

        //2.验证登录信息
        boolean loginSuccess = login(userloginInfo);
        System.out.println(loginSuccess ? "登陆成功" : "登录失败" );
    }
    /*
     * 用户登录
     * @param userloginInfo 用户登陆成功
     * @return false表示失败，true表示成功
     * */
    private static boolean login(Map<String, String> userloginInfo) {

        boolean loginSuccess = false;

        Connection conn =null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sql","root","hhhh");
            //3.获取数据库操作对象
            stmt = conn.createStatement();
            //4.执行sql语句
            String sql = "select * from user where userName='"+userloginInfo.get("userName")+ "' and userPwd='"+userloginInfo.get("userPwd")+"'";
            rs = stmt.executeQuery(sql);
            //5.处理查询结果集
            if(rs.next()){
                loginSuccess = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally{


            //6.关闭资源
            try {
                if(rs != null){
                    rs.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if(stmt != null){
                    stmt.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return loginSuccess;
    }

    private static Map<String, String> initUI() {

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String userName = sc.nextLine();

        System.out.print("请输入密码：");
        String userPwd = sc.nextLine();

        Map<String,String> userloginInfo = new HashMap<String,String>();
        userloginInfo.put("userName",userName);
        userloginInfo.put("userPwd",userPwd);

        return userloginInfo;
    }
}