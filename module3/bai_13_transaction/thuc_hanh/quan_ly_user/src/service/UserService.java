package service;

import bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    void save(User user);
    List<User> findAll();
    User findById(Integer id);
    List<User> findByName(String name);
    void deleteById(Integer id);
    public User getUserById(int id);
    public void insertUserStore(User user) throws SQLException;
    public String addUserTransaction(User user, int[] permission);
    public void insertUpdateWithoutTransaction();
    public void insertUpdateUseTransaction();
}
