package service.impl;

import dao.StudentDAO;
import dao.impl.StudentDAOImpl;
import model.Student;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public boolean save(Student student) {
        if (student.getAddress().length() < 2) {
            student.setAddress("Ha Noi");
        }

        return studentDAO.save(student) > 0;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }
}
