package JDBCTest_06_DataSource;

import Util.DruidUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Charon
 * @date 2020/6/23
 * JdbcTemplate 方法测试
 **/
public class JDBCTemplate_02 {

    @Test
    public void test_update() {

        /*1.创建JdbcTemplate对象*/
        JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
        /*2.写sql语句，调用方法*/
        String sql = "update xs_kc set 学分=? where 学号=?";
        int count = template.update(sql, 50, "081260");
        System.out.println(count);

    }

    @Test
    public void test_insert() {

        JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
        String sql = "insert into xs_kc values(?,?,?,?)";
        int count = template.update(sql, "081270", "101", 100, 30);
        System.out.println(count);

    }

    @Test
    public void test_delete() {

        JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
        String sql = "delete from xs_kc where 学号=?";
        int count = template.update(sql, "081260");
        System.out.println(count);

    }

    @Test
    public void test_queryForMap() {

        JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
        String sql = "select * from xs_kc where 学号=?";
        Map<String, Object> map1 = template.queryForMap(sql, "081270");
        Set<Map.Entry<String, Object>> entrySet = map1.entrySet();
        for (Map.Entry<String, Object> es : entrySet) {
            System.out.println(es.getKey() + ":" + es.getValue());
        }

    }

    @Test
    public void test_queryForList() {

        JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
        String sql = "select * from xs_kc";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> ls : list) {
            System.out.println(ls);
        }

    }

    @Test
    public void test_query() {

        JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
        String sql = "select * from xs_kc";
        List<xskc> list = template.query(sql,new BeanPropertyRowMapper<xskc>(xskc.class));

        for (xskc xskc : list) {
            System.out.println(xskc);
        }
    }

    @Test
    public void test_count(){

        JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
        String sql = "select count(学号) from xs_kc";
        Long aLong = template.queryForObject(sql, Long.class);
        System.out.println(aLong);


    }

}
