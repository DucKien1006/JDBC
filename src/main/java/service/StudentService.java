package service;

import model.Student;

import java.util.List;

public interface StudentService {
    boolean save(Student student);

    List<Student> findAll();
}
