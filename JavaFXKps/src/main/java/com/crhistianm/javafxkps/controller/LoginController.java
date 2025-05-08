package com.crhistianm.javafxkps.controller;

import com.crhistianm.javafxkps.dao.AccountDaoImpl;
import com.crhistianm.javafxkps.model.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;

public class LoginController {
    @FXML // Al estar declarado en el FXML busca en controlador el boton por el nombre puesto en esta clase y el ID
    public Button buttonLogin;
    @FXML
    public TextField textFieldUsername;
    @FXML
    public TextField textFieldPassword;

    @FXML
    public void handleButtonClick(){
        AccountDaoImpl account = new AccountDaoImpl();
        //Get from textFields all data and query
        //This saves accId from accNumber
        int dataId =account.loginByAccNum(new Account(this.textFieldPassword.getText(), this.textFieldUsername.getText(), 0));
        if (dataId != 666){
            JOptionPane.showMessageDialog(null,"Login succesfull");
        }else{
            JOptionPane.showMessageDialog(null,"User account number or password not correct");
        }

    }
}