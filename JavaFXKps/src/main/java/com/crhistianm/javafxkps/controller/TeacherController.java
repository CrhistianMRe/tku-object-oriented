package com.crhistianm.javafxkps.controller;

import java.util.ArrayList;

import com.crhistianm.javafxkps.dao.SubjectDaoImpl;
import com.crhistianm.javafxkps.dao.TeacherDaoImpl;
import com.crhistianm.javafxkps.model.Subject;
import com.crhistianm.javafxkps.model.Teacher;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TeacherController {
    TeacherDaoImpl teacherData = new TeacherDaoImpl();
    SubjectDaoImpl subjectData = new SubjectDaoImpl();
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
        for (Subject subject: this.subjectData.findByTeacherId(teacher.getId())){
              comboCourse.getItems().addAll(subject.getName());
          }  
    }

    
    @FXML
    public void handleComboSelection(){
        System.out.println("hola");

    }


}
