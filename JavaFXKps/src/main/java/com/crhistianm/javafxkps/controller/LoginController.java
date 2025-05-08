package com.crhistianm.javafxkps.controller;

import com.crhistianm.javafxkps.dao.AccountDaoImpl;
import com.crhistianm.javafxkps.dao.AuthDaoImpl;
import com.crhistianm.javafxkps.model.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        AuthDaoImpl auth = new AuthDaoImpl(); 
        //Get from textFields all data and query
        //This saves accId from accNumber
        int dataId =account.loginByAccNum(new Account(this.textFieldPassword.getText(), this.textFieldUsername.getText(), 0));
        if (dataId != 666){
            //auth return teacher or student 
            JOptionPane.showMessageDialog(null,"Login succesfull you are a ".concat(auth.verifyAccountType(dataId)));

                
            

        }else{
            JOptionPane.showMessageDialog(null,"User account number or password not correct");
        }

    }
}
