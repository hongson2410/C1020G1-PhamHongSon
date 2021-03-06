package repository.impl;

import bean.User;
import repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private BaseRepository baseRepository = new BaseRepository();

    private final String SQL_FIND_ALL = "select id, `name`, email, country " +
            "from users";

    private final String SQL_FIND_BY_ID = "select id, `name`, email, country " +
            "from users " +
            "where id = ";

    private final String SQL_FIND_BY_NAME = "select * " +
            "from users " +
            "where `name` like ? ";

    private final String SQL_UPDATE = "update users " +
            "set `name` = ?, email = ?, country = ? " +
            "where id = ?";

    private final String SQL_CREATE = "insert into users(`name`, email, country) values " +
            "(?, ?, ?)";

    private final String SQL_DELETE = "delete from users " +
            "where id = ?";

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_CREATE);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_UPDATE);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                preparedStatement.setString(4, String.valueOf(user.getId()));

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_BY_ID + id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement preparedStatement =
                null;
        try {
            preparedStatement = this.baseRepository.getConnection().prepareStatement(SQL_DELETE);
            preparedStatement.setString(1, String.valueOf(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        try {
            CallableStatement callableStatement =
                    this.baseRepository.getConnection().prepareCall(query);
            callableStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = callableStatement.executeQuery();

            resultSet.next();

            String name = resultSet.getString("name");

            String email = resultSet.getString("email");

            String country = resultSet.getString("country");

            user = new User(id, name, email, country);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?)}";

        try {
            CallableStatement callableStatement =
                    this.baseRepository.getConnection().prepareCall(query);
            callableStatement.setString(1, "name");
            callableStatement.setString(1, "email");
            callableStatement.setString(1, "country");

            callableStatement.setString(1, user.getName());

            callableStatement.setString(2, user.getEmail());

            callableStatement.setString(3, user.getCountry());

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @Override
    public String addUserTransaction(User user, int[] permission) {
        String msg = "OK, transaction successfully!";
        int userId = 0;
        Connection connection = this.baseRepository.getConnection();

        try {
            connection.setAutoCommit(false);

            PreparedStatement pSInsertUser =
                    connection.prepareStatement("insert into users(`name`, email, country)\n" +
                            "values (?, ?,?)", Statement.RETURN_GENERATED_KEYS);
            pSInsertUser.setString(1, user.getName());
            pSInsertUser.setString(2, user.getEmail());
            pSInsertUser.setString(3, user.getCountry());

            int rowAffect = pSInsertUser.executeUpdate();
            ResultSet resultSet= pSInsertUser.getGeneratedKeys();

            if (resultSet.next()) {

                userId = resultSet.getInt(1);
            }

            PreparedStatement pSInsertUserPermission =
                    connection.prepareStatement("insert into User_Permision(permision_id, user_id)\n" +
                            "values (?, ?)");
            for (int index=0;index < permission.length;index++){
                pSInsertUserPermission.setInt(1, permission[index]);
                pSInsertUserPermission.setInt(2, userId);
                rowAffect += pSInsertUserPermission.executeUpdate();
            }

            if (rowAffect == 4 ) {
                connection.commit();
            } else {
                msg = "rollback try";
                connection.rollback();
            }

        } catch (SQLException e) {
            try {
                msg = "rollback catch";
                connection.rollback();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return msg;
    }
}
