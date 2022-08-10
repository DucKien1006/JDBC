package controller;

import model.Student;
import model.Teacher;
import service.StudentService;
import service.TeacherService;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;
import util.DBUtil;

import java.util.List;

public class Main {
    private static final StudentService studentService = new StudentServiceImpl();
    private static final TeacherService teacherService = new TeacherServiceImpl();
    public static void main(String[] args) {
//        Student student = new Student("Kien", "HN");
//
//        boolean result = studentService.save(student);
//        System.out.println(result);
//
//        List<Student> students = studentService.findAll();
//        students.forEach(System.out::println);
        
        //Teacher
        Teacher teacher = new Teacher("Nhung", "HN", 3);
        
        boolean resultSaveTeacher = teacherService.save(teacher);
        System.out.println(resultSaveTeacher);
    }
}
