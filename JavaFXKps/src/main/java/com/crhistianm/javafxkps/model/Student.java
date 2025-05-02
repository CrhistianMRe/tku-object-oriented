package com.crhistianm.javafxkps.model;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String emailAddress;
    private int semesterId;

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

    public int getSemesterId(){
        return semesterId;
    }

    public void setSemesterId(int semesterId){
        this.semesterId = semesterId;
        
        
    }

    
}
