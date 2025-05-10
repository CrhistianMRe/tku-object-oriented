package com.crhistianm.javafxkps.controller;

import com.crhistianm.javafxkps.dao.AccountDaoImpl;
import com.crhistianm.javafxkps.dao.AuthDaoImpl;
import com.crhistianm.javafxkps.model.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

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
        int dataId = account.loginByAccNum(new Account(this.textFieldPassword.getText(), this.textFieldUsername.getText(), 0));
        if (dataId != 666){
            //auth return teacher or student 
            //JOptionPane.showMessageDialog(null,"Login succesfull you are a ".concat(auth.verifyAccountType(dataId)));


            if (auth.verifyAccountType(dataId).equals("Teacher")){
                try {
                    TeacherController control = new TeacherController();

                    //Before control.setId so it replaces the controller after that
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/crhistianm/javafxkps/view/steacher-view.fxml"));

                    control.setId(dataId);

                    fxmlLoader.setController(control); 

                    Parent root = fxmlLoader.load();
 
                    Scene scene = new Scene(root);
                    
                    Stage teacherS = new Stage();
                    
                    teacherS.setTitle("Grades");

                    teacherS.setScene(scene);

                    teacherS.initModality(Modality.WINDOW_MODAL);
 
                    teacherS.initOwner(buttonLogin.getScene().getWindow());

                    teacherS.show();
                
                } catch (IOException e){
                    System.out.println("Error loading teacherView "+ e);
                }
            }

        }else{
            JOptionPane.showMessageDialog(null,"User account number or password not correct");
        }

    }
}
