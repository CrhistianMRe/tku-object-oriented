package com.crhistianm.javafxkps.controller;

import java.util.ArrayList;


import com.crhistianm.javafxkps.dao.GradeDaoImpl;
import com.crhistianm.javafxkps.dao.SubjectDaoImpl;
import com.crhistianm.javafxkps.dao.TeacherDaoImpl;
import com.crhistianm.javafxkps.dto.StudentGradeEditDto;
import com.crhistianm.javafxkps.model.Subject;
import com.crhistianm.javafxkps.model.Teacher;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

public class TeacherController {
    TeacherDaoImpl teacherData = new TeacherDaoImpl();
    SubjectDaoImpl subjectData = new SubjectDaoImpl();
    GradeDaoImpl gradeData = new GradeDaoImpl();
    Teacher teacher = new Teacher();

    private int id;

    @FXML
    public Label lblName;
    
    @FXML
    public Button btnEdit;

    @FXML
    public ComboBox comboCourse;

    @FXML
    public TextField txtSearch;

    @FXML
    public TableView tblStudent;

    @FXML
    public Button btnUpdate;


    @FXML 
    public TableColumn<StudentGradeEditDto, String> colGradeId;

    @FXML
    public TableColumn<StudentGradeEditDto, String> colAccountNumber;

    @FXML
    public TableColumn <StudentGradeEditDto, String> colStudentName;

    @FXML
    public TableColumn <StudentGradeEditDto, String> colTotalGrade;

    @FXML
    public TableColumn <StudentGradeEditDto, String> colGradeDate;

    public void setId(int id) {

        this.id = id;
        //System.out.println("Dentro : " + id);
    }

    //Initialize loads after fxml
    @FXML
    public void initialize(){
        teacher = teacherData.findByAccId(this.id);
        System.out.println(teacher);
        this.lblName.setText(teacher.getName().concat(" ".concat(teacher.getSurname())).concat(" Change grades"));
        for (Subject subject: this.subjectData.findByTeacherId(teacher.getId())){
              comboCourse.getItems().addAll(subject.getName());
          }  
    }

    @FXML
    public void handleUpdateButtonClick(){
        System.out.println(this.tblStudent.getSelectionModel().getSelectedIndex());

    }

    @FXML
    public void handleEditButtonClick(){
        this.tblStudent.setEditable(true);
        this.colTotalGrade.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    
    @FXML
    public void handleComboSelection(){

        tblStudent.getItems().clear();
        StudentGradeEditDto dto = new StudentGradeEditDto();
        dto.setSubjectName(String.valueOf(comboCourse.getValue()));
        System.out.println(dto.getSubjectName());
        for (StudentGradeEditDto grade: gradeData.findAllByName(dto)) {
            System.out.println(grade);


            colGradeId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGrade()));
            colAccountNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccountNumber()));
            colStudentName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStudentName()));
            colTotalGrade.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTotalGrade())));
            colGradeDate.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getGradeDate())));

            tblStudent.getItems().add(grade);
        }
    }


}
