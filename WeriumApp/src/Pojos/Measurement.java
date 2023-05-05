/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojos;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math4.legacy.stat.regression.SimpleRegression;

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
    private float r;
    
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

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
    
    public ArrayList<Float> convertStringIntoFloatArray(String value) {
        ArrayList<Float> l = new ArrayList();
        value = value.trim();
        
        char[] x = value.toCharArray();
        
        int countComas = 0;
        
        for(int c = 0; c < value.length(); c++) {
            if(x[c] == ',' && countComas%2 == 0) {
                x[c] = '.';
                countComas++;
            }
            else if(x[c] == ',' && countComas%2 != 0){
                countComas++;
            }
        }
        
        String f = String.valueOf(x);
        
        int i = 0;
        do{
            for(int j = i; j < f.length(); j++) {
                char c = f.charAt(j);
                if(c == ',') {
                    String k = f.substring(i, j);
                    float v = Float.parseFloat(k);
                    l.add(v);
                    i = j + 1;
                    break;
                }
            }
        }while(i<f.length());
        
        
        return l;
    }
    
    public float[] obtainCoefficients(ArrayList<Float> times, ArrayList<Float> ids) {
        double data[][] = new double[18][18];
        
        for(int i = 0; i < 18; i++) {
            for(int j = 0; j < 2; j++) {
                if(j%2 == 0) {
                    data[i][j] = ids.get(i);
                }
                else {
                    data[i][j] = times.get(i);
                }
            }
        }
        
        SimpleRegression si = new SimpleRegression(true);
        si.addData(data);
        
        float coefficients[] = new float[3];
        
        this.coeff_A = (float) si.getIntercept();
        this.coeff_B = (float) si.getSlope();
        this.r = (float) si.getR();
        
        coefficients[0] =(float) si.getSlope();
        coefficients[1] = (float) si.getIntercept();
        coefficients[2] = (float) si.getR();
        
        return coefficients;
    }
}
