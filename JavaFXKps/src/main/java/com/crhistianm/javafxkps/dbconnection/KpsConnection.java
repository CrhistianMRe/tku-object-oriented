package com.crhistianm.javafxkps.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * KpsConnection
 */
public class KpsConnection {

  private Connection myConnection;

  private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;/databaseName=kps;trustServerCertificate=true;";
  private static final String USER = "root";
  private static final String PASSWORD = "root";

    public Connection getMyConnection() {
	    return myConnection;
    }

    public void setMyConnection(Connection myConnection) {
	    this.myConnection = myConnection;
    }

    public void openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            myConnection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection opened succesfully");
        } catch (Exception e) {
            System.out.println("Could not open connection : " + e);
        }
    }
    public void closeConnection(){  
        try {
            if(myConnection != null){
                if(!(myConnection.isClosed())){
                    myConnection.close();
                    System.out.println("Closed succesfully");
                }
            }
            
            
        } catch (Exception e) {
            System.out.println("Erro could not close connection : "+ e);
        }


    }

}
