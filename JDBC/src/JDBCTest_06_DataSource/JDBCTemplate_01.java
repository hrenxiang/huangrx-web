package JDBCTest_06_DataSource;

import Util.DruidUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Charon
 * @date 2020/6/23
 *
 * JDBCTemplate 入门
 **/
public class JDBCTemplate_01 {

    public static void main(String[] args) {

        /*1.导入jar包（5个）*/
        /*2.创建Template对象*/
        JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
        /*3.调用方法*/
        String sql = "update xs_kc set 学分=? where 学号=?";
        int count = template.update(sql, 5, "081260");
        System.out.println(count);


    }
}
