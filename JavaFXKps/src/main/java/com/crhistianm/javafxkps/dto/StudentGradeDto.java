package com.crhistianm.javafxkps.dto;

import com.crhistianm.javafxkps.model.Account;

public class StudentGradeDto {
    private String accountNumber;
    private String name;
    private String surname;
    private String subjectName;
    private String semesterName;
    private String teacherName;
    private float totalScore;

    public StudentGradeDto() {
    }

    public StudentGradeDto(String accountNumber, String name, String surname, String subjectName, String semesterName, String teacherName, float totalScore) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.surname = surname;
        this.subjectName = subjectName;
        this.semesterName = semesterName;
        this.teacherName = teacherName;
        this.totalScore = totalScore;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "StudentGradeDto{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", semesterName='" + semesterName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", totalScore=" + totalScore +
                '}';
    }
}
