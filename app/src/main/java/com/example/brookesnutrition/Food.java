package com.example.brookesnutrition;

public class Food {
    private int calories;
    private double grams;
    private String name;

    public Food(String n){
        this.name = n;
    }
    public String getName(){
        return name;
    }
    public int getCalories(){
        return calories;
    }
    public double getGrams(){
        return grams;
    }
    public void setCalories(int c){
        this.calories = c;
    }
    public void setGrams(double g){
        this.grams = g;
    }
}
