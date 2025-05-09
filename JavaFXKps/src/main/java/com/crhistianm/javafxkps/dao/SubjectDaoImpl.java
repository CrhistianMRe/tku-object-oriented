package com.crhistianm.javafxkps.dao;

import com.crhistianm.javafxkps.dbconnection.KpsConnection;
import com.crhistianm.javafxkps.model.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * SubjectDaoImpl
 */
public class SubjectDaoImpl implements SubjectDao {
    KpsConnection connect = new KpsConnection();
    private String sql;
    private PreparedStatement execute;

    @Override
    public ArrayList<Subject> findByTeacherId(int id) {
        ArrayList<Subject> list = null;

        ResultSet rs;

        try {
            connect.openConnection();

            sql="SELECT subject.ID, subject.Name, subject.Description"
                +" FROM subject" 
                +" WHERE Teacher_ID_FK = ?";

            execute = connect.getMyConnection().prepareStatement(sql);
            execute.setInt(1, id);

            rs = execute.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                Subject subject = new Subject();
                subject.setId(rs.getInt("ID"));
                subject.setName(rs.getString("Name"));
                subject.setDescription(rs.getString("Description"));
                list.add(subject);
            }
            
            
        } catch (SQLException e) {
            System.out.println("Error in findByTeacherID SubjectDaoImpl " + e);
        }finally{
            connect.closeConnection();
        }

        return list;
    }

    @Override
    public ArrayList<Subject> findByStudentId(int id) {
        return null;
    }
}
