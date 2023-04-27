/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojos;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Patient {
    private int id;
    private String name;
    private String surname;
    private Date dob;
    private int idPhysiotherapist;
    private ArrayList<Measurement> measurements;
    
    public Patient() {
        this.measurements = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }   

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getIdPhysiotherapist() {
        return idPhysiotherapist;
    }

    public void setIdPhysiotherapist(int idPhysiotherapist) {
        this.idPhysiotherapist = idPhysiotherapist;
    }

    public ArrayList<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(ArrayList<Measurement> measurements) {
        this.measurements = measurements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }
}


