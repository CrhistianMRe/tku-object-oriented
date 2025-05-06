package com.crhistianm.javafxkps.dao;

import com.crhistianm.javafxkps.dbconnection.KpsConnection;
import com.crhistianm.javafxkps.model.Account;
import com.crhistianm.javafxkps.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * StudentDaoImpl
 */
public class StudentDaoImpl implements StudentDao {
    KpsConnection connect = new KpsConnection(); 
    private String sql;
    private PreparedStatement execute;

    @Override
    public List<Student> findAll() {
        ResultSet rs;
        return List.of();
    }

    @Override
    public List<Student> findByName(String name) {
        return List.of();
    }

    @Override
    public int getAccountId() {
        return 0;
    }

    @Override
    public Account findByAccount(int accountId) {
        return null;
    }

}

