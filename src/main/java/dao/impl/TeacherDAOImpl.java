package dao.impl;

import dao.TeacherDAO;
import model.Teacher;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TeacherDAOImpl implements TeacherDAO {
    @Override
    public int save(Teacher teacher) {
        try(Connection connection = DBUtil.getInstance().getConnection()) {
            String sql = "INSERT INTO TEACHER(TEANAME, ADDRESS, CLASSID) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getAddress());
            preparedStatement.setInt(3, teacher.getClassID());
            
            return preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        
    }
}
