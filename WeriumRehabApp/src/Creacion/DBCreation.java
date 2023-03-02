/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creacion;

import java.sql.Statement;

/**
 *
 * @author andre
 */
public abstract class DBCreation {
    public static void createDb(Conector conector) {
        cTPatient(conector);
        cTTest(conector);
        
    }
    
    private static void cTPatient(Conector con) {
        Statement st = null;
        String in = "";
        
        try {
            st = con.getConnect().createStatement();
            
            in = "CREATE TABLE PATIENT " + "(ID integer PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + "NAME varchar(20) NOT NULL,SURNAME varchar(20) NOT NULL,"
                    + "AGE int NOT NULL, GENDER varchar(20), USERNAME varchar(50) NOT NULL,"
                    + "PASSWORD varchar(50) NOT NULL)";
            
            st.execute(in);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("error aqui paciente");
        }
        finally {
            try {
                st.close();
            }
            catch(Exception ex) {
                
            }
        }
        
    }
    
    private static void cTTest(Conector con) {
        Statement st = null;
        String in = "";
        
        try {
            st = con.getConnect().createStatement();
            
            in = "CREATE TABLE TEST (ID integer PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " QUESTION1 varchar(10), QUESTION2 varchar(10), QUESTION3 varchar(10),"
                    + " QUESTION4 varchar(10), QUESTION5 varchar(10), QUESTION6 varchar(10),"
                    + " QUESTION7 varchar(10), QUESTION8 varchar(10), QUESTION9 varchar(10),"
                    + " QUESTION10 varchar(10), QUESTION11 varchar(10),"
                    + " QUESTION12 varchar(10), IDPATIENT int CONSTRAINT rPatient REFERENCES PATIENT ON UPDATE CASCADE ON DELETE SET NULL)";
            
            st.execute(in);
        }
        catch(Exception ex) {
            System.out.println("error aqui test");
        }
        finally {
            try {
                st.close();
            }
            catch(Exception ex) {
                
            }
        }
    }
}
