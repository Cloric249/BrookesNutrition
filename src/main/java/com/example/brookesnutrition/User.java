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
    
    public void fitnessPlan(){
        String line1 = "Day A";
        String line2 = "3x5+ Barbell Rows";
        String line3 = "3x5+ Bench Press";
        String line4 = "3x5+ Squats";
        String line5 = "Day B";
        String line6 = "3x5+ Chinups";
        String line7 = "3x5+ Overhead Press";
        String line8 = "3x5+ Deadlift";

        String line9 = "Day A";
        String line10 = "3x5+ Barbell Rows";
        String line11 = "3x5+ Bench Press";
        String line12 = "3x5+ Squats";
        String line13 = "Day B";
        String line14 = "3x5+ Chinups";
        String line15 = "3x5+ Overhead Press";
        String line16 = "3x5+ Deadlift";

        String info1 ("Notation is Sets x Reps. + equals As Many Reps As Possible, but not for the last set");
        String info2 ("Rest 2-3 minutes between each set, depending on how you feel");

        String progression1 ("Add 2.5kg to the upper body lifts you each day");
        String progression2 ("Add 5kg to the lower body lifts each day you do the lift");
        String progression2 ("If you do more than 10 reps on your AMRAP set, double the weight progression and and 5/10kg's instead");
        String progression2 ("If you fail to complete at least 15 total reps for a lift, deload by subtracting 10% from the weight the next time you do that lift");

        public void stored(String s){

        }
        }




        

}


