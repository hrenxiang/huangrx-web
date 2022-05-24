package JDBCTest_06_DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Charon
 * @date 2020/6/22
 * 连接，最大连接值，归还操作测试
 **/
public class druidDemo_01 {

    @Test
    public void test_connection() throws Exception {

        /*1.导入jar包*/
        /*2.定义配置文件 druid.properties*/
        /*3.加载配置文件*/
        InputStream is = druidDemo_01.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        pro.load(is);

        /*4.获取数据库连接池对象*/
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        /*5.获取连接*/
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }

    @Test
    public void test_maxActive() throws Exception {

        /*1.导入jar包*/
        /*2.创建配置文件*/
        /*3.加载配置文件*/
        InputStream is = druidDemo_01.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        pro.load(is);
        /*4.获取数据库连接池对象*/
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        /*5.获取连接*/
        for (int i=0;i<5;i++){
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
        }
    }

    /**
    *归还结果：能多运行一次，并且第六（5）次的conn和第五（4）次的一模一样
    *4:com.mysql.jdbc.Connection@1ff8b8f
    *5:com.mysql.jdbc.Connection@1ff8b8f
    *
    */
    @Test
    public void test_close() throws Exception {

        /*1.导入jar包*/
        /*2.创建配置文件*/
        /*3.加载配置文件*/
        InputStream is = druidDemo_01.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        pro.load(is);
        /*4.获取数据库连接池对象*/
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        /*5.获取连接*/
        for (int i=0;i<6;i++){
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
            if (i==4){
                conn.close();
            }
        }
    }

}
