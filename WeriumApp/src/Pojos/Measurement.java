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
public class Measurement {
    private float coeff_A;
    private float coeff_B;
    private int numberBalls;
    private String times;
    private String ids;
    
    public Measurement() {
        
    }

    public float getCoeff_A() {
        return coeff_A;
    }

    public void setCoeff_A(float coeff_A) {
        this.coeff_A = coeff_A;
    }

    public float getCoeff_B() {
        return coeff_B;
    }

    public void setCoeff_B(float coeff_B) {
        this.coeff_B = coeff_B;
    }

    public int getNumberBalls() {
        return numberBalls;
    }

    public void setNumberBalls(int numberBalls) {
        this.numberBalls = numberBalls;
    }   

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }    
    
    public ArrayList<Float> convertStringIntoFloatArray(String value) {
        ArrayList<Float> l = new ArrayList();
        value = value.trim();
        int i = 0;
        do{
            for(int j = i; j < value.length(); j++) {
                char c = value.charAt(j);
                if(c == ',') {
                    String k = value.substring(i, j);
                    float v = Float.parseFloat(k);
                    l.add(v);
                    i = j + 1;
                    break;
                }
            }
        }while(i<value.length());
        
        return l;
    }
    
    
}
