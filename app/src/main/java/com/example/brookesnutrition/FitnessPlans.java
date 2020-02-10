package com.example.brookesnutrition;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Bundle;
import android.widget.Toast;

public class FitnessPlans extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fitness_plans);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fitness_plans, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    private boolean isDoneStretching = false;
    private boolean isDoneWorkout = false;

    private boolean isDoneJumpingJacks = false;
    private boolean isDonePlank = false;
    private boolean isDoneLunges = false;
    private boolean isDonePushups = false;
    private boolean isDoneSitups = false;
    private boolean isDoneHighKnees = false;
    private boolean isDoneSidePlank = false;
    private boolean isDoneTricepDips = false;
    private boolean isDoneSquats = false;

    private String jumpingJacksCount = "";
    private String plankCount = "";
    private String lungesCount = "";
    private String pushupsCount = "";
    private String situpsCount = "";
    private String highKneesCount = "";
    private String sidePlankCount = "";
    private String tricepDipCount = "";
    private String squatCount = "";

    //Required empty constructor
    public FitnessPlans() {

    }
    public static String weightLoss; {
        System.out.println("Rowing Machine for 6 Mins To Warmup\n");
        System.out.println("Have a minute break\n");
        System.out.println("Deadlift - 4 Sets, 3-5 Reps\n");
        System.out.println("Bent Over Row - 4 Set, 5 Reps\n");
        System.out.println("Weighted Chin Up - 3 Sets, 6 Reps\n");
        System.out.println("Face Pull - 3 Sets, 12 Reps\n");
        System.out.println("Barbell Curl- 4 Sets, 10 Reps\n");
    }
    public static String Cardio; {
        System.out.println("Rowing Machine for 10 Mins To Warmup\n");
        System.out.println("Rest 2 Minutes\n");
        System.out.println("1.5 Mile Run\n");

    }

    //Create a date String thats populated with the date the user completed the workout
    SimpleDateFormat sdf = new SimpleDateFormat("DD, MM, YYYY");
    String date = sdf.format(new Date());

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
