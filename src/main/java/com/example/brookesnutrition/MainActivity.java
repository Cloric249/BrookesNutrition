package com.example.brookesnutrition;

import Step;
import User;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public static void main(String args[]) {

        Scanner usrinput = new Scanner(System.in);
        boolean end = false;


        System.out.println("Enter your name");
        String usrname = usrinput.next();
        System.out.println("Enter your age");
        int usrage = usrinput.nextInt();
        User user = new User(usrname, usrage);
        System.out.println("Enter your sex");
        String usrsex = usrinput.next();
        user.setSex(usrsex);

        System.out.println("Enter 'H' to set your height");
        System.out.println("Enter 'M' to set your mass");
        System.out.println("Enter 'BMR' to calculate your BMR");
        System.out.println("Enter 'BMI' to calculate your BMI");
        System.out.println("Enter 'Q' to quit");

        while(end == false){
            String usroption = usrinput.next();
            switch(usroption){
                case "H":
                    System.out.println("Enter your height");
                    double usrheight = usrinput.nextDouble();
                    user.setHeight(usrheight);
                    System.out.println("Height stored: " + user.getHeight());
                    break;

                case "M":
                    System.out.println("Enter you mass");
                    double usrmass = usrinput.nextDouble();
                    user.setMass(usrmass);
                    System.out.println("Mass stored: " + user.getMass());
                    break;

                case "BMR":
                    System.out.println("BMR: " + user.calculateBMR());
                    break;

                case "BMI":
                    System.out.println("BMI: " + user.calculateBMI());
                    break;

                case "Q":
                    end = true;
                    break;
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
        }
    }


    boolean programRunning = true;

    System.out.println("Please select the fitness plan you would like to choose");
    System.out.println("S)trength & Training");
    System.out.println("C)ardio & Conditioning");

    String plan = input.nextLine();

    if (plan.equals("S" || "s" || "S)" || "s)")){
        while (programRunning){
            String stored = input.nextLine();

            System.out.println(line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" + line5 + "\n"+ line6 + "\n" + line7+ "\n" + line8);
            System.out.println(info1 + "\n" + info2);

        if (plan.equals("C" || "c" || "C)" || "c)")){
            while (programRunning){
                System.out.println("This is not programmed yet");
            }

            }

            }


}
