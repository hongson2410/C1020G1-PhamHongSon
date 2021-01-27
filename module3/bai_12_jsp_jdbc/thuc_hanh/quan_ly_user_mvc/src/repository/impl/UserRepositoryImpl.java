package repository.impl;

import bean.User;
import repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private BaseRepository baseRepository = new BaseRepository();
//    private static Map<Integer, Student> studentMap = new TreeMap<>();

    private final String SQL_FIND_ALL = "select id, `name`, email, country " +
            "from users";
    private final String SQL_FIND_BY_ID = "select id, `name`, date_of_birth " +
            "from student " +
            "where id = ";
    private final String SQL_UPDATE = "update student " +
            "set `name` = ?, date_of_birth = ? " +
            "where id = ?";

//    static {
//        studentMap.put(1, new Student(1, "Duong", "25/01/2021", 1, 4));
//        studentMap.put(2, new Student(2, "Van Phuc", "26/01/2021", 0, 6));
//        studentMap.put(3, new Student(3, "Luong", "27/01/2021", 0, 9));
//    }

    @Override
    public void save(User user) {
//        if (user.getId() == null) {
//            // register student
//        } else {
//
//            try {
//                PreparedStatement preparedStatement =
//                        this.baseRepository.getConnection().prepareStatement(SQL_UPDATE);
//                preparedStatement.setString(1, user.getName());
//                preparedStatement.setString(2, user.getDateOfBirth());
//                preparedStatement.setString(3, String.valueOf(user.getId()));
//
//                preparedStatement.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();

            // bufferedReader.readLine()
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User findById(Integer id) {
        User user = new User();
//
//        try {
//            PreparedStatement preparedStatement =
//                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_BY_ID + id);
////            preparedStatement.setString(1, String.valueOf(id));
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                user.setId(Integer.parseInt(resultSet.getString("id")));
//                user.setName(resultSet.getString("name"));
//                user.setDateOfBirth(resultSet.getString("date_of_birth"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return user;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
