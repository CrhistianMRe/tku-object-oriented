package com.crhistianm.javafxkps.dao;

import java.util.ArrayList;
import java.util.List;

import com.crhistianm.javafxkps.model.Account;

/**
 * AccountDao
 */
public interface AccountDao {

    ArrayList<Account> findAll();

    int loginByAccNum(Account acc);



}
