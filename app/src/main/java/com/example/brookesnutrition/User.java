package com.example.brookesnutrition;


import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private double mass;
    private int height;
    private int age;
    private String name;
    private String sex;
<<<<<<< HEAD

=======
    private String plan;
>>>>>>> Initial commit

    public User(){

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
    public int getAge(){
        return age;
    }

    public void setMass(double mass){
        this.mass = mass;
    }

    public double getMass(){
        return mass;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getSex(){
        return sex;
    }

<<<<<<< HEAD
=======
    public String setPlan() { return plan; }

>>>>>>> Initial commit
    public double calculateBMI(){
        double BMI;
        double tmpheight = height;
        if (height > 5){
            tmpheight = height/100;
        }
        BMI = mass/(tmpheight);
        return BMI;
    }

    public double calculateBMR(){
        double BMR;
        if (sex.equals("Male") || sex.equals("male")){
            BMR = 66.47 + (13.75 * mass) + (5.003 * height) - (6.755 * age);
        }
        else {
            BMR = 655.1 + (9.563 * mass) + (1.85 * height) - (4.676 * age);
        }
        return BMR;
    }


    protected User(Parcel in) {
        name = in.readString();
        age = in.readInt();
        sex = in.readString();
        height = in.readInt();
        mass = in.readDouble();
<<<<<<< HEAD
=======
        plan = in.readString();
>>>>>>> Initial commit

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(sex);
        dest.writeInt(height);
        dest.writeDouble(mass);
<<<<<<< HEAD
=======
        dest.writeString(plan);
>>>>>>> Initial commit
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
