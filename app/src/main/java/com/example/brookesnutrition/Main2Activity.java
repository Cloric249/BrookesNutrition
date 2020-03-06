package com.example.brookesnutrition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {
    private Button button;
    String sex;
    EditText userheight;
    EditText usermass;
    User user = new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFitnessPlan();

            }
        });

        Bundle bundle = getIntent().getExtras();
        user = bundle.getParcelable("myUser");





        final Spinner M_F = findViewById(R.id.M_or_F);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.M_or_F));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        M_F.setAdapter(myAdapter);

        M_F.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sex = M_F.getItemAtPosition(M_F.getSelectedItemPosition()).toString();
                user.setSex(sex);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        userheight = findViewById(R.id.text_fheight);

        userheight.setOnKeyListener(new EditText.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        String height = userheight.getText().toString();
                        if (isNum(height)){
                            final int r_height = Integer.parseInt(height);
                            user.setHeight(r_height);
                            Toast.makeText(Main2Activity.this, "Height saved", Toast.LENGTH_LONG).show();
                        }
                    }
                return false;
            }
        });
        usermass = findViewById(R.id.text_fmass);

        usermass.setOnKeyListener(new EditText.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        String mass = userheight.getText().toString();
                        if (isValidMass(mass) && isNum(userheight.getText().toString())){
                            final int r_mass = Integer.parseInt(mass);
                            user.setMass(r_mass);
                            Toast.makeText(Main2Activity.this, "Mass saved", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("myUser", user);
                            Fragment fragInfo = new Fragment();
                            fragInfo.setArguments(bundle);
                            startActivity(intent);
                        }
                    }
                return false;
            }
        });

    }
    public void openActivityFitnessPlan() {
        Intent intent = new Intent(this, FitnessPlan.class);
        startActivity(intent);
    }

    public boolean isNum(String height){
        if (!height.matches("[0-9]+")) {
            Toast.makeText(Main2Activity.this, "Enter a number", Toast.LENGTH_LONG).show();
            return false;
        }else if(height.matches("[0-9]+") && height.length() != 3){
            Toast.makeText(Main2Activity.this, "Enter your height in cm", Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            return true;
        }
    }

    public boolean isValidMass(String mass){
        if (!mass.matches("[0-9]+")){
            Toast.makeText(Main2Activity.this,"Enter a number", Toast.LENGTH_LONG).show();
            return false;
        }else if(mass.matches("[0-9]+") && mass.length() > 3){
            Toast.makeText(Main2Activity.this, "Enter your mass in kg", Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            return true;
        }
    }
}
