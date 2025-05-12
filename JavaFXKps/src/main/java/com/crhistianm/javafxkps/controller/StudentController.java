package com.crhistianm.javafxkps.controller;

import java.util.ArrayList;

import com.crhistianm.javafxkps.dao.GradeDaoImpl;
import com.crhistianm.javafxkps.dto.StudentGradeDto;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


public class StudentController {
    ObservableList<StudentGradeDto> list;
    GradeDaoImpl gradeData = new GradeDaoImpl();

    private int accId;

    public void setAccId(int accId) {
	    this.accId = accId;
    }
    @FXML
    public TableColumn<StudentGradeDto, String> colSubjectName;

    @FXML
    public TableColumn<StudentGradeDto, String> colSemesterName;

    @FXML
    public TableColumn<StudentGradeDto, String> colTeacherName;

    @FXML
    public TableColumn<StudentGradeDto, String> colTotalGrade;





    @FXML
    public TableView<StudentGradeDto> tblData;

    @FXML
    public Label lblAccount;

    @FXML
    public Label lblName;

    @FXML
    public Label lblAverage;

    @FXML
    public Button btnBack;

    @FXML
    public void handleBtnBackClick(){
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize(){

        list = FXCollections.observableList(gradeData.findAllStudentGrade(accId));

        this.lblAccount.setText("Account Number: " + list.get(1).getAccountNumber());
        this.lblName.setText("Name : " + list.get(1).getName() + " " + list.get(1).getSurname());
        fillTable();
        float sum =0;
        int count = 0;
        float total;
        for (StudentGradeDto studentGradeDto : list) {
            sum += studentGradeDto.getTotalScore(); 
            System.out.println(sum);
            count++;
        }

        sum = sum/count;

        this.lblAverage.setText("Average Score: "+ Integer.valueOf(String.valueOf(Math.round(sum))));

    }

    public void fillTable(){

         for (StudentGradeDto grade: gradeData.findAllStudentGrade(accId)) {
            System.out.println("to string : "+ grade);

            colSubjectName.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSubjectName())));
            colSemesterName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSemesterName()));
            colTeacherName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTeacherName()));
            colTotalGrade.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTotalScore())));

            tblData.getItems().add(grade);
        }
    }

}
