package com.crhistianm.javafxkps.dao;

import com.crhistianm.javafxkps.dbconnection.KpsConnection;
import com.crhistianm.javafxkps.model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * AccountDaoImpl
 */
public class AccountDaoImpl implements AccountDao{

    KpsConnection connect = new KpsConnection(); 
    private String sql;
    private PreparedStatement execute;

    @Override
    public ArrayList<Account> findAll() {
        return null;
    }

    @Override
    public int loginByAccNum(Account acc) {
        ResultSet rs;
        //If returns this number it will be an error or doesnt find
        int accId = 666;

        try {
            connect.openConnection(); 

            sql = "SELECT account.ID FROM account WHERE Account_Number =? AND Password=?";

            execute = connect.getMyConnection().prepareStatement(sql);

            execute.setString(1, acc.getAccountNumber());
            execute.setString(2, acc.getPassword());
            //System.out.println(connect.getMyConnection().getCatalog());;

            rs = execute.executeQuery();

            //Go to first query
            rs.next();
            //Get id
            accId = rs.getInt("ID");
        } catch (SQLException e) {
            System.out.println("Error in findByAccNum " + e);
        }finally{
            connect.closeConnection();
        }
        return accId;

    }
}
