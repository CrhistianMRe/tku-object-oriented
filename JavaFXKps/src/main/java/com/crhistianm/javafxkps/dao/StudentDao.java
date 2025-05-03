
package com.crhistianm.javafxkps.dao;

import java.util.List;

import com.crhistianm.javafxkps.model.Student;
import com.crhistianm.javafxkps.model.StudentAccount;

public interface StudentDao {

    List<Student> findAll();
    List<Student> findByName(String name);
    int getAccountId();
    Account findByAccount(int accountId);


    
}
