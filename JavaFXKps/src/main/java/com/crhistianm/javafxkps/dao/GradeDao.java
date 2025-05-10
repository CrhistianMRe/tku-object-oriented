package com.crhistianm.javafxkps.dao;

import java.util.ArrayList;

import com.crhistianm.javafxkps.dto.StudentGradeDto;
import com.crhistianm.javafxkps.dto.StudentGradeEditDto;
import com.crhistianm.javafxkps.model.Grade;

/**
 * GradeDao
 */
public interface GradeDao {

    ArrayList<StudentGradeEditDto> findAllByName(StudentGradeEditDto dto);
    //Same as the upper one but with acc number search
    ArrayList<StudentGradeEditDto> findAllBySearch(StudentGradeEditDto dto);
     
    ArrayList<StudentGradeDto> findAllStudentGrade(int accId);

    String updateGrade(Grade grade);

}
