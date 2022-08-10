package dao;

import model.Student;

import java.util.List;

public interface StudentDAO {
    int save(Student student);

    List<Student> findAll();
}
