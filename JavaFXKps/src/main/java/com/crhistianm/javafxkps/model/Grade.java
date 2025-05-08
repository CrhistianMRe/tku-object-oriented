package com.crhistianm.javafxkps.model;

import java.util.Date;

/**
 * Grade
 */
public class Grade {

    private int id;
    private float totalGrade;
    private Date gradeDate;
    private Subject subject;
    private Student student;

    public Grade(Student student, Subject subject, Date gradeDate, float totalGrade, int id){
    this.student = student;
    this.subject = subject;
    this.gradeDate = gradeDate;
    this.totalGrade = totalGrade;
    this.id = id;
    }

    public Grade(){
    }


    public int getId() {
	    return id;
    }
    public void setId(int id) {
	    this.id = id;
    }
    public float getTotalGrade() {
	    return totalGrade;
    }
    public void setTotalGrade(float totalGrade) {
	    this.totalGrade = totalGrade;
    }
    public Date getGradeDate() {
	    return gradeDate;
    }
    public void setGradeDate(Date gradeDate) {
	    this.gradeDate = gradeDate;
    }
    public Subject getSubject() {
	    return subject;
    }
    public void setSubject(Subject subject) {
	    this.subject = subject;
    }
    public Student getStudent() {
	    return student;
    }
    public void setStudent(Student student) {
	    this.student = student;
    }


    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", totalGrade=" + totalGrade +
                ", gradeDate=" + gradeDate +
                ", subject=" + subject +
                ", student=" + student +
                '}';
    }
}
