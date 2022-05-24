package JDBCTest_03;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test02_Prepare {

    public static void main(String[] args) {


        //1.初始化登路界面(返回用户信息，map接收)
        Map<String , String> userLoginInfo = initUI();
        //2.验证用户登录信息(创建方法，传入参数，提供验证，返回true或false)
        boolean loginSuccess = login(userLoginInfo);
        System.out.println(loginSuccess ? "登陆成功":"登陆失败");

    }

    private static boolean login(Map<String, String> userLoginInfo) {

        String userName = userLoginInfo.get("userName");
        String userPwd = userLoginInfo.get("userPwd");

        boolean loginSuccess = false;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //JDBC六部
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sql","root","hhhh");

            //3.获取预编译数据库操作对象
            String sql = "select * from user where userName=? and userPwd=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,userPwd);

            //4.执行sql语句
            rs = ps.executeQuery();

            //5.处理是查询结果集
            if(rs.next()){
                loginSuccess = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally{

            //6.关闭资源
            try {
                if(rs != null){
                    rs.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try {
                if(ps != null){
                    ps.close();
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

        //提供用户输入口
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String userName = sc.nextLine();

        System.out.print("请输入密码：");
        String userPwd = sc.nextLine();

        //接收数据
        Map<String,String> userLoginInfo = new HashMap<String, String>();
        userLoginInfo.put("userName",userName);
        userLoginInfo.put("userPwd",userPwd);

        //返回给用户登录信息的 Map集合
        return userLoginInfo;
    }
}
