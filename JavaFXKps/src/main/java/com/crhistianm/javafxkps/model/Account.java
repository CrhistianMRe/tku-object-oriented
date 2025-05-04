package com.crhistianm.javafxkps.model;

public class Account {
    private int id;
    private String accountNumber;
    private String password;

    public Account(String password, String accountNumber, int id){
        this.password = password;
        this.accountNumber = accountNumber;
        this.id = id;
    }
    public Account(){
    }
    public void setId(int id) {
	    this.id = id;
    }
    public int getId() {
	    return id;
    }
    public void setAccountNumber(String accountNumber) {
	    this.accountNumber = accountNumber;
    }
    public String getAccountNumber() {
	    return accountNumber;
    }
    public void setPassword(String password) {
	    this.password = password;
    }
    public String getPassword() {
	    return password;
    }

    
}
