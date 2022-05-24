package dao;

import bean.User;

/**
 * @author Charon
 * @date 2020/7/7
 **/
public interface UserDao {

    public User queryUserByNmae(String username);

    public User queryUserByNameAndPassword(String username,String password);

    public int saveUser(User user);

}
