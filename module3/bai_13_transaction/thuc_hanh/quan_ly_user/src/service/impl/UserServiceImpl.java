package service.impl;

import bean.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public String save(User user) {
        if (user.getName().equals("") || user.getEmail().equals("") || user.getCountry().equals("")){
            return "Please Input";
        } else {
            userRepository.save(user);
            return "User was update";
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        userRepository.insertUserStore(user);
    }

    @Override
    public String addUserTransaction(User user, int[] permission) {
        return userRepository.addUserTransaction(user,permission);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        userRepository.insertUpdateUseTransaction();
    }
}
