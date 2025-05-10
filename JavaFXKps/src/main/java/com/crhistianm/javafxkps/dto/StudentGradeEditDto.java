package com.crhistianm.javafxkps.dto;

import java.sql.Date;

public class StudentGradeEditDto {
    private int gradeId;
    private String subjectName;
    private String accountNumber;
    private String studentName;
    private double totalGrade;
    private Date gradeDate;

    public StudentGradeEditDto() {
    }

    public StudentGradeEditDto(int gradeId, String subjectName, String accountNumber, String studentName, double totalGrade, Date gradeDate) {
        this.subjectName = subjectName;
        this.accountNumber = accountNumber;
        this.studentName = studentName;
        this.totalGrade = totalGrade;
        this.gradeDate = gradeDate;
        this.gradeId = gradeId;
    }

    public void setGradeId(int gradeId) {
	    this.gradeId = gradeId;
    }

    public int getGradeId() {
	    return gradeId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(double totalGrade) {
        this.totalGrade = totalGrade;
    }

    public Date getGradeDate() {
        return gradeDate;
    }

    public void setGradeDate(Date gradeDate) {
        this.gradeDate = gradeDate;
    }


    @Override
    public String toString() {
        return "StudentGradeEditDto{" +
                "gradeId=" + gradeId +
                ", subjectName='" + subjectName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", studentName='" + studentName + '\'' +
                ", totalGrade=" + totalGrade +
                ", gradeDate=" + gradeDate +
                '}';
    }
}
