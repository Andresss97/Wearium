/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creacion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author andre
 */
public class Conector {
    private Connection connect;
    private String url;
    
    public Conector() {
        this.connect = null;
        this.url = "";
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
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
            this.connect = DriverManager.getConnection(bUrl);
            this.url = ".//Database//DBproject.db";
        }
        catch(Exception ex) {
            System.out.println("error aqui");
        }
    }
    
    public void killConnection() {
        try {
            this.connect.close();
        }
        catch(Exception ex) {
            
        }      
    }
}
