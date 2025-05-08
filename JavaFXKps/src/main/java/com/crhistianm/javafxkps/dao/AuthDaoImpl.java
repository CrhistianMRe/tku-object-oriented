package com.crhistianm.javafxkps.dao;

import com.crhistianm.javafxkps.dbconnection.KpsConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDaoImpl implements AuthDao{

    KpsConnection connect = new KpsConnection();
    private PreparedStatement execute;
    private String sql;

    @Override
    public String verifyAccountType(int accID) {
        String accountType= null;
        ResultSet rs;

        try {
            connect.openConnection();
            
            sql = "SELECT student.ID AS Student_ID, teacher.ID AS Teacher_ID "
            +" FROM account"
            +" left join student on student.Account_ID_FK = account.ID"
            +" left join teacher on teacher.Account_ID_FK = account.ID"
            +" WHERE account.ID =?"; 


            execute = connect.getMyConnection().prepareStatement(sql);

            execute.setInt(1, accID);
            rs = execute.executeQuery();

            rs.next();

            if(rs.getInt("Student_ID") != 0){
                accountType = "Student";
            }else{
                accountType = "Teacher";
            } 


        } catch (SQLException e) {
            System.out.println("Error in verifyAccType" + e);
        }finally {
            connect.closeConnection();
        }



        return accountType;
    }
}
