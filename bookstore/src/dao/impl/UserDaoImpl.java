package dao.impl;

import bean.User;
import dao.UserDao;

/**
 * @author Charon
 * @date 2020/7/7
 **/
public class UserDaoImpl extends  BaseDao implements UserDao {

    @Override
    public User queryUserByNmae(String username) {
        String sql = "select * from t_user where username=?";
        return queryOne(sql,User.class,username);
    }

    @Override
    public User queryUserByNameAndPassword(String username,String password) {
        String sql = "select * from t_user where username=? and password=? ";
        return queryOne(sql,User.class,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
