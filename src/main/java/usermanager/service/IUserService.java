package usermanager.service;


import usermanager.model.User;

import java.util.List;

public interface IUserService {
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(int id);
    public User getUserId(int id);
    public List<User> listUsers();
}
