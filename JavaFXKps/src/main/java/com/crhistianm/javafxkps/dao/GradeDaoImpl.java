package com.crhistianm.javafxkps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crhistianm.javafxkps.dbconnection.KpsConnection;
import com.crhistianm.javafxkps.dto.StudentGradeEditDto;
import com.crhistianm.javafxkps.model.Grade;

/**
 * GradeDaoImpl
 */
public class GradeDaoImpl implements GradeDao{
    KpsConnection connect = new KpsConnection();
    private String sql;
    private PreparedStatement execute;

   @Override
    public ArrayList<Grade> findAll(Grade student) {

        return null;
    } 

   @Override
   public ArrayList<StudentGradeEditDto> findAllBySearch(StudentGradeEditDto dto) {
       ArrayList<StudentGradeEditDto> list = null;


       ResultSet rs;
        try {
            connect.openConnection();

            sql = "SELECT account.Account_Number, student.Name, student.Surname, grade.Total_Grade, grade.Grade_Date, grade.ID"
                    +" FROM grade INNER JOIN student ON grade.Student_ID_FK = student.ID" 
                    +" INNER JOIN subject ON grade.Subject_ID_FK = subject.ID"
                    +" INNER JOIN account ON student.Account_ID_FK = account.ID"
                    +" WHERE subject.Name =? AND Account_Number LIKE ?";
           
            list = new ArrayList();

            execute = connect.getMyConnection().prepareStatement(sql);
            execute.setString(1, dto.getSubjectName()); 
            execute.setString(2, "%" + dto.getAccountNumber() + "%");

            rs = execute.executeQuery();

            while(rs.next()){
                StudentGradeEditDto g = new StudentGradeEditDto();

                g.setGradeId(rs.getInt("ID"));
                g.setAccountNumber(rs.getString("Account_Number"));
                g.setStudentName((rs.getString("Name").concat(" ").concat(rs.getString("Surname"))));
                g.setTotalGrade(rs.getDouble("Total_Grade"));
                g.setGradeDate(rs.getDate("Grade_Date"));

                list.add(g);
            }

       } catch (SQLException e) {
           System.out.println("Error in findAllSearch "+ e);
       } finally{
           connect.closeConnection();
       }

       return list;
   }

   @Override
   public ArrayList<StudentGradeEditDto> findAllByName(StudentGradeEditDto dto) {
       ArrayList<StudentGradeEditDto> list = null;


       ResultSet rs;
        try {
            connect.openConnection();

            sql = "SELECT account.Account_Number, student.Name, student.Surname, grade.Total_Grade, grade.Grade_Date, grade.ID"
                    +" FROM grade INNER JOIN student ON grade.Student_ID_FK = student.ID" 
                    +" INNER JOIN subject ON grade.Subject_ID_FK = subject.ID"
                    +" INNER JOIN account ON student.Account_ID_FK = account.ID"
                    +" WHERE subject.Name =?";
           
            list = new ArrayList();

            execute = connect.getMyConnection().prepareStatement(sql);
            execute.setString(1, dto.getSubjectName()); 

            rs = execute.executeQuery();

            while(rs.next()){
                StudentGradeEditDto g = new StudentGradeEditDto();

                g.setGradeId(rs.getInt("ID"));
                g.setAccountNumber(rs.getString("Account_Number"));
                g.setStudentName((rs.getString("Name").concat(" ").concat(rs.getString("Surname"))));
                g.setTotalGrade(rs.getDouble("Total_Grade"));
                g.setGradeDate(rs.getDate("Grade_Date"));

                list.add(g);
            }

       } catch (SQLException e) {
           System.out.println("Error in findAllTeacher "+ e);
       } finally{
           connect.closeConnection();
       }

       return list;
   }
    
}
