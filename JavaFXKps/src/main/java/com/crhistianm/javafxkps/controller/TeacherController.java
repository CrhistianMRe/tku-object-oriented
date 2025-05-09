package com.crhistianm.javafxkps.controller;

import com.crhistianm.javafxkps.dao.TeacherDaoImpl;

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

        TeacherDaoImpl teach = new TeacherDaoImpl();
        teach.findByAccId(7);

    }


}
