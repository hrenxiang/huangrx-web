package service.impl;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

/**
 * @author Charon
 * @date 2020/7/7
 **/
public class UserSServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByNameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String name) {
        return userDao.queryUserByNmae(name) != null;
    }
}
