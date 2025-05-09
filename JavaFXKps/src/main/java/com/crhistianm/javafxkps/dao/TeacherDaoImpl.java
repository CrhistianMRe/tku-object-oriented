package com.crhistianm.javafxkps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crhistianm.javafxkps.dbconnection.KpsConnection;
import com.crhistianm.javafxkps.model.Teacher;

/**
 * TeacherDaoImpl
 */
public class TeacherDaoImpl implements TeacherDao{

    KpsConnection connection = new KpsConnection();
    private PreparedStatement execute;
    private String sql;



    @Override
    public ArrayList<Teacher> findAll(){
        return null;
    }

    @Override
    public Teacher findByAccId(int accId){
        Teacher t = new Teacher();

        
        ResultSet rs;
        
        try {

            connection.openConnection();
            sql = "SELECT teacher.ID, teacher.Name, teacher.Surname, Teacher.Email_Address, Teacher.Phone_Number"
                    +" FROM teacher"
                    +" WHERE Account_ID_FK =?";

            execute = connection.getMyConnection().prepareStatement(sql);
            execute.setInt(1, accId);
            rs = execute.executeQuery();

            rs.next();

            t.setId(rs.getInt("ID"));
            t.setName(rs.getString("Name"));
            t.setSurname(rs.getString("Surname"));
            t.setEmailAddress(rs.getString("Email_Address"));
            t.setPhoneNumber(rs.getString("Phone_Number"));
            System.out.println(t.getName());
            
        } catch (SQLException e) {
            System.out.println("Error findByAccId teacher" + e);
        } finally{
            connection.closeConnection();
        }


        return t; 
    }
    
}
