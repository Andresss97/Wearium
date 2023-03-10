/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojos;

/**
 *
 * @author andre
 */
public class Measurement {
    private float coeff_A;
    private float coeff_B;
    private float radius;
    private int numberBalls;
    private int trials;
    
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

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getNumberBalls() {
        return numberBalls;
    }

    public void setNumberBalls(int numberBalls) {
        this.numberBalls = numberBalls;
    }

    public int getTrials() {
        return trials;
    }

    public void setTrials(int trials) {
        this.trials = trials;
    }
    
    
}
