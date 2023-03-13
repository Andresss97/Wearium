/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Pojos.Patient;
import Pojos.Physiotherapist;
import java.sql.*;
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
            p.setName(set.getString("name"));
            p.setSurname(set.getString("surname"));
            p.setUsername(set.getString("username"));
            p.setPassword(set.getString("password"));
        }
        
        set.close();
        st.close();
        
        return p;
    }
}
