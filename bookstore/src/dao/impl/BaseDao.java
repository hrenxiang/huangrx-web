package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.jdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Charon
 * @date 2020/7/7
 **/
public class BaseDao {

    //使用DBUtils操作数据库对象
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * 进行增删改的操作
     *
     * @param sql  数据库操作语句
     * @param args sql语句的参数
     * @return 返回-1表示操作失败，其他值表示成功，值为影响的数据条数
     */
    public int update(String sql, Object... args) {
        Connection conn = jdbcUtil.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回一个javaBean的sql语句
     *
     * @param sql  查询单个的查询语句
     * @param type 返回的对象类型
     * @param args sql语句的参数
     * @param <T>  返回的数据类型的泛型
     * @return 返回null，说明数据库中，无此查询数据
     */
    public <T> T queryOne(String sql, Class<T> type, Object... args) {
        Connection conn = jdbcUtil.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回多个javaBean的sql语句
     *
     * @param sql  查询单个的查询语句
     * @param type 返回的对象类型
     * @param args sql语句的参数
     * @param <T>  返回的数据类型的泛型
     * @return 返回null，说明数据库中，无此查询数据
     */
    public <T> List<T> queryList(String sql, Class<T> type, Object... args) {
        Connection conn = jdbcUtil.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 聚合函数，统计查询
     *
     * @param sql  查询单个的查询语句
     * @param args sql语句的参数
     * @return 返回null，说明数据库中，无此查询数据
     */
    public Object queryFunction(String sql, Object... args) {
        Connection conn = jdbcUtil.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
