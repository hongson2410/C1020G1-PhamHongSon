package repository.impl;

import bean.Student;
import repository.StudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentRepositoryImpl implements StudentRepository {

    private BaseRepository baseRepository = new BaseRepository();
    private static Map<Integer, Student> studentMap = new TreeMap<>();

    private final String SQL_FIND_ALL = "select id, `name`, date_of_birth " +
            "from student";
    private final String SQL_FIND_BY_ID = "select id, `name`, date_of_birth " +
            "from student " +
            "where id = ";
    private final String SQL_UPDATE = "update student " +
            "set `name` = ?, date_of_birth = ? " +
            "where id = ?";

    static {
        studentMap.put(1, new Student(1, "Duong", "25/01/2021", 1, 4));
        studentMap.put(2, new Student(2, "Van Phuc", "26/01/2021", 0, 6));
        studentMap.put(3, new Student(3, "Luong", "27/01/2021", 0, 9));
    }

    @Override
    public void save(Student student) {
        if (student.getId() == null) {
            // register student
        } else {

            try {
                PreparedStatement preparedStatement =
                        this.baseRepository.getConnection().prepareStatement(SQL_UPDATE);
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getDateOfBirth());
                preparedStatement.setString(3, String.valueOf(student.getId()));

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();

            // bufferedReader.readLine()
            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(Integer.parseInt(resultSet.getString("id")));
                student.setName(resultSet.getString("name"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));

                studentList.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public Student findById(Integer id) {
        Student student = new Student();

        try {
            PreparedStatement preparedStatement =
                    this.baseRepository.getConnection().prepareStatement(SQL_FIND_BY_ID + id);
//            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student.setId(Integer.parseInt(resultSet.getString("id")));
                student.setName(resultSet.getString("name"));
                student.setDateOfBirth(resultSet.getString("date_of_birth"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public String callTransaction() {
        return null;
    }
}
