/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author andre
 */
public class Conector {
    private Connection con;
    private String url;
    
    public Conector() {
        this.con = null;
        this.url =  "";
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            String bUrl = "jdbc:sqlite:" + ".//Database//DBproject.db";
            this.con = DriverManager.getConnection(bUrl);
            this.url = ".//Database//DBproject.db";
        }
        catch(Exception ex) {
            System.out.println("error aqui");
        }
    }
    
    public void killConnection() {
        try {
            this.con.close();
        }
        catch(Exception ex) {
            
        }      
    }
}
