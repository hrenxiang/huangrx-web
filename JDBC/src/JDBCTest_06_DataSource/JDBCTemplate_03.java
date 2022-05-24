package JDBCTest_06_DataSource;

import Util.DruidUtil2;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Charon
 * @date 2020/6/24
 * @内容  复习JDBCTemplate的使用
 **/
public class JDBCTemplate_03 {

    @Test
    public void test_delete(){

        /*获取Template对象*/
        JdbcTemplate template = new JdbcTemplate(DruidUtil2.getDataSource());

        /*执行sql语句*/
        int count = template.update("delete from xs_kc where 学号=?", "088888");

        /*输出结果*/
        if (count>0){
            System.out.println("执行成功！");
        }else {
            System.out.println("执行失败！");
        }

    }

    @Test
    public void test_QueryForMap(){

        JdbcTemplate template = new JdbcTemplate(DruidUtil2.getDataSource());

        Map<String, Object> map = template.queryForMap("select * from xs_kc where 学号=?","10000");

        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry);
        }

    }

    @Test
    public void test_QueryForList(){

        JdbcTemplate template = new JdbcTemplate(DruidUtil2.getDataSource());

        List<Map<String, Object>> list = template.queryForList("select * from xs_kc");
        for (Map<String, Object> ls : list) {
            System.out.println(ls);
        }

    }

    @Test
    public void test_Query(){

        JdbcTemplate template = new JdbcTemplate(DruidUtil2.getDataSource());

        List<xskc> query = template.query("select * from xs_kc", new BeanPropertyRowMapper<xskc>(xskc.class));

        for (xskc xskc : query) {
            System.out.println(xskc);
        }
    }

    @Test
    public void test_QueryForObject(){

        JdbcTemplate template = new JdbcTemplate(DruidUtil2.getDataSource());

        Long aLong = template.queryForObject("select sum(学分) from xs_kc", Long.class);
        System.out.println(aLong);

    }
}
