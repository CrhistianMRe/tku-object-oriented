
package com.crhistianm.javafxkps.dao;

import java.util.List;

import com.crhistianm.javafxkps.model.Account;
import com.crhistianm.javafxkps.model.Student;

public interface StudentDao {

    List<Student> findAll();
    List<Student> findByName(String name);
    int getAccountId();
    Account findByAccount(int accountId);


    
}
