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
        cTPhysiotherapist(con);
        cTPatient(con);
    }
    
    private static void cTMeasurement(Conector con) {
        Statement st = null;
        String in =  "";
        
        try {
            st = con.getCon().createStatement();
            in = "CREATE TABLE MEASUREMENT (ID integer PRIMARY KEY AUTOINCREMENT NOT NULL, "
                    + "COEF_A float NOT NULL, COEF_B float NOT NULL, "
                    + "TIMES text NOT NULL, IDS text NOT NULL, "
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
    
    private static void cTPatient(Conector con) {
        Statement st = null;
        String in =  "";
        
        try {
            st = con.getCon().createStatement();
            in = "CREATE TABLE PATIENT (ID integer PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " NAME varchar(20) NOT NULL, SURNAME varchar(20) NOT NULL,"
                    + " IDPHYSIOTHERAPIST int CONSTRAINT rPhysiotherapist references PHYSIOTHERAPIST ON UPDATE CASCADE ON DELETE SET NULL)";
            
            st.execute(in);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                st.close();
            }catch(Exception ex){
                
            }
            
        }
    }
    
    private static void cTPhysiotherapist(Conector con) {
        Statement st = null;
        String in =  "";
        
        try {
            st = con.getCon().createStatement();
            in = "CREATE TABLE PHYSIOTHERAPIST (ID integer PRIMARY KEY AUTOINCREMENT NOT NULL,"
                    + " NAME varchar(20) NOT NULL, SURNAME varchar(20) NOT NULL,"
                    + " USERNAME varchar(20) NOT NULL, PASSWORD varchar(20) NOT NULL)";
            
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
