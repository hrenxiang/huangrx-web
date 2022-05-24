package JDBCTest_06_DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Charon
 * @date 2020/6/22
 * @close() 验证连接池中 归还方法：close()
 *          不归还，因最大连接条数原因，只有10条结果
 *          归还后，发现有11条结果，且5和9的连接对象是同一个（这个调用时随机的，不一定和后面的哪一个一样）
 *          5：[wrapping: com.mysql.jdbc.Connection@4590c9c3]
 *          9：[wrapping: com.mysql.jdbc.Connection@4590c9c3]
 * @ new ComboPooledDataSource(); 括号内不传参数表示使用xml中的默认参数，传值表示使用的是xml中相应名字的参数
 **/
public class c3p0Demo_03 {

    @Test
    public void test_Close() throws SQLException {

        /*1.获取数据库连接池对象*/
        DataSource dataSource = new ComboPooledDataSource();
        /*2.获取连接 因为归还了一个，所以说可以有11次*/
        for (int i=0; i<=10; i++){
            Connection conn = dataSource.getConnection();
        /*3.打印*/
            System.out.println(i+":"+conn);
        /*4.归还连接*/
            if (i==5){
                conn.close();
            }
        }
    }
}
