package service;

import bean.User;

import java.util.List;

public interface UserService {

    void save(User user);
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
}
