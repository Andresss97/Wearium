/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Pojos.Measurement;
import Pojos.Patient;
import Pojos.Physiotherapist;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author andre
 */
public class QuerysSelect {
    
    private Conector con;
    
    public QuerysSelect(Conector con) {
        this.con = con;
    }
    
    public Physiotherapist selectPhysiotherapist(String username, String password) throws SQLException {
        Physiotherapist p = new Physiotherapist();
        
        String query = "SELECT * from PHYSIOTHERAPIST where username = '" + username + "' and password = '" + password + "'";
        PreparedStatement st = this.con.getCon().prepareStatement(query);
        
        ResultSet set = st.executeQuery();
        
        while(set.next()) {
            p.setId(set.getInt("ID"));
            p.setName(set.getString("name"));
            p.setSurname(set.getString("surname"));
            p.setUsername(set.getString("username"));
            p.setPassword(set.getString("password"));
        }
        
        p.setPatients(this.selectPatientsOfDoctor(p.getId()));
        
        set.close();
        st.close();
        
        return p;
    }
    
    public ArrayList<Patient> selectPatientsOfDoctor(int id) throws SQLException {
        ArrayList<Patient> patients = new ArrayList();
        String query = "SELECT * from PATIENT where idphysiotherapist = '"+ id +"'";
        PreparedStatement st = this.con.getCon().prepareStatement(query);
        
        ResultSet set = st.executeQuery();
        
        while(set.next()) {
            Patient patient = new Patient();
            patient.setName(set.getString("name"));
            patient.setSurname(set.getString("surname"));
            patient.setIdPhysiotherapist(set.getInt("idphysiotherapist"));
            patient.setId(set.getInt("id"));
            
            ArrayList<Measurement> measurements = this.selectMeasurementsPatients(patient.getId());
            patient.setMeasurements(measurements);
            patients.add(patient);
        }
        
        set.close();
        st.close();
        
        return patients;
    }
    
    public ArrayList<Measurement> selectMeasurementsPatients(int patientId) throws SQLException{
        ArrayList<Measurement> measurements = new ArrayList();
        String query = "SELECT * from MEASUREMENT where idpatient = '" + patientId +"'";
        
        PreparedStatement st = this.con.getCon().prepareStatement(query);
        
        ResultSet set = st.executeQuery();
        
        while(set.next()) {
            Measurement m = new Measurement();
            m.setCoeff_A(set.getFloat("coef_a"));
            m.setCoeff_B(set.getFloat("coef_b"));
            m.setTimes(set.getString("times"));
            m.setIds(set.getString("ids"));
            m.setNumberBalls(set.getInt("Nballs"));
            m.setR(set.getFloat("r"));
            
            measurements.add(m);
        }
        
        return measurements;
    }
    
    public int selectIdPatient(Patient patient) throws SQLException {
        String query = "SELECT id from Patient where name = '" + patient.getName() + "' and surname = '" + patient.getSurname() + "'";
        
        PreparedStatement st = this.con.getCon().prepareStatement(query);
        
        ResultSet set = st.executeQuery();
        
        int id = 0;
        
        while(set.next()) {
            id =set.getInt("id");
        }
        
        return id;
    }
    
    public int selectIdPhysiotherapist(Physiotherapist ph) throws SQLException {
        String query = "SELECT id from Physiotherapist where username = '" + ph.getUsername() + "' and password = '" + ph.getPassword() + "'";
        
        PreparedStatement st = this.con.getCon().prepareStatement(query);
        
        ResultSet set = st.executeQuery();
        
        int id = 0;
        
        while(set.next()) {
            id =set.getInt("id");
        }
        
        return id;
    }
}
