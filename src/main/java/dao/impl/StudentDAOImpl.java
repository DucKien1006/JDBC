package dao.impl;

import dao.StudentDAO;
import model.Student;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public int save(Student student) {
//        Connection connection = null;
//
//        try {
//            connection = DBUtil.getInstance().getConnection();
//            String sql = "INSERT INTO STUDENT(NAME, ADDRESS) VALUES('" + student.getName() + "', '" + student.getAddress() + "')";
//            Statement statement = connection.createStatement();
//
//            return statement.executeUpdate(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            return 0;
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


        try(Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "INSERT INTO STUDENT(NAME, ADDRESS) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
    
                //System.out.println(id);
                return id;
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }

    @Override
    public List<Student> findAll() {
        try (Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "SELECT * FROM STUDENT";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String address = resultSet.getString("ADDRESS");

                students.add(new Student(id, name, address));
            }

            return students;
        } catch (Exception e) {
            e.printStackTrace();

            return new ArrayList<>();
        }
    }
}
