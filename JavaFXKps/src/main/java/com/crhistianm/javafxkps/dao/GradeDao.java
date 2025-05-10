package com.crhistianm.javafxkps.dao;

import java.util.ArrayList;

import com.crhistianm.javafxkps.dto.StudentGradeEditDto;
import com.crhistianm.javafxkps.model.Grade;

/**
 * GradeDao
 */
public interface GradeDao {

    ArrayList<StudentGradeEditDto> findAllByName(StudentGradeEditDto dto);
     
    ArrayList<Grade> findAll(Grade student);

}
