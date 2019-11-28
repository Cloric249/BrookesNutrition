package com.example.brookesnutrition;


public class User {
    private double weight;
    private double height;
    private int age;
    private boolean initalizing = true;
    private String name;
    private String sex;
    public int stepsGoal;
    public int caloriesGoal;

    public User(String name, int age){
        while(initalizing == true){
            if (name.length() < 1){
                System.out.println("Please enter your name");
            }
            else if (12 > age){
                System.out.println("You are too young to use this app");
            }
            else if (age > 99){
                System.out.println("You are too old to use this app");
            }
            else {
                initalizing = false;
                System.out.println("Please enter all body measurements in metric units\n");
                this.age = age;
                this.name = name;
            }
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight(){
        return height;
    }

    public void setSex(String sex){
        if (sex.equals("Male") || sex.equals("male") || sex.equals("Female") || sex.equals("female")){
            this.sex = sex;
        }
        else{
            System.out.println("Please enter either Male or Female");
        }
    }

    public String getSex(){
        return sex;
    }

    public double calculateBMI(){
        double BMI;
        double tmpheight = height;
        if (height > 5){
            tmpheight = height/100;
        }
        BMI = Weight/(tmpheight);
        return BMI;
    }

    public double calculateBMR(){
        double BMR;
        if (sex.equals("Male") || sex.equals("male")){
            BMR = 66.47 + (13.75 * weight) + (5.003 * height) - (6.755 * age);
        }
        else {
            BMR = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
        }
        return BMR;
    }
    
    public fitnessPlan(){
        System.out.println("Please select the fitness plan you would like to choose");
        System.out println("Strength & Training);
        System.out println("Cardio & Conditiong);
        System.out println("To Be Added");     
        

}


