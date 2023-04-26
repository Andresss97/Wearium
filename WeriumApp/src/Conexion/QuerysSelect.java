/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

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
            
            patients.add(patient);
        }
        
        set.close();
        st.close();
        
        return patients;
    }
}
