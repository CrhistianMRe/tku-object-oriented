package com.crhistianm.javafxkps.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {
    @FXML // Al estar declarado en el FXML busca en controlador el boton por el nombre puesto en esta clase y el ID
    public Button buttonLogin;

    @FXML
    public int handleButtonClick(){
        System.out.println("Boton funciona");
        return 1;
    }
}