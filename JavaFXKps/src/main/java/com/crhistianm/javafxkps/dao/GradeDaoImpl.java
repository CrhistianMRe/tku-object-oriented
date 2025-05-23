package com.crhistianm.javafxkps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crhistianm.javafxkps.dbconnection.KpsConnection;
import com.crhistianm.javafxkps.dto.StudentGradeDto;
import com.crhistianm.javafxkps.dto.StudentGradeEditDto;
import com.crhistianm.javafxkps.model.Grade;

/**
 * GradeDaoImpl
 */
public class GradeDaoImpl implements GradeDaoCustom{
    KpsConnection connect = new KpsConnection();
    private String sql;
    private String answer;
    private PreparedStatement execute;

    @Override
    public ArrayList<Grade> findAll(Grade grade) {
        return null;
    }

    @Override
    public ArrayList<StudentGradeDto> findAllStudentGrade(int accId) {
        ArrayList<StudentGradeDto> list = null;
        ResultSet rs;

        try {
            connect.openConnection();
            sql = "SELECT account.Account_Number, student.Name, student.Surname, "
                +"subject.Name AS subjectName, semester.Name AS semesterName, "
                +" CONCAT(teacher.Name, ' ' , teacher.Surname) AS teacherName, grade.Total_Grade"
                +" FROM account INNER JOIN student ON student.Account_ID_FK = account.ID"
                +" INNER JOIN semester ON student.Semester_ID_FK = semester.ID" 
                +" INNER JOIN grade ON grade.Student_ID_FK = student.ID" 
                +" INNER JOIN subject ON grade.Subject_ID_FK = subject.ID" 
                +" INNER JOIN teacher ON subject.Teacher_ID_FK = teacher.ID"
                +" WHERE account.ID=?";

            list = new ArrayList();

            execute = connect.getMyConnection().prepareStatement(sql);
            execute.setInt(1, accId);

            rs = execute.executeQuery();

            while(rs.next()){
                StudentGradeDto st = new StudentGradeDto();

                st.setAccountNumber(rs.getString("Account_Number"));
                st.setName(rs.getString("Name"));
                st.setSurname(rs.getString("Surname"));
                st.setSubjectName(rs.getString("subjectName"));
                st.setSemesterName(rs.getString("semesterName"));
                st.setTeacherName(rs.getString("teacherName"));
                st.setTotalScore(rs.getFloat("Total_Grade"));
                list.add(st);
            }
            
        } catch (SQLException e) {
            System.out.println("Error in findAllStudentGrade "+ e);
        }finally{
            connect.closeConnection();
        }
        return list;
    }

    @Override
   public String updateGrade(Grade grade) {
        
       try {
           connect.openConnection();

           sql = "UPDATE grade set grade.Grade_Date=?, grade.Total_Grade=? WHERE grade.ID =?";

           execute = connect.getMyConnection().prepareStatement(sql);
           execute.setDate(1, grade.getGradeDate());
           execute.setFloat(2, grade.getTotalGrade());
           execute.setInt(3, grade.getId());

           execute.executeUpdate();

           answer= "Data updated successfully";
           
       } catch (SQLException e) {
           System.out.println("Error on update grade"+ e);
       }finally{
           connect.closeConnection();
       }
       return answer;
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
