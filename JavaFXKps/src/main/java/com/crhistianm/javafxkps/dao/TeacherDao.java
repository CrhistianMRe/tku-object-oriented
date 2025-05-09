package com.crhistianm.javafxkps.dao;

import com.crhistianm.javafxkps.model.Teacher;

import java.util.ArrayList;

public interface TeacherDao {
    ArrayList<Teacher> findAll();
    Teacher findByAccId(int accId);

}
