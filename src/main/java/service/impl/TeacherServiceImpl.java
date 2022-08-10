package service.impl;

import dao.TeacherDAO;
import dao.impl.TeacherDAOImpl;
import model.Teacher;
import service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDAO teacherDAO = new TeacherDAOImpl();
    @Override
    public boolean save(Teacher teacher) {
        
        return teacherDAO.save(teacher) > 0;
    }
}
