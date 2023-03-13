/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Pojos.Physiotherapist;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/**
 *
 * @author andre
 */
public class QuerysInsert {
    private Conector con;
    
    public QuerysInsert(Conector con) {
        this.con = con;
    }
    
    public void insertPatient(Physiotherapist p) {
        String query = "INSERT into Physiotherapist (name, surname, username, password) values (?,?,?,?)";
        try {
            PreparedStatement st = this.con.getCon().prepareStatement(query);
            st.setString(1, p.getName());
            st.setString(2, p.getSurname());
            st.setString(3, p.getUsername());
            st.setString(4, p.getPassword());
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuerysInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
