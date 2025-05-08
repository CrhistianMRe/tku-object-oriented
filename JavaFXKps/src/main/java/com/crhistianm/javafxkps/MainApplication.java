package com.crhistianm.javafxkps;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.crhistianm.javafxkps.dao.AccountDaoImpl;
import com.crhistianm.javafxkps.model.Account;

//import com.crhistianm.javafxkps.dbconnection.KpsConnection;

public class MainApplication extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        //KpsConnection con = new KpsConnection();
        //con.openConnection();
        //con.closeConnection();
        //AccountDaoImpl acc = new AccountDaoImpl();
        
        //System.out.println(acc.loginByAccNum(new Account("pass2", "413854893", 1)));
    }

    public static void main(String[] args) {
        launch();
    }
}
