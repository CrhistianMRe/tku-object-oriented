package com.crhistianm.javafxkps.controller;

import com.crhistianm.javafxkps.dao.TeacherDaoImpl;
import com.crhistianm.javafxkps.model.Teacher;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TeacherController {
    TeacherDaoImpl teacherData = new TeacherDaoImpl();
    Teacher teacher = new Teacher();

    private int id;

    @FXML
    public Label lblName;

    @FXML
    public ComboBox comboCourse;

    @FXML
    public TextField txtSearch;


    public void setId(int id) {

        this.id = id;
        //System.out.println("Dentro : " + id);
    }

    //Initialize loads after fxml
    @FXML
    public void initialize(){
        teacher = teacherData.findByAccId(this.id);
        System.out.println(teacher);
        this.lblName.setText(teacher.getName().concat(" ".concat(teacher.getSurname())).concat(" Student Grades"));
    }

    
    @FXML
    public void handleComboSelection(){
        System.out.println("hola");

    }


}
