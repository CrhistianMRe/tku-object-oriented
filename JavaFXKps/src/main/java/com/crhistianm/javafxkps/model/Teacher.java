package com.crhistianm.javafxkps.model;

/**
 * Teacher
 */
public class Teacher {
   private int id; 
   private String name;
   private String surname;
   private String emailAddress;
   private String phoneNumber;
   private Account account;

   public Teacher(Account account, String phoneNumber, String emailAddress, String surname, String name, int id) {
       this.account = account;
       this.phoneNumber = phoneNumber;
       this.emailAddress = emailAddress;
       this.surname = surname;
       this.name = name;
       this.id = id;
   }
   public Teacher() {
   }

    public int getId() {
	    return id;
    }  
    public void setId(int id) {
	    this.id = id;
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
    public void setEmailAddress(String emailAddress) {
	    this.emailAddress = emailAddress;
    }
    public String getEmailAddress() {
	    return emailAddress;
    }
    public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
	    return phoneNumber;
    }
    public Account getAccount() {
	    return account;
    }
    public void setAccount(Account account) {
	    this.account = account;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", account=" + account +
                '}';
    }
}
