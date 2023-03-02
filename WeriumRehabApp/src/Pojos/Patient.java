/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojos;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author andre
 */
public class Patient {
    public enum GENDER{MALE, FEMALE};
    
    private int ID;
    private String name;
    private String surname;
    private int age;
    private GENDER gender;
    
    public Patient() {
        this.name = "";
        this.surname = "";
        this.age = 0;
        this.gender = GENDER.FEMALE;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
