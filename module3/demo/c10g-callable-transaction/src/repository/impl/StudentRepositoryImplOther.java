package repository.impl;

import bean.Student;
import repository.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentRepositoryImplOther implements StudentRepository {

    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public void save(Student student) {

    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();

        try {
            CallableStatement callableStatement =
                    this.baseRepository.getConnection().prepareCall("call find_all_student(?)");
            callableStatement.setString(1, "t");

            ResultSet resultSet = callableStatement.executeQuery();

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
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public String callTransaction() {
        String msg = "OK, transaction successfully!";
        Connection connection = this.baseRepository.getConnection();

        try {
            connection.setAutoCommit(false);

            PreparedStatement pSInsertTypeOfClass =
                    connection.prepareStatement("insert into type_of_class (id, `name`)\n" +
                            "values (?, ?)");
            pSInsertTypeOfClass.setString(1, "3");
            pSInsertTypeOfClass.setString(2, "Other");

            int rowAffect = pSInsertTypeOfClass.executeUpdate();

            PreparedStatement pSInsertClass =
                    connection.prepareStatement("insert into class (id, `name`, type_of_class_id)\n" +
                            "values (?, ?, ?)");
            pSInsertClass.setString(1, "4");
            pSInsertClass.setString(2, "C0121G1");
            pSInsertClass.setString(3, "3");

            rowAffect += pSInsertClass.executeUpdate();

            if (rowAffect == 2) {
                PreparedStatement pSInsertStudent
                        = connection.prepareStatement("insert into student(`name`, date_of_birth, class_id) " +
                        "values (?, ?, ?)");
                pSInsertStudent.setString(1, "Nguyen Van A");
                pSInsertStudent.setString(2, "2021-09-28");
                pSInsertStudent.setString(3, "4");

                rowAffect += pSInsertStudent.executeUpdate();
            }

            if (rowAffect == 3) {
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
