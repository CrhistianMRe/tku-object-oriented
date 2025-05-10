package com.crhistianm.javafxkps.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.crhistianm.javafxkps.dao.GradeDaoImpl;
import com.crhistianm.javafxkps.dao.SubjectDaoImpl;
import com.crhistianm.javafxkps.dao.TeacherDaoImpl;
import com.crhistianm.javafxkps.dto.StudentGradeEditDto;
import com.crhistianm.javafxkps.model.Grade;
import com.crhistianm.javafxkps.model.Subject;
import com.crhistianm.javafxkps.model.Teacher;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private float totalGradeChange;
        
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
    public TableView<StudentGradeEditDto> tblStudent;

    @FXML
    public Button btnRestart;

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
    public void handleGradeChange(TableColumn.CellEditEvent<StudentGradeEditDto, String> event){
            int index = this.tblStudent.getSelectionModel().getSelectedIndex();
            ObservableList<StudentGradeEditDto>list; 

            totalGradeChange=(Float.valueOf(event.getNewValue()));

            System.out.println("salta" + String.valueOf(totalGradeChange)); 
        if(index != -1 && totalGradeChange != 0){
            list = this.tblStudent.getItems(); 
            Grade grade = new Grade();
            grade.setId(list.get(index).getGradeId());
            System.out.println(grade.getId());
            System.out.println("");
            grade.setGradeDate(java.sql.Date.valueOf(LocalDate.now()));
            grade.setTotalGrade(totalGradeChange);

            JOptionPane.showMessageDialog(null,gradeData.updateGrade(grade));
            comboFill();
            totalGradeChange = 0;
        }else {
            JOptionPane.showMessageDialog(null, "Select a row to update");
        }
    }

    @FXML
    public void handleButtonAddClick(){}

    public void changeViewStatus(boolean bool){

           this.tblStudent.setDisable(bool);
           this.btnEdit.setDisable(bool);
           this.txtSearch.setDisable(bool);
           this.comboCourse.setDisable(bool);
    }

    @FXML
    public void handleUpdateButtonClick(){
        

    }
    @FXML
    public void handleButtonRestartClick(){
        this.tblStudent.setEditable(false);
        
        comboFill();
     
        
    }

    @FXML
    public void handleEditButtonClick(){
        this.tblStudent.setEditable(true);
        this.colTotalGrade.setCellFactory(TextFieldTableCell.forTableColumn());
        

    }

    public void comboFill(){
        tblStudent.getItems().clear();

        this.txtSearch.clear();
        StudentGradeEditDto dto = new StudentGradeEditDto();

        dto.setSubjectName(String.valueOf(comboCourse.getValue()));

        System.out.println(dto.getSubjectName());

        fillTableCombo(dto);
    }
    
    @FXML
    public void handleComboSelection(){
        comboFill() ;
        
    }

    private void fillTableCombo(StudentGradeEditDto dto){
        for (StudentGradeEditDto grade: gradeData.findAllByName(dto)) {
            System.out.println("to string : "+ grade);

            colGradeId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getGradeId())));
            colAccountNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccountNumber()));
            colStudentName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStudentName()));
            colTotalGrade.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTotalGrade())));
            colGradeDate.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getGradeDate())));

            tblStudent.getItems().add(grade);
        }
    }
    private void fillTableSearch(StudentGradeEditDto dto){
        for (StudentGradeEditDto grade: gradeData.findAllBySearch(dto)) {
            System.out.println("to string : "+ grade);

            colGradeId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getGradeId())));
            colAccountNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccountNumber()));
            colStudentName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStudentName()));
            colTotalGrade.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTotalGrade())));
            colGradeDate.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getGradeDate())));

            tblStudent.getItems().add(grade);
        }
    }

    @FXML
    public void handleTextTyped(){
        this.tblStudent.getItems().clear();
        StudentGradeEditDto dtoType = new StudentGradeEditDto();
        dtoType.setSubjectName(String.valueOf(comboCourse.getValue()));
        dtoType.setAccountNumber(this.txtSearch.getText());
        fillTableSearch(dtoType);
        
    }


}
