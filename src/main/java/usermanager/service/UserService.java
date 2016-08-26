package usermanager.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import usermanager.dao.UserDao;
import usermanager.model.User;

import java.util.List;

@Service
public class UserService implements IUserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserId(int id) {
        return this.userDao.getUserId(id);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
