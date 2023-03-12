/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author andre
 */
public abstract class DBCreation {
    public static void createDb(Conector con) {
        cTMeasurement(con);
    }
    
    private static void cTMeasurement(Conector con) {
        Statement st = null;
        String in =  "";
        
        try {
            st = con.getCon().createStatement();
            in = "CREATE TABLE MEASUREMENT (ID integer PRIMARY KEY AUTOINCREMENT NOT NULL, "
                    + "COEF_A float NOT NULL, COEF_B float NOT NULL, "
                    + "DISTANCE float NOT NULL, SIZE float NOT NULL, TIME float NOT NULL, "
                    + "IDPATIENT int CONSTRAINT rPatient references PATIENT ON UPDATE CASCADE ON DELETE SET NULL)";
            st.execute(in);
        }
        catch(Exception ex) {
            
        }
        finally {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBCreation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static void CTPatient(Conector con) {
        Statement st = null;
        String in =  "";
        
        try {
            st = con.getCon().createStatement();
            in = "CREATE TABLE PATIENT (ID ibteger PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " NAME varchar(20) NOT NULL, SURNAME varchar(20) NOT NULL,"
                    + " DOB date NOT NULL, USERNAME varchar(25) NOT NULL,"
                    + " PASSWORD text NOT NULL)";
            
            st.execute(in);
        }
        catch(Exception ex) {
            
        }
        finally {
            try {
                st.close();
            }catch(Exception ex){
                
            }
            
        }
    }
}
