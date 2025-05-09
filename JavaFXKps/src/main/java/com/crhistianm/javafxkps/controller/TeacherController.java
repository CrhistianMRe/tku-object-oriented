package com.crhistianm.javafxkps.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TeacherController {

    @FXML
    public ComboBox comboCourse;

    @FXML
    public TextField txtSearch;
    
    @FXML
    public void handleComboSelection(){
        System.out.println("Course selected");

    }


}
