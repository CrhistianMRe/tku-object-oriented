package com.crhistianm.javafxkps.dao;

import java.util.ArrayList;

import com.crhistianm.javafxkps.model.Subject;

/**
 * SubjectDao
 */
public interface SubjectDao {

    ArrayList<Subject> findByTeacherId(int id);

    ArrayList<Subject> findByStudentId(int id);


}
