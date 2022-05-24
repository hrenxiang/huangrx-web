package JDBCTest_06_DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Charon
 * @date 2020/6/22
 * @maxPoolSize 验证连接池最大连接数量
 **/
public class c3p0Demo_02 {

    public static void main(String[] args) throws SQLException {

        /*创建数据库连接池对象*/
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        /*获取连接对象*/
        for (int i=0; i<29;i++){
            Connection conn = dataSource.getConnection();
            /*打印*/
            System.out.println(i+":"+conn);
        }
    }

}
