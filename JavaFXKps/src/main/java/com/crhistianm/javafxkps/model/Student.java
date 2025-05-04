package com.crhistianm.javafxkps.model;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String emailAddress;
    private Account account;
    private Semester semester;

    public Student(){
    }

    public Student(int id, String name, String surname, String phoneNumber, String emailAddress, int semesterId, Account account, Semester semester){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.account = account;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public Account getAccount() {
	    return account;
    }
    public void setAccount(Account account) {
	    this.account = account;
    }

    public void setSemester(Semester semester) {
	    this.semester = semester;
    } 
    public Semester getSemester() {
	    return semester;
    }




    
}
