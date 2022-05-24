package service;

import bean.User;

/**
 * @author Charon
 * @date 2020/7/7
 **/
public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    public void register(User user);

    /**
     * 用户登录
     * @param user
     */
    public User login(User user);

    /**
     * 查看用户名是否存在
     * @param name
     */
    public boolean existsUsername(String name);
}
