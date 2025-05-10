package com.crhistianm.javafxkps.controller;

import com.crhistianm.javafxkps.dao.GradeDaoImpl;
import com.crhistianm.javafxkps.dto.StudentGradeDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.text.TableView;

public class StudentController {
    ObservableList<StudentGradeDto> list;
    GradeDaoImpl gradeData = new GradeDaoImpl();

    private int accId;

    public void setAccId(int accId) {
	    this.accId = accId;
    }
    @FXML
    public TableView tblData;

    @FXML
    public Label lblAccount;

    @FXML
    public Label lblName;

    @FXML
    public Label lblAverage;

    @FXML
    public Button btnBack;

    @FXML
    public void initializable(){

        list = FXCollections.observableList(gradeData.findAllStudentGrade(accId));

    }


}
